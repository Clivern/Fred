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
 * Channel Deleted Event
 *
 * A channel was deleted. It Works with RTM and Events API
 *
 * Expected scopes: channels:read
 *
 * <a href="https://api.slack.com/events/channel_deleted">For More Info</a>
 *
 * @author Clivern
 * @since 1.0.0
 */
public class ChannelDeleted extends EventTemplate {

    protected Function<ChannelDeleted,String> callback;

    /**
     * Class Constructor
     *
     * @param callback
     */
    public ChannelDeleted(Function<ChannelDeleted,String> callback)
    {
        this.callback = callback;
    }

    /**
     * Set Event Type. It should be channel_deleted
     *
     * @param eventType
     */
    public void setEventType(String eventType)
    {
        this.setIncomingItem("event.type", eventType);
    }

    /**
     * Set Channel Name
     *
     * @param channel
     */
    public void setChannel(String channel)
    {
        this.setIncomingItem("event.channel", channel);
    }

    /**
     * Get Event Type. It should be channel_deleted
     *
     * @return String
     */
    public String getEventType()
    {
        return this.getIncomingItem("event.type", "");
    }

    /**
     * Get Channel Name
     *
     * @return String
     */
    public String getChannel()
    {
        return this.getIncomingItem("event.channel", "");
    }

    /**
     * Check if This Event Is Called
     *
     * @return Boolean
     */
    public Boolean isCalled()
    {
        JSONObject requestData = new JSONObject(this.getPlainRequest());

        return (requestData.has("type") && requestData.getString("type").equals("channel_deleted"));
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
        if( requestData.has("channel") && !requestData.getString("channel").equals("") ){
            this.setChannel(requestData.getString("channel"));
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