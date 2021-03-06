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
 * Channels History Template Class
 *
 * It Fetches history of messages and events from a channel.
 * It returns a portion of message events from the specified public channel.
 * To read the entire history for a channel, call the method with no latest or oldest arguments,
 * and then continue paging using the instructions below.
 * To retrieve a single message, specify its ts value as latest, set inclusive to true, and dial your count down to 1.
 *
 * Supported token types: bot, workspace, user
 * Expected scopes: channels:history, read
 *
 * <a href="https://api.slack.com/methods/channels.history">For More Info</a>
 *
 * @author Clivern
 * @since 1.0.0
 */
public class ChannelsHistory extends BasicTemplate {

    protected String token;
    protected String channel;
    protected Integer count;
    protected Boolean inclusive;
    protected String latest;
    protected String oldest;
    protected Boolean unreads;

    /**
     * Class Constructor
     */
    public ChannelsHistory()
    {
        this.setURL(Basic.methodURL(Basic.channelsHistoryMethod));
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
     * Set Count
     *
     * @param count
     */
    public void setCount(Integer count)
    {
        this.count = count;
    }

    /**
     * Set Inclusive
     *
     * @param inclusive
     */
    public void setInclusive(Boolean inclusive)
    {
        this.inclusive = inclusive;
    }

    /**
     * Set Latest
     *
     * @param latest
     */
    public void setLatest(String latest)
    {
        this.latest = latest;
    }

    /**
     * Set Oldest
     *
     * @param oldest
     */
    public void setOldest(String oldest)
    {
        this.oldest = oldest;
    }

    /**
     * Set Unreads
     *
     * @param unreads
     */
    public void setUnreads(Boolean unreads)
    {
        this.unreads = unreads;
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
     * Get Count
     *
     * @return Integer
     */
    public Integer getCount()
    {
        return this.count;
    }

    /**
     * Get Inclusive
     *
     * @return Integer
     */
    public Boolean getInclusive()
    {
        return this.inclusive;
    }

    /**
     * Get Latest
     *
     * @return String
     */
    public String getLatest()
    {
        return this.latest;
    }

    /**
     * Get Oldest
     *
     * @return String
     */
    public String getOldest()
    {
        return this.oldest;
    }

    /**
     * Get Unreads
     *
     * @return Integer
     */
    public Boolean getUnreads()
    {
        return this.unreads;
    }

    /**
     * Build Message Body
     */
    public String build()
    {
        if( !this.isDefined(this.token) || !this.isDefined(this.channel) ){
            return "";
        }

        if( this.isDefined(this.token) ){
            this.body += "token=" + this.token;
        }

        if( this.isDefined(this.channel) ){
            this.body += "&channel=" + this.channel;
        }

        if( this.isDefined(this.count) ){
            this.body += "&count=" + this.count;
        }

        if( this.isDefined(this.inclusive) ){
            this.body += "&inclusive=" + ((this.inclusive) ? "true" : "false");
        }

        if( this.isDefined(this.latest) ){
            this.body += "&latest=" + this.latest;
        }

        if( this.isDefined(this.oldest) ){
            this.body += "&oldest=" + this.oldest;
        }

        if( this.isDefined(this.unreads) ){
            this.body += "&unreads=" + ((this.unreads) ? "true" : "false");
        }

        this.setBody(this.body);

        return this.body;
    }
}