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
 * Channels Rename Template Class
 *
 * It Renames a channel. The only people who can rename a channel are Team Admins, or the person that originally created the channel.
 * Others will receive a "not_authorized" error.
 *
 * Supported token types: workspace, user
 * Expected scopes: channels:write, post
 *
 * <a href="https://api.slack.com/methods/channels.rename">For More Info</a>
 *
 * @author Clivern
 * @since 1.0.0
 */
public class ChannelsRename extends BasicTemplate {

    protected String token;
    protected String channel;
    protected String name;
    protected Boolean validate;

    /**
     * Class Constructor
     */
    public ChannelsRename()
    {
        this.setURL(Basic.methodURL(Basic.channelsRenameMethod));
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
        if( !this.isDefined(this.token) || !this.isDefined(this.channel) || !this.isDefined(this.name) ){
            return "";
        }

        if( this.isDefined(this.token) ){
            this.body += "token=" + this.token;
        }

        if( this.isDefined(this.channel) ){
            this.body += "&channel=" + this.channel;
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