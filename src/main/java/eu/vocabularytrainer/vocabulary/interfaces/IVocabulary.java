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

import java.util.List;

/**
 *
 * @author Andre Schepers andreschepers81@gmail.com
 */
public interface IVocabulary {
    
    /**
     * 
     */
    public enum Direction {
       COLUMNONETOONE,
       COLUMNONETOTWO,
       COLUMNTWOTOONE,
       COLUMNTWOTOTWO;
    };
    
    /**
     * 
     */
    public enum UpdateType {
       PAIRS,
       ACTIVEPAIRS,
       DIRECTION,
       ACTIVEPAIR,
       QUERYINTERACTIONTYPE,
       OPTIONSINTERACTIONTYPE;
    };
    
    /**
     * 
     * @param pairs 
     */
    public void setPairs(List<IVocabularyElementPair> pairs);
    
    /**
     * 
     * @return 
     */
    public List<IVocabularyElementPair> getPairs();

    /**
     * 
     * @param iterations 
     */
    public void setIterations(List<IIteration> iterations);
    
    /**
     * 
     * @return 
     */
    public List<IIteration> getIterations();
    
    /**
     * 
     * @param index
     * @return 
     */
    public IRepresentative.Representation getQueryRepresentation(int index);
    
    /**
     * 
     * @param index
     * @return 
     */
    public IRepresentative.Representation getOptionsRepresentation(int index);
    
    /**
     * 
     * @param index
     * @return 
     */
    public Direction getDirection(int index);
    
    /**
     * 
     * @param index
     * @return 
     */
    public List<IVocabularyElementPair> getPairGroup(int index);
    
    /**
     * 
     * @return 
     */
    public int getNofPairGroups();
    
}
