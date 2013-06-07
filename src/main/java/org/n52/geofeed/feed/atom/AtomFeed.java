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
import java.util.List;

import org.n52.geofeed.BaseFeedElement;
import org.n52.geofeed.FeedType;
import org.n52.geofeed.feed.FeedElement;
import org.n52.geofeed.feed.IAuthor;
import org.n52.geofeed.feed.ICategory;
import org.n52.geofeed.feed.IEntry;
import org.n52.geofeed.feed.IFeed;
import org.xml.sax.Attributes;

/**
 * 
 * @author Arne de Wall <a.dewall@52North.org>
 * 
 */
public class AtomFeed extends BaseFeedElement implements IFeed {
    public static final String ENTRY_ELEMENT = "entry";
    public static final String AUTHOR_ELEMENT = "author";
    public static final String AUTHOR_NAME_ELEMENT = "name";
    protected static final String ICON_ELEMENT = "icon";    

    public AtomFeed(String name, String uri, Attributes attributes) {
        super(name, uri, attributes);
    }

    @Override
    public String getTitle() {
        FeedElement title = getElement(TITLE_ELEMENT);
        return title == null ? null : title.getContentString();
    }

    @Override
    public FeedType getFeedType() {
        return FeedType.ATOM2;
    }

    @Override
    public String getDescription() {
        FeedElement element = getElement(SUBTITLE_ELEMENT);
        return element == null ? null : element.getContentString();
    }

    @Override
    public String getPublishedDate() {
        FeedElement element = getElement(UPDATED_ELEMENT);
        return element.getContentString();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<AtomCategory> getCategoryElements() {
        List<FeedElement> element = getElementList(CATEGORY_ELEMENT);
        return (List<AtomCategory>)(List<?>) element;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<AtomEntry> getEntrys() {
        List<FeedElement> element = getElementList(ENTRY_ELEMENT);
        return (List<AtomEntry>)(List<?>) element;
    }

    @Override
    public String getLink() {
        FeedElement element = getElement(LINK_ELEMENT);
        return element == null ? null : element.getContentString();
    }

    @Override
    public String getAuthor() {
        FeedElement element = getElement(AUTHOR_ELEMENT);
        element = element == null ? null : element.getElement(AUTHOR_NAME_ELEMENT);
        return element == null ? null : element.getContentString();
    }

    @Override
    public AtomLink getLinkElement() {
        return (AtomLink) getElement(LINK_ELEMENT);
    }

    @Override
    public IAuthor getAuthorElement() {
        return (IAuthor) getElement(AUTHOR_ELEMENT);
    }

    @Override
    public List<String> getCategories() {
        List<FeedElement> element = getElementList(CATEGORY_ELEMENT);
        List<String> res = new ArrayList<String>();
        for(FeedElement e : element){
            res.add(e.getContentString());
        }
        return res;
    }
}
