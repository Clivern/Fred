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
 * Files Comments Add Template Class
 *
 * It Add a comment to an existing file.
 *
 * Supported token types: bot, workspace, user
 * Expected scopes: files:write:user, post
 *
 * <a href="https://api.slack.com/methods/files.comments.add">For More Info</a>
 *
 * @author A.F
 * @since 1.0.0
 */
public class FilesCommentsAdd extends BasicTemplate {

    protected String url = Basic.methodURL(Basic.filesCommentsAddMethod);
    protected String token;
    protected String comment;
    protected String file;

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
     * Build Message Body
     */
    public String build()
    {
        if( this.token.isEmpty() || this.comment.isEmpty() || this.file.isEmpty() ){
            return "";
        }

        if( !this.token.isEmpty() ){
            this.body += "token=" + this.token;
        }

        if( !this.comment.isEmpty() ){
            this.body += "&comment=" + this.comment;
        }

        if( !this.file.isEmpty() ){
            this.body += "&file=" + this.file;
        }

        return this.body;
    }
}