/*
 * Copyright (C) 2017 A.F <http://clivern.com>
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

/**
 * Event Template Class
 *
 * @author A.F
 * @since 1.0.0
 */
public abstract class EventTemplate {

    protected String event;

    protected Map<String, String> incomingData = new HashMap<String, String>();

    protected String plainRequest;

/*
    {
        "token": "XXYYZZ",
        "team_id": "TXXXXXXXX",
        "api_app_id": "AXXXXXXXXX",
        "event": {
                "type": "name_of_event",
                "event_ts": "1234567890.123456",
                "user": "UXXXXXXX1",
                ...
        },
        "type": "event_callback",
        "authed_users": [
                "UXXXXXXX1",
                "UXXXXXXX2"
        ],
        "event_id": "Ev08MFMKH6",
        "event_time": 1234567890
    }
*/

    /**
     * Class Constructor
     *
     * @param event
     */
    public void EventTemplate(String event)
    {
        this.event = event;
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
    public void setAuthedUsers(String authedUsers)
    {
        this.setIncomingItem("authed_users", authedUsers);
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