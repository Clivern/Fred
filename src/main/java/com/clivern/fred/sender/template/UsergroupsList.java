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
 * User Groups List Template Class
 *
 * It list all User Groups for a team.
 *
 * Supported token types: workspace, user
 * Expected scopes: usergroups:read, read
 *
 * <a href="https://api.slack.com/methods/usergroups.list">For More Info</a>
 *
 * @author Clivern
 * @since 1.0.0
 */
public class UsergroupsList extends BasicTemplate {

    protected String token;
    protected Boolean includeCount;
    protected Boolean includeDisabled;
    protected Boolean includeUsers;

    /**
     * Class Constructor
     */
    public UsergroupsList()
    {
        this.setURL(Basic.methodURL(Basic.usergroupsListMethod));
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
     * Set Include Count
     *
     * @param includeCount
     */
    public void setIncludeCount(Boolean includeCount)
    {
        this.includeCount = includeCount;
    }

    /**
     * Set Include Disabled
     *
     * @param includeDisabled
     */
    public void setIncludeDisabled(Boolean includeDisabled)
    {
        this.includeDisabled = includeDisabled;
    }

    /**
     * Set Include Users
     *
     * @param includeUsers
     */
    public void setIncludeUsers(Boolean includeUsers)
    {
        this.includeUsers = includeUsers;
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
     * Get Include Count
     *
     * @return Boolean
     */
    public Boolean getIncludeCount()
    {
        return this.includeCount;
    }

    /**
     * Get Include Disabled
     *
     * @return Boolean
     */
    public Boolean getIncludeDisabled()
    {
        return this.includeDisabled;
    }

    /**
     * Get Include Users
     *
     * @return Boolean
     */
    public Boolean getIncludeUsers()
    {
        return this.includeUsers;
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

        if( this.isDefined(this.includeCount) ){
            this.body += "&include_count=" + ((this.includeCount) ? "true" : "false");
        }

        if( this.isDefined(this.includeDisabled) ){
            this.body += "&include_disabled=" + ((this.includeDisabled) ? "true" : "false");
        }

        if( this.isDefined(this.includeUsers) ){
            this.body += "&include_users=" + ((this.includeUsers) ? "true" : "false");
        }

        this.setBody(this.body);

        return this.body;
    }
}