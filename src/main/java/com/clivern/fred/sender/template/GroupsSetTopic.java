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
 * Groups Set Topic Template Class
 *
 * It is used to change the topic of a private channel. The calling user must be a member of the private channel.
 *
 * Supported token types: bot, workspace, user
 * Expected scopes: groups:write, post
 *
 * <a href="https://api.slack.com/methods/groups.setTopic">For More Info</a>
 *
 * @author A.F
 * @since 1.0.0
 */
public class GroupsSetTopic extends BasicTemplate {

    protected String token;
    protected String channel;
    protected String topic;

    /**
     * Class Constructor
     */
    public GroupsSetTopic()
    {
        this.setURL(Basic.methodURL(Basic.groupsSetTopicMethod));
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
        if( !this.isDefined(this.token) || !this.isDefined(this.channel) || !this.isDefined(this.topic) ){
            return "";
        }

        if( this.isDefined(this.token) ){
            this.body += "token=" + this.token;
        }

        if( this.isDefined(this.channel) ){
            this.body += "&channel=" + this.channel;
        }

        if( this.isDefined(this.topic) ){
            this.body += "&topic=" + this.topic;
        }

        this.setBody(this.body);

        return this.body;
    }
}