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
package com.clivern.fred.contract.sender.template;

/**
 * Basic Template Class
 *
 * @author A.F
 * @since 1.0.0
 */
public abstract class BasicTemplate {

    protected String url = "";
    protected String body = "";
    protected String contentType = "application/x-www-form-urlencoded";
    protected String method = "POST";
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

    /**
     * Check if property is defined
     *
     * @param  property
     * @return Boolean
     */
    public Boolean isDefined(String property)
    {
        return (property != null && !property.isEmpty());
    }

    /**
     * Check if property is defined
     *
     * @param  property
     * @return Boolean
     */
    public Boolean isDefined(Integer property)
    {
        return (property != null);
    }

    /**
     * Check if property is defined
     *
     * @param  property
     * @return Boolean
     */
    public Boolean isDefined(Boolean property)
    {
        return (property != null);
    }

    /**
     * Check if property is defined
     *
     * @param  property
     * @return Boolean
     */
    public Boolean isDefined(Long property)
    {
        return (property != null);
    }

    /**
     * Build Message Body
     */
    abstract public String build();
}