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
 * Mpim Open Template Class
 *
 * It opens a multiparty direct message.
 *
 * Supported token types: bot, user
 * Expected scopes: mpim:write, post
 *
 * <a href="https://api.slack.com/methods/mpim.open">For More Info</a>
 *
 * @author A.F
 * @since 1.0.0
 */
public class MpimOpen extends BasicTemplate {

    protected String url = Basic.methodURL(Basic.mpimOpenMethod);
    protected String token;
    protected String users;

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
     * Set Users
     *
     * @param users
     */
    public void setUsers(String users)
    {
        this.users = users;
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
     * Get Users
     *
     * @return String
     */
    public String getUsers()
    {
        return this.users;
    }

    /**
     * Build Message Body
     */
    public String build()
    {
        if( this.token.isEmpty() || this.users.isEmpty() ){
            return "";
        }

        if( !this.token.isEmpty() ){
            this.body += "token=" + this.token;
        }

        if( !this.users.isEmpty() ){
            this.body += "&users=" + this.users;
        }

        return this.body;
    }
}
