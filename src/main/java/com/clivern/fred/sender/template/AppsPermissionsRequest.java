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
 * Apps Permissions Request Template Class
 *
 * It Allows an app to request additional scopes. It is used to request additional permissions with a team.
 * It's a part of the Permissions API made available to workspace token-based applications.
 *
 * Supported token types: workspace
 *
 * <a href="https://api.slack.com/methods/apps.permissions.request">For More Info</a>
 *
 * @author Clivern
 * @since 1.0.0
 */
public class AppsPermissionsRequest extends BasicTemplate {

    protected String token;
    protected String scopes;
    protected String triggerId;

    /**
     * Class Constructor
     */
    public AppsPermissionsRequest()
    {
        this.setURL(Basic.methodURL(Basic.appsPermissionsRequestMethod));
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
        if( !this.isDefined(this.token) || !this.isDefined(this.scopes) || !this.isDefined(this.triggerId) ){
            return "";
        }

        if( this.isDefined(this.token) ){
            this.body += "token=" + this.token;
        }

        if( this.isDefined(this.scopes) ){
            this.body += "&scopes=" + this.scopes;
        }

        if( this.isDefined(this.triggerId) ){
            this.body += "&trigger_id=" + this.triggerId;
        }

        this.setBody(this.body);

        return this.body;
    }
}