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
 * Mpim List Template Class
 *
 * It Lists multiparty direct message channels for the calling user.
 *
 * Supported token types: bot, workspace, user
 * Expected scopes: mpim:read, read
 *
 * <a href="https://api.slack.com/methods/mpim.list">For More Info</a>
 *
 * @author Clivern
 * @since 1.0.0
 */
public class MpimList extends BasicTemplate {

    protected String token;

    /**
     * Class Constructor
     */
    public MpimList()
    {
        this.setURL(Basic.methodURL(Basic.mpimListMethod));
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