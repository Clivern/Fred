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
 * Bots Info Template Class
 *
 * It Gets information about a bot user.
 *
 * Supported token types: workspace, user
 * Expected scopes: users:read, read
 *
 * <a href="https://api.slack.com/methods/bots.info">For More Info</a>
 *
 * @author A.F
 * @since 1.0.0
 */
public class BotsInfo extends BasicTemplate {

    protected String token;
    protected String bot;

    /**
     * Class Constructor
     */
    public BotsInfo()
    {
        this.setURL(Basic.methodURL(Basic.botsInfoMethod));
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
     * Set Bot
     *
     * @param bot
     */
    public void setBot(String bot)
    {
        this.bot = bot;
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
     * Get Bot
     *
     * @return String
     */
    public String getBot()
    {
        return this.bot;
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

        if( this.isDefined(this.bot) ){
            this.body += "&bot=" + this.bot;
        }

        this.setBody(this.body);

        return this.body;
    }
}