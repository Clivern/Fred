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
import com.clivern.fred.contract.senders.templates.BasicTemplate;

/**
 * Reactions Add Template Class
 *
 * It Adds a reaction to an item.
 *
 * Supported token types: bot, workspace, user
 * Expected scopes: reactions:write, post
 *
 * <a href="https://api.slack.com/methods/reactions.add">For More Info</a>
 *
 * @author A.F
 * @since 1.0.0
 */
public class ReactionsAdd extends BasicTemplate {

    protected String url = Basic.methodURL(Basic.reactionsAddMethod);
    protected String token;
    protected String name;
    protected String channel;
    protected String file;
    protected String fileComment;
    protected String timestamp;

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
     * Set Name
     *
     * @param name
     */
    public void setName(String name)
    {
        this.name = name;
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
     * Get Name
     *
     * @return String
     */
    public String getName()
    {
        return this.name;
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
        if( this.token.isEmpty() || this.name.isEmpty() ){
            return "";
        }

        if( !this.token.isEmpty() ){
            this.body += "token=" + this.token;
        }

        if( !this.name.isEmpty() ){
            this.body += "&name=" + this.name;
        }

        if( !this.channel.isEmpty() ){
            this.body += "&channel=" + this.channel;
        }

        if( !this.file.isEmpty() ){
            this.body += "&file=" + this.file;
        }

        if( !this.fileComment.isEmpty() ){
            this.body += "&file_comment=" + this.fileComment;
        }

        if( !this.timestamp.isEmpty() ){
            this.body += "&timestamp=" + this.timestamp;
        }

        return this.body;
    }
}