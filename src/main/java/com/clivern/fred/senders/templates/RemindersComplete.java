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
 * Reminders Complete Template Class
 *
 * It Marks a reminder as complete.
 *
 * Supported token types: user
 * Expected scopes: reminders:write, post
 *
 * <a href="https://api.slack.com/methods/reminders.complete">For More Info</a>
 *
 * @author A.F
 * @since 1.0.0
 */
public class RemindersComplete extends BasicTemplate {

    protected String url = Basic.methodURL(Basic.remindersCompleteMethod);
    protected String token;
    protected String reminder;

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
        if( this.token.isEmpty() || this.reminder.isEmpty() ){
            return "";
        }

        if( !this.token.isEmpty() ){
            this.body += "token=" + this.token;
        }

        if( !this.reminder.isEmpty() ){
            this.body += "&reminder=" + this.reminder;
        }

        return this.body;
    }
}