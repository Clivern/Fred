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
 * Channel Rename Event
 *
 * A channel was renamed. It Works with RTM and Events API
 *
 * Expected scopes: channels:read
 *
 * <a href="https://api.slack.com/events/channel_rename">For More Info</a>
 *
 * @author Clivern
 * @since 1.0.0
 */
public class ChannelRename extends EventTemplate {

    protected Function<ChannelRename,String> callback;

    /**
     * Class Constructor
     *
     * @param callback
     */
    public ChannelRename(Function<ChannelRename,String> callback)
    {
        this.callback = callback;
    }

    /**
     * Set Event Type. It should be channel_rename
     *
     * @param eventType
     */
    public void setEventType(String eventType)
    {
        this.setIncomingItem("event.type", eventType);
    }

    /**
     * Set Channel Id
     *
     * @param channelId
     */
    public void setChannelId(String channelId)
    {
        this.setIncomingItem("event.channel.id", channelId);
    }

    /**
     * Set Channel Name
     *
     * @param channelName
     */
    public void setChannelName(String channelName)
    {
        this.setIncomingItem("event.channel.name", channelName);
    }

    /**
     * Set Channel Created
     *
     * @param channelCreated
     */
    public void setChannelCreated(String channelCreated)
    {
        this.setIncomingItem("event.channel.created", channelCreated);
    }

    /**
     * Get Event Type. It should be channel_rename
     *
     * @return String
     */
    public String getEventType()
    {
        return this.getIncomingItem("event.type", "");
    }

    /**
     * Get Channel Id
     *
     * @return String
     */
    public String getChannelId()
    {
        return this.getIncomingItem("event.channel.id", "");
    }

    /**
     * Get Channel Name
     *
     * @return String
     */
    public String getChannelName()
    {
        return this.getIncomingItem("event.channel.name", "");
    }

    /**
     * Get Channel Created
     *
     * @return String
     */
    public String getChannelCreated()
    {
        return this.getIncomingItem("event.channel.created", "");
    }

    /**
     * Check if This Event Is Called
     *
     * @return Boolean
     */
    public Boolean isCalled()
    {
        JSONObject requestData = new JSONObject(this.getPlainRequest());

        return (requestData.has("type") && requestData.getString("type").equals("channel_rename"));
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
            JSONObject channelData = new JSONObject(requestData.getString("channel"));
            this.setChannelId(channelData.has("id") ? channelData.getString("id") : "");
            this.setChannelName(channelData.has("name") ? channelData.getString("name") : "");
            this.setChannelCreated(channelData.has("created") ? channelData.getString("created") : "");
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