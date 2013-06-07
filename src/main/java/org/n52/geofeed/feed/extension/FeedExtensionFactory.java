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
package org.n52.geofeed.feed.extension;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.n52.geofeed.BaseFeedElement;
import org.n52.geofeed.feed.FeedFactory;
import org.xml.sax.Attributes;

/**
 * 
 * @author Arne de Wall <a.dewall@52North.org>
 *
 */
public abstract class FeedExtensionFactory implements FeedFactory {
    
    protected FeedFactory feedFactory;
    protected final Map<String, Class<? extends BaseFeedElement>> classMap;
    
    public FeedExtensionFactory(FeedFactory feedFactory, Map<String, 
            Class<? extends BaseFeedElement>> classMap){
        this.feedFactory = feedFactory;
        this.classMap = classMap;  
    }
    
    @Override
    public BaseFeedElement createElement(String localName, String uri,
            Attributes attributes) {
        
        Class<? extends BaseFeedElement> clazz;
        BaseFeedElement element = null;
        if((clazz = classMap.get(localName)) != null){
            try {
                 element = clazz.getConstructor(String.class,
                        String.class, Attributes.class).newInstance(localName, uri,
                        attributes);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        } else {
            element = feedFactory.createElement(localName, uri, attributes);
        }
        return element;
    }
}
