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

import java.util.ArrayList;
import java.util.List;

import org.n52.geofeed.BaseFeedElement;
import org.n52.geofeed.FeedConstants;
import org.n52.geofeed.feed.FeedElement;
import org.n52.geofeed.feed.IEntry;
import org.xml.sax.Attributes;

/**
 * 
 * @author Arne de Wall <a.dewall@52North.org>
 *
 */
public class RSSItem_2 extends BaseFeedElement implements IEntry{

    public RSSItem_2(String name, String uri, Attributes attibutes) {
        super(name, uri, attibutes);
    }

    @Override
    public String getTitle() {
        FeedElement element = getElement(FeedConstants.RSS_ITEM.TITLE);
        return element == null ? null : element.getContentString();
    }

    @Override
    public String getId() {
        FeedElement element = getElement(FeedConstants.RSS_ITEM.ID);
        return element == null ? null : element.getContentString();
    }

    @Override
    public String getLink() {
        FeedElement element = getElement(FeedConstants.RSS_ITEM.LINK);
        return element == null ? null : element.getContentString();
    }

    @Override
    public List<String> getLinks() {
        List<FeedElement> element = getElementList(FeedConstants.RSS_ITEM.LINK);
        List<String> res = new ArrayList<String>();
        for(FeedElement e : element)
            res.add(e.getContentString());
        return res;
    }

    @Override
    public String getDescription() {
        FeedElement element = getElement(FeedConstants.RSS_ITEM.DESCRIPTION);
        return element == null ? null : element.getContentString();
    }

    @Override
    public String getContents() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getPublisedDate() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getUpdatedDate() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<String> getCategorys() {
        List<String> res = new ArrayList<String>(); 
        for(FeedElement e : getElementList(FeedConstants.RSS_ITEM.CATEGORY))
            res.add(e.getContentString());
        return res;
    }

    @Override
    public String getAuthor() {
        FeedElement element = getElement(FeedConstants.RSS_ITEM.AUTHOR);
        return element == null ? null : element.getContentString();
    }

    @Override
    public String getRights() {
        return null;
    }

}
