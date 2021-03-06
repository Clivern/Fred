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
 * Conversations Create Template Class
 *
 * It Initiates a public or private channel-based conversation.
 *
 * Supported token types: user
 * Expected scopes: channels:write, groups:write, im:write, mpim:write, post
 *
 * <a href="https://api.slack.com/methods/conversations.create">For More Info</a>
 *
 * @author Clivern
 * @since 1.0.0
 */
public class ConversationsCreate extends BasicTemplate {

    protected String token;
    protected String name;
    protected Boolean isPrivate;

    /**
     * Class Constructor
     */
    public ConversationsCreate()
    {
        this.setURL(Basic.methodURL(Basic.conversationsCreateMethod));
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
     * Set Is Private
     *
     * @param isPrivate
     */
    public void setIsPrivate(Boolean isPrivate)
    {
        this.isPrivate = isPrivate;
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
     * Get Is Private
     *
     * @return Boolean
     */
    public Boolean getIsPrivate()
    {
        return this.isPrivate;
    }

    /**
     * Build Message Body
     */
    public String build()
    {
        if( !this.isDefined(this.token) || !this.isDefined(this.name) ){
            return "";
        }

        if( this.isDefined(this.token) ){
            this.body += "token=" + this.token;
        }

        if( this.isDefined(this.name) ){
            this.body += "&name=" + this.name;
        }

        if( this.isDefined(this.isPrivate) ){
            this.body += "&is_private=" + ((this.isPrivate) ? "true" : "false");
        }

        this.setBody(this.body);

        return this.body;
    }
}