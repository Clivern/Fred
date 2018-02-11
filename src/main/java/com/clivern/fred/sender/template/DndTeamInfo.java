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
 * Dnd Team Info Template Class
 *
 * It Retrieves the Do Not Disturb status for users on a team.
 *
 * Supported token types: bot, user
 * Expected scopes: dnd:read, read
 *
 * <a href="https://api.slack.com/methods/dnd.teamInfo">For More Info</a>
 *
 * @author Clivern
 * @since 1.0.0
 */
public class DndTeamInfo extends BasicTemplate {

    protected String token;
    protected String users;

    /**
     * Class Constructor
     */
    public DndTeamInfo()
    {
        this.setURL(Basic.methodURL(Basic.dndTeamInfoMethod));
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
     * Set Users
     *
     * @param users
     */
    public void setUsers(String users)
    {
        this.users = users;
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
     * Get Users
     *
     * @return String
     */
    public String getUsers()
    {
        return this.users;
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

        if( this.isDefined(this.users) ){
            this.body += "&users=" + this.users;
        }

        this.setBody(this.body);

        return this.body;
    }
}