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
 * Channels Join Template Class
 *
 * It Joins a channel, creating it if needed. It is used to join a channel. If the channel does not exist, it is created.
 *
 * Supported token types: user
 * Expected scopes: channels:write, post
 *
 * <a href="https://api.slack.com/methods/channels.join">For More Info</a>
 *
 * @author A.F
 * @since 1.0.0
 */
public class ChannelsJoin extends BasicTemplate {

    protected String token;
    protected String name;
    protected Boolean validate;

    /**
     * Class Constructor
     */
    public ChannelsJoin()
    {
        this.setURL(Basic.methodURL(Basic.channelsJoinMethod));
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
        if( this.token.isEmpty() || this.name.isEmpty() ){
            return "";
        }

        if( !this.token.isEmpty() ){
            this.body += "token=" + this.token;
        }

        if( !this.name.isEmpty() ){
            this.body += "&name=" + this.name;
        }

        if( this.validate != null ){
            this.body += "&validate=" + ((this.validate) ? "true" : "false");
        }

        this.setBody(this.body);

        return this.body;
    }
}