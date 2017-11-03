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
 * Conversations Set Purpose Template Class
 *
 * It Sets the purpose for a conversation.
 *
 * Supported token types: bot, user
 * Expected scopes: channels:write, groups:write, im:write, mpim:write, post
 *
 * <a href="https://api.slack.com/methods/conversations.setPurpose">For More Info</a>
 *
 * @author A.F
 * @since 1.0.0
 */
public class ConversationsSetPurpose extends BasicTemplate {

    protected String url = Basic.methodURL(Basic.conversationsSetPurposeMethod);
    protected String token;
    protected String channel;
    protected String purpose;

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
    public void getPurpose()
    {
        return this.purpose;
    }

    /**
     * Build Message Body
     */
    public String build()
    {
        if( this.token.isEmpty() || this.channel.isEmpty() || this.purpose.isEmpty() ){
            return "";
        }

        if( !this.token.isEmpty() ){
            this.body += "token=" + this.token;
        }

        if( !this.channel.isEmpty() ){
            this.body += "&channel=" + this.channel;
        }

        if( !this.purpose.isEmpty() ){
            this.body += "&purpose=" + this.purpose;
        }

        return this.body;
    }
}