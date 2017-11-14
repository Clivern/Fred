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
 * Reminders Add Template Class
 *
 * It Creates a reminder.
 *
 * Supported token types: user
 * Expected scopes: reminders:write, post
 *
 * <a href="https://api.slack.com/methods/reminders.add">For More Info</a>
 *
 * @author A.F
 * @since 1.0.0
 */
public class RemindersAdd extends BasicTemplate {

    protected String url = Basic.methodURL(Basic.remindersAddMethod);
    protected String token;
    protected String text;
    protected String time;
    protected Long timestamp;
    protected String user;

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
     * Set Text
     *
     * @param text
     */
    public void setText(String text)
    {
        this.text = text;
    }

    /**
     * Set Time
     *
     * @param time
     */
    public void setTime(String time)
    {
        this.time = time;
    }

    /**
     * Set Timestamp
     *
     * @param timestamp
     */
    public void setTimestamp(Long timestamp)
    {
        this.timestamp = timestamp;
    }

    /**
     * Set User
     *
     * @param user
     */
    public void setUser(String user)
    {
        this.user = user;
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
     * Get Text
     *
     * @return String
     */
    public String getText()
    {
        return this.text;
    }

    /**
     * Get Time
     *
     * @return String
     */
    public String getTime()
    {
        return this.time;
    }

    /**
     * Get Timestamp
     *
     * @return String
     */
    public Long getTimestamp()
    {
        return this.timestamp;
    }

    /**
     * Get User
     *
     * @return String
     */
    public String getUser()
    {
        return this.user;
    }

    /**
     * Build Message Body
     */
    public String build()
    {
        if( this.token.isEmpty() || this.text.isEmpty() || (this.time.isEmpty() && this.timestamp != null) ){
            return "";
        }

        if( !this.token.isEmpty() ){
            this.body += "token=" + this.token;
        }

        if( !this.text.isEmpty() ){
            this.body += "&text=" + this.text;
        }

        if( !this.time.isEmpty() ){
            this.body += "&time=" + this.time;
        }

        if( this.timestamp != null ){
            this.body += "&time=" + this.timestamp;
        }

        if( !this.user.isEmpty() ){
            this.body += "&user=" + this.user;
        }

        return this.body;
    }
}