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
import eu.vocabularytrainer.vocabulary.DefaultIterationImpl;
import eu.vocabularytrainer.vocabulary.interfaces.IVocabulary.Direction;
import eu.vocabularytrainer.vocabulary.interfaces.IRepresentative.Representation;

/**
 *
 * @author Andre Schepers andreschepers81@gmail.com
 */
@JsonDeserialize(as=DefaultIterationImpl.class)
public interface IIteration {
 
    /**
     * 
     * @return 
     */
    public int getIndex();
    
    /**
     * 
     * @param index 
     */
    public void setIndex(int index);
    
    /**
     * 
     * @return 
     */
    public Representation getOptionType();
    
    /**
     * 
     * @param type
     */
    public void setOptionType(Representation representation);
    
    /**
     * 
     * @return 
     */
    public Representation getQueryType();
    
    /**
     * 
     * @param type
     */
    public void setQueryType(Representation representation);
    
    /**
     * 
     * @return 
     */
    public Direction getColumnOrder();
    
    /**
     * 
     * @param order
     */
    public void setColumnOrder(Direction direction);
}
