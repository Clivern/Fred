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
 * User Groups Update Template Class
 *
 * It Updates an existing User Group.
 *
 * Supported token types: workspace, user
 * Expected scopes: usergroups:write, post
 *
 * <a href="https://api.slack.com/methods/usergroups.update">For More Info</a>
 *
 * @author Clivern
 * @since 1.0.0
 */
public class UsergroupsUpdate extends BasicTemplate {

    protected String token;
    protected String usergroup;
    protected String name;
    protected String channels;
    protected String description;
    protected String handle;
    protected Boolean includeCount;

    /**
     * Class Constructor
     */
    public UsergroupsUpdate()
    {
        this.setURL(Basic.methodURL(Basic.usergroupsUpdateMethod));
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
     * Set Name
     *
     * @param name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Set Channels
     *
     * @param channels
     */
    public void setChannels(String channels)
    {
        this.channels = channels;
    }

    /**
     * Set Description
     *
     * @param description
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    /**
     * Set Handle
     *
     * @param handle
     */
    public void setHandle(String handle)
    {
        this.handle = handle;
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
     * Get Name
     *
     * @return String
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * Get Channels
     *
     * @return String
     */
    public String getChannels()
    {
        return this.channels;
    }

    /**
     * Get Description
     *
     * @return String
     */
    public String getDescription()
    {
        return this.description;
    }

    /**
     * Get Handle
     *
     * @return String
     */
    public String getHandle()
    {
        return this.handle;
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
        if( !this.isDefined(this.token) || !this.isDefined(this.usergroup) ){
            return "";
        }

        if( this.isDefined(this.token) ){
            this.body += "token=" + this.token;
        }

        if( this.isDefined(this.usergroup) ){
            this.body += "&usergroup=" + this.usergroup;
        }

        if( this.isDefined(this.name) ){
            this.body += "&name=" + this.name;
        }

        if( this.isDefined(this.channels) ){
            this.body += "&channels=" + this.channels;
        }

        if( this.isDefined(this.description) ){
            this.body += "&description=" + this.description;
        }

        if( this.isDefined(this.handle) ){
            this.body += "&handle=" + this.handle;
        }

        if( this.isDefined(this.includeCount) ){
            this.body += "&include_count=" + ((this.includeCount) ? "true" : "false");
        }

        this.setBody(this.body);

        return this.body;
    }
}