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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.n52.geofeed.BaseFeedEntry;
import org.n52.geofeed.core.FeedElement;
import org.n52.geofeed.core.IEntry;
import org.xml.sax.Attributes;

/**
 * 
 * @author Arne de Wall <a.dewall@52North.org>
 *
 */
public class AtomEntry extends BaseFeedEntry implements IEntry{

    
    public AtomEntry(String name, String uri, Attributes attibutes) {
        super(name, uri, attibutes);
    }

    @Override
    public String getTitle() {
        FeedElement title = getElement(TITLE_ATTRIB);
        return title == null ? null : title.getContentString();
    }

    @Override
    public String getId() {
        FeedElement id = getElement(ID_ATTRIB);
        return id == null ? null : id.getContentString();
    }

    @Override
    public String getLink() {
        FeedElement link = getElement(LINK_ATTRIB);
        return link == null ? null : link.getAttributes().getValue(HREF_ATTRIB);
    }

    @Override
    public List<String> getLinks() {
        FeedElement link = getElement(LINK_ATTRIB);
        return link == null ? null : Arrays.asList(link.getContentString());
    }

    @Override
    public String getDescription() {
        FeedElement description = getElement(SUMMARY_ATTRIB);
        return description == null ? null : description.getContentString();
    }

    @Override
    public String getContents() {
        FeedElement element = getElement(CONTENT_ATTRIB);
        return element == null ? null : element.getContentString();
    }

    @Override
    public Date getPublisedDate() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Date getUpdatedDate() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<String> getCategorys() {
        List<String> res = new ArrayList<String>();
        for(FeedElement e : getElementList(CATEGORY_ATTRIB))
            res.add(e.getContentString());
        return res;
    }

    @Override
    public String getAuthor() {
        FeedElement element = getElement(AUTHOR_ATTRIB);
        return element == null ? null : element.getContentString();
    }

    @Override
    public FeedElement getBbox() {
        List<FeedElement> bbox = getElementList(BBOX_ATTRIB);
        return bbox == null ? null : bbox.get(0);
    }

    @Override
    public String getRights() {
        FeedElement element = getElement(RIGHTS_ATTRIB);
        return element == null ? null : element.getContentString();
    }

}
