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
package com.clivern.fred.sender.template;

import com.clivern.fred.config.Basic;
import com.clivern.fred.contract.sender.template.BasicTemplate;

/**
 * Groups List Template Class
 *
 * It returns a list of private channels in the team that the caller is in and archived groups that the caller was in.
 * The list of (non-deactivated) members in each private channel is also returned.
 *
 * Supported token types: bot, workspace, user
 * Expected scopes: groups:read, read
 *
 * <a href="https://api.slack.com/methods/groups.list">For More Info</a>
 *
 * @author A.F
 * @since 1.0.0
 */
public class GroupsList extends BasicTemplate {

    protected String url = Basic.methodURL(Basic.groupsListMethod);
    protected String token;
    protected Boolean excludeArchived;
    protected Boolean excludeMembers;

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
     * Get Token
     *
     * @return String
     */
    public String getToken()
    {
        return this.token;
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

        if( this.excludeArchived != null ){
            this.body += "&exclude_archived=" + ((this.excludeArchived) ? "true" : "false");
        }

        if( this.excludeMembers != null ){
            this.body += "&exclude_members=" + ((this.excludeMembers) ? "true" : "false");
        }

        return this.body;
    }
}