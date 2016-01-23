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
package eu.vocabularytrainer;

import eu.vocabularytrainer.vocabulary.interfaces.IVocabulary;
import eu.vocabularytrainer.interfaces.IVocabularyTrainerModel;
import eu.vocabularytrainer.vocabulary.interfaces.IVocabularyElementPair;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Random;
import java.util.UUID;

/**
 *
 * @author Andre Schepers <andre@team51.nl>
 */
public class DefaultVocabularyTrainerModel extends Observable implements IVocabularyTrainerModel {

  private IVocabulary vocabulary = null;
  private List<IVocabularyElementPair> activePairs = null;
  private IVocabularyElementPair activePair = null;
  
  /**
   * 
   * @param index 
   */
  @Override
  public void setNewPairGroup(int index) {
    if (vocabulary == null) throw new NullPointerException("No Vocabulary set, can't update!");
    if (index < 0 || index >= vocabulary.getNofPairGroups()) throw new IllegalArgumentException("Index is not within range of the number of groups.");
    getVocabularyPairs().clear();
    getVocabularyPairs().addAll(vocabulary.getPairGroup(index));
    setRandomActiveQuery();
  }

  /**
   * 
   */
  @Override
  public void setRandomActiveQuery() {
    if (activePairs == null) throw new NullPointerException("No Vocabulary set, can't set random active pair!");
    Random r = new Random();
    if (activePair == null) activePair = activePairs.get(r.nextInt(activePairs.size()));
    List<IVocabularyElementPair> temp = new ArrayList<>();
    temp.addAll(activePairs);
    temp.remove(activePair);
    activePair = temp.get(r.nextInt(temp.size()));
  }

  /**
   * 
   * @param uuid 
   */
  @Override
  public void setActiveQuery(UUID uuid) {
    for (IVocabularyElementPair pair : activePairs) {
      if (pair.getUuid() == uuid) {
        activePair = pair;
      }
    }
  }

  /**
   * 
   * @return 
   */
  @Override
  public IVocabularyElementPair getActiveQueryPair() {
    return activePair;
  }

  /**
   * 
   * @param vocabulary 
   */
  @Override
  public void setVocabulary(IVocabulary vocabulary) {
    this.vocabulary = vocabulary;
  }

  /**
   * 
   * @return 
   */
  private List<IVocabularyElementPair> getVocabularyPairs() {
    if (activePairs == null) {
      activePairs = new ArrayList<>();
    }
    return activePairs;
  }
  
}
