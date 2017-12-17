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
 * Star Added Event
 *
 * A member has starred an item. It Works with RTM & Events API
 *
 * Expected scopes: stars:read
 *
 * <a href="https://api.slack.com/events/star_added">For More Info</a>
 *
 * @author A.F
 * @since 1.0.0
 */
public class StarAdded extends EventTemplate {

    /**
     * Set Event Type. It should be star_added
     *
     * @param eventType
     */
    public void setEventType(String eventType)
    {
        this.setIncomingItem("event.type", eventType);
    }

    /**
     * Set User Name
     *
     * @param user
     */
    public void setUser(String user)
    {
        this.setIncomingItem("event.user", user);
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
     * Get Event Type. It should be star_added
     *
     * @return String
     */
    public String getEventType()
    {
        return this.getIncomingItem("event.type", "");
    }

    /**
     * Get User Name
     *
     * @return String
     */
    public String getUser()
    {
        return this.getIncomingItem("event.user", "");
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
     * Parse Event Incoming Data
     *
     * @return Boolean
     */
    public Boolean parse()
    {
        return true;
    }
}