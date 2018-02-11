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
 * Im Open Template Class
 *
 * It Opens a direct message channel.
 *
 * Supported token types: bot, user
 * Expected scopes: im:write, post
 *
 * <a href="https://api.slack.com/methods/im.open">For More Info</a>
 *
 * @author Clivern
 * @since 1.0.0
 */
public class ImOpen extends BasicTemplate {

    protected String token;
    protected String user;
    protected Boolean includeLocale;
    protected Boolean returnIm;

    /**
     * Class Constructor
     */
    public ImOpen()
    {
        this.setURL(Basic.methodURL(Basic.imOpenMethod));
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
     * Set Return Im
     *
     * @param returnIm
     */
    public void setReturnIm(Boolean returnIm)
    {
        this.returnIm = returnIm;
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
     * Get Return Im
     *
     * @return Boolean
     */
    public Boolean getReturnIm()
    {
        return this.returnIm;
    }

    /**
     * Build Message Body
     */
    public String build()
    {
        if( !this.isDefined(this.token) || !this.isDefined(this.user) ){
            return "";
        }

        if( this.isDefined(this.token) ){
            this.body += "token=" + this.token;
        }

        if( this.isDefined(this.user) ){
            this.body += "&user=" + this.user;
        }

        if( this.isDefined(this.includeLocale) ){
            this.body += "&include_locale=" + ((this.includeLocale) ? "true" : "false");
        }

        if( this.isDefined(this.returnIm) ){
            this.body += "&return_im=" + ((this.returnIm) ? "true" : "false");
        }

        this.setBody(this.body);

        return this.body;
    }
}