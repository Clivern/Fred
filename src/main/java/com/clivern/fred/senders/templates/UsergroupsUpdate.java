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
import com.clivern.fred.contract.templates.BasicTemplate;

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
 * @author A.F
 * @since 1.0.0
 */
public class UsergroupsUpdate extends BasicTemplate {

    protected String url = Basic.methodURL(Basic.usergroupsUpdateMethod);
    protected String token;
    protected String usergroup;
    protected String name;
    protected String channels;
    protected String description;
    protected String handle;
    protected Boolean includeCount;

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
        if( this.token.isEmpty() || this.usergroup.isEmpty() ){
            return "";
        }

        if( !this.token.isEmpty() ){
            this.body += "token=" + this.token;
        }

        if( !this.usergroup.isEmpty() ){
            this.body += "&usergroup=" + this.usergroup;
        }

        if( !this.name.isEmpty() ){
            this.body += "&name=" + this.name;
        }

        if( !this.channels.isEmpty() ){
            this.body += "&channels=" + this.channels;
        }

        if( !this.description.isEmpty() ){
            this.body += "&description=" + this.description;
        }

        if( !this.handle.isEmpty() ){
            this.body += "&handle=" + this.handle;
        }

        if( !this.includeCount !== null ){
            this.body += "&include_count=" + ((this.includeCount) ? "true" : "false");
        }

        return this.body;
    }
}