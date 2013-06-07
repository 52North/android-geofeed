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
import java.util.Date;
import java.util.List;

import org.n52.geofeed.BaseFeedElement;
import org.n52.geofeed.FeedConstants;
import org.n52.geofeed.FeedType;
import org.n52.geofeed.exception.NoElementOfFeedTypeException;
import org.n52.geofeed.feed.FeedElement;
import org.n52.geofeed.feed.IAuthor;
import org.n52.geofeed.feed.ICategory;
import org.n52.geofeed.feed.IEntry;
import org.n52.geofeed.feed.IFeed;
import org.n52.geofeed.feed.ILink;
import org.xml.sax.Attributes;

/**
 * 
 * @author Arne de Wall <a.dewall@52North.org>
 * 
 */
public class RSSFeed_2 extends BaseFeedElement implements IFeed {
    public static final String ITEM_ELEMENT = "item";
    public static final String IMAGE_ELEMENT = "image";
    private FeedElement channel;

    public RSSFeed_2(String name, String uri, Attributes attibutes) {
        super(name, uri, attibutes);
    }

    @Override
    public String getTitle() {
        FeedElement element = getElement(FeedConstants.RSS_FEED.TITLE);
        return element == null ? null : element.getContentString();
    }

    @Override
    public FeedType getFeedType() {
        return FeedType.RSS2;
    }

    @Override
    public String getDescription() {
        FeedElement element = getElement(FeedConstants.RSS_FEED.DESCRIPTION);
        return element == null ? null : element.getContentString();
    }

    @Override
    public String getPublishedDate() {
        FeedElement element = getElement(FeedConstants.RSS_FEED.PUBLISHED);
        // TODO
        return null;
    }

    @Override
    public List<String> getCategories() {
        List<FeedElement> element = getElementList(FeedConstants.RSS_FEED.CATEGORY);
        List<String> res = new ArrayList<String>();
        for(FeedElement e : element)
            res.add(e.getContentString());
        return res;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<IEntry> getEntrys() {
        List<FeedElement> element = getElementList(FeedConstants.RSS_FEED.ITEM);
        return (List<IEntry>) (List<?>) element;
    }

    @Override
    public FeedElement getElement(String key) {
        if(channel == null){
            channel = super.getElement(FeedConstants.RSS_FEED.CHANNEL);
        }
        return channel.getElement(key);
    }

    @Override
    public List<FeedElement> getElementList(String key) {
        if(channel == null){
            channel = super.getElement(FeedConstants.RSS_FEED.CHANNEL);
        }
        return channel.getElementList(key);
    }

    @Override
    public String getLink() {
        FeedElement element = getElement(LINK_ELEMENT);
        return element == null ? null : element.getContentString();
    }

    @Override
    public String getAuthor() {
        try {
            throw new NoElementOfFeedTypeException("RSS2.0", "author");
        } catch (NoElementOfFeedTypeException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public FeedElement getLinkElement() {
        return getElement(LINK_ELEMENT);
    }

    @Override
    public FeedElement getAuthorElement() {
        try {
            throw new NoElementOfFeedTypeException("RSS2.0", "author");
        } catch (NoElementOfFeedTypeException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<FeedElement> getCategoryElements() {
        return getElementList(CATEGORY_ELEMENT);
    }
    


}
