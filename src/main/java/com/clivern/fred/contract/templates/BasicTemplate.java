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
package com.clivern.fred.contract.templates;

/**
 * Basic Template Interface
 *
 * @author A.F
 * @since 1.0.0
 */
public interface BasicTemplate {

    /**
     * Set URL
     *
     * @param  url
     */
    public void setURL(String url);

    /**
     * Set Message Body
     *
     * @param  body
     */
    public void setBody(String body);

    /**
     * Set Content Type
     *
     * @param contentType
     */
    public void setContentType(String contentType);

    /**
     * Set Method
     *
     * @param method
     */
    public void setMethod(String method);

    /**
     * Get URL
     *
     * @return String
     */
    public String getURL();

    /**
     * Get Body
     *
     * @return String
     */
    public String getBody();

    /**
     * Get Content Type
     *
     * @return String
     */
    public String getContentType();

    /**
     * Get Method
     *
     * @return String
     */
    public String getMethod();

    /**
     * Build Message Body
     */
    public String build();

    /**
     * Check if All Required Data is Provided
     *
     * @return Boolean
     */
    public Boolean isValid();

    /**
     * Debug The Request
     *
     * @return String
     */
    public String debug();

    /**
     * Debug The Request
     *
     * @return String
     */
    public String toString();
}