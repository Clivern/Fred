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
 * Channels Rename Template Class
 *
 * It Renames a channel. The only people who can rename a channel are Team Admins, or the person that originally created the channel. Others will receive a "not_authorized" error.
 *
 * Supported token types: workspace, user
 * Expected scopes: channels:write, post
 *
 * <a href="https://api.slack.com/methods/channels.rename">For More Info</a>
 *
 * @author A.F
 * @since 1.0.0
 */
public class ChannelsRename extends BasicTemplate {

    protected String url = Basic.methodURL(Basic.channelsRenameMethod);
    protected String token;
    protected String channel;
    protected String name;
    protected Boolean validate;

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
     * Get Channel
     *
     * @return String
     */
    public String getChannel()
    {
        return this.channel;
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
        if( this.token.isEmpty() || this.channel.isEmpty() || this.name.isEmpty() ){
            return "";
        }

        if( !this.token.isEmpty() ){
            this.body += "token=" + this.token;
        }

        if( !this.channel.isEmpty() ){
            this.body += "&channel=" + this.channel;
        }

        if( !this.name.isEmpty() ){
            this.body += "&name=" + this.name;
        }

        if( !this.validate !== null ){
            this.body += "&validate=" + ((this.validate) ? "true" : "false");
        }

        return this.body;
    }
}