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
 * Reaction Added Event
 *
 * A member has added an emoji reaction to an item. It Works with RTM and Events API
 *
 * Expected scopes: reactions:read
 *
 * <a href="https://api.slack.com/events/reaction_added">For More Info</a>
 *
 * @author Clivern
 * @since 1.0.0
 */
public class ReactionAdded extends EventTemplate {

    protected Function<ReactionAdded,String> callback;

    /**
     * Class Constructor
     *
     * @param callback
     */
    public ReactionAdded(Function<ReactionAdded,String> callback)
    {
        this.callback = callback;
    }

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
     * @return String
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
     * Check if This Event Is Called
     *
     * @return Boolean
     */
    public Boolean isCalled()
    {
        JSONObject requestData = new JSONObject(this.getPlainRequest());

        return (requestData.has("type") && requestData.getString("type").equals("reaction_added"));
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
        if( requestData.has("user") && !requestData.getString("user").equals("") ){
            this.setUser(requestData.getString("user"));
        }
        if( requestData.has("reaction") && !requestData.getString("reaction").equals("") ){
            this.setReaction(requestData.getString("reaction"));
        }
        if( requestData.has("item_user") && !requestData.getString("item_user").equals("") ){
            this.setItemUser(requestData.getString("item_user"));
        }
        if( requestData.has("event_ts") && !requestData.getString("event_ts").equals("") ){
            this.setEventTs(requestData.getString("event_ts"));
        }

        if( requestData.has("item") && !requestData.getString("item").equals("") ){
            JSONObject item = new JSONObject(requestData.getString("item"));

            if( item.has("type") && !item.getString("type").equals("") ){
                if( item.getString("type").equals("message") ){
                    this.setItemType("message");
                    this.setItemChannel(item.has("channel") ? item.getString("channel") : "");
                    this.setItemTs(item.has("ts") ? item.getString("ts") : "");
                }else if( item.getString("type").equals("file") ){
                    this.setItemType("file");
                    this.setItemFile(item.has("file") ? item.getString("file") : "");
                }else if( item.getString("type").equals("file_comment") ){
                    this.setItemType("file_comment");
                    this.setItemFile(item.has("file") ? item.getString("file") : "");
                    this.setItemFileComment(item.has("file_comment") ? item.getString("file_comment") : "");
                }
            }
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