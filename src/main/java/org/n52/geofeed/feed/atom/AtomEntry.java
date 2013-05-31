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
package org.n52.geofeed.feed.atom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.n52.geofeed.BaseFeedEntry;
import org.n52.geofeed.feed.FeedElement;
import org.n52.geofeed.feed.IEntry;
import org.xml.sax.Attributes;

/**
 * 
 * @author Arne de Wall <a.dewall@52North.org>
 *
 */
public class AtomEntry extends BaseFeedEntry implements IEntry{
    private static final String PUBLISHED_ELEMENT = "published";
    private static final String UPDATED_ELEMENT = "updated";
    
    public AtomEntry(String name, String uri, Attributes attibutes) {
        super(name, uri, attibutes);
    }

    @Override
    public String getTitle() {
        FeedElement title = getElement(TITLE_ELEMENT);
        return title == null ? null : title.getContentString();
    }

    @Override
    public String getId() {
        FeedElement id = getElement(ID_ELEMENT);
        return id == null ? null : id.getContentString();
    }

    @Override
    public String getLink() {
        FeedElement link = getElement(LINK_ELEMENT);
        return link == null ? null : link.getAttributes().getValue(HREF_ELEMENT);
    }

    @Override
    public List<String> getLinks() {
        FeedElement link = getElement(LINK_ELEMENT);
        return link == null ? null : Arrays.asList(link.getContentString());
    }

    @Override
    public String getDescription() {
        FeedElement description = getElement(SUMMARY_ELEMENT);
        return description == null ? null : description.getContentString();
    }

    @Override
    public String getContents() {
        FeedElement element = getElement(CONTENT_ELEMENT);
        return element == null ? null : element.getContentString();
    }

    @Override
    public String getPublisedDate() {
        FeedElement element = getElement(PUBLISHED_ELEMENT);
        return element == null ? null : element.getContentString();
    }

    @Override
    public String getUpdatedDate() {
        FeedElement element = getElement(UPDATED_ELEMENT);
        return element == null ? null : element.getContentString();
    }

    @Override
    public List<String> getCategorys() {
        List<String> res = new ArrayList<String>();
        for(FeedElement e : getElementList(CATEGORY_ELEMENT))
            res.add(e.getContentString());
        return res;
    }

    @Override
    public String getAuthor() {
        FeedElement element = getElement(AUTHOR_ELEMENT);
        return element == null ? null : element.getContentString();
    }

    @Override
    public String getRights() {
        FeedElement element = getElement(RIGHTS_ELEMENT);
        return element == null ? null : element.getContentString();
    }

}
