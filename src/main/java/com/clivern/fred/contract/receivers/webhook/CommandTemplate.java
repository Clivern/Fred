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
package com.clivern.fred.contract.receivers.webhook;

import java.util.HashMap;
import java.util.Map;

/**
 * Command Template Class
 *
 * @author A.F
 * @since 1.0.0
 */
public abstract class CommandTemplate {

    protected String plainRequest;

    protected String commnadName;

    protected Map<String, String> incomingData = new HashMap<String, String>();


    /**
     * Class Constructor
     *
     * @param commnadName
     */
    public void Command(String commnadName)
    {
        this.commnadName = commnadName;
    }

    /**
     * Set Command
     *
     * @param commnadName
     */
    public void setCommand(String commnadName)
    {
        this.commnadName = commnadName;
    }

    /**
     * Get Commnad Name
     *
     * @return String
     */
    public String getCommandName()
    {
        return this.commnadName;
    }

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
     * Parse the Incoming Request
     */
    abstract public Boolean parse();
}