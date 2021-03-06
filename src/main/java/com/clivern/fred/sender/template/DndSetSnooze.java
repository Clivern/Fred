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
 * Dnd Set Snooze Template Class
 *
 * It Turns on Do Not Disturb mode for the current user, or changes its duration.
 *
 * Supported token types: user
 * Expected scopes: dnd:write, post
 *
 * <a href="https://api.slack.com/methods/dnd.setSnooze">For More Info</a>
 *
 * @author Clivern
 * @since 1.0.0
 */
public class DndSetSnooze extends BasicTemplate {

    protected String token;
    protected Integer numMinutes;

    /**
     * Class Constructor
     */
    public DndSetSnooze()
    {
        this.setURL(Basic.methodURL(Basic.dndSetSnoozeMethod));
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
     * Set Num Minutes
     *
     * @param numMinutes
     */
    public void setNumMinutes(Integer numMinutes)
    {
        this.numMinutes = numMinutes;
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
     * Get Num Minutes
     *
     * @return Integer
     */
    public Integer getNumMinutes()
    {
        return this.numMinutes;
    }

    /**
     * Build Message Body
     */
    public String build()
    {
        if( !this.isDefined(this.token) || !this.isDefined(this.numMinutes) ){
            return "";
        }

        if( this.isDefined(this.token) ){
            this.body += "token=" + this.token;
        }

        if( this.isDefined(this.numMinutes) ){
            this.body += "&num_minutes=" + this.numMinutes;
        }

        this.setBody(this.body);

        return this.body;
    }
}