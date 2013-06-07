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
package org.n52.geofeed.feed;

import java.util.List;

import org.n52.geofeed.FeedType;

/**
 * 
 * @author Arne de Wall <a.dewall@52North.org>
 *
 */
public interface IFeed extends FeedElement {
    public static final String TITLE_ELEMENT = "title";
    public static final String SUBTITLE_ELEMENT = "subtitle";
    public static final String UPDATED_ELEMENT = "updated";
    public static final String LINK_ELEMENT = "link";
    public static final String RIGHTS_ELEMENT = "rights";
    public static final String CATEGORY_ELEMENT = "category";

    public String getTitle();
    public FeedType getFeedType();
    public String getLink();
    public FeedElement getLinkElement();
    public String getDescription();
    public String getPublishedDate();
    public String getAuthor();
    public FeedElement getAuthorElement();
    public List<String> getCategories();
    public List<? extends FeedElement> getCategoryElements();
    public List<? extends IEntry> getEntrys();
    
    // TODO Modules!?
}
