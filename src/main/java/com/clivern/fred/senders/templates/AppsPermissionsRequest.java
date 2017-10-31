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
 * Apps Permissions Request Template Class
 *
 * <a href="https://api.slack.com/methods/apps.permissions.request">For More Info</a>
 *
 * @author A.F
 * @since 1.0.0
 */
public class AppsPermissionsRequest implements BasicTemplate {

    protected String url = Basic.methodURL(Basic.appsPermissionsRequestMethod);
    protected String body = "";
    protected String contentType = "application/x-www-form-urlencoded";
    protected String method = "POST";
    protected String token;
    protected String scopes;
    protected String triggerId;
    protected Boolean valid;

    /**
     * Set URL
     *
     * @param  url
     */
    public void setURL(String url)
    {
        this.url = url;
    }

    /**
     * Set Message Body
     *
     * @param  body
     */
    public void setBody(String body)
    {
        this.body = body;
    }

    /**
     * Set Content Type
     *
     * @param contentType
     */
    public void setContentType(String contentType)
    {
        this.contentType = contentType;
    }

    /**
     * Set Method
     *
     * @param method
     */
    public void setMethod(String method)
    {
        this.method = method;
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
     * Get URL
     *
     * @return String
     */
    public String getURL()
    {
        return this.url;
    }

    /**
     * Get Body
     *
     * @return String
     */
    public String getBody()
    {
        return this.body;
    }

    /**
     * Get Content Type
     *
     * @return String
     */
    public String getContentType()
    {
        return this.contentType;
    }

    /**
     * Get Method
     *
     * @return String
     */
    public String getMethod()
    {
        return this.method;
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

    /**
     * Check if All Required Data is Provided
     *
     * @return Boolean
     */
    public Boolean isValid()
    {
        return (!this.method.isEmpty() && !this.contentType.isEmpty() && !this.body.isEmpty() && !this.url.isEmpty());
    }

    /**
     * Debug The Request
     *
     * @return String
     */
    public String debug()
    {
        return "curl -X " + this.method + " -H \"Content-Type: " + this.contentType + "\" -d '" + this.body + "' \"" + this.url + "\"";
    }

    /**
     * Debug The Request
     *
     * @return String
     */
    public String toString()
    {
        return this.debug();
    }
}