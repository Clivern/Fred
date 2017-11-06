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
 * Team Access Logs Template Class
 *
 * It Gets the access logs for the current team.
 *
 * Supported token types: user
 * Expected scopes: admin
 *
 * <a href="https://api.slack.com/methods/team.accessLogs">For More Info</a>
 *
 * @author A.F
 * @since 1.0.0
 */
public class TeamAccessLogs extends BasicTemplate {

    protected String url = Basic.methodURL(Basic.teamAccessLogsMethod);
    protected String token;
    protected String before;
    protected Integer count;
    protected Integer page;

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
     * Set Before
     *
     * @param before
     */
    public void setBefore(String before)
    {
        this.before = before;
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
     * Get Token
     *
     * @return String
     */
    public String getToken()
    {
        return this.token;
    }

    /**
     * Get Before
     *
     * @return String
     */
    public String getBefore()
    {
        return this.before;
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

        if( !this.before.isEmpty() ){
            this.body += "&before=" + this.before;
        }

        if( this.count != null ){
            this.body += "&count=" + this.count;
        }

        if( this.page != null ){
            this.body += "&page=" + this.page;
        }

        return this.body;
    }
}