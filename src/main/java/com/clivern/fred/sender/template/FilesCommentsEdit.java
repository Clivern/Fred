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
 * Files Comments Edit Template Class
 *
 * It Edit an existing file comment.
 *
 * Supported token types: bot, workspace, user
 * Expected scopes: files:write:user, post
 *
 * <a href="https://api.slack.com/methods/files.comments.edit">For More Info</a>
 *
 * @author Clivern
 * @since 1.0.0
 */
public class FilesCommentsEdit extends BasicTemplate {

    protected String token;
    protected String comment;
    protected String file;
    protected String id;

    /**
     * Class Constructor
     */
    public FilesCommentsEdit()
    {
        this.setURL(Basic.methodURL(Basic.filesCommentsEditMethod));
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
     * Set Comment
     *
     * @param comment
     */
    public void setComment(String comment)
    {
        this.comment = comment;
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
     * Set Id
     *
     * @param id
     */
    public void setId(String id)
    {
        this.id = id;
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
     * Get Comment
     *
     * @return String
     */
    public String getComment()
    {
        return this.comment;
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
     * Get Id
     *
     * @return String
     */
    public String getId()
    {
        return this.id;
    }

    /**
     * Build Message Body
     */
    public String build()
    {
        if( !this.isDefined(this.token) || !this.isDefined(this.comment) || !this.isDefined(this.file) || !this.isDefined(this.id) ){
            return "";
        }

        if( this.isDefined(this.token) ){
            this.body += "token=" + this.token;
        }

        if( this.isDefined(this.comment) ){
            this.body += "&comment=" + this.comment;
        }

        if( this.isDefined(this.file) ){
            this.body += "&file=" + this.file;
        }

        if( this.isDefined(this.id) ){
            this.body += "&id=" + this.id;
        }

        this.setBody(this.body);

        return this.body;
    }
}