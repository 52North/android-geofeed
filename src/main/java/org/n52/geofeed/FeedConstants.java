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

/**
 * 
 * @author Arne de Wall <a.dewall@52North.org>
 *
 */
public interface FeedConstants {
    
    public interface ATOM_FEED{
        String TITLE                = "title";
        String ID_ATTRIB            = "id";
        String CONTENT_ATTRIB       = "content";
        String SUMMARY_ATTRIB       = "summary";
        String NAME_ATTRIB          = "name";
        String AUTHOR_ATTRIB        = "author";
        String CATEGORY_ATTRIB      = "category";
        String UPDATED_ATTRIB       = "updated";
        String LINK_ATTRIB          = "link";
        String RIGHTS_ATTRIB        = "rights";
        String BBOX_ATTRIB          = "bbox";
    }
    
    public interface RSS_FEED{
        String CHANNEL = "channel";
        String TITLE = "title";
        String LINK = "link";
        String DESCRIPTION = "description";
        String COPYRIGHT = "copyright";
        String MANAGING_EDITOR = "managingEditor";
        String WEBMASTER = "webmaster";
        String PUBLISHED = "pubDate";
        String LASTBUILD = "lastBuildDate";
        String CATEGORY = "category";
        String GENERATOR = "generator";
        String DOCS_URL = "docs";
        String IMAGE = "image";
        String TTL = "ttl";
        String ITEM = "item";
    }
    
    public interface RSS_ITEM{
        String TITLE = "title";
        String LINK = "link";
        String DESCRIPTION = "description";
        String AUTHOR = "author";
        String CATEGORY = "category";
        String COMMENTS = "comments";
        String ENCLOSURE = "enclosure";
        String ID = "guid";
        String PUBLISHED = "pubDate";
        String SOURCE = "source";
    }
    
    public interface RSS_ITEM_2_0{
        
    }
}
