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
 * Dnd Updated User Event
 *
 * Do not Disturb settings changed for a member. It Works with RTM and Events API
 *
 * Expected scopes: dnd:read
 *
 * <a href="https://api.slack.com/events/dnd_updated_user">For More Info</a>
 *
 * @author A.F
 * @since 1.0.0
 */
public class DndUpdatedUser extends EventTemplate {

    protected Function<DndUpdatedUser,String> callback;

    /**
     * Class Constructor
     *
     * @param callback
     */
    public DndUpdatedUser(Function<DndUpdatedUser,String> callback)
    {
        this.callback = callback;
    }

    /**
     * Set Event Type. It should be dnd_updated_user
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
     * Set Dnd Enabled
     *
     * @param dndEnabled
     */
    public void setDndEnabled(String dndEnabled)
    {
        this.setIncomingItem("event.dnd_status.dnd_enabled", dndEnabled);
    }

    /**
     * Set Dnd Start Ts
     *
     * @param dndStartTs
     */
    public void setDndStartTs(String dndStartTs)
    {
        this.setIncomingItem("event.dnd_status.next_dnd_start_ts", dndStartTs);
    }

    /**
     * Set Dnd End Ts
     *
     * @param dndEndTs
     */
    public void setDndEndTs(String dndEndTs)
    {
        this.setIncomingItem("event.dnd_status.next_dnd_end_ts", dndEndTs);
    }

    /**
     * Get Event Type. It should be dnd_updated_user
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
     * Get Dnd Enabled
     *
     * @return String
     */
    public String getDndEnabled()
    {
        return this.getIncomingItem("event.dnd_status.dnd_enabled", "");
    }

    /**
     * Get Dnd Start Ts
     *
     * @return String
     */
    public String getDndStartTs()
    {
        return this.getIncomingItem("event.dnd_status.next_dnd_start_ts", "");
    }

    /**
     * Get Dnd End Ts
     *
     * @return String
     */
    public String getDndEndTs()
    {
        return this.getIncomingItem("event.dnd_status.next_dnd_end_ts", "");
    }

    /**
     * Check if This Event Is Called
     *
     * @return Boolean
     */
    public Boolean isCalled()
    {
        JSONObject requestData = new JSONObject(this.getPlainRequest());

        return (requestData.has("type") && requestData.getString("type").equals("dnd_updated_user"));
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

        if( requestData.has("dnd_status") && !requestData.getString("dnd_status").equals("") ){
            JSONObject dndStatus = new JSONObject(requestData.getString("dnd_status"));
            this.setDndEnabled(dndStatus.has("dnd_enabled") ? dndStatus.getString("dnd_enabled") : "");
            this.setDndStartTs(dndStatus.has("next_dnd_start_ts") ? dndStatus.getString("next_dnd_start_ts") : "");
            this.setDndEndTs(dndStatus.has("next_dnd_end_ts") ? dndStatus.getString("next_dnd_end_ts") : "");
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