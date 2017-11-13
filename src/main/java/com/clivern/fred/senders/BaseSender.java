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
package com.clivern.fred.senders;

import com.clivern.fred.senders.templates.*;
import com.clivern.fred.utils.Config;
import com.clivern.fred.utils.Log;
import com.mashape.unirest.http.*;
import com.mashape.unirest.http.async.Callback;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.http.options.Options;
import com.mashape.unirest.request.GetRequest;
import com.mashape.unirest.request.HttpRequest;
import com.clivern.fred.contract.senders.templates.BasicTemplate;

/**
 * Base Sender Class
 *
 * @author A.F
 * @since 1.0.0
 */
public class BaseSender {

    protected Config configs;

    protected Log log;

    protected String response;


    /**
     * Class Constructor
     *
     * @param configs
     * @param log
     */
    public BaseSender(Config configs, Log log)
    {
        this.configs = configs;
        this.log = log;
    }

    /**
     * Send Basic Template
     *
     * @param  basicTemplate
     * @return Boolean
     * @throws UnirestException
     */
    public Boolean send(BasicTemplate basicTemplate) throws UnirestException
    {
        this.log.info(basicTemplate.debug());

        HttpResponse<String> responseObj = Unirest.post(basicTemplate.getURL()).header("Content-Type", basicTemplate.getContentType()).body(basicTemplate.getBody()).asString();

        this.response = responseObj.getBody();

        this.log.info(this.response);
        if( this.response.indexOf("\"ok\":true") > 0 ){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Get Response
     *
     * @return String
     */
    public String getResponse()
    {
        return this.response;
    }
}