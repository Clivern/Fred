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
 * Rtm Start Template Class
 *
 * It Starts a Real Time Messaging session.
 *
 * Supported token types: bot, user
 * Expected scopes: rtm:stream, client
 *
 * <a href="https://api.slack.com/methods/rtm.start">For More Info</a>
 *
 * @author A.F
 * @since 1.0.0
 */
public class RtmStart extends BasicTemplate {

    protected String token;
    protected Integer batchPresenceAware;
    protected Integer noLatest;
	protected Boolean includeLocale;
	protected Boolean mpimAware;
	protected Boolean noUnreads;
	protected Boolean simpleLatest;

    /**
     * Class Constructor
     */
    public RtmStart()
    {
        this.setURL(Basic.methodURL(Basic.rtmStartMethod));
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
     * Set Batch Presence Aware
     *
     * @param batchPresenceAware
     */
    public void setBatchPresenceAware(Integer batchPresenceAware)
    {
        this.batchPresenceAware = batchPresenceAware;
    }

    /**
     * Set No Latest
     *
     * @param noLatest
     */
    public void setNoLatest(Integer noLatest)
    {
        this.noLatest = noLatest;
    }

    /**
     * Set Include Locale
     *
     * @param includeLocale
     */
    public void setIncludeLocale(Boolean includeLocale)
    {
        this.includeLocale = includeLocale;
    }

    /**
     * Set Mpim Aware
     *
     * @param mpimAware
     */
    public void setMpimAware(Boolean mpimAware)
    {
        this.mpimAware = mpimAware;
    }

    /**
     * Set INo Unreads
     *
     * @param noUnreads
     */
    public void setNoUnreads(Boolean noUnreads)
    {
        this.noUnreads = noUnreads;
    }

    /**
     * Set Simple Latest
     *
     * @param simpleLatest
     */
    public void setSimpleLatest(Boolean simpleLatest)
    {
        this.simpleLatest = simpleLatest;
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
     * Get Batch Presence Aware
     *
     * @return Integer
     */
    public Integer getBatchPresenceAware()
    {
        return this.batchPresenceAware;
    }

    /**
     * Get No Latest
     *
     * @return Integer
     */
    public Integer getNoLatest()
    {
        return this.noLatest;
    }

    /**
     * Get Include Locale
     *
     * @return Boolean
     */
    public Boolean getIncludeLocale()
    {
        return this.includeLocale;
    }

    /**
     * Get Mpim Aware
     *
     * @return Boolean
     */
    public Boolean getMpimAware()
    {
        return this.mpimAware;
    }

    /**
     * Get No Unreads
     *
     * @return Boolean
     */
    public Boolean getNoUnreads()
    {
        return this.noUnreads;
    }

    /**
     * Get Simple Latest
     *
     * @return Boolean
     */
    public Boolean getSimpleLatest()
    {
        return this.simpleLatest;
    }

    /**
     * Build Message Body
     */
    public String build()
    {
        if( this.token.isEmpty() ){
            return "";
        }

        if( !this.token.isEmpty() ){
            this.body += "token=" + this.token;
        }

        if( this.batchPresenceAware != null ){
            this.body += "&batch_presence_aware=" + this.batchPresenceAware;
        }

        if( this.noLatest != null ){
            this.body += "&no_latest=" + this.noLatest;
        }

        if( this.includeLocale != null ){
            this.body += "&include_locale=" + ((this.includeLocale) ? "true" : "false");
        }

        if( this.mpimAware != null ){
            this.body += "&mpim_aware=" + ((this.mpimAware) ? "true" : "false");
        }

        if( this.noUnreads != null ){
            this.body += "&no_unreads=" + ((this.noUnreads) ? "true" : "false");
        }
        if( this.simpleLatest != null ){
            this.body += "&simple_latest=" + ((this.simpleLatest) ? "true" : "false");
        }

        this.setBody(this.body);

        return this.body;
    }
}