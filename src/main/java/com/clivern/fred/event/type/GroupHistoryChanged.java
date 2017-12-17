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
 * Group History Changed Event
 *
 * Expected scopes: groups:read
 *
 * <a href="https://api.slack.com/events/group_history_changed">For More Info</a>
 *
 * @author A.F
 * @since 1.0.0
 */
public class GroupHistoryChanged extends EventTemplate {

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
     * Parse Event Incoming Data
     *
     * @return Boolean
     */
    public Boolean parse()
    {
        return true;
    }
}