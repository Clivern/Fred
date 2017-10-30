/*
 * Copyright (C) 2017 Clivern. <https://clivern.com>
 */
package com.clivern.fred.contract.templates;

/**
 * Basic Template Interface
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
}