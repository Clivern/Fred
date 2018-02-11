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
 * Files List Template Class
 *
 * It Lists and filters team files.
 *
 * Supported token types: workspace, user
 * Expected scopes: files:read, read
 *
 * <a href="https://api.slack.com/methods/files.list">For More Info</a>
 *
 * @author Clivern
 * @since 1.0.0
 */
public class FilesList extends BasicTemplate {

    protected String token;
    protected String channel;
    protected Integer count;
    protected Integer page;
    protected String tsFrom;
    protected String tsTo;
    protected String types;
    protected String user;

    /**
     * Class Constructor
     */
    public FilesList()
    {
        this.setURL(Basic.methodURL(Basic.filesListMethod));
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
     * Set Page
     *
     * @param page
     */
    public void setPage(Integer page)
    {
        this.page = page;
    }

    /**
     * Set Ts From
     *
     * @param tsFrom
     */
    public void setTsFrom(String tsFrom)
    {
        this.tsFrom = tsFrom;
    }

    /**
     * Set Ts To
     *
     * @param tsTo
     */
    public void setTsTo(String tsTo)
    {
        this.tsTo = tsTo;
    }

    /**
     * Set Types
     *
     * @param types
     */
    public void setTypes(String types)
    {
        this.types = types;
    }

    /**
     * Set User
     *
     * @param user
     */
    public void setUser(String user)
    {
        this.user = user;
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
     * Get Page
     *
     * @return Integer
     */
    public Integer getPage()
    {
        return this.page;
    }

    /**
     * Get Ts From
     *
     * @return String
     */
    public String getTsFrom()
    {
        return this.tsFrom;
    }

    /**
     * Get Ts To
     *
     * @return String
     */
    public String getTsTo()
    {
        return this.tsTo;
    }

    /**
     * Get Type
     *
     * @return String
     */
    public String getTypes()
    {
        return this.types;
    }

    /**
     * Get User
     *
     * @return String
     */
    public String getUser()
    {
        return this.user;
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

        if( this.isDefined(this.channel) ){
            this.body += "&channel=" + this.channel;
        }

        if( this.isDefined(this.count) ){
            this.body += "&count=" + this.count;
        }

        if( this.isDefined(this.page) ){
            this.body += "&page=" + this.page;
        }

        if( this.isDefined(this.tsFrom) ){
            this.body += "&ts_from=" + this.tsFrom;
      	}

        if( this.isDefined(this.tsTo) ){
            this.body += "&ts_to=" + this.tsTo;
        }

        if( this.isDefined(this.types) ){
            this.body += "&types=" + this.types;
        }

        if( this.isDefined(this.user) ){
            this.body += "&user=" + this.user;
        }

        this.setBody(this.body);

        return this.body;
    }
}