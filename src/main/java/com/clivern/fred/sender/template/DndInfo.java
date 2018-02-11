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
 * Dnd Info Template Class
 *
 * It Retrieves a user's current Do Not Disturb status.
 *
 * Supported token types: bot, user
 * Expected scopes: dnd:read, read
 *
 * <a href="https://api.slack.com/methods/dnd.info">For More Info</a>
 *
 * @author Clivern
 * @since 1.0.0
 */
public class DndInfo extends BasicTemplate {

    protected String token;
    protected String user;

    /**
     * Class Constructor
     */
    public DndInfo()
    {
        this.setURL(Basic.methodURL(Basic.dndInfoMethod));
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
     * Set User
     *
     * @param user
     */
    public void setUser(String user)
    {
        this.user = user;
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
     * Get User
     *
     * @return String
     */
    public String getUser()
    {
        return this.user;
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

        if( this.isDefined(this.user) ){
            this.body += "&user=" + this.user;
        }

        this.setBody(this.body);

        return this.body;
    }
}