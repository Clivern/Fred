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
package com.clivern.fred.event.type;

import com.clivern.fred.contract.event.type.EventTemplate;
import org.json.JSONObject;
import java.util.function.Function;

/**
 * App Uninstalled Event
 *
 * Your Slack app was uninstalled. It Works with Events API
 *
 * <a href="https://api.slack.com/events/app_uninstalled">For More Info</a>
 *
 * @author Clivern
 * @since 1.0.0
 */
public class AppUninstalled extends EventTemplate {

    protected Function<AppUninstalled,String> callback;

    /**
     * Class Constructor
     *
     * @param callback
     */
    public AppUninstalled(Function<AppUninstalled,String> callback)
    {
        this.callback = callback;
    }

    /**
     * Set Event Type. It should be app_uninstalled
     *
     * @param eventType
     */
    public void setEventType(String eventType)
    {
        this.setIncomingItem("event.type", eventType);
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
     * Set Team ID
     *
     * @param teamId
     */
    public void setTeamId(String teamId)
    {
        this.setIncomingItem("team_id", teamId);
    }

    /**
     * Set API App Id
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
     * Get Event Type. It should be app_uninstalled
     *
     * @return String
     */
    public String getEventType()
    {
        return this.getIncomingItem("event.type", "");
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
     * Get Team Id
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
     * Check if This Event Is Called
     *
     * @return Boolean
     */
    public Boolean isCalled()
    {
        JSONObject requestData = new JSONObject(this.getPlainRequest());

        return (requestData.has("event") && !requestData.getString("event").equals("") && requestData.getString("event").contains("app_uninstalled") );
    }

    /**
     * Parse Event Incoming Data
     *
     * @return Boolean
     */
    public Boolean parse()
    {
        JSONObject requestData = new JSONObject(this.getPlainRequest());

        if( requestData.has("event") && !requestData.getString("event").equals("") ){
            JSONObject eventData = new JSONObject(requestData.getString("event"));
            this.setEventType(eventData.has("type") ? eventData.getString("type") : "");
        }

        if( requestData.has("token") && !requestData.getString("token").equals("") ){
            this.setToken(requestData.getString("token"));
        }

        if( requestData.has("team_id") && !requestData.getString("team_id").equals("") ){
            this.setTeamId(requestData.getString("team_id"));
        }

        if( requestData.has("api_app_id") && !requestData.getString("api_app_id").equals("") ){
            this.setApiAppId(requestData.getString("api_app_id"));
        }

        if( requestData.has("type") && !requestData.getString("type").equals("") ){
            this.setType(requestData.getString("type"));
        }

        if( requestData.has("event_id") && !requestData.getString("event_id").equals("") ){
            this.setEventId(requestData.getString("event_id"));
        }

        if( requestData.has("event_time") && !requestData.getString("event_time").equals("") ){
            this.setEventTime(requestData.getString("event_time"));
        }

        return true;
    }

    /**
     * Call Event Callback
     *
     * @return String
     */
    public String call()
    {
        return this.callback.apply(this);
    }
}