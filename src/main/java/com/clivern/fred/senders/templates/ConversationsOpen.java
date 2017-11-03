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
 * Conversations Open Template Class
 *
 * It Opens or resumes a direct message or multi-person direct message.
 *
 * Supported token types: bot, user
 * Expected scopes: channels:write, groups:write, im:write, mpim:write, post
 *
 * <a href="https://api.slack.com/methods/conversations.open">For More Info</a>
 *
 * @author A.F
 * @since 1.0.0
 */
public class ConversationsOpen extends BasicTemplate {

    protected String url = Basic.methodURL(Basic.conversationsOpenMethod);
    protected String token;
    protected String channel;
    protected Boolean returnIm;
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
    public void getUsers()
    {
        return this.users;
    }

    /**
     * Build Message Body
     */
    public String build()
    {
        if( this.token.isEmpty() ){
            return "";
        }

        if( !this.token.isEmpty() ){
            this.body += "token=" + this.token;
        }

        if( !this.channel.isEmpty() ){
            this.body += "&channel=" + this.channel;
        }

        if( !this.returnIm.isEmpty() ){
            this.body += "&return_im=" + ((this.returnIm) ? "true" : "false");
        }

        if( !this.users.isEmpty() ){
            this.body += "&users=" + this.users;
        }

        return this.body;
    }
}