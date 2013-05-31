package org.n52.geofeed.extension;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.n52.geofeed.core.FeedElement;
import org.n52.geofeed.core.IEntry;
import org.n52.geofeed.core.IFeed;
import org.n52.geofeed.geo.IGeoFeed;
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
    public String getFeedType() {
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

}
