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
package eu.vocabularytrainer.vocabulary.interfaces;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import eu.vocabularytrainer.vocabulary.DefaultRepresentative;
import java.util.UUID;

/**
 *
 * @author andres81
 */
@JsonDeserialize(as=DefaultRepresentative.class)
public interface IRepresentative {

    /**
     * 
     * @return 
     */
    public String getImage();
    
    /**
     * 
     * @return 
     */
    public String getTitle();

    /**
     * 
     * @return 
     */
    public String getSound();
    
    /**
     * 
     * @param sound
     */
    public void setSound(String sound);
    
    /**
     * 
     * @return 
     */
    public UUID getUuid();
    
    /**
     * 
     */
    public enum Representation {
       STRING,
       IMAGE,
       SOUND;
    }
}
