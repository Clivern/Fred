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
import com.clivern.fred.contract.senders.templates.BasicTemplate;

/**
 * Search All Template Class
 *
 * It Searches for messages and files matching a query.
 *
 * Supported token types: workspace, user
 * Expected scopes: search:read, read
 *
 * <a href="https://api.slack.com/methods/search.all">For More Info</a>
 *
 * @author A.F
 * @since 1.0.0
 */
public class SearchAll extends BasicTemplate {

    protected String url = Basic.methodURL(Basic.searchAllMethod);
    protected String token;
    protected String query;
    protected Integer count;
    protected Integer page;
    protected Boolean highlight;
    protected String sort;
    protected String sortDir;

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
     * Set Query
     *
     * @param query
     */
    public void setQuery(String query)
    {
        this.query = query;
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
     * Set Highlight
     *
     * @param highlight
     */
    public void setHighlight(Boolean highlight)
    {
        this.highlight = highlight;
    }

    /**
     * Set Sort
     *
     * @param sort
     */
    public void setSort(String sort)
    {
        this.sort = sort;
    }

    /**
     * Set Sort Dir
     *
     * @param sortDir
     */
    public void setSortDir(String sortDir)
    {
        this.sortDir = sortDir;
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
     * Get Query
     *
     * @return String
     */
    public String getQuery()
    {
        return this.query;
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
     * Get Highlight
     *
     * @return Boolean
     */
    public Boolean getHighlight()
    {
        return this.highlight;
    }

    /**
     * Get Sort
     *
     * @return String
     */
    public String getSort()
    {
        return this.sort;
    }

    /**
     * Get Sort Dir
     *
     * @return String
     */
    public String getSortDir()
    {
        return this.sortDir;
    }

    /**
     * Build Message Body
     */
    public String build()
    {
        if( this.token.isEmpty() || this.query.isEmpty() ){
            return "";
        }

        if( !this.token.isEmpty() ){
            this.body += "token=" + this.token;
        }

        if( !this.query.isEmpty() ){
            this.body += "&query=" + this.query;
        }

        if( this.count != null ){
            this.body += "&count=" + this.count;
        }

        if( this.page != null ){
            this.body += "&page=" + this.page;
        }

        if( this.highlight != null ){
            this.body += "&highlight=" + ((this.highlight) ? "true" : "false");
        }

        if( !this.sort.isEmpty() ){
            this.body += "&sort=" + this.sort;
        }

        if( !this.sortDir.isEmpty() ){
            this.body += "&sort_dir=" + this.sortDir;
        }

        return this.body;
    }
}