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

/**
 * 
 * @author Arne de Wall <a.dewall@52North.org>
 *
 */
public interface IEntry extends FeedElement {
    String TITLE_ELEMENT         = "title";
    String ID_ELEMENT            = "id";
    String CONTENT_ELEMENT       = "content";
    String SUMMARY_ELEMENT       = "summary";
    String NAME_ELEMENT          = "name";
    String AUTHOR_ELEMENT        = "author";
    String CATEGORY_ELEMENT      = "category";
    String UPDATED_ELEMENT       = "updated";
    String LINK_ELEMENT          = "link";
    String RIGHTS_ELEMENT        = "rights";
    String HREF_ELEMENT          = "href";
    
    public String getTitle();
    public String getId();
    public String getLink();
    public List<String> getLinks();
    public String getDescription();
    public String getContents();
    public String getPublisedDate();
    public String getUpdatedDate();
    public List<String> getCategorys();
    public String getAuthor();
    public String getRights();
}
