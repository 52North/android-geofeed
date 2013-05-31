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

import java.util.List;

import org.n52.geofeed.BaseFeedParser;
import org.n52.geofeed.FeedParser;
import org.n52.geofeed.feed.FeedElement;
import org.n52.geofeed.feed.IFeed;
import org.n52.geofeed.feed.rss2.RSSItem_2;

import android.test.AndroidTestCase;

/**
 * 
 * @author Arne de Wall <a.dewall@52North.org>
 * 
 */
public class RSSFeedParserTest extends AndroidTestCase {
    private FeedParser feedParser;


    @SuppressWarnings("unchecked")
    public void testParseRSS() throws Throwable {
        feedParser = new BaseFeedParser();
        IFeed feed = null;

        try {
            if(getClass().getResource("samplefeed-rss2.xml") == null)
                System.out.println("samplefeed ist null");
            feed = feedParser.parse(getClass()
                    .getResource("samplefeed-rss2.xml") //
                    .openConnection() //
                    .getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }

        assertNotNull("RSS Feed", feed);

        assertEquals("RSS title", "rss title", feed.getTitle());
        assertEquals("RSS link", "http://www.example.com/", feed.getElement("link").getContentString());
        assertEquals("RSS descr", "a description", feed.getDescription());
        assertEquals("RSS lang", "en-us", feed.getElement("language").getContentString());
        assertEquals("RSS right", "Copyright", feed.getElement("copyright").getContentString());
        
        for(FeedElement cat : feed.getCategories()){
            assertEquals("RSS cat", "category", cat.getContentString());
        }
        
        for(RSSItem_2 item : (List<RSSItem_2>)(List<?>)feed.getEntrys()){
            assertEquals("RSSitem description", "description", item.getDescription());
            assertEquals("RSSitem guid", "anyguid", item.getId());
            assertEquals("RSSitem pubDate", "Mon, 30 Sep 2002 01:56:02 GMT", item.getElement("pubDate").getContentString());
        }

    }
}
