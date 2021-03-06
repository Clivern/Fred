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
package com.clivern.fred.contract.event.type;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.function.Function;

/**
 * Event Template Class
 *
 * @author Clivern
 * @since 1.0.0
 */
public abstract class EventTemplate {

    protected Map<String, String> incomingData = new HashMap<String, String>();

    protected String plainRequest;

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
     * Set API App ID
     *
     * @param apiAppId
     */
    public void setApiAppId(String apiAppId)
    {
        this.setIncomingItem("api_app_id", apiAppId);
    }

    /**
     * Set Type
     *
     * @param type
     */
    public void setType(String type)
    {
        this.setIncomingItem("type", type);
    }

    /**
     * Set Authed Users
     *
     * @param authedUsers
     */
    public void setAuthedUsers(ArrayList<String> authedUsers)
    {
        String authedUsersStr = "";

        for (String authedUser : authedUsers) {
            if( !authedUsersStr.equals("") ){
                authedUsersStr += ",";
            }
            authedUsersStr += authedUser;
        }

        this.setIncomingItem("authed_users", authedUsersStr);
    }

    /**
     * Set Event Id
     *
     * @param eventId
     */
    public void setEventId(String eventId)
    {
        this.setIncomingItem("event_id", eventId);
    }

    /**
     * Set Event Time
     *
     * @param eventTime
     */
    public void setEventTime(String eventTime)
    {
        this.setIncomingItem("event_time", eventTime);
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
     * Get API App ID
     *
     * @return String
     */
    public String getApiAppId()
    {
        return this.getIncomingItem("api_app_id", "");
    }

    /**
     * Get Type
     *
     * @return String
     */
    public String getType()
    {
        return this.getIncomingItem("type", "");
    }

    /**
     * Get Authed Users
     *
     * @return String
     */
    public String getAuthedUsers()
    {
        return this.getIncomingItem("authed_users", "");
    }

    /**
     * Get Event Id
     *
     * @return String
     */
    public String getEventId()
    {
        return this.getIncomingItem("event_id", "");
    }

    /**
     * Get Event Time
     *
     * @return String
     */
    public String getEventTime()
    {
        return this.getIncomingItem("event_time", "");
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
     * @return Map
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
     * Call Event Callback
     *
     * @return String
     */
    abstract public String call();

    /**
     * Check if This Event Is Called
     *
     * @return Boolean
     */
    abstract public Boolean isCalled();

    /**
     * Parse the Incoming Request Data
     *
     * @return Boolean
     */
    abstract public Boolean parse();

}