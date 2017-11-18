/*
 * Copyright (C) 2017 A.F <http://clivern.com>
 *
 * Licensed under the MIT License; you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * https://github.com/Clivern/Fred/blob/master/LICENSE
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.clivern.fred.contract.event.type;

import java.util.HashMap;
import java.util.Map;

/**
 * Event Template Class
 *
 * @author A.F
 * @since 1.0.0
 */
public abstract class EventTemplate {

    protected Map<String, String> incomingData = new HashMap<String, String>();

    protected String plainRequest;

    /**
     * Set Incoming Item
     *
     * @param key
     * @param value
     */
    public void setIncomingItem(String key, String value)
    {
        this.incomingData.put(key, value);
    }

    /**
     * Get Incoming Item
     *
     * @param key
     * @param defaultValue
     * @return String
     */
    public String getIncomingItem(String key, String defaultValue)
    {
        if( this.incomingData.containsKey(key) ){
            return this.incomingData.get(key);
        }

        return defaultValue;
    }

    /**
     * Set All Incoming Data
     *
     * @return incomingData
     */
    public void setIncomigData(Map<String, String> incomingData)
    {
        for (Map.Entry<String, String> pair : incomingData.entrySet()) {
            this.setIncomingItem(pair.getKey(), pair.getValue());
        }
    }

    /**
     * Get All Incoming Data
     *
     * @return Map<String, String>
     */
    public Map<String, String> getIncomigData()
    {
        return this.incomingData;
    }

    /**
     * Set Plain Request
     *
     * @param plainRequest
     */
    public void setPlainRequest(String plainRequest)
    {
        this.plainRequest = plainRequest;
    }

    /**
     * Get Plain Request
     *
     * @return String
     */
    public String getPlainRequest()
    {
        return this.plainRequest;
    }

    /**
     * Debug The Request
     *
     * @return String
     */
    public String toString()
    {
        return this.getPlainRequest();
    }

    /**
     * Parse the Incoming Request Data
     *
     * @param incomingData
     */
    abstract public Boolean parse();

}