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
package com.clivern.fred.sender.template;

import com.clivern.fred.config.Basic;
import com.clivern.fred.contract.sender.template.BasicTemplate;

/**
 * Rtm Connect Template Class
 *
 * It Starts a Real Time Messaging session.
 *
 * Supported token types: bot, workspace, user
 * Expected scopes: rtm:stream, client
 *
 * <a href="https://api.slack.com/methods/rtm.connect">For More Info</a>
 *
 * @author Clivern
 * @since 1.0.0
 */
public class RtmConnect extends BasicTemplate {

    protected String token;
    protected Integer batchPresenceAware;

    /**
     * Class Constructor
     */
    public RtmConnect()
    {
        this.setURL(Basic.methodURL(Basic.rtmConnectMethod));
    }

    /**
     * Set Token
     *
     * @param token
     */
    public void setToken(String token)
    {
        this.token = token;
    }

    /**
     * Set Batch Presence Aware
     *
     * @param batchPresenceAware
     */
    public void setBatchPresenceAware(Integer batchPresenceAware)
    {
        this.batchPresenceAware = batchPresenceAware;
    }

    /**
     * Get Token
     *
     * @return String
     */
    public String getToken()
    {
        return this.token;
    }

    /**
     * Get Batch Presence Aware
     *
     * @return Integer
     */
    public Integer getBatchPresenceAware()
    {
        return this.batchPresenceAware;
    }

    /**
     * Build Message Body
     */
    public String build()
    {
        if( !this.isDefined(this.token) ){
            return "";
        }

        if( this.isDefined(this.token) ){
            this.body += "token=" + this.token;
        }

        if( this.isDefined(this.batchPresenceAware) ){
            this.body += "&batch_presence_aware=" + this.batchPresenceAware;
        }

        this.setBody(this.body);

        return this.body;
    }
}