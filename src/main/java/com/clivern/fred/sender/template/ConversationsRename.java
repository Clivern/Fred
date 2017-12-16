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
 * Conversations Rename Template Class
 *
 * It Renames a conversation. Some types of conversations cannot be renamed.
 * The only the user that originally created a channel or an admin may rename it. Others will receive a not_authorized error.
 *
 * Supported token types: user
 * Expected scopes: channels:write, groups:write, im:write, mpim:write, post
 *
 * <a href="https://api.slack.com/methods/conversations.rename">For More Info</a>
 *
 * @author A.F
 * @since 1.0.0
 */
public class ConversationsRename extends BasicTemplate {

    protected String token;
    protected String channel;
    protected String name;

    /**
     * Class Constructor
     */
    public ConversationsRename()
    {
        this.setURL(Basic.methodURL(Basic.conversationsRenameMethod));
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
     * Set Name
     *
     * @param name
     */
    public void setName(String name)
    {
        this.name = name;
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
     * Get Token
     *
     * @return String
     */
    public String getToken()
    {
        return this.token;
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
     * Get Channel
     *
     * @return String
     */
    public String getChannel()
    {
        return this.channel;
    }

    /**
     * Build Message Body
     */
    public String build()
    {
        if( !this.isDefined(this.token) || !this.isDefined(this.channel) || !this.isDefined(this.name) ){
            return "";
        }

        if( this.isDefined(this.token) ){
            this.body += "token=" + this.token;
        }

        if( this.isDefined(this.channel) ){
            this.body += "&channel=" + this.channel;
        }

        if( this.isDefined(this.name) ){
            this.body += "&name=" + this.name;
        }

        this.setBody(this.body);

        return this.body;
    }
}