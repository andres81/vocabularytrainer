/*
 * Copyright 2016 Andre Schepers andreschepers81@gmail.com.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package eu.vocabularytrainer.vocabulary;

import eu.vocabularytrainer.vocabulary.interfaces.IRepresentative;
import java.util.UUID;

/**
 *
 * @author andres81
 */
public class DefaultRepresentative implements IRepresentative {
    
    /**
     * 
     */
    private String title = null;
    
    /**
     * 
     */
    private String image = null;
    
    /**
     * 
     */
    private String sound = null;
    
    /**
     * 
     */
    private UUID uuid = null;
    
    /**
     * 
     */
    public DefaultRepresentative() {
        uuid = UUID.randomUUID();
        image = "";
        sound = "";
        title = "TITLE";
    }
    
    /**
     * 
     * @param title
     * @param image 
     * @param sound 
     */
    public DefaultRepresentative(String title, String image, String sound) {
        this();
        this.title = title == null ? "title" : title;
        this.image = image;
        this.sound = sound;
    }
    
    /**
     * 
     */
    @Override
    public String getImage() {
        return image;
    }
    
    /**
     * 
     * @param image 
     */
    public void setImage(String image) {
        this.image = image;
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public String getTitle() {
        return title; 
    }
    
    /**
     * 
     * @param title 
     */
    public void setTitle(String title) {
        this.title = title == null ? "title" : title;
    }

    /**
     * 
     */
    @Override
    public String getSound() {
        return sound;
    }
    
    /**
     * 
     * @param sound 
     */
    @Override
    public void setSound(String sound) {
        this.sound = sound;
    }
    
    @Override
    public UUID getUuid() {
        return uuid;
    }
}
