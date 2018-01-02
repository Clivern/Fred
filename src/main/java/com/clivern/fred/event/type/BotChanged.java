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
import org.json.JSONObject;
import java.util.function.Function;
import java.util.ArrayList;

/**
 * Bot Changed Event
 *
 * A bot user was changed. It Works with RTM.
 *
 * <a href="https://api.slack.com/events/bot_changed">For More Info</a>
 *
 * @author A.F
 * @since 1.0.0
 */
public class BotChanged extends EventTemplate {

    protected Function<BotChanged,String> callback;

    /**
     * Class Constructor
     *
     * @param callback
     */
    public BotChanged(Function<BotChanged,String> callback)
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
     * Set Event Type. It should be bot_changed
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
     * Get Event Type. It should be bot_changed
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
}