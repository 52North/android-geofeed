/**
 * Copyright 2012 52°North Initiative for Geospatial Open Source Software GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.n52.geofeed;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import org.n52.geofeed.exception.InvalidFeedTypeException;
import org.n52.geofeed.feed.FeedFactory;
import org.n52.geofeed.feed.IFeed;
import org.n52.geofeed.feed.atom.AtomFeedFactory;
import org.n52.geofeed.feed.geo.GeoRSSSimpleFactory;
import org.n52.geofeed.feed.rss2.RSS2FeedFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * 
 * @author Arne de Wall <a.dewall@52North.org>
 * 
 */
public class FeedHandler extends DefaultHandler {
    private static final String GEORSS_SIMPLE_NS = "http://www.georss.org/georss";

    static final String ATOM_FEED_TAG = "feed";
    static final String ATOM_ENTRY_TAG = "entry";
    static final String RSS_FEED_TAG = "rss";
    static final String RSS_ITEM_TAG = "item";

    private static Map<String, Class<? extends FeedFactory>> factoryMap = new HashMap<String, Class<? extends FeedFactory>>() {
        private static final long serialVersionUID = -7620727063955616858L;
        {
            put(ATOM_FEED_TAG, AtomFeedFactory.class);
            put(RSS_FEED_TAG, RSS2FeedFactory.class);
        }
    };

    private static Map<String, Class<? extends FeedFactory>> extensionMap = new HashMap<String, Class<? extends FeedFactory>>() {
        private static final long serialVersionUID = -3280630678147939541L;
        {
            put(GEORSS_SIMPLE_NS, GeoRSSSimpleFactory.class);
        }
    };

    private IFeed feed;
    private StringBuilder builder;
    private Stack<BaseFeedElement> elementStack;

    private FeedFactory feedFactory;
    
    private Set<Class<? extends FeedFactory>> usedExtensions = new HashSet<Class<? extends FeedFactory>>();

    @Override
    public void startDocument() throws SAXException {
        elementStack = new Stack<BaseFeedElement>();
        super.startDocument();
    }

    
    
    @Override
    public void startPrefixMapping(String prefix, String uri)
            throws SAXException {
        if(prefix != null && !prefix.equals(""))
            usedExtensions.add(extensionMap.get(uri));
        super.startPrefixMapping(prefix, uri);
    }



    @Override
    public void startElement(String uri, String localName, String qName,
            Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        
        if (feedFactory == null) {
            try {
                Class<? extends FeedFactory> factoryClass = factoryMap
                        .get(localName);
                if (factoryClass == null) 
                    throw new InvalidFeedTypeException(localName);
                feedFactory = factoryClass.newInstance();
                
                for(Class<? extends FeedFactory> fac : usedExtensions)
                    feedFactory = fac.getConstructor(FeedFactory.class).newInstance(feedFactory);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvalidFeedTypeException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        } 
        
        BaseFeedElement newElement = feedFactory.createElement(localName, uri, attributes);
        if(feed == null){
            feed = (IFeed) newElement;
        }

        elementStack.push(newElement);
        builder = new StringBuilder();
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        super.characters(ch, start, length);
        builder.append(ch, start, length);
    }

    @Override
    public void endDocument() throws SAXException {
        elementStack.clear();
        super.endDocument();
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        super.endElement(uri, localName, qName);
        BaseFeedElement current = elementStack.pop().setContent(
                builder.toString());

        if (!elementStack.empty())
            elementStack.peek().addElementToMap(new String(qName), current);

        this.builder.delete(0, builder.length());
    }

    public IFeed getFeed() {
        return this.feed;
    }
}
