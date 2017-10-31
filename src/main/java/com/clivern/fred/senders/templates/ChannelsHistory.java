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
 * Channels History Template Class
 *
 * <a href="https://api.slack.com/methods/channels.history">For More Info</a>
 *
 * @author A.F
 * @since 1.0.0
 */
public class ChannelsHistory implements BasicTemplate {

    protected String url = Basic.methodURL(Basic.channelsHistoryMethod);
    protected String body = "";
    protected String contentType = "application/x-www-form-urlencoded";
    protected String method = "POST";
    protected String token;
    protected String channel;
    protected Integer count;
    protected Boolean inclusive;
    protected String latest;
    protected String oldest;
    protected Boolean unreads;
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
     * Set Channel
     *
     * @param channel
     */
    public void setChannel(String channel)
    {
        this.channel = channel;
    }

    /**
     * Set Count
     *
     * @param count
     */
    public void setCount(Integer count)
    {
        this.count = count;
    }

    /**
     * Set Inclusive
     *
     * @param inclusive
     */
    public void setInclusive(Boolean inclusive)
    {
        this.inclusive = inclusive;
    }

    /**
     * Set Latest
     *
     * @param latest
     */
    public void setLatest(String latest)
    {
        this.latest = latest;
    }

    /**
     * Set Oldest
     *
     * @param oldest
     */
    public void setOldest(String oldest)
    {
        this.oldest = oldest;
    }

    /**
     * Set Unreads
     *
     * @param unreads
     */
    public void setUnreads(Boolean unreads)
    {
        this.unreads = unreads;
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
     * Get Channel
     *
     * @return String
     */
    public String getChannel()
    {
        return this.channel;
    }

    /**
     * Get Count
     *
     * @return Integer
     */
    public Integer getCount()
    {
        return this.count;
    }

    /**
     * Get Inclusive
     *
     * @return Integer
     */
    public Boolean getInclusive()
    {
        return this.inclusive;
    }

    /**
     * Get Latest
     *
     * @return String
     */
    public String getLatest()
    {
        return this.latest;
    }

    /**
     * Get Oldest
     *
     * @return String
     */
    public String getOldest()
    {
        return this.oldest;
    }

    /**
     * Get Unreads
     *
     * @return Integer
     */
    public Boolean getUnreads()
    {
        return this.unreads;
    }

    /**
     * Build Message Body
     */
    public String build()
    {
        if( this.token.isEmpty() || this.channel.isEmpty() ){
            return "";
        }

        if( !this.token.isEmpty() ){
            this.body += "token=" + this.token;
        }

        if( !this.channel.isEmpty() ){
            this.body += "&channel=" + this.channel;
        }

        if( !this.count.isEmpty() ){
            this.body += "&count=" + this.count;
        }

        if( !this.inclusive !== null ){
            this.body += "&inclusive=" + ((this.inclusive) ? "true" : "false");
        }

        if( !this.latest !== null ){
            this.body += "&latest=" + this.latest;
        }

        if( !this.oldest !== null ){
            this.body += "&oldest=" + this.oldest;
        }

        if( !this.unreads !== null ){
            this.body += "&unreads=" + ((this.unreads) ? "true" : "false");
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