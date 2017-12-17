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
package com.clivern.fred.event;

import java.util.HashMap;
import java.util.Map;
import com.clivern.fred.util.Config;
import com.clivern.fred.util.Log;
import com.clivern.fred.exception.EventNotFound;
import com.clivern.fred.exception.EventDataNotValid;
import com.clivern.fred.contract.event.type.EventTemplate;
import com.clivern.fred.event.type.*;

/**
 * Events Listener
 *
 * @author A.F
 * @since 1.0.0
 */
public class Listener {

    protected Config configs;

    protected Log log;

    protected String verificationToken;

    protected Map<String, EventTemplate> events = new HashMap<String, EventTemplate>();

    public static String URL_VERIFICATION_EVENT = "URL_VERIFICATION";


    /**
     * Class Constructor
     *
     * @param configs
     * @param log
     */
    public Listener(Config configs, Log log)
    {
        this.configs = configs;
        this.log = log;
        this.verificationToken = this.configs.get("verification_token", "");
    }

    /**
     * Get Verification Token
     *
     * @return String
     */
    public String getVerificationToken()
    {
        return this.verificationToken;
    }

    /**
     * Set Event
     *
     * @param template
     */
    public void addEvent(String event, EventTemplate template)
    {
        this.events.put(event, template);
    }

    /**
     * Call Current Event
     *
     * @param  body
     * @return String
     * @throws EventDataNotValid, EventNotFound
     */
    public String callCurrentEvent(String body) throws EventDataNotValid, EventNotFound
    {
        for( String key : this.events.keySet() ){
            EventTemplate event = this.events.get(key);
            if( key.equals(Listener.URL_VERIFICATION_EVENT) ){
                event = (UrlVerification) this.events.get(key);
            }
            event.setPlainRequest(body);
            if( event.isCalled() ){
                if( event.parse() ){
                    return event.call();
                }

                throw new EventDataNotValid("Error! Event Data Cannot Be Parsed.");
            }
        }

        throw new EventNotFound("Error! Slack Event Not Found.");
    }
}