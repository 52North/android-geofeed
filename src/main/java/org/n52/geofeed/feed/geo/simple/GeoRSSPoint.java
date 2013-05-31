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
package org.n52.geofeed.feed.geo.simple;

import org.n52.geofeed.exception.MalformedGeoElementExecption;
import org.n52.geofeed.feed.geo.BaseGeoFeedElement;
import org.n52.geofeed.feed.geo.IPoint;
import org.xml.sax.Attributes;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Point;

/**
 * 
 * @author Arne de Wall <a.dewall@52North.org>
 * 
 */
public class GeoRSSPoint extends BaseGeoFeedElement implements IPoint {

    public GeoRSSPoint(String name, String uri, Attributes attibutes) {
        super(name, uri, attibutes);
    }

    @Override
    public double getLongitude() {
        return getPoint().getX();
    }

    @Override
    public double getLatitude() {
        return getPoint().getY();
    }

    @Override
    protected void parseGeometry() throws MalformedGeoElementExecption {
        String[] coordStrings = getElement(POINT).getContentString().split(" ");
        if (coordStrings.length != 2)
            throw new MalformedGeoElementExecption(POINT);

        geometry = factory.createPoint(new Coordinate( //
                Double.parseDouble(coordStrings[0]), //
                Double.parseDouble(coordStrings[1])));
    }

    @Override
    public Point getPoint() {
        return (Point) getGeometry();
    }

}
