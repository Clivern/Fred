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
 * User groups Users List Template Class
 *
 * It List all users in a User Group.
 *
 * Supported token types: workspace, user
 * Expected scopes: usergroups:read, read
 *
 * <a href="https://api.slack.com/methods/usergroups.users.list">For More Info</a>
 *
 * @author A.F
 * @since 1.0.0
 */
public class UsergroupsUsersList extends BasicTemplate {

    protected String url = Basic.methodURL(Basic.usergroupsUsersListMethod);
    protected String token;
    protected String usergroup;
    protected Boolean includeDisabled;


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
     * Set User Group
     *
     * @param usergroup
     */
    public void setUserGroup(String usergroup)
    {
        this.usergroup = usergroup;
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
     * Get Token
     *
     * @return String
     */
    public String getToken()
    {
        return this.token;
    }

    /**
     * Get User Group
     *
     * @return String
     */
    public String getUserGroup()
    {
        return this.usergroup;
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
     * Build Message Body
     */
    public String build()
    {
        if( this.token.isEmpty() || this.usergroup.isEmpty() ){
            return "";
        }

        if( !this.token.isEmpty() ){
            this.body += "token=" + this.token;
        }

        if( !this.usergroup.isEmpty() ){
            this.body += "&usergroup=" + this.usergroup;
        }

        if( this.includeDisabled != null ){
            this.body += "&include_disabled=" + ((this.includeDisabled) ? "true" : "false");
        }

        return this.body;
    }
}