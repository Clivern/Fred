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
package com.clivern.fred.sender.template;

import com.clivern.fred.config.Basic;
import com.clivern.fred.contract.sender.template.BasicTemplate;

/**
 * Chat Delete Template Class
 *
 * It Deletes a message.
 * When used with a typical user token, may only delete messages posted by that user.
 * When used with an admin user's user token, may delete most messages posted in a workspace.
 * When used with a bot user's token, may delete only messages posted by that bot user.
 *
 * Supported token types: bot, workspace, user
 * Expected scopes: chat:write, post
 *
 * <a href="https://api.slack.com/methods/chat.delete">For More Info</a>
 *
 * @author A.F
 * @since 1.0.0
 */
public class ChatDelete extends BasicTemplate {

    protected String url = Basic.methodURL(Basic.chatDeleteMethod);
    protected String token;
    protected String channel;
    protected String ts;
    protected Boolean asUser;

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
     * Set Ts
     *
     * @param ts
     */
    public void setTs(String ts)
    {
        this.ts = ts;
    }

    /**
     * Set As User
     *
     * @param asUser
     */
    public void setAsUser(Boolean asUser)
    {
        this.asUser = asUser;
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
     * Get Ts
     *
     * @return String
     */
    public String getTs()
    {
        return this.ts;
    }

    /**
     * Get As User
     *
     * @return Boolean
     */
    public Boolean getAsUser()
    {
        return this.asUser;
    }

    /**
     * Build Message Body
     */
    public String build()
    {
        if( this.token.isEmpty() || this.channel.isEmpty() || this.ts.isEmpty() ){
            return "";
        }

        if( !this.token.isEmpty() ){
            this.body += "token=" + this.token;
        }

        if( !this.channel.isEmpty() ){
            this.body += "&channel=" + this.channel;
        }

        if( !this.ts.isEmpty() ){
            this.body += "&ts=" + this.ts;
        }

        if( this.asUser != null ){
            this.body += "&as_user=" + ((this.asUser) ? "true" : "false");
        }

        return this.body;
    }
}