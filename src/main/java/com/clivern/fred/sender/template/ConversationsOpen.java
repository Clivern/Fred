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
 * Conversations Open Template Class
 *
 * It Opens or resumes a direct message or multi-person direct message.
 *
 * Supported token types: bot, user
 * Expected scopes: channels:write, groups:write, im:write, mpim:write, post
 *
 * <a href="https://api.slack.com/methods/conversations.open">For More Info</a>
 *
 * @author Clivern
 * @since 1.0.0
 */
public class ConversationsOpen extends BasicTemplate {

    protected String token;
    protected String channel;
    protected Boolean returnIm;
    protected String users;

    /**
     * Class Constructor
     */
    public ConversationsOpen()
    {
        this.setURL(Basic.methodURL(Basic.conversationsOpenMethod));
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
     * Set Return Im
     *
     * @param returnIm
     */
    public void setReturnIm(Boolean returnIm)
    {
        this.returnIm = returnIm;
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
     * Get Channel
     *
     * @return String
     */
    public String getChannel()
    {
        return this.channel;
    }

    /**
     * Get Return Im
     *
     * @return Boolean
     */
    public Boolean getReturnIm()
    {
        return this.returnIm;
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

        if( this.isDefined(this.channel) ){
            this.body += "&channel=" + this.channel;
        }

        if( this.isDefined(this.returnIm) ){
            this.body += "&return_im=" + ((this.returnIm) ? "true" : "false");
        }

        if( this.isDefined(this.users) ){
            this.body += "&users=" + this.users;
        }

        this.setBody(this.body);

        return this.body;
    }
}