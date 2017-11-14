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
 * Files Comments Delete Template Class
 *
 * It Deletes an existing comment on a file.
 *
 * Supported token types: bot, workspace, user
 * Expected scopes: files:write:user, post
 *
 * <a href="https://api.slack.com/methods/files.comments.delete">For More Info</a>
 *
 * @author A.F
 * @since 1.0.0
 */
public class FilesCommentsDelete extends BasicTemplate {

    protected String url = Basic.methodURL(Basic.filesCommentsDeleteMethod);
    protected String token;
    protected String id;
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
     * Set Id
     *
     * @param id
     */
    public void setId(String id)
    {
        this.id = id;
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
     * Get Id
     *
     * @return String
     */
    public String getId()
    {
        return this.id;
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
        if( this.token.isEmpty() || this.id.isEmpty() || this.file.isEmpty() ){
            return "";
        }

        if( !this.token.isEmpty() ){
            this.body += "token=" + this.token;
        }

        if( !this.id.isEmpty() ){
            this.body += "&id=" + this.id;
        }

        if( !this.file.isEmpty() ){
            this.body += "&file=" + this.file;
        }

        return this.body;
    }
}