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
 * Channels Set Topic Template Class
 *
 * It Sets the topic for a channel. The calling user must be a member of the channel.
 *
 * Supported token types: bot, workspace, user
 * Expected scopes: channels:write, post
 *
 * <a href="https://api.slack.com/methods/channels.setTopic">For More Info</a>
 *
 * @author A.F
 * @since 1.0.0
 */
public class ChannelsSetTopic extends BasicTemplate {

    protected String token;
    protected String channel;
    protected String topic;

    /**
     * Class Constructor
     */
    public ChannelsSetTopic()
    {
        this.setURL(Basic.methodURL(Basic.channelsSetTopicMethod));
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
     * Set Channel
     *
     * @param channel
     */
    public void setChannel(String channel)
    {
        this.channel = channel;
    }

    /**
     * Set Topic
     *
     * @param topic
     */
    public void setTopic(String topic)
    {
        this.topic = topic;
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
     * Get Topic
     *
     * @return String
     */
    public String getTopic()
    {
        return this.topic;
    }

    /**
     * Build Message Body
     */
    public String build()
    {
        if( this.token.isEmpty() || this.channel.isEmpty() || this.topic.isEmpty() ){
            return "";
        }

        if( !this.token.isEmpty() ){
            this.body += "token=" + this.token;
        }

        if( !this.channel.isEmpty() ){
            this.body += "&channel=" + this.channel;
        }

        if( !this.topic.isEmpty() ){
            this.body += "&topic=" + this.topic;
        }

        this.setBody(this.body);

        return this.body;
    }
}