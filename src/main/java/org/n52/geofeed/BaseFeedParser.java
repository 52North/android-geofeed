/**
 * Copyright 2012 52�North Initiative for Geospatial Open Source Software GmbH
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

import java.io.InputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.n52.geofeed.feed.IFeed;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

/**
 * 
 * @author Arne de Wall <a.dewall@52North.org>
 * 
 */
public class BaseFeedParser implements FeedParser {

    @Override
    public IFeed parse(InputStream inStream) throws Exception {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            factory.setNamespaceAware(true);

            SAXParser saxP = factory.newSAXParser();
            XMLReader xmlReader = saxP.getXMLReader();
 
            FeedHandler feedHandler = new FeedHandler();
            xmlReader.setContentHandler(feedHandler);
            xmlReader.parse(new InputSource(inStream));
            return feedHandler.getFeed();
        } catch (Exception e) {
            //TODO XXX FIXME
            e.printStackTrace();
            throw new Exception(e);
        }
    }
}
