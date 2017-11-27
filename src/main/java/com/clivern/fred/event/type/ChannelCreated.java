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

/**
 * Channel Created Event
 *
 * Expected scopes: channels:read
 *
 * <a href="https://api.slack.com/events/channel_created">For More Info</a>
 *
 * @author A.F
 * @since 1.0.0
 */
public class ChannelCreated {

    /**
     * Set Event Type. It should be channel_created
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
     * Set Channel Creator
     *
     * @param channelCreator
     */
    public void setChannelCreator(String channelCreator)
    {
        this.setIncomingItem("event.channel.creator", channelCreator);
    }

    /**
     * Get Event Type. It should be channel_created
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
     * Get Channel Creator
     *
     * @return String
     */
    public String getChannelCreator()
    {
        return this.getIncomingItem("event.channel.creator", "");
    }

    /**
     * Parse Event Incoming Data
     *
     * @return Boolean
     */
    public Boolean parse()
    {
        return true;
    }
}