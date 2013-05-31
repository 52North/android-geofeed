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
package org.n52.geofeed.atom;

import java.util.Date;
import java.util.List;

import org.n52.geofeed.BaseFeedElement;
import org.n52.geofeed.FeedDateTimeConverter;
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
public class AtomFeed extends BaseFeedElement implements IFeed {

    public static final String TITLE_ELEMENT = "title";
    public static final String SUBTITLE_ELEMENT = "subtitle";
    public static final String UPDATED_ELEMENT = "updated";
    public static final String LINK_ELEMENT = "link";
    public static final String RIGHTS_ELEMENT = "rights";
    public static final String CATEGORY_ELEMENT = "category";
    public static final String ENTRY_ELEMENT = "entry";

    public static final String NAMESPACE_ATOM = "http://www.w3.org/2005/Atom";

    public AtomFeed(String name, String uri, Attributes attributes) {
        super(name, uri, attributes);
    }

    @Override
    public String getTitle() {
        FeedElement title = getElement(TITLE_ELEMENT);
        return title == null ? null : title.getContentString();
    }

    @Override
    public String getFeedType() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getDescription() {
        FeedElement element = getElement(SUBTITLE_ELEMENT);
        return element == null ? null : element.getContentString();
    }

    @Override
    public Date getPublishedDate() {
        FeedElement element = getElement(UPDATED_ELEMENT);
        return FeedDateTimeConverter.parseW3CDate(element.getContentString());
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<FeedElement> getCategories() {
        List<FeedElement> element = getElementList(CATEGORY_ELEMENT);
        return element;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<IEntry> getEntrys() {
        List<FeedElement> element = getElementList(ENTRY_ELEMENT);
        return (List<IEntry>)(List<?>) element;
    }
}
