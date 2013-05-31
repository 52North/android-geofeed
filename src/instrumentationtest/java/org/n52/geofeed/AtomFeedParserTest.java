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

import org.n52.geofeed.core.IEntry;
import org.n52.geofeed.core.IFeed;

import android.test.AndroidTestCase;

/**
 * 
 * @author Arne de Wall <a.dewall@52North.org>
 * 
 */
public class AtomFeedParserTest extends AndroidTestCase{
    private FeedParser feedParser;
    
    public void testParseAtom() throws Throwable{
        feedParser = new BaseFeedParser();
        IFeed feed = null;
        try {
            if(getClass().getResource("samplefeed-atom.xml") == null)
                System.out.println("samplefeed ist null");
            feed = feedParser.parse(getClass()
                    .getResource("samplefeed-atom.xml") //
                    .openConnection() //
                    .getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }

        assertNotNull("atom feed", feed);

        assertEquals("atom id", "11", feed.getElement("id").getContentString());
        assertEquals("atom title", "atom title", feed.getTitle());
        assertEquals("atom updated", "2003-12-14T10:20:09Z",
                feed.getElement("updated").getContentString());

        IEntry entry = feed.getEntrys().get(0);
        assertNotNull("atom entry", entry);
        assertEquals("entry title", "entry title", entry.getTitle());
        assertEquals("entry link",
                "http://example.org/2003/12/13/atom-beispiel", entry.getLink());
        assertEquals("entry id", "12", entry.getId());
        assertEquals("entry updated", "2003-12-13T18:30:02Z",
                entry.getElement("updated").getContentString()); //getUpdatedDate());
        assertEquals("entry content", "content", entry.getContents());
    }
    
    public void testParseGeoAtom() throws Throwable{
        feedParser = new BaseFeedParser();
        IFeed feed = null;
        try {
            if(getClass().getResource("samplefeed-geoatom.xml") == null)
                System.out.println("samplefeed ist null");
            feed = feedParser.parse(getClass()
                    .getResource("samplefeed-geoatom.xml") //
                    .openConnection() //
                    .getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
        
        IEntry entry = feed.getEntrys().get(0);
        
    }
}
