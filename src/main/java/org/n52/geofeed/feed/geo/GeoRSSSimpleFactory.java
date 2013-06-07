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
package org.n52.geofeed.feed.geo;

import java.util.HashMap;
import java.util.Map;

import org.n52.geofeed.BaseFeedElement;
import org.n52.geofeed.feed.FeedFactory;
import org.n52.geofeed.feed.extension.FeedExtensionFactory;
import org.n52.geofeed.feed.geo.simple.GeoRSSBox;
import org.n52.geofeed.feed.geo.simple.GeoRSSCircle;
import org.n52.geofeed.feed.geo.simple.GeoRSSLineString;
import org.n52.geofeed.feed.geo.simple.GeoRSSPoint;
import org.n52.geofeed.feed.geo.simple.GeoRSSPolygon;
import org.n52.geofeed.feed.geo.simple.GeoRSSSimpleConstants;

/**
 * 
 * @author Arne de Wall <a.dewall@52North.org>
 *
 */
public class GeoRSSSimpleFactory extends FeedExtensionFactory implements GeoRSSSimpleConstants{
    private static Map<String, Class<? extends BaseFeedElement>> classMap = new HashMap<String, Class<? extends BaseFeedElement>>() {
        private static final long serialVersionUID = -3093458063451053096L;
        {
           put(BOX_KEY, GeoRSSBox.class);
           put(POINT_KEY, GeoRSSPoint.class);
           put(CIRCLE_KEY, GeoRSSCircle.class);
           put(POLYGON_KEY, GeoRSSPolygon.class);
           put(LINE_KEY, GeoRSSLineString.class);
        }  
    };
    
    public GeoRSSSimpleFactory(FeedFactory feedFactory) {
        super(feedFactory, GeoRSSSimpleFactory.classMap);
    }

}
