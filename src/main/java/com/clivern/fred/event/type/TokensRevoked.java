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
package com.clivern.fred.event.type;

import com.clivern.fred.contract.event.type.EventTemplate;
import java.util.ArrayList;

/**
 * Tokens Revoked Event
 *
 * <a href="https://api.slack.com/events/tokens_revoked">For More Info</a>
 *
 * @author A.F
 * @since 1.0.0
 */
public class TokensRevoked extends EventTemplate {

    /**
     * Set Event Type. It should be tokens_revoked
     *
     * @param eventType
     */
    public void setEventType(String eventType)
    {
        this.setIncomingItem("event.type", eventType);
    }

    /**
     * Set Oauth Tokens (Comma Separated)
     *
     * @param oauthTokens
     */
    public void setOauthTokens(ArrayList<String> oauthTokens)
    {
        String oauthTokenStr = "";

        for (String oauthToken : oauthTokens) {
            if( !oauthTokenStr.equals("") ){
                oauthTokenStr += ",";
            }
            oauthTokenStr += oauthToken;
        }

        this.setIncomingItem("tokens.oauth", oauthTokenStr);
    }

    /**
     * Set Bot Tokens (Comma Separated)
     *
     * @param botTokens
     */
    public void setBotTokens(ArrayList<String> botTokens)
    {
        String botTokenStr = "";

        for (String botToken : botTokens) {
            if( !botTokenStr.equals("") ){
                botTokenStr += ",";
            }
            botTokenStr += botToken;
        }

        this.setIncomingItem("tokens.bot", botTokenStr);
    }

    /**
     * Get Event Type. It should be tokens_revoked
     *
     * @return String
     */
    public String getEventType()
    {
        return this.getIncomingItem("event.type", "");
    }

    /**
     * Get Oauth Tokens (Comma Separated)
     *
     * @return String
     */
    public String getOauthTokens()
    {
        return this.getIncomingItem("tokens.oauth", "");
    }

    /**
     * Get Bot Tokens (Comma Separated)
     *
     * @return String
     */
    public String getBotTokens()
    {
        return this.getIncomingItem("tokens.bot", "");
    }

    /**
     * Parse Event Incoming Data
     *
     * @return Boolean
     */
    public Boolean parse()
    {
        return true;
    }

}