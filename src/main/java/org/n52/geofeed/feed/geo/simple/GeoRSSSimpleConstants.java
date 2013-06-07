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

/**
 * 
 * @author Arne de Wall <a.dewall@52North.org>
 *
 */
public interface GeoRSSSimpleConstants {
    String BOX_KEY = "box";
    String POLYGON_KEY = "polygon";
    String LINE_KEY = "line";
    String CIRCLE_KEY = "circle";
    String POINT_KEY = "point";
    
    String ELEVATION_KEY = "elev";
    String RADIUS_KEY = "radius";
    String FLOOR_KEY = "floor";
    
    String FEATURE_TYPE_TAG_KEY = "featureTypeTag";
    String RELATIONSHIP_TAG_KEY = "relationshipTag";
    String FEATURENAME_KEY = "featureName";
}
