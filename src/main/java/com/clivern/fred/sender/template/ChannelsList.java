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
 * Channels List Template Class
 *
 * It Lists all channels in a Slack team. returns a list of all channels in the team. This includes channels the caller is in,
 * channels they are not currently in, and archived channels but does not include private channels.
 * The number of (non-deactivated) members in each channel is also returned.
 *
 * Having trouble getting a HTTP 200 response from this method?
 * Try excluding the members list from each channel object using the exclude_members parameter.
 *
 * Supported token types: bot, workspace, user
 * Expected scopes: channels:read, read
 *
 * <a href="https://api.slack.com/methods/channels.list">For More Info</a>
 *
 * @author A.F
 * @since 1.0.0
 */
public class ChannelsList extends BasicTemplate {

    protected String token;
    protected String cursor;
    protected Boolean excludeArchived;
    protected Boolean excludeMembers;
    protected Integer limit;

    /**
     * Class Constructor
     */
    public ChannelsList()
    {
        this.setURL(Basic.methodURL(Basic.channelsListMethod));
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
     * Set Cursor
     *
     * @param cursor
     */
    public void setCursor(String cursor)
    {
        this.cursor = cursor;
    }

    /**
     * Set Exclude Archived
     *
     * @param excludeArchived
     */
    public void setExcludeArchived(Boolean excludeArchived)
    {
        this.excludeArchived = excludeArchived;
    }

    /**
     * Set Exclude Members
     *
     * @param excludeMembers
     */
    public void setExcludeMembers(Boolean excludeMembers)
    {
        this.excludeMembers = excludeMembers;
    }

    /**
     * Set Limit
     *
     * @param limit
     */
    public void setLimit(Integer limit)
    {
        this.limit = limit;
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
     * Get Cursor
     *
     * @return String
     */
    public String getCursor()
    {
        return this.cursor;
    }

    /**
     * Get Exclude Archived
     *
     * @return Boolean
     */
    public Boolean getExcludeArchived()
    {
        return this.excludeArchived;
    }

    /**
     * Get Exclude Members
     *
     * @return Boolean
     */
    public Boolean getExcludeMembers()
    {
        return this.excludeMembers;
    }

    /**
     * Get Limit
     *
     * @return Integer
     */
    public Integer getLimit()
    {
        return this.limit;
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

        if( !this.cursor.isEmpty() ){
            this.body += "&cursor=" + this.cursor;
        }

        if( this.excludeArchived != null ){
            this.body += "&exclude_archived=" + ((this.excludeArchived) ? "true" : "false");
        }

        if( this.excludeMembers != null ){
            this.body += "&exclude_members=" + ((this.excludeMembers) ? "true" : "false");
        }

        if( this.limit != null ){
            this.body += "&limit=" + this.limit;
        }

        this.setBody(this.body);

        return this.body;
    }
}