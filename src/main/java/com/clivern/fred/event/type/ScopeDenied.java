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
 * Scope Denied Event
 *
 * OAuth scopes were denied to your app. It Works with Events API
 *
 * <a href="https://api.slack.com/events/scope_denied">For More Info</a>
 *
 * @author A.F
 * @since 1.0.0
 */
public class ScopeDenied extends EventTemplate {

    protected Function<ScopeDenied,String> callback;

    /**
     * Class Constructor
     *
     * @param callback
     */
    public ScopeDenied(Function<ScopeDenied,String> callback)
    {
        this.callback = callback;
    }

    /**
     * Check if This Event Is Called
     *
     * @return Boolean
     */
    public Boolean isCalled()
    {
        JSONObject requestData = new JSONObject(this.getPlainRequest());

        return true;
    }

    /**
     * Parse Event Incoming Data
     *
     * @return Boolean
     */
    public Boolean parse()
    {
        JSONObject requestData = new JSONObject(this.getPlainRequest());

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
    
    /**
     * Set Event Type. It should be scope_denied
     *
     * @param eventType
     */
    public void setEventType(String eventType)
    {
        this.setIncomingItem("event.type", eventType);
    }

    /**
     * Get Event Type. It should be scope_denied
     *
     * @return String
     */
    public String getEventType()
    {
        return this.getIncomingItem("event.type", "");
    }
}