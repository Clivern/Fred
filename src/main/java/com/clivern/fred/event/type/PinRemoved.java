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
 * Pin Removed Event
 *
 * A pin was removed from a channel. It Works with RTM and Events API
 *
 * Expected scopes: pins:read
 *
 * <a href="https://api.slack.com/events/pin_removed">For More Info</a>
 *
 * @author A.F
 * @since 1.0.0
 */
public class PinRemoved extends EventTemplate {

    protected Function<PinRemoved,String> callback;

    /**
     * Class Constructor
     *
     * @param callback
     */
    public PinRemoved(Function<PinRemoved,String> callback)
    {
        this.callback = callback;
    }

    /**
     * Set Event Type. It should be pin_removed
     *
     * @param eventType
     */
    public void setEventType(String eventType)
    {
        this.setIncomingItem("event.type", eventType);
    }

    /**
     * Set User
     *
     * @param user
     */
    public void setUser(String user)
    {
        this.setIncomingItem("event.user", user);
    }

    /**
     * Set Channel Id
     *
     * @param channelId
     */
    public void setChannelId(String channelId)
    {
        this.setIncomingItem("event.channel_id", channelId);
    }

    /**
     * Set Has Pins
     *
     * @param hasPins
     */
    public void setHasPins(String hasPins)
    {
        this.setIncomingItem("event.has_pins", hasPins);
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
     * Get Event Type. It should be pin_removed
     *
     * @return String
     */
    public String getEventType()
    {
        return this.getIncomingItem("event.type", "");
    }

    /**
     * Get User
     *
     * @return String
     */
    public String getUser()
    {
        return this.getIncomingItem("event.user", "");
    }

    /**
     * Get Channel Id
     *
     * @return String
     */
    public String getChannelId()
    {
        return this.getIncomingItem("event.channel_id", "");
    }

    /**
     * Get Has Pins
     *
     * @return String
     */
    public String getHasPins()
    {
        return this.getIncomingItem("event.has_pins", "");
    }

    /**
     * Get Event Ts
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

        return (requestData.has("type") && requestData.getString("type").equals("pin_removed"));
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
        if( requestData.has("user") && !requestData.getString("user").equals("") ){
            this.setUser(requestData.getString("user"));
        }
        if( requestData.has("channel_id") && !requestData.getString("channel_id").equals("") ){
            this.setChannelId(requestData.getString("channel_id"));
        }
        if( requestData.has("has_pins") && !requestData.getString("has_pins").equals("") ){
            this.setHasPins(requestData.getString("has_pins"));
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