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
 * Apps Permissions Request Template Class
 *
 * It Allows an app to request additional scopes. It is used to request additional permissions with a team.
 * It's a part of the Permissions API made available to workspace token-based applications.
 *
 * Supported token types: workspace
 *
 * <a href="https://api.slack.com/methods/apps.permissions.request">For More Info</a>
 *
 * @author A.F
 * @since 1.0.0
 */
public class AppsPermissionsRequest extends BasicTemplate {

    protected String url = Basic.methodURL(Basic.appsPermissionsRequestMethod);
    protected String token;
    protected String scopes;
    protected String triggerId;

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
     * Set Scopes
     *
     * @param scopes
     */
    public void setScopes(String scopes)
    {
        this.scopes = scopes;
    }

    /**
     * Set Trigger Id
     *
     * @param triggerId
     */
    public void setTriggerId(String triggerId)
    {
        this.triggerId = triggerId;
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
     * Get Scopes
     *
     * @return String
     */
    public String getScopes()
    {
        return this.scopes;
    }

    /**
     * Get Trigger ID
     *
     * @return String
     */
    public String getTriggerId()
    {
        return this.triggerId;
    }

    /**
     * Build Message Body
     */
    public String build()
    {
        if( this.token.isEmpty() || this.scopes.isEmpty() || this.triggerId.isEmpty() ){
            return "";
        }

        if( !this.token.isEmpty() ){
            this.body += "token=" + this.token;
        }

        if( !this.scopes.isEmpty() ){
            this.body += "&scopes=" + this.scopes;
        }

        if( !this.triggerId.isEmpty() ){
            this.body += "&trigger_id=" + this.triggerId;
        }

        return this.body;
    }
}