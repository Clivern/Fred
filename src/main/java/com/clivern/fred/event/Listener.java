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
package com.clivern.fred.event;

import java.util.HashMap;
import java.util.Map;
import com.clivern.fred.util.Config;
import com.clivern.fred.util.Log;
import com.clivern.fred.exception.EventNotFound;
import com.clivern.fred.exception.EventDataNotValid;
import com.clivern.fred.contract.event.type.EventTemplate;

/**
 * Events Listener
 *
 * @author A.F
 * @since 1.0.0
 */
public class Listener {

    protected Config configs;

    protected Log log;

    protected String requestURL;

    protected String verificationToken;

    protected String verificationChallenge;

    protected String verificationType;

    protected Map<String, EventTemplate> events = new HashMap<String, EventTemplate>();

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
    }

    /**
     * Set Request URL
     *
     * @param requestURL
     */
    public void setRequestURL(String requestURL)
    {
        this.requestURL = requestURL;
    }

    /**
     * Set Verification Token
     *
     * @param verificationToken
     */
    public void setVerificationToken(String verificationToken)
    {
        this.verificationToken = verificationToken;
    }

    /**
     * Set Verification Challenge
     *
     * @param verificationChallenge
     */
    public void setVerificationChallenge(String verificationChallenge)
    {
        this.verificationChallenge = verificationChallenge;
    }

    /**
     * Set Verification Type
     *
     * @param verificationType
     */
    public void setVerificationType(String verificationType)
    {
        this.verificationType = verificationType;
    }

    /**
     * Get Request URL
     *
     * @return String
     */
    public String getRequestURL()
    {
        return this.requestURL;
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
     * Get Verification Challenge
     *
     * @return String
     */
    public String getVerificationChallenge()
    {
        return this.verificationChallenge;
    }

    /**
     * Get Verification Type
     *
     * @return String
     */
    public String getVerificationType()
    {
        return this.verificationType;
    }

    /**
     * Set Event
     *
     * @param event
     * @param template
     */
    public void setEvent(String event, EventTemplate template)
    {
        this.events.put(event, template);
    }

    /**
     * Get Event
     *
     * @param  event
     * @return String
     * @throws EventNotFound
     */
    public EventTemplate getEvent(String event) throws EventNotFound
    {
        if( this.eventExists(event) ){
            return this.events.get(event);
        }

        throw new EventNotFound("Error! Slack Event Not Found.");
    }

    /**
     * Check if Event Exists
     *
     * @param  event
     * @return Boolean
     */
    public Boolean eventExists(String event)
    {
        return this.events.containsKey(event);
    }

    /**
     * Get Current Event
     *
     * @param  event
     * @param  incomingData
     * @return EventTemplate
     * @throws EventNotFound
     * @throws EventDataNotValid
     */
    public EventTemplate getCurrentEvent(String event, Map<String, String> incomingData) throws EventNotFound, EventDataNotValid
    {
        if( this.eventExists(event) ){
            EventTemplate currentEvent = this.getEvent(event);
            currentEvent.setIncomigData(incomingData);

            if( currentEvent.parse() ){
                this.setEvent(event, currentEvent);
                return currentEvent;
            }

            throw new EventDataNotValid("Error! Event Data Cannot Be Parsed.");
        }

        throw new EventNotFound("Error! Slack Event Not Found.");
    }
}