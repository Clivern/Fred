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
 * Channels Replies Template Class
 *
 * It Retrieve a thread of messages posted to a channel. It returns an entire thread (a message plus all the messages in reply to it).
 *
 * Supported token types: bot, workspace, user
 * Expected scopes: channels:history, read
 *
 * <a href="https://api.slack.com/methods/channels.replies">For More Info</a>
 *
 * @author A.F
 * @since 1.0.0
 */
public class ChannelsReplies extends BasicTemplate {

    protected String url = Basic.methodURL(Basic.channelsRepliesMethod);
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