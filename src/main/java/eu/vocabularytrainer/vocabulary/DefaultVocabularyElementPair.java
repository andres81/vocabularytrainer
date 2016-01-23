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
import eu.vocabularytrainer.vocabulary.interfaces.IVocabularyElementPair;
import java.util.Objects;
import java.util.UUID;

/**
 *
 * @author andres81
 */
public class DefaultVocabularyElementPair implements IVocabularyElementPair {
    
    /**
     * 
     */
    private IRepresentative first;

    public void setFirst(IRepresentative first) {
        this.first = first;
    }

    public void setSecond(IRepresentative second) {
        this.second = second;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
    
    /**
     * 
     */
    private IRepresentative second;
    
    /**
     * 
     */
    private UUID uuid;
    
    public DefaultVocabularyElementPair() {}
    
    /**
     * 
     * @param first
     * @param second
     */
    public DefaultVocabularyElementPair(IRepresentative first, IRepresentative second) {
        if (first == null ||
            second == null) {
            throw new NullPointerException();
        }
        this.uuid = UUID.randomUUID();
        this.first = first;
        this.second = second;
    }
    
    /**
     * 
     * @param pair 
     */
    public DefaultVocabularyElementPair(IVocabularyElementPair pair) {
        if (pair.getUuid() == null ||
            pair.getFirst() == null ||
            pair.getSecond() == null) {
            throw new NullPointerException();
        }
        this.uuid = pair.getUuid();
        this.first = pair.getFirst();
        this.second = pair.getSecond();
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public IRepresentative getFirst() {
        return first;
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public IRepresentative getSecond() {
        return second;
    }

    /**
     * 
     * @return 
     */
    @Override
    public UUID getUuid() {
        return uuid;
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof DefaultVocabularyElementPair) {
            DefaultVocabularyElementPair pair = (DefaultVocabularyElementPair) obj;
            return uuid == pair.getUuid();
        }
        return false;
    }

    /**
     * 
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.uuid);
        return hash;
    }
}
