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
 * Conversations Invite Template Class
 *
 * It Invites users to a channel. It invites 1-30 users to a public or private channel.
 * The calling user must be a member of the channel.
 *
 * Supported token types: user
 * Expected scopes: channels:write, groups:write, im:write, mpim:write, post
 *
 * <a href="https://api.slack.com/methods/conversations.invite">For More Info</a>
 *
 * @author A.F
 * @since 1.0.0
 */
public class ConversationsInvite extends BasicTemplate {

    protected String url = Basic.methodURL(Basic.conversationsInviteMethod);
    protected String token;
    protected String channel;
    protected String users;

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
        if( this.token.isEmpty() || this.channel.isEmpty() || this.users.isEmpty() ){
            return "";
        }

        if( !this.token.isEmpty() ){
            this.body += "token=" + this.token;
        }

        if( !this.channel.isEmpty() ){
            this.body += "&channel=" + this.channel;
        }

        if( !this.users.isEmpty() ){
            this.body += "&users=" + this.users;
        }

        return this.body;
    }
}