/*
 * Copyright (C) 2017 Clivern. <https://clivern.com>
 */
package com.clivern.fred.senders.templates;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Button Template Class
 */
public class ButtonTemplate {

    protected String url;
    protected String body;

    /**
     * Set URL
     *
     * @param  url
     */
    public String setURL(String url)
    {
        this.url = url;
    }

    /**
     * Set Message Body
     *
     * @param  body
     */
    public String setBody(String body)
    {
        this.body = body;
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
     * Build Message Body
     */
    public Boolean build()
    {
        this.body = "";
    }
}