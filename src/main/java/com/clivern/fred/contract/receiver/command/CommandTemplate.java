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
package com.clivern.fred.contract.receiver.command;

import java.util.HashMap;
import java.util.Map;

/**
 * Command Template Class
 *
 * @author A.F
 * @since 1.0.0
 */
public abstract class CommandTemplate {

    protected String command;

    protected String requestURL;

    protected String shortDescription;

    protected String usageHint;

    protected Map<String, String> incomingData = new HashMap<String, String>();

    protected String plainRequest;


    /**
     * Class Constructor
     *
     * @param command
     * @param requestURL
     */
    public void Command(String command, String requestURL)
    {
        this.command = command;
        this.requestURL = requestURL;
    }

    /**
     * Class Constructor
     *
     * @param command
     * @param requestURL
     * @param shortDescription
     * @param usageHint
     */
    public void Command(String command, String requestURL, String shortDescription, String usageHint)
    {
        this.command = command;
        this.requestURL = requestURL;
        this.shortDescription = shortDescription;
        this.usageHint = usageHint;
    }

    /**
     * Set Command
     *
     * @param command
     */
    public void setCommand(String command)
    {
        this.command = command;
    }

    /**
     * Set Request URL
     *
     * @param requestURL
     */
    public void setRequestURL(String requestURL)
    {
        this.requestURL = requestURL;
    }

    /**
     * Set Short Description
     *
     * @param shortDescription
     */
    public void setShortDescription(String shortDescription)
    {
        this.shortDescription = shortDescription;
    }

    /**
     * Set Usage Hint
     *
     * @param usageHint
     */
    public void setUsageHint(String usageHint)
    {
        this.usageHint = usageHint;
    }

    /**
     * Get Commnad Name
     *
     * @return String
     */
    public String getCommand()
    {
        return this.command;
    }

    /**
     * Get request URL
     *
     * @return String
     */
    public String getRequestURL()
    {
        return this.requestURL;
    }

    /**
     * Get Short Description
     *
     * @return String
     */
    public String getShortDescription()
    {
        return this.shortDescription;
    }

    /**
     * Get Usage Hint
     *
     * @return String
     */
    public String getUsageHint()
    {
        return this.usageHint;
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