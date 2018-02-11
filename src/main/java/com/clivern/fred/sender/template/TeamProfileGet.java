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
 * Team Profile Get Template Class
 *
 * It Retrieve a team's profile.
 *
 * Supported token types: workspace, user
 * Expected scopes: users.profile:read, read
 *
 * <a href="https://api.slack.com/methods/team.profile.get">For More Info</a>
 *
 * @author Clivern
 * @since 1.0.0
 */
public class TeamProfileGet extends BasicTemplate {

    protected String token;
    protected String visibility;

    /**
     * Class Constructor
     */
    public TeamProfileGet()
    {
        this.setURL(Basic.methodURL(Basic.teamProfileGetMethod));
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
     * Set Visibility
     *
     * @param visibility
     */
    public void setVisibility(String visibility)
    {
        this.visibility = visibility;
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
     * Get Visibility
     *
     * @return String
     */
    public String getVisibility()
    {
        return this.visibility;
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

        if( this.isDefined(this.visibility) ){
            this.body += "&visibility=" + this.visibility;
        }

        this.setBody(this.body);

        return this.body;
    }
}