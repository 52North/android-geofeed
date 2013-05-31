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
import org.n52.geofeed.feed.geo.ICircle;
import org.xml.sax.Attributes;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.LinearRing;
import com.vividsolutions.jts.util.GeometricShapeFactory;

/**
 * 
 * @author Arne de Wall <a.dewall@52North.org>
 *
 */
public class GeoRSSCircle extends BaseGeoFeedElement implements ICircle {
    private Double radius = null;
    private Double latitude = null;
    private Double longitude = null;
    
    public GeoRSSCircle(String name, String uri, Attributes attibutes) {
        super(name, uri, attibutes);
    }

    @Override
    protected void parseGeometry() throws MalformedGeoElementExecption {
        String[] circleStrings = getElement(CIRCLE).getContentString().split(" ");
        if(circleStrings.length != 3)
            throw new MalformedGeoElementExecption("[CIRCLE]");
        
        latitude = Double.parseDouble(circleStrings[0]);
        longitude = Double.parseDouble(circleStrings[1]);
        radius = Double.parseDouble(circleStrings[2]);
        
        GeometricShapeFactory shapeFactory = new GeometricShapeFactory();
        shapeFactory.setNumPoints(32);
        shapeFactory.setCentre(new Coordinate(latitude,longitude));
        shapeFactory.setSize(2*radius);
        geometry = shapeFactory.createCircle();
    }

    @Override
    public double getRadius() {
        getGeometry();
        return radius;
    }

    @Override
    public double getLongitude() {
        getGeometry();
        return longitude;
    }

    @Override
    public double getLatitude() {
        getGeometry();
        return latitude;
    }

    @Override
    public LinearRing getCircle() {
        return (LinearRing) getGeometry();
    }
    
}
