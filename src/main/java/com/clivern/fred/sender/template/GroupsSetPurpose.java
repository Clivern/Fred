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
 * Groups Set Purpose Template Class
 *
 * It is used to change the purpose of a private channel. The calling user must be a member of the private channel.
 *
 * Supported token types: bot, workspace, user
 * Expected scopes: groups:write, post
 *
 * <a href="https://api.slack.com/methods/groups.setPurpose">For More Info</a>
 *
 * @author A.F
 * @since 1.0.0
 */
public class GroupsSetPurpose extends BasicTemplate {

    protected String token;
    protected String channel;
    protected String purpose;

    /**
     * Class Constructor
     */
    public GroupsSetPurpose()
    {
        this.setURL(Basic.methodURL(Basic.groupsSetPurposeMethod));
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
     * Set Channel
     *
     * @param channel
     */
    public void setChannel(String channel)
    {
        this.channel = channel;
    }

    /**
     * Set Purpose
     *
     * @param purpose
     */
    public void setPurpose(String purpose)
    {
        this.purpose = purpose;
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
     * Get Channel
     *
     * @return String
     */
    public String getChannel()
    {
        return this.channel;
    }

    /**
     * Get Purpose
     *
     * @return String
     */
    public String getPurpose()
    {
        return this.purpose;
    }

    /**
     * Build Message Body
     */
    public String build()
    {
        if( !this.isDefined(this.token) || !this.isDefined(this.channel) || !this.isDefined(this.purpose) ){
            return "";
        }

        if( this.isDefined(this.token) ){
            this.body += "token=" + this.token;
        }

        if( this.isDefined(this.channel) ){
            this.body += "&channel=" + this.channel;
        }

        if( this.isDefined(this.purpose) ){
            this.body += "&purpose=" + this.purpose;
        }

        this.setBody(this.body);

        return this.body;
    }
}