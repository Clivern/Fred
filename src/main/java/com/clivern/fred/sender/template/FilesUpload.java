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
 * Files Upload Template Class
 *
 * It Uploads or creates a file.
 *
 * Supported token types: bot, workspace, user
 * Expected scopes: files:write:user, post
 *
 * <a href="https://api.slack.com/methods/files.upload">For More Info</a>
 *
 * @author Clivern
 * @since 1.0.0
 */
public class FilesUpload extends BasicTemplate {

    protected String token;
    protected String channels;
    protected String content;
    protected String file;
    protected String filename;
    protected String filetype;
    protected String initialComment;
    protected String title;

    /**
     * Class Constructor
     */
    public FilesUpload()
    {
        this.setURL(Basic.methodURL(Basic.filesUploadMethod));
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
     * Set Channels
     *
     * @param channels
     */
    public void setChannels(String channels)
    {
        this.channels = channels;
    }

    /**
     * Set Content
     *
     * @param content
     */
    public void setContent(String content)
    {
        this.content = content;
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
     * Set Filename
     *
     * @param filename
     */
    public void setFilename(String filename)
    {
        this.filename = filename;
    }

    /**
     * Set Filetype
     *
     * @param filetype
     */
    public void setFiletype(String filetype)
    {
        this.filetype = filetype;
    }

    /**
     * Set Initial Comment
     *
     * @param initialComment
     */
    public void setInitialComment(String initialComment)
    {
        this.initialComment = initialComment;
    }

    /**
     * Set Title
     *
     * @param title
     */
    public void setTitle(String title)
    {
        this.title = title;
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
     * Get Channels
     *
     * @return String
     */
    public String getChannels()
    {
        return this.channels;
    }

    /**
     * Get Content
     *
     * @return String
     */
    public String getContent()
    {
        return this.content;
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
     * Get Filename
     *
     * @return String
     */
    public String getFilename()
    {
        return this.filename;
    }

    /**
     * Get Filetype
     *
     * @return String
     */
    public String getFiletype()
    {
        return this.filetype;
    }

    /**
     * Get Initial Comment
     *
     * @return String
     */
    public String getInitialComment()
    {
        return this.initialComment;
    }

    /**
     * Get Title
     *
     * @return String
     */
    public String getTitle()
    {
        return this.title;
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

        if( this.isDefined(this.channels) ){
            this.body += "&channels=" + this.channels;
        }

        if( this.isDefined(this.content) ){
            this.body += "&content=" + this.content;
        }

        if( this.isDefined(this.file) ){
            this.body += "&file=" + this.file;
        }

        if( this.isDefined(this.filename) ){
            this.body += "&filename=" + this.filename;
      	}

        if( this.isDefined(this.filetype) ){
            this.body += "&filetype=" + this.filetype;
        }

        if( this.isDefined(this.initialComment) ){
            this.body += "&initial_comment=" + this.initialComment;
        }

        if( this.isDefined(this.title) ){
            this.body += "&title=" + this.title;
        }

        this.setBody(this.body);

        return this.body;
    }
}