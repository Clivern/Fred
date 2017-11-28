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
 * Bot Added Event
 *
 * A bot user was added. It Works with RTM.
 *
 * <a href="https://api.slack.com/events/bot_added">For More Info</a>
 *
 * @author A.F
 * @since 1.0.0
 */
public class BotAdded extends EventTemplate {

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
     * Parse Event Incoming Data
     *
     * @return Boolean
     */
    public Boolean parse()
    {
        return true;
    }
}