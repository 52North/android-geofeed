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
package org.n52.geofeed.feed.extension;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.n52.geofeed.FeedType;
import org.n52.geofeed.feed.FeedElement;
import org.n52.geofeed.feed.IEntry;
import org.n52.geofeed.feed.IFeed;
import org.n52.geofeed.feed.geo.IGeoFeed;
import org.xml.sax.Attributes;

/**
 * 
 * @author Arne de Wall <a.dewall@52North.org>
 * 
 */
public class BaseFeedExtensionDecorator implements IFeed {
    private IFeed feed;
    
    public BaseFeedExtensionDecorator(IFeed feed){
        this.feed = feed;
    }

    @Override
    public String getName() {
        return feed.getName();
    }

    @Override
    public String getContentString() {
        return feed.getContentString();
    }

    @Override
    public FeedElement getElement(String name) {
        return feed.getElement(name);
    }

    @Override
    public List<FeedElement> getElementList(String name) {
        return feed.getElementList(name);
    }

    @Override
    public Set<String> getElementKeys() {
        return feed.getElementKeys();
    }

    @Override
    public Attributes getAttributes() {
        return feed.getAttributes();
    }

    @Override
    public String getTitle() {  
        return feed.getTitle();
    }

    @Override
    public FeedType getFeedType() {
        return feed.getFeedType();
    }

    @Override
    public String getUri() {
        return feed.getUri();
    }

    @Override
    public String getDescription() {
        return feed.getDescription();
    }

    @Override
    public Date getPublishedDate() {
        return feed.getPublishedDate();
    }

    @Override
    public List<FeedElement> getCategories() {
        return feed.getCategories();
    }

    @Override
    public List<IEntry> getEntrys() {
        return feed.getEntrys();
    }

    @Override
    public String getLink() {
        return feed.getLink();
    }

    @Override
    public String getAuthor() {
        return feed.getAuthor();
    }

}
