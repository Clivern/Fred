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
package com.clivern.fred.sender.template;

import com.clivern.fred.config.Basic;
import com.clivern.fred.contract.sender.template.BasicTemplate;

/**
 * API Test Template Class
 *
 * It helps you test your calling code.
 *
 * Supported token types: workspace, user
 *
 * <a href="https://api.slack.com/methods/api.test">For More Info</a>
 *
 * @author A.F
 * @since 1.0.0
 */
public class ApiTest extends BasicTemplate {

    protected String url = Basic.methodURL(Basic.apiTestMethod);
    protected String arg = "Test";

    /**
     * Set Arg
     *
     * @param arg
     */
    public void setArg(String arg)
    {
        this.arg = arg;
    }

    /**
     * Get Arg
     *
     * @return String
     */
    public String getArg()
    {
        return this.arg;
    }

    /**
     * Build Message Body
     */
    public String build()
    {
        if( this.arg.isEmpty() ){
            return "";
        }

        if( !this.arg.isEmpty() ){
            this.body += "arg=" + this.arg;
        }

        return this.body;
    }
}