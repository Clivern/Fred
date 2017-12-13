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
 * Users List Template Class
 *
 * It Lists all users in a Slack team. It  returns a list of all users in the team. This includes deleted/deactivated users.
 *
 * Supported token types: bot, workspace, user
 * Expected scopes: users:read, read
 *
 * <a href="https://api.slack.com/methods/users.list">For More Info</a>
 *
 * @author A.F
 * @since 1.0.0
 */
public class UsersList extends BasicTemplate {

    protected String token;
    protected String cursor;
    protected Boolean includeLocale;
    protected Integer limit;
    protected Boolean presence;

    /**
     * Class Constructor
     */
    public UsersList()
    {
        this.setURL(Basic.methodURL(Basic.usersListMethod));
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
     * Set Include Locale
     *
     * @param includeLocale
     */
    public void setIncludeLocale(Boolean includeLocale)
    {
        this.includeLocale = includeLocale;
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
     * Set Presence
     *
     * @param presence
     */
    public void setPresence(Boolean presence)
    {
        this.presence = presence;
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
     * Get Include Locale
     *
     * @return Boolean
     */
    public Boolean getIncludeLocale()
    {
        return this.includeLocale;
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
     * Get Presence
     *
     * @return Boolean
     */
    public Boolean getPresence()
    {
        return this.presence;
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

        if( this.includeLocale != null ){
            this.body += "&include_locale=" + ((this.includeLocale) ? "true" : "false");
        }

        if( this.limit != null ){
            this.body += "&limit=" + this.limit;
        }

        if( this.presence != null ){
            this.body += "&presence=" + ((this.presence) ? "true" : "false");
        }

        this.setBody(this.body);

        return this.body;
    }
}