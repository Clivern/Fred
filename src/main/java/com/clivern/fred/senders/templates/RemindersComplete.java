/*
 * Copyright (C) 2017 Clivern. <https://clivern.com>
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
 * For More Info, Please Visit <https://api.slack.com/methods/reminders.complete>
 */
public class RemindersComplete implements BasicTemplate {

    protected String url = Basic.methodURL(Basic.remindersCompleteMethod);
    protected String body = "";
    protected String contentType = "application/x-www-form-urlencoded";
    protected String method = "POST";
    protected String token;
    protected String reminder;
    protected Boolean valid;

    /**
     * Set URL
     *
     * @param  url
     */
    public void setURL(String url)
    {
        this.url = url;
    }

    /**
     * Set Message Body
     *
     * @param  body
     */
    public void setBody(String body)
    {
        this.body = body;
    }

    /**
     * Set Content Type
     *
     * @param contentType
     */
    public void setContentType(String contentType)
    {
        this.contentType = contentType;
    }

    /**
     * Set Method
     *
     * @param method
     */
    public void setMethod(String method)
    {
        this.method = method;
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
     * Get URL
     *
     * @return String
     */
    public String getURL()
    {
        return this.url;
    }

    /**
     * Get Body
     *
     * @return String
     */
    public String getBody()
    {
        return this.body;
    }

    /**
     * Get Content Type
     *
     * @return String
     */
    public String getContentType()
    {
        return this.contentType;
    }

    /**
     * Get Method
     *
     * @return String
     */
    public String getMethod()
    {
        return this.method;
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

    /**
     * Check if All Required Data is Provided
     *
     * @return Boolean
     */
    public Boolean isValid()
    {
        return (!this.method.isEmpty() && !this.contentType.isEmpty() && !this.body.isEmpty() && !this.url.isEmpty());
    }

    /**
     * Debug The Request
     *
     * @return String
     */
    public String debug()
    {
        return "curl -X " + this.method + " -H \"Content-Type: " + this.contentType + "\" -d '" + this.body + "' \"" + this.url + "\"";
    }

    /**
     * Debug The Request
     *
     * @return String
     */
    public String toString()
    {
        return this.debug();
    }
}