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
 * Users Info Template Class
 *
 * It Gets information about a user.
 *
 * Supported token types: bot, workspace, user
 * Expected scopes: users:read, read
 *
 * <a href="https://api.slack.com/methods/users.info">For More Info</a>
 *
 * @author A.F
 * @since 1.0.0
 */
public class UsersInfo extends BasicTemplate {

    protected String url = Basic.methodURL(Basic.usersInfoMethod);
    protected String token;
    protected String user;
    protected Boolean includeLocale;

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
     * Set User
     *
     * @param user
     */
    public void setUser(String user)
    {
        this.user = user;
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
     * Get Token
     *
     * @return String
     */
    public String getToken()
    {
        return this.token;
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
     * Get Include Locale
     *
     * @return Boolean
     */
    public Boolean getIncludeLocale()
    {
        return this.includeLocale;
    }

    /**
     * Build Message Body
     */
    public String build()
    {
        if( this.token.isEmpty() || this.user.isEmpty() ){
            return "";
        }

        if( !this.token.isEmpty() ){
            this.body += "token=" + this.token;
        }

        if( !this.user.isEmpty() ){
            this.body += "&user=" + this.user;
        }

        if( !this.includeLocale !== null ){
            this.body += "&include_locale=" + ((this.includeLocale) ? "true" : "false");
        }

        return this.body;
    }
}