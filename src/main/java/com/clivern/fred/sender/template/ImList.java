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
 * Im List Template Class
 *
 * It Lists direct message channels for the calling user.
 *
 * Supported token types: bot, workspace, user
 * Expected scopes: im:read, read
 *
 * <a href="https://api.slack.com/methods/im.list">For More Info</a>
 *
 * @author A.F
 * @since 1.0.0
 */
public class ImList extends BasicTemplate {

    protected String token;
    protected String cursor;
    protected Integer limit;

    /**
     * Class Constructor
     */
    public ImList()
    {
        this.setURL(Basic.methodURL(Basic.imListMethod));
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
        if( !this.isDefined(this.token) ){
            return "";
        }

        if( this.isDefined(this.token) ){
            this.body += "token=" + this.token;
        }

        if( this.isDefined(this.cursor) ){
            this.body += "&cursor=" + this.cursor;
        }

        if( this.isDefined(this.limit) ){
            this.body += "&limit=" + this.limit;
        }

        this.setBody(this.body);

        return this.body;
    }
}