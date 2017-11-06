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
 * Reactions List Template Class
 *
 * It Lists reactions made by a user.
 *
 * Supported token types: bot, workspace, user
 * Expected scopes: reactions:read, read
 *
 * <a href="https://api.slack.com/methods/reactions.list">For More Info</a>
 *
 * @author A.F
 * @since 1.0.0
 */
public class ReactionsList extends BasicTemplate {

    protected String url = Basic.methodURL(Basic.reactionsListMethod);
    protected String token;
    protected Integer count;
    protected Boolean full;
    protected Integer page;
    protected String user;

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
     * Set Count
     *
     * @param count
     */
    public void setCount(Integer count)
    {
        this.count = count;
    }

    /**
     * Set Full
     *
     * @param full
     */
    public void setFull(Boolean full)
    {
        this.full = full;
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
     * Get Count
     *
     * @return Integer
     */
    public Integer getCount()
    {
        return this.count;
    }

    /**
     * Get Full
     *
     * @return Boolean
     */
    public Boolean getFull()
    {
        return this.full;
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
        if( this.token.isEmpty() ){
            return "";
        }

        if( !this.token.isEmpty() ){
            this.body += "token=" + this.token;
        }

        if( this.count != null ){
            this.body += "count=" + this.count;
        }

        if( this.full != null ){
            this.body += "&full=" + ((this.full) ? "true" : "false");
        }

        if( this.page != null ){
            this.body += "page=" + this.page;
        }

        if( !this.user.isEmpty() ){
            this.body += "user=" + this.user;
        }

        return this.body;
    }
}