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
 * Groups Create Template Class
 *
 * It creates a private channel.
 *
 * Supported token types: workspace, user
 * Expected scopes: groups:write, post
 *
 * <a href="https://api.slack.com/methods/groups.create">For More Info</a>
 *
 * @author Clivern
 * @since 1.0.0
 */
public class GroupsCreate extends BasicTemplate {

    protected String token;
    protected String name;
    protected Boolean validate;

    /**
     * Class Constructor
     */
    public GroupsCreate()
    {
        this.setURL(Basic.methodURL(Basic.groupsCreateMethod));
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
     * Set Name
     *
     * @param name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Set Validate
     *
     * @param validate
     */
    public void setValidate(Boolean validate)
    {
        this.validate = validate;
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
     * Get Name
     *
     * @return String
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * Get Validate
     *
     * @return Boolean
     */
    public Boolean getValidate()
    {
        return this.validate;
    }

    /**
     * Build Message Body
     */
    public String build()
    {
        if( !this.isDefined(this.token) || !this.isDefined(this.name) ){
            return "";
        }

        if( this.isDefined(this.token) ){
            this.body += "token=" + this.token;
        }

        if( this.isDefined(this.name) ){
            this.body += "&name=" + this.name;
        }

        if( this.isDefined(this.validate) ){
            this.body += "&validate=" + ((this.validate) ? "true" : "false");
        }

        this.setBody(this.body);

        return this.body;
    }
}