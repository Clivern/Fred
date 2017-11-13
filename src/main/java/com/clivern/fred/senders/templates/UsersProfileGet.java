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
 * Users Profile Get Template Class
 *
 * It Retrieves a user's profile information.
 *
 * Supported token types: workspace, user
 * Expected scopes: users.profile:read, read
 *
 * <a href="https://api.slack.com/methods/users.profile.get">For More Info</a>
 *
 * @author A.F
 * @since 1.0.0
 */
public class UsersProfileGet extends BasicTemplate {

    protected String url = Basic.methodURL(Basic.usersProfileGetMethod);
    protected String token;
    protected Boolean includeLabels;
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
     * Set User
     *
     * @param user
     */
    public void setUser(String user)
    {
        this.user = user;
    }

    /**
     * Set Include Labels Flag
     *
     * @param includeLabels
     */
    public void setIncludeLabels(Boolean includeLabels)
    {
        this.includeLabels = includeLabels;
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
     * Get Include Labels Flag
     *
     * @return String
     */
    public Boolean getIncludeLabels()
    {
        return this.includeLabels;
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

        if( this.includeLabels != null ){
            this.body += "&include_labels=" + ((this.includeLabels) ? "true" : "false");
        }

        if( !this.user.isEmpty() ){
            this.body += "&user=" + this.user;
        }

        return this.body;
    }
}