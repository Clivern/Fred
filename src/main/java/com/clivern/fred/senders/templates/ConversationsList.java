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
 * Conversations List Template Class
 *
 * It Lists all channels in a Slack team.
 *
 * Supported token types: bot, user
 * Expected scopes: channels:read, groups:read, im:read, mpim:read, read
 *
 * <a href="https://api.slack.com/methods/conversations.list">For More Info</a>
 *
 * @author A.F
 * @since 1.0.0
 */
public class ConversationsList extends BasicTemplate {

    protected String url = Basic.methodURL(Basic.conversationsListMethod);
    protected String token;
    protected String cursor;
    protected Boolean excludeArchived;
    protected String types;
    protected Integer limit;

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
     * Set Types
     *
     * @param types
     */
    public void setTypes(String types)
    {
        this.types = types;
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
     * Get Types
     *
     * @return String
     */
    public String getTypes()
    {
        return this.types;
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

        if( !this.excludeArchived !== null ){
            this.body += "&exclude_archived=" + ((this.excludeArchived) ? "true" : "false");
        }

        if( !this.types !== null ){
            this.body += "&types=" + this.types;
        }

        if( !this.limit.isEmpty() ){
            this.body += "&limit=" + this.limit;
        }

        return this.body;
    }
}