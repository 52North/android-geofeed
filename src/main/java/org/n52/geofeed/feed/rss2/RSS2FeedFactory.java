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
package org.n52.geofeed.feed.rss2;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.n52.geofeed.BaseFeedElement;
import org.n52.geofeed.feed.FeedFactory;
import org.xml.sax.Attributes;

/**
 * 
 * @author Arne de Wall <a.dewall@52North.org>
 *
 */
public class RSS2FeedFactory implements FeedFactory {
    static final String RSS_FEED_TAG = "rss";
    static final String RSS_ITEM_TAG = "item";

    private static Map<String, Class<? extends BaseFeedElement>> classMap = new HashMap<String, Class<? extends BaseFeedElement>>() {
        private static final long serialVersionUID = -3892396510805199085L;
        {
            put(RSS_FEED_TAG, RSSFeed_2.class);
            put(RSSFeed_2.ITEM_ELEMENT, RSSItem_2.class);
            put(RSSFeed_2.IMAGE_ELEMENT, RSSImage_2.class);
        }
    };

    
    @Override
    public BaseFeedElement createElement(String localName, String uri,
            Attributes attributes) {
        Class<? extends BaseFeedElement> clazz = classMap.get(localName);
        
        BaseFeedElement element = null;
        if(clazz != null){
            try {
                 element = clazz.getConstructor(String.class,
                        String.class, Attributes.class).newInstance(localName, uri,
                        attributes);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        } else {
            element = new BaseFeedElement(localName, uri, attributes);
        }
        
        return element;
    }

}
