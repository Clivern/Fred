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
 * Email Domain Changed Event
 *
 * The workspace email domain has changed. It Works with RTM and Events API
 *
 * Expected scopes: team:read
 *
 * <a href="https://api.slack.com/events/mail_domain_changed">For More Info</a>
 *
 * @author Clivern
 * @since 1.0.0
 */
public class EmailDomainChanged extends EventTemplate {

    protected Function<EmailDomainChanged,String> callback;

    /**
     * Class Constructor
     *
     * @param callback
     */
    public EmailDomainChanged(Function<EmailDomainChanged,String> callback)
    {
        this.callback = callback;
    }

    /**
     * Set Event Type. It should be mail_domain_changed
     *
     * @param eventType
     */
    public void setEventType(String eventType)
    {
        this.setIncomingItem("event.type", eventType);
    }

    /**
     * Set Email Domain
     *
     * @param emailDomain
     */
    public void setEmailDomain(String emailDomain)
    {
        this.setIncomingItem("event.email_domain", emailDomain);
    }

    /**
     * Set Event Ts
     *
     * @param eventTs
     */
    public void setEventTs(String eventTs)
    {
        this.setIncomingItem("event.event_ts", eventTs);
    }

    /**
     * Get Event Type. It should be mail_domain_changed
     *
     * @return String
     */
    public String getEventType()
    {
        return this.getIncomingItem("event.type", "");
    }

    /**
     * Get Email Domain
     *
     * @return String
     */
    public String getEmailDomain()
    {
        return this.getIncomingItem("event.email_domain", "");
    }

    /**
     * Get Event Ts
     *
     * @return String
     */
    public String getEventTs()
    {
        return this.getIncomingItem("event.event_ts", "");
    }

    /**
     * Check if This Event Is Called
     *
     * @return Boolean
     */
    public Boolean isCalled()
    {
        JSONObject requestData = new JSONObject(this.getPlainRequest());

        return (requestData.has("type") && requestData.getString("type").equals("mail_domain_changed"));
    }

    /**
     * Parse Event Incoming Data
     *
     * @return Boolean
     */
    public Boolean parse()
    {
        JSONObject requestData = new JSONObject(this.getPlainRequest());

        if( requestData.has("type") && !requestData.getString("type").equals("") ){
            this.setEventType(requestData.getString("type"));
        }

        if( requestData.has("email_domain") && !requestData.getString("email_domain").equals("") ){
            this.setEmailDomain(requestData.getString("email_domain"));
        }

        if( requestData.has("event_ts") && !requestData.getString("event_ts").equals("") ){
            this.setEventTs(requestData.getString("event_ts"));
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