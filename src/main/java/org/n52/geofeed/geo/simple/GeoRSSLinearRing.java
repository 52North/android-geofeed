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
package org.n52.geofeed.geo.simple;

import org.n52.geofeed.exception.MalformedGeoElementExecption;
import org.n52.geofeed.geo.BaseGeoFeedElement;
import org.n52.geofeed.geo.core.ILinearRing;
import org.xml.sax.Attributes;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.LinearRing;

/**
 * 
 * @author Arne de Wall <a.dewall@52North.org>
 *
 */
public class GeoRSSLinearRing extends BaseGeoFeedElement implements ILinearRing {

    public GeoRSSLinearRing(String name, String uri, Attributes attibutes) {
        super(name, uri, attibutes);
    }

    @Override
    public LinearRing getLinearRing() { 
        return (LinearRing) getGeometry();
    }

    @Override
    protected void parseGeometry() throws MalformedGeoElementExecption {
        String[] coordStrings = getElement(CIRCLE).getContentString().split(" ");
        if(coordStrings.length%2 != 0)
            throw new MalformedGeoElementExecption(CIRCLE);
        Coordinate[] coordinates = new Coordinate[coordStrings.length/2];
        for(int i = 0, j = 0; i < coordStrings.length / 2; i+=2, j++){
            coordinates[j] = new Coordinate(Double.parseDouble(coordStrings[i]), 
                    Double.parseDouble(coordStrings[i+1]));
        }  
        geometry = factory.createLinearRing(coordinates);
    }

}
