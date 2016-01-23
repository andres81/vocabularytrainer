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

import eu.vocabularytrainer.vocabulary.interfaces.IVocabulary;
import eu.vocabularytrainer.vocabulary.interfaces.IVocabulary.Direction;
import eu.vocabularytrainer.vocabulary.interfaces.IIteration;
import eu.vocabularytrainer.vocabulary.interfaces.IRepresentative;
import eu.vocabularytrainer.vocabulary.interfaces.IVocabularyElementPair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Andre Schepers andreschepers81@gmail.com
 */
public class DefaultVocabulary implements IVocabulary {

    /**
     * 
     */
    private List<IVocabularyElementPair> vocabularyPairs;
    
    /**
     * 
     */
    private List<IIteration> iterations;
    
    /**
     * 
     */
    private DefaultVocabulary() {}
    
    /**
     * 
     * @return 
     */
    @Override
    public List<IVocabularyElementPair> getPairs() {
        return vocabularyPairs;
    }
    
    /**
     * 
     * @param pairs 
     */
    @Override
    public void setPairs(List<IVocabularyElementPair> pairs) {
        if (pairs == null) {
            throw new NullPointerException();
        }
        this.vocabularyPairs = pairs;
    }
    
    /**
     * 
     * @param pair 
     */
    public void addPair(IVocabularyElementPair pair) {
        if (pair == null) {
            throw new NullPointerException();
        }
        if (vocabularyPairs == null) {
            vocabularyPairs = new ArrayList<>();
        }
        vocabularyPairs.add(pair);
    }

    /**
     * 
     * @param iterations 
     */
    @Override
    public void setIterations(List<IIteration> iterations) {
        this.iterations = iterations;
        Collections.sort(this.iterations, new Comparator<IIteration>() {
            @Override
            public int compare(IIteration t, IIteration t1) {
                int ti1 = t.getIndex();
                int ti2 = t.getIndex();
                if (ti1 < ti2) return -1;
                if (ti1 == ti2) return 0;
                return 1;
            }
        });
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public List<IIteration> getIterations() {
        return iterations;
    }

    /**
     * 
     * @param index
     * @return 
     */
    @Override
    public IRepresentative.Representation getQueryRepresentation(int index) {
      return getIterations().get(index/5).getQueryType();
    }

    /**
     * 
     * @param index
     * @return 
     */
    @Override
    public IRepresentative.Representation getOptionsRepresentation(int index) {
      return getIterations().get(index/5).getOptionType();
    }

    /**
     * 
     * @param index
     * @return 
     */
    @Override
    public Direction getDirection(int index) {
      return getIterations().get(index/5).getColumnOrder();
    }

    /**
     * 
     * @param index
     * @return 
     */
    @Override
    public List<IVocabularyElementPair> getPairGroup(int index) {
      List<IVocabularyElementPair> pairs = new ArrayList<>();
      int pc = vocabularyPairs.size();
      int nofGroupsPerIteration = pc / 5 + (pc%5 == 0 ? 0 : 1);
      int reducedIndex = index % nofGroupsPerIteration;
      for (int i=reducedIndex;i<reducedIndex+5;++i) {
        if (i<pc) {
          pairs.add(vocabularyPairs.get(i));
        } else {
          pairs.add(vocabularyPairs.get(i%pc));
        }
      }
      return pairs;
    }

    /**
     * 
     * @return 
     */
    @Override
    public int getNofPairGroups() {
        return ((int)(vocabularyPairs.size() / 5) + 1) * iterations.size();
    }
}
