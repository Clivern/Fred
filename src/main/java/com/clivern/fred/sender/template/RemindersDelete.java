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
 * Reminders Delete Template Class
 *
 * It Deletes a reminder.
 *
 * Supported token types: user
 * Expected scopes: reminders:write, post
 *
 * <a href="https://api.slack.com/methods/reminders.delete">For More Info</a>
 *
 * @author Clivern
 * @since 1.0.0
 */
public class RemindersDelete extends BasicTemplate {

    protected String token;
    protected String reminder;

    /**
     * Class Constructor
     */
    public RemindersDelete()
    {
        this.setURL(Basic.methodURL(Basic.remindersDeleteMethod));
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
     * Set Reminder
     *
     * @param reminder
     */
    public void setReminder(String reminder)
    {
        this.reminder = reminder;
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
     * Get Reminder
     *
     * @return String
     */
    public String getReminder()
    {
        return this.reminder;
    }

    /**
     * Build Message Body
     */
    public String build()
    {
        if( !this.isDefined(this.token) || !this.isDefined(this.reminder) ){
            return "";
        }

        if( this.isDefined(this.token) ){
            this.body += "token=" + this.token;
        }

        if( this.isDefined(this.reminder) ){
            this.body += "&reminder=" + this.reminder;
        }

        this.setBody(this.body);

        return this.body;
    }
}