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

    protected String validationToken;

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
     * Set Validation Token
     *
     * @param validationToken
     */
    public void setValidationToken(String validationToken)
    {
        this.validationToken = validationToken;
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
     * Get Validation Token
     *
     * @return String
     */
    public String getValidationToken()
    {
        return this.validationToken;
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
     * Set Token
     *
     * @param token
     */
    public void setToken(String token)
    {
        this.setIncomingItem("token", token);
    }

    /**
     * Set Team Id
     *
     * @param teamId
     */
    public void setTeamId(String teamId)
    {
        this.setIncomingItem("team_id", teamId);
    }

    /**
     * Set Team Domain
     *
     * @param teamDomain
     */
    public void setTeamDomain(String teamDomain)
    {
        this.setIncomingItem("team_domain", teamDomain);
    }

    /**
     * Set Enterprise Id
     *
     * @param enterpriseId
     */
    public void setEnterpriseId(String enterpriseId)
    {
        this.setIncomingItem("enterprise_id", enterpriseId);
    }

    /**
     * Set Enterprise Name
     *
     * @param enterpriseName
     */
    public void setEnterpriseName(String enterpriseName)
    {
        this.setIncomingItem("enterprise_name", enterpriseName);
    }

    /**
     * Set Channel Id
     *
     * @param channelId
     */
    public void setChannelId(String channelId)
    {
        this.setIncomingItem("channel_id", channelId);
    }

    /**
     * Set Channel Name
     *
     * @param channelName
     */
    public void setChannelName(String channelName)
    {
        this.setIncomingItem("channel_name", channelName);
    }

    /**
     * Set User Id
     *
     * @param userId
     */
    public void setUserId(String userId)
    {
        this.setIncomingItem("user_id", userId);
    }

    /**
     * Set User Name
     *
     * @param userName
     */
    public void setUserName(String userName)
    {
        this.setIncomingItem("user_name", userName);
    }

    /**
     * Set Text
     *
     * @param text
     */
    public void setText(String text)
    {
        this.setIncomingItem("text", text);
    }

    /**
     * Set Response Url
     *
     * @param responseUrl
     */
    public void setResponseUrl(String responseUrl)
    {
        this.setIncomingItem("response_url", responseUrl);
    }

    /**
     * Set Trigger Id
     *
     * @param triggerId
     */
    public void setTriggerId(String triggerId)
    {
        this.setIncomingItem("trigger_id", triggerId);
    }

    /**
     * Get Token
     *
     * @return String
     */
    public String getToken()
    {
        return this.getIncomingItem("token", "");
    }

    /**
     * Get Team ID
     *
     * @return String
     */
    public String getTeamId()
    {
        return this.getIncomingItem("team_id", "");
    }

    /**
     * Get Team Domain
     *
     * @return String
     */
    public String getTeamDomain()
    {
        return this.getIncomingItem("team_domain", "");
    }

    /**
     * Get Enterprise ID
     *
     * @return String
     */
    public String getEnterpriseId()
    {
        return this.getIncomingItem("enterprise_id", "");
    }

    /**
     * Get Enterprise Name
     *
     * @return String
     */
    public String getEnterpriseName()
    {
        return this.getIncomingItem("enterprise_name", "");
    }

    /**
     * Get Channel ID
     *
     * @return String
     */
    public String getChannelId()
    {
        return this.getIncomingItem("channel_id", "");
    }

    /**
     * Get Channel Name
     *
     * @return String
     */
    public String getChannelName()
    {
        return this.getIncomingItem("channel_name", "");
    }

    /**
     * Get User ID
     *
     * @return String
     */
    public String getUserId()
    {
        return this.getIncomingItem("user_id", "");
    }

    /**
     * Get User Name
     *
     * @return String
     */
    public String getUserName()
    {
        return this.getIncomingItem("user_name", "");
    }

    /**
     * Get Text
     *
     * @return String
     */
    public String getText()
    {
        return this.getIncomingItem("text", "");
    }

    /**
     * Get Response URL
     *
     * @return String
     */
    public String getResponseUrl()
    {
        return this.getIncomingItem("response_url", "");
    }

    /**
     * Get Trigger ID
     *
     * @return String
     */
    public String getTriggerId()
    {
        return this.getIncomingItem("trigger_id", "");
    }


    /**
     * Parse the Incoming Request Data
     *
     * @param incomingData
     */
    abstract public Boolean parse(Map<String, String> incomingData);
}