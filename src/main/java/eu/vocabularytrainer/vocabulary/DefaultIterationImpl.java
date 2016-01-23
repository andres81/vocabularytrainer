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

import eu.vocabularytrainer.vocabulary.interfaces.IVocabulary.Direction;
import eu.vocabularytrainer.vocabulary.interfaces.IIteration;
import eu.vocabularytrainer.vocabulary.interfaces.IRepresentative.Representation;

/**
 *
 * @author Andre Schepers andreschepers81@gmail.com
 */
public class DefaultIterationImpl implements IIteration {

    /**
     * 
     */
    private int index = 0;
    
    /**
     * 
     */
    private Representation queryRepresentation = null;
    
    /**
     * 
     */
    private Representation optionRepresentation = null;
    
    /**
     * 
     */
    private Direction direction = null;
    
    
    /**
     * 
     */
    public DefaultIterationImpl() {
    }

    /**
     * 
     * @return 
     */
    @Override
    public int getIndex() {
        return index;
    }

    /**
     * 
     * @param index 
     */
    @Override
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * 
     * @return 
     */
    @Override
    public Representation getOptionType() {
        return optionRepresentation;
    }

    /**
     * 
     * @return 
     */
    @Override
    public Representation getQueryType() {
        return queryRepresentation;
    }

    /**
     * 
     * @return 
     */
    @Override
    public Direction getColumnOrder() {
        return direction;
    }

    /**
     * 
     * @param direction 
     */
    @Override
    public void setColumnOrder(Direction direction) {
        if (direction == null) throw new NullPointerException();
        this.direction = direction;
    }

    /**
     * 
     * @param representation 
     */
    @Override
    public void setOptionType(Representation representation) {
        if (representation == null) throw new NullPointerException();
        this.optionRepresentation = representation;
    }

    /**
     * 
     * @param representation 
     */
    @Override
    public void setQueryType(Representation representation) {
        if (representation == null) throw new NullPointerException();
        this.queryRepresentation = representation;
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public String toString() {
        return "Index: " + index +
               "queryType: " + queryRepresentation +
               "optionType: " + optionRepresentation + 
               "direction: " + direction;
    }
    
}
