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
 * Stars Remove Template Class
 *
 * It Removes a star from an item.
 *
 * Supported token types: bot, workspace, user
 * Expected scopes: stars:write, post
 *
 * <a href="https://api.slack.com/methods/stars.remove">For More Info</a>
 *
 * @author Clivern
 * @since 1.0.0
 */
public class StarsRemove extends BasicTemplate {

    protected String token;
    protected String channel;
    protected String file;
    protected String fileComment;
    protected String timestamp;

    /**
     * Class Constructor
     */
    public StarsRemove()
    {
        this.setURL(Basic.methodURL(Basic.starsRemoveMethod));
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
     * Set File
     *
     * @param file
     */
    public void setFile(String file)
    {
        this.file = file;
    }

    /**
     * Set File Comment
     *
     * @param fileComment
     */
    public void setFileComment(String fileComment)
    {
        this.fileComment = fileComment;
    }

    /**
     * Set Timestamp
     *
     * @param timestamp
     */
    public void setTimestamp(String timestamp)
    {
        this.timestamp = timestamp;
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
     * Get File
     *
     * @return String
     */
    public String getFile()
    {
        return this.file;
    }

    /**
     * Get File Comment
     *
     * @return String
     */
    public String getFileComment()
    {
        return this.fileComment;
    }

    /**
     * Get Timestamp
     *
     * @return String
     */
    public String getTimestamp()
    {
        return this.timestamp;
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

        if( this.isDefined(this.channel) ){
            this.body += "&channel=" + this.channel;
        }

        if( this.isDefined(this.file) ){
            this.body += "&file=" + this.file;
        }

        if( this.isDefined(this.fileComment) ){
            this.body += "&file_comment=" + this.fileComment;
        }

        if( this.isDefined(this.timestamp) ){
            this.body += "&timestamp=" + this.timestamp;
        }

        this.setBody(this.body);

        return this.body;
    }
}