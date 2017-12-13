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
 * User Groups Enable Template Class
 *
 * It Enables a User Group.
 *
 * Supported token types: workspace, user
 * Expected scopes: usergroups:write, post
 *
 * <a href="https://api.slack.com/methods/usergroups.enable">For More Info</a>
 *
 * @author A.F
 * @since 1.0.0
 */
public class UsergroupsEnable extends BasicTemplate {

    protected String token;
    protected String usergroup;
    protected Boolean includeCount;

    /**
     * Class Constructor
     */
    public UsergroupsEnable()
    {
        this.setURL(Basic.methodURL(Basic.usergroupsEnableMethod));
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
     * Set User Group
     *
     * @param usergroup
     */
    public void setUserGroup(String usergroup)
    {
        this.usergroup = usergroup;
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
     * Get Include Count
     *
     * @return Boolean
     */
    public Boolean getIncludeCount()
    {
        return this.includeCount;
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

        if( this.includeCount != null ){
            this.body += "&include_count=" + ((this.includeCount) ? "true" : "false");
        }

        this.setBody(this.body);

        return this.body;
    }
}