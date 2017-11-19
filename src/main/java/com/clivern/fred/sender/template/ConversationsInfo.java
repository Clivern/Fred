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
 * Conversations Info Template Class
 *
 * It Retrieve information about a conversation.
 *
 * Supported token types: bot, user
 * Expected scopes: channels:read, groups:read, im:read, mpim:read, read
 *
 * <a href="https://api.slack.com/methods/conversations.info">For More Info</a>
 *
 * @author A.F
 * @since 1.0.0
 */
public class ConversationsInfo extends BasicTemplate {

    protected String url = Basic.methodURL(Basic.conversationsInfoMethod);
    protected String token;
    protected String channel;
    protected Boolean includeLocale;

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
     * Set Include Locale
     *
     * @param includeLocale
     */
    public void setIncludeLocale(Boolean includeLocale)
    {
        this.includeLocale = includeLocale;
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
     * Get Include Locale
     *
     * @return Boolean
     */
    public Boolean getIncludeLocale()
    {
        return this.includeLocale;
    }

    /**
     * Build Message Body
     */
    public String build()
    {
        if( this.token.isEmpty() || this.channel.isEmpty() ){
            return "";
        }

        if( !this.token.isEmpty() ){
            this.body += "token=" + this.token;
        }

        if( !this.channel.isEmpty() ){
            this.body += "&channel=" + this.channel;
        }

        if( this.includeLocale != null ){
            this.body += "&include_locale=" + ((this.includeLocale) ? "true" : "false");
        }

        return this.body;
    }
}