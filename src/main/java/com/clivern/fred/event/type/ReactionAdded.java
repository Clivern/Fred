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

/**
 * Reaction Added Event
 *
 * A member has added an emoji reaction to an item. It Works with RTM & Events API
 *
 * Expected scopes: reactions:read
 *
 * <a href="https://api.slack.com/events/reaction_added">For More Info</a>
 *
 * @author A.F
 * @since 1.0.0
 */
public class ReactionAdded extends EventTemplate {

    /**
     * Set Event Type. It should be reaction_added
     *
     * @param eventType
     */
    public void setEventType(String eventType)
    {
        this.setIncomingItem("event.type", eventType);
    }

    /**
     * Set User
     *
     * @param user
     */
    public void setUser(String user)
    {
        this.setIncomingItem("event.user", user);
    }

    /**
     * Set Reaction
     *
     * @param reaction
     */
    public void setReaction(String reaction)
    {
        this.setIncomingItem("event.reaction", reaction);
    }

    /**
     * Set Item User
     *
     * @param itemUser
     */
    public void setItemUser(String itemUser)
    {
        this.setIncomingItem("event.item_user", itemUser);
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
     * Set Item Type
     *
     * @param itemType
     */
    public void setItemType(String itemType)
    {
        this.setIncomingItem("event.item.type", itemType);
    }

    /**
     * Set Item Channel
     *
     * @param itemChannel
     */
    public void setItemChannel(String itemChannel)
    {
        this.setIncomingItem("event.item.channel", itemChannel);
    }

    /**
     * Set Item Ts
     *
     * @param itemTs
     */
    public void setItemTs(String itemTs)
    {
        this.setIncomingItem("event.item.ts", itemTs);
    }

    /**
     * Set Item File
     *
     * @param itemFile
     */
    public void setItemFile(String itemFile)
    {
        this.setIncomingItem("event.item.file", itemFile);
    }

    /**
     * Set Item File Comment
     *
     * @param itemFileComment
     */
    public void setItemFileComment(String itemFileComment)
    {
        this.setIncomingItem("event.item.file_comment", itemFileComment);
    }

    /**
     * Get Event Type. It should be reaction_added
     *
     * @return String
     */
    public String getEventType()
    {
        return this.getIncomingItem("event.type", "");
    }

    /**
     * Get User
     *
     * @return String
     */
    public String getUser()
    {
        return this.getIncomingItem("event.user", "");
    }

    /**
     * Get Reaction
     *
     * @return String
     */
    public String getReaction()
    {
        return this.getIncomingItem("event.reaction", "");
    }

    /**
     * Get Item User
     *
     * @return String
     */
    public String getItemUser()
    {
        return this.getIncomingItem("event.item_user", "");
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
     * Get Item Type
     *
     * @return String
     */
    public String getItemType()
    {
        return this.getIncomingItem("event.item.type", "");
    }

    /**
     * Get Item Channel
     *
     * @@return String
     */
    public String getItemChannel()
    {
        return this.getIncomingItem("event.item.channel", "");
    }

    /**
     * Get Item Ts
     *
     * @return String
     */
    public String getItemTs()
    {
        return this.getIncomingItem("event.item.ts", "");
    }

    /**
     * Get Item File
     *
     * @return String
     */
    public String getItemFile()
    {
        return this.getIncomingItem("event.item.file", "");
    }

    /**
     * Get Item File Comment
     *
     * @return String
     */
    public String getItemFileComment()
    {
        return this.getIncomingItem("event.item.file_comment", "");
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