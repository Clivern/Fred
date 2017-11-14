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
package com.clivern.fred.sender.template;

import com.clivern.fred.config.Basic;
import com.clivern.fred.contract.sender.template.BasicTemplate;

/**
 * Dnd Set Snooze Template Class
 *
 * It Turns on Do Not Disturb mode for the current user, or changes its duration.
 *
 * Supported token types: user
 * Expected scopes: dnd:write, post
 *
 * <a href="https://api.slack.com/methods/dnd.setSnooze">For More Info</a>
 *
 * @author A.F
 * @since 1.0.0
 */
public class DndSetSnooze extends BasicTemplate {

    protected String url = Basic.methodURL(Basic.dndSetSnoozeMethod);
    protected String token;
    protected Integer numMinutes;

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
     * Set Num Minutes
     *
     * @param numMinutes
     */
    public void setNumMinutes(Integer numMinutes)
    {
        this.numMinutes = numMinutes;
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
     * Get Num Minutes
     *
     * @return Integer
     */
    public Integer getNumMinutes()
    {
        return this.numMinutes;
    }

    /**
     * Build Message Body
     */
    public String build()
    {
        if( this.token.isEmpty() || this.numMinutes == null ){
            return "";
        }

        if( !this.token.isEmpty() ){
            this.body += "token=" + this.token;
        }

        if( this.numMinutes != null ){
            this.body += "&num_minutes=" + this.numMinutes;
        }

        return this.body;
    }
}