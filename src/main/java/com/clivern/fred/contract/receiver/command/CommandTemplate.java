/*
 * Copyright (C) 2017 Clivern <http://clivern.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.clivern.fred.contract.receiver.command;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * Command Template Class
 *
 * <a href="https://api.slack.com/slash-commands">For More Info</a>
 *
 * @author Clivern
 * @since 1.0.0
 */
public abstract class CommandTemplate {

    protected String command;

    protected String validationToken;

    protected Boolean expandedText;

    protected Map<String, String> incomingData = new HashMap<String, String>();

    protected String plainRequest;

    protected Function<CommandTemplate,String> callback;

    /**
     * Class Constructor
     *
     * @param command
     * @param expandedText
     * @param callback
     */
    public CommandTemplate(String command, Boolean expandedText, Function<CommandTemplate,String> callback)
    {
        this.command = command;
        this.expandedText = expandedText;
        this.callback = callback;
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
     * Set Validation Token
     *
     * @param validationToken
     */
    public void setValidationToken(String validationToken)
    {
        this.validationToken = validationToken;
    }

    /**
     * Set Expanded Text
     *
     * @param expandedText
     */
    public void setExpandedText(Boolean expandedText)
    {
        this.expandedText = expandedText;
    }

    /**
     * Set Callback
     *
     * @param callback
     */
    public void setCallback(Function<CommandTemplate,String> callback)
    {
        this.callback = callback;
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
     * Get Validation Token
     *
     * @return String
     */
    public String getValidationToken()
    {
        return this.validationToken;
    }

    /**
     * Get Expanded Text
     *
     * @return Boolean
     */
    public Boolean getExpandedText()
    {
        return this.expandedText;
    }

    /**
     * Get Callback
     *
     * @return Function<CommandTemplate,String>
     */
    public Function<CommandTemplate,String> getCallback()
    {
        return this.callback;
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
     * Validate The Incoming Token
     *
     * @return Boolean
     */
    public Boolean validateRequest()
    {
        if( this.validationToken.equals(this.getIncomingItem("token", "")) ){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Call Command Callback
     *
     * @return String
     */
    public String call()
    {
        return this.callback.apply(this);
    }

    /**
     * Do Further Processing
     *
     * @param Boolean
     */
    abstract public Boolean process();
}