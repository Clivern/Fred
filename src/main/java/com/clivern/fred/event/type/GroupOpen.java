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

/**
 * Group Open Event
 *
 * Expected scopes: groups:read
 *
 * <a href="https://api.slack.com/events/group_open">For More Info</a>
 *
 * @author A.F
 * @since 1.0.0
 */
public class GroupOpen extends EventTemplate {

    /**
     * Set Event Type. It should be group_open
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
     * Set User
     *
     * @param user
     */
    public void setUser(String user)
    {
        this.setIncomingItem("event.user", user);
    }

    /**
     * Get Event Type. It should be group_open
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
     * Get User
     *
     * @return String
     */
    public String getUser()
    {
        return this.getIncomingItem("event.user", "");
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