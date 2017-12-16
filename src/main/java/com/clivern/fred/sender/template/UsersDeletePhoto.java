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
 * Users Delete Photo Template Class
 *
 * It Deletes the user profile photo.
 *
 * Supported token types: user
 * Expected scopes: users.profile:write, post
 *
 * <a href="https://api.slack.com/methods/users.deletePhoto">For More Info</a>
 *
 * @author A.F
 * @since 1.0.0
 */
public class UsersDeletePhoto extends BasicTemplate {

    protected String token;

    /**
     * Class Constructor
     */
    public UsersDeletePhoto()
    {
        this.setURL(Basic.methodURL(Basic.usersDeletePhotoMethod));
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
     * Get Token
     *
     * @return String
     */
    public String getToken()
    {
        return this.token;
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

        this.setBody(this.body);

        return this.body;
    }
}