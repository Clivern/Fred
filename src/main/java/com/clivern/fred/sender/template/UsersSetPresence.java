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
package com.clivern.fred.sender.template;

import com.clivern.fred.config.Basic;
import com.clivern.fred.contract.sender.template.BasicTemplate;

/**
 * Users Set Presence Template Class
 *
 * Manually sets user presence.
 *
 * Supported token types: bot, user
 * Expected scopes: users:write, post
 *
 * <a href="https://api.slack.com/methods/users.setPresence">For More Info</a>
 *
 * @author A.F
 * @since 1.0.0
 */
public class UsersSetPresence extends BasicTemplate {

    protected String token;
    protected String presence;

    /**
     * Class Constructor
     */
    public UsersSetPresence()
    {
        this.setURL(Basic.methodURL(Basic.usersSetPresenceMethod));
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
     * Set Presence
     *
     * @param presence
     */
    public void setPresence(String presence)
    {
        this.presence = presence;
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
     * Get Presence
     *
     * @return String
     */
    public String getPresence()
    {
        return this.presence;
    }

    /**
     * Build Message Body
     */
    public String build()
    {
        if( !this.isDefined(this.token) || !this.isDefined(this.presence) ){
            return "";
        }

        if( this.isDefined(this.token) ){
            this.body += "token=" + this.token;
        }

        if( this.isDefined(this.presence) ){
            this.body += "&presence=" + this.presence;
        }

        this.setBody(this.body);

        return this.body;
    }
}