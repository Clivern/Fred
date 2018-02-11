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
package com.clivern.fred.event.type;

import com.clivern.fred.contract.event.type.EventTemplate;
import org.json.JSONObject;
import java.util.function.Function;

/**
 * URL Verification Event
 *
 * @author Clivern
 * @since 1.0.0
 */
public class UrlVerification extends EventTemplate {

    protected Function<UrlVerification,String> callback;

    /**
     * Class Constructor
     *
     * @param callback
     */
    public UrlVerification(Function<UrlVerification,String> callback)
    {
        this.callback = callback;
    }

    /**
     * Set Challenge
     *
     * @param challenge
     */
    public void setChallenge(String challenge)
    {
        this.setIncomingItem("challenge", challenge);
    }

    /**
     * Get Challenge
     *
     * @return String
     */
    public String getChallenge()
    {
        return this.getIncomingItem("challenge", "");
    }

    /**
     * Check if This Event Is Called
     *
     * @return Boolean
     */
    public Boolean isCalled()
    {
        JSONObject requestData = new JSONObject(this.getPlainRequest());

        return (requestData.has("token") && requestData.has("challenge") && requestData.has("type"));
    }

    /**
     * Parse Event Incoming Data
     *
     * @return Boolean
     */
    public Boolean parse()
    {
        JSONObject requestData = new JSONObject(this.getPlainRequest());

        if( requestData.has("challenge") && !requestData.getString("challenge").equals("") ){
            this.setChallenge(requestData.getString("challenge"));
        }else{
            return false;
        }

        if( requestData.has("token") && !requestData.getString("token").equals("") ){
            this.setToken(requestData.getString("token"));
        }else{
            return false;
        }

        if( requestData.has("type") && !requestData.getString("type").equals("") ){
            this.setType(requestData.getString("type"));
        }else{
            return false;
        }

        return true;
    }

    /**
     * Call Event Callback
     *
     * @return String
     */
    public String call()
    {
        return this.callback.apply(this);
    }
}