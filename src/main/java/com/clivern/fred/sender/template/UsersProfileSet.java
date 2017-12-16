/*
 * Copyright (C) 2017 A.F <http://clivern.com>
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
 * Users Profile Set Template Class
 *
 * It Set the profile information for a user.
 *
 * Supported token types: user
 * Expected scopes: users.profile:write, post
 *
 * <a href="https://api.slack.com/methods/users.profile.set">For More Info</a>
 *
 * @author A.F
 * @since 1.0.0
 */
public class UsersProfileSet extends BasicTemplate {

    protected String token;
    protected String user;
    protected String name;
    protected String value;

    /**
     * Class Constructor
     */
    public UsersProfileSet()
    {
        this.setURL(Basic.methodURL(Basic.usersProfileSetMethod));
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
     * Set Name
     *
     * @param name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Set Value
     *
     * @param value
     */
    public void setValue(String value)
    {
        this.value = value;
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
     * Get Name
     *
     * @return String
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * Get Value
     *
     * @return String
     */
    public String getValue()
    {
        return this.value;
    }

    /**
     * Build Message Body
     */
    public String build()
    {
        if( !this.isDefined(this.token) ){
            return "";
        }

        if( this.isDefined(this.token) ){
            this.body += "token=" + this.token;
        }

        if( this.isDefined(this.user) ){
            this.body += "&user=" + this.user;
        }

        if( this.isDefined(this.name) ){
            this.body += "&name=" + this.name;
        }

        if( this.isDefined(this.value) ){
            this.body += "&value=" + this.value;
        }

        this.setBody(this.body);

        return this.body;
    }
}