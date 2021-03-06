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
import java.util.ArrayList;

/**
 * Bot Added Event
 *
 * A bot user was added. It Works with RTM.
 *
 * <a href="https://api.slack.com/events/bot_added">For More Info</a>
 *
 * @author Clivern
 * @since 1.0.0
 */
public class BotAdded extends EventTemplate {

    protected Function<BotAdded,String> callback;

    /**
     * Class Constructor
     *
     * @param callback
     */
    public BotAdded(Function<BotAdded,String> callback)
    {
        this.callback = callback;
    }

    /**
     * Set Event Type. It should be bot_added
     *
     * @param eventType
     */
    public void setEventType(String eventType)
    {
        this.setIncomingItem("event.type", eventType);
    }

    /**
     * Set Bot ID
     *
     * @param botId
     */
    public void setBotId(String botId)
    {
        this.setIncomingItem("event.bot.id", botId);
    }

    /**
     * Set Bot App ID
     *
     * @param botAppId
     */
    public void setBotAppId(String botAppId)
    {
        this.setIncomingItem("event.bot.app_id", botAppId);
    }

    /**
     * Set Bot Name
     *
     * @param botName
     */
    public void setBotName(String botName)
    {
        this.setIncomingItem("event.bot.name", botName);
    }

    /**
     * Set Bots Icons
     *
     * @param botIcons
     */
    public void setBotIcons(ArrayList<String> botIcons)
    {
        String botIconsStr = "";

        for (String botIcon : botIcons) {
            if( !botIconsStr.equals("") ){
                botIconsStr += ",";
            }
            botIconsStr += botIcon;
        }
        this.setIncomingItem("event.bot.icons", botIconsStr);
    }

    /**
     * Get Event Type. It should be bot_added
     *
     * @return String
     */
    public String getEventType()
    {
        return this.getIncomingItem("event.type", "");
    }

    /**
     * Get Bot ID
     *
     * @return String
     */
    public String getBotId(String botId)
    {
        return this.getIncomingItem("event.bot.id", "");
    }

    /**
     * Get Bot App ID
     *
     * @return String
     */
    public String getBotAppId(String botAppId)
    {
        return this.getIncomingItem("event.bot.app_id", "");
    }

    /**
     * Get Bot Name
     *
     * @return String
     */
    public String getBotName(String botName)
    {
        return this.getIncomingItem("event.bot.name", "");
    }

    /**
     * Get Bots Icons
     *
     * @return String
     */
    public String getBotIcons(ArrayList<String> botIcons)
    {
        return this.getIncomingItem("event.bot.icons", "");
    }

    /**
     * Check if This Event Is Called
     *
     * @return Boolean
     */
    public Boolean isCalled()
    {
        JSONObject requestData = new JSONObject(this.getPlainRequest());

        return ( requestData.has("type") && !requestData.getString("type").equals("") && requestData.getString("type").contains("bot_added") );
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
        if( requestData.has("bot") && !requestData.getString("bot").equals("") ){
            JSONObject botData = new JSONObject(requestData.getString("bot"));
            this.setBotId(botData.has("id") ? botData.getString("id") : "");
            this.setBotAppId(botData.has("app_id") ? botData.getString("app_id") : "");
            this.setBotName(botData.has("name") ? botData.getString("name") : "");
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