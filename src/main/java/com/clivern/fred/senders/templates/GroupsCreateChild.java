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
 * Groups Create Child Template Class
 *
 * It Clones and archives a private channel.
 *
 * It takes an existing private channel and performs the following steps:
 * - Renames the existing private channel (from "example" to "example-archived").
 * - Archives the existing private channel.
 * - Creates a new private channel with the name of the existing private channel.
 * - Adds all members of the existing private channel to the new private channel.
 * - This is useful when inviting a new member to an existing private channel while hiding all previous chat history from them.
 *   In this scenario you can call groups.createChild followed by groups.invite.
 *
 * The new private channel will have a special parent_group property pointing to the original archived private channel.
 * This will only be returned for members of both private channels, so will not be visible to any newly invited members.
 *
 * Supported token types: workspace, user
 * Expected scopes: groups:write, post
 *
 * <a href="https://api.slack.com/methods/groups.createChild">For More Info</a>
 *
 * @author A.F
 * @since 1.0.0
 */
public class GroupsCreateChild extends BasicTemplate {

    protected String url = Basic.methodURL(Basic.groupsCreateChildMethod);
    protected String token;
    protected String channel;

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
     * Set Channel
     *
     * @param channel
     */
    public void setChannel(String channel)
    {
        this.channel = channel;
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
     * Get Channel
     *
     * @return String
     */
    public String getChannel()
    {
        return this.channel;
    }

    /**
     * Build Message Body
     */
    public String build()
    {
        if( this.token.isEmpty() || this.channel.isEmpty() ){
            return "";
        }

        if( !this.token.isEmpty() ){
            this.body += "token=" + this.token;
        }

        if( !this.channel.isEmpty() ){
            this.body += "&channel=" + this.channel;
        }

        return this.body;
    }
}