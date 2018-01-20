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
package com.clivern.fred.event.type;

import com.clivern.fred.contract.event.type.EventTemplate;
import org.json.JSONObject;
import java.util.function.Function;

/**
 * Group History Changed Event
 *
 * Bulk updates were made to a private channel's history. It Works with RTM and Events API
 *
 * Expected scopes: groups:history
 *
 * <a href="https://api.slack.com/events/group_history_changed">For More Info</a>
 *
 * @author A.F
 * @since 1.0.0
 */
public class GroupHistoryChanged extends EventTemplate {

    protected Function<GroupHistoryChanged,String> callback;

    /**
     * Class Constructor
     *
     * @param callback
     */
    public GroupHistoryChanged(Function<GroupHistoryChanged,String> callback)
    {
        this.callback = callback;
    }

    /**
     * Set Event Type. It should be group_history_changed
     *
     * @param eventType
     */
    public void setEventType(String eventType)
    {
        this.setIncomingItem("event.type", eventType);
    }

    /**
     * Set Latest
     *
     * @param latest
     */
    public void setLatest(String latest)
    {
        this.setIncomingItem("event.latest", latest);
    }

    /**
     * Set Ts
     *
     * @param ts
     */
    public void setTs(String ts)
    {
        this.setIncomingItem("event.ts", ts);
    }

    /**
     * Set Event Ts
     *
     * @param eventTs
     */
    public void setEventTs(String eventTs)
    {
        this.setIncomingItem("event.event_ts", eventTs);
    }

    /**
     * Get Event Type. It should be group_history_changed
     *
     * @return String
     */
    public String getEventType()
    {
        return this.getIncomingItem("event.type", "");
    }

    /**
     * Get Latest
     *
     * @return String
     */
    public String getLatest()
    {
        return this.getIncomingItem("event.latest", "");
    }

    /**
     * Get Ts
     *
     * @return String
     */
    public String getTs()
    {
        return this.getIncomingItem("event.ts", "");
    }

    /**
     * Get EventTs
     *
     * @return String
     */
    public String getEventTs()
    {
        return this.getIncomingItem("event.event_ts", "");
    }

    /**
     * Check if This Event Is Called
     *
     * @return Boolean
     */
    public Boolean isCalled()
    {
        JSONObject requestData = new JSONObject(this.getPlainRequest());

        return (requestData.has("type") && requestData.getString("type").equals("group_history_changed"));
    }

    /**
     * Parse Event Incoming Data
     *
     * @return Boolean
     */
    public Boolean parse()
    {
        JSONObject requestData = new JSONObject(this.getPlainRequest());

        if( requestData.has("type") && !requestData.getString("type").equals("") ){
            this.setEventType(requestData.getString("type"));
        }
        if( requestData.has("latest") && !requestData.getString("latest").equals("") ){
            this.setLatest(requestData.getString("latest"));
        }
        if( requestData.has("ts") && !requestData.getString("ts").equals("") ){
            this.setTs(requestData.getString("ts"));
        }
        if( requestData.has("event_ts") && !requestData.getString("event_ts").equals("") ){
            this.setEventTs(requestData.getString("event_ts"));
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