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
package org.n52.geofeed.rss2;

import java.util.Date;
import java.util.List;

import org.n52.geofeed.BaseFeedElement;
import org.n52.geofeed.FeedConstants;
import org.n52.geofeed.core.FeedElement;
import org.n52.geofeed.core.ICategory;
import org.n52.geofeed.core.IEntry;
import org.n52.geofeed.core.IFeed;
import org.xml.sax.Attributes;

/**
 * 
 * @author Arne de Wall <a.dewall@52North.org>
 *
 */
public abstract class AbstractRSSFeed extends BaseFeedElement implements IFeed {

    private final FeedElement channel;
    
    public AbstractRSSFeed(String name, String uri, Attributes attibutes) {
        super(name, uri, attibutes);
        channel = getElement(FeedConstants.RSS_FEED.CHANNEL);
    }

    @Override
    public String getTitle() {
        FeedElement element = channel.getElement(FeedConstants.RSS_FEED.TITLE);
        return element == null ? null : element.getContentString();
    }

    @Override
    public String getFeedType() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getDescription() {
        FeedElement element = channel.getElement(FeedConstants.RSS_FEED.DESCRIPTION);
        return element == null ? null : element.getContentString();
    }

    @Override
    public Date getPublishedDate() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<FeedElement> getCategories() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<IEntry> getEntrys() {
        // TODO Auto-generated method stub
        return null;
    }

}
