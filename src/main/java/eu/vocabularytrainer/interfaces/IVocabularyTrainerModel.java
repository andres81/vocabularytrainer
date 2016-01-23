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
package eu.vocabularytrainer.interfaces;

import eu.vocabularytrainer.vocabulary.interfaces.IVocabulary;
import eu.vocabularytrainer.vocabulary.interfaces.IVocabularyElementPair;
import java.util.Observer;
import java.util.UUID;

/**
 *
 * @author Andre Schepers <andre@team51.nl>
 */
public interface IVocabularyTrainerModel {

  /**
   * 
   * @param index 
   */
  public void setNewPairGroup(int index);
  
  /**
   * 
   */
  public void setRandomActiveQuery();
  
  /**
   * 
   * @param uuid 
   */
  public void setActiveQuery(UUID uuid);
  
  /**
   * 
   * @return 
   */
  public IVocabularyElementPair getActiveQueryPair();
  
  /**
   * 
   * @param vocabulary 
   */
  public void setVocabulary(IVocabulary vocabulary);

  /**
   * 
   * @param o 
   */
  public void addObserver(Observer o);
  
}
