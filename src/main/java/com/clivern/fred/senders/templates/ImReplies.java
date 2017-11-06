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
 * Im Replies Template Class
 *
 * It Retrieve a thread of messages posted to a direct message conversation.
 *
 * Supported token types: bot, workspace, user
 * Expected scopes: im:history, read
 *
 * <a href="https://api.slack.com/methods/im.replies">For More Info</a>
 *
 * @author A.F
 * @since 1.0.0
 */
public class ImReplies extends BasicTemplate {

    protected String url = Basic.methodURL(Basic.imRepliesMethod);
    protected String token;
    protected String channel;
    protected String threadTs;

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
     * Set Thread Ts
     *
     * @param threadTs
     */
    public void setThreadTs(String threadTs)
    {
        this.threadTs = threadTs;
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
     * Get Thread Ts
     *
     * @return String
     */
    public String getThreadTs()
    {
        return this.threadTs;
    }

    /**
     * Build Message Body
     */
    public String build()
    {
        if( this.token.isEmpty() || this.channel.isEmpty() || this.threadTs.isEmpty() ){
            return "";
        }

        if( !this.token.isEmpty() ){
            this.body += "token=" + this.token;
        }

        if( !this.channel.isEmpty() ){
            this.body += "&channel=" + this.channel;
        }

        if( !this.threadTs.isEmpty() ){
            this.body += "&thread_ts=" + this.threadTs;
        }

        return this.body;
    }
}