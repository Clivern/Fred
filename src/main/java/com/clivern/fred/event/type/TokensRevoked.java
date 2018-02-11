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
import java.util.ArrayList;
import org.json.JSONObject;
import java.util.function.Function;

/**
 * Tokens Revoked Event
 *
 * <a href="https://api.slack.com/events/tokens_revoked">For More Info</a>
 *
 * @author Clivern
 * @since 1.0.0
 */
public class TokensRevoked extends EventTemplate {

    protected Function<TokensRevoked,String> callback;

    /**
     * Class Constructor
     *
     * @param callback
     */
    public TokensRevoked(Function<TokensRevoked,String> callback)
    {
        this.callback = callback;
    }

    /**
     * Check if This Event Is Called
     *
     * @return Boolean
     */
    public Boolean isCalled()
    {
        JSONObject requestData = new JSONObject(this.getPlainRequest());

        return true;
    }

    /**
     * Parse Event Incoming Data
     *
     * @return Boolean
     */
    public Boolean parse()
    {
        JSONObject requestData = new JSONObject(this.getPlainRequest());

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
}