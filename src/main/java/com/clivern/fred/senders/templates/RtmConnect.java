/*
 * Copyright (C) 2017 A.F <http://clivern.com>
 *
 * Licensed under the MIT License; you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * https://github.com/Clivern/Fred/blob/master/LICENSE
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.clivern.fred.senders.templates;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.clivern.fred.configs.Basic;
import com.clivern.fred.contract.senders.templates.BasicTemplate;

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
 * @author A.F
 * @since 1.0.0
 */
public class RtmConnect extends BasicTemplate {

    protected String url = Basic.methodURL(Basic.rtmConnectMethod);
    protected String token;
    protected Integer batchPresenceAware;

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
        if( this.token.isEmpty() ){
            return "";
        }

        if( !this.token.isEmpty() ){
            this.body += "token=" + this.token;
        }

        if( this.batchPresenceAware != null ){
            this.body += "&batch_presence_aware=" + this.batchPresenceAware;
        }

        return this.body;
    }
}