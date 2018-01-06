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

    public static String ACCOUNTS_CHANGED_EVENT = "ACCOUNTS_CHANGED";
    
    public static String APP_UNINSTALLED_EVENT = "APP_UNINSTALLED";
    
    public static String BOT_ADDED_EVENT = "BOT_ADDED";
    
    public static String BOT_CHANGED_EVENT = "BOT_CHANGED";
    
    public static String CHANNEL_ARCHIVE_EVENT = "CHANNEL_ARCHIVE";
    
    public static String CHANNEL_CREATED_EVENT = "CHANNEL_CREATED";
    
    public static String CHANNEL_DELETED_EVENT = "CHANNEL_DELETED";
    
    public static String CHANNEL_HISTORY_CHANGED_EVENT = "CHANNEL_HISTORY_CHANGED";
    
    public static String CHANNEL_LEFT_EVENT = "CHANNEL_LEFT";
    
    public static String CHANNEL_MARKED_EVENT = "CHANNEL_MARKED";
    
    public static String CHANNEL_RENAME_EVENT = "CHANNEL_RENAME";
    
    public static String CHANNEL_UNARCHIVE_EVENT = "CHANNEL_UNARCHIVE";
    
    public static String DND_UPDATED_EVENT = "DND_UPDATED";
    
    public static String DND_UPDATED_USER_EVENT = "DND_UPDATED_USER";

    public static String EMAIL_DOMAIN_CHANGED_EVENT = "EMAIL_DOMAIN_CHANGED";
    
    public static String EMOJI_CHANGED_EVENT = "EMOJI_CHANGED";
    
    public static String FILE_CHANGE_EVENT = "FILE_CHANGE";
    
    public static String FILE_COMMENT_ADDED_EVENT = "FILE_COMMENT_ADDED";
    
    public static String FILE_COMMENT_DELETED_EVENT = "FILE_COMMENT_DELETED";
    
    public static String FILE_COMMENT_EDITED_EVENT = "FILE_COMMENT_EDITED";
    
    public static String FILE_CREATED_EVENT = "FILE_CREATED";
    
    public static String FILE_DELETED_EVENT = "FILE_DELETED";
    
    public static String FILE_PUBLIC_EVENT = "FILE_PUBLIC";
    
    public static String FILE_SHARED_EVENT = "FILE_SHARED";
    
    public static String FILE_UNSHARED_EVENT = "FILE_UNSHARED";
    
    public static String GRID_MIGRATION_FINISHED_EVENT = "GRID_MIGRATION_FINISHED";
    
    public static String GRID_MIGRATION_STARTED_EVENT = "GRID_MIGRATION_STARTED";
    
    public static String GROUP_ARCHIVE_EVENT = "GROUP_ARCHIVE";
    
    public static String GROUP_CLOSE_EVENT = "GROUP_CLOSE";
    
    public static String GROUP_HISTORY_CHANGED_EVENT = "GROUP_HISTORY_CHANGED";

    public static String GROUP_OPEN_EVENT = "GROUP_OPEN";
    
    public static String GROUP_RENAME_EVENT = "GROUP_RENAME";
    
    public static String GROUP_UNARCHIVE_EVENT = "GROUP_UNARCHIVE";
    
    public static String IM_CLOSE_EVENT = "IM_CLOSE";
    
    public static String IM_CREATED_EVENT = "IM_CREATED";
    
    public static String IM_HISTORY_CHANGED_EVENT = "IM_HISTORY_CHANGED";
    
    public static String IM_OPEN_EVENT = "IM_OPEN";
    
    public static String LINK_SHARED_EVENT = "LINK_SHARED";
    
    public static String MEMBER_JOINED_CHANNEL_EVENT = "MEMBER_JOINED_CHANNEL";
    
    public static String MEMBER_LEFT_CHANNEL_EVENT = "MEMBER_LEFT_CHANNEL";

    public static String MESSAGE_EVENT = "MESSAGE";
    
    public static String MESSAGE_CHANNELS_EVENT = "MESSAGE_CHANNELS";
    
    public static String MESSAGE_GROUPS_EVENT = "MESSAGE_GROUPS";
    
    public static String MESSAGE_IM_EVENT = "MESSAGE_IM";
    
    public static String MESSAGE_MPIM_EVENT = "MESSAGE_MPIM";
    
    public static String PIN_ADDED_EVENT = "PIN_ADDED";
    
    public static String PIN_REMOVED_EVENT = "PIN_REMOVED";
    
    public static String REACTION_ADDED_EVENT = "REACTION_ADDED";
    
    public static String REACTION_REMOVED_EVENT = "REACTION_REMOVED";
    
    public static String RESOURCES_ADDED_EVENT = "RESOURCES_ADDED";
    
    public static String RESOURCES_REMOVED_EVENT = "RESOURCES_REMOVED";
    
    public static String SCOPE_DENIED_EVENT = "SCOPE_DENIED";
    
    public static String SCOPE_GRANTED_EVENT = "SCOPE_GRANTED";
    
    public static String STAR_ADDED_EVENT = "STAR_ADDED";
    
    public static String STAR_REMOVED_EVENT = "STAR_REMOVED";
    
    public static String SUB_TEAM_CREATED_EVENT = "SUB_TEAM_CREATED";
    
    public static String SUB_TEAM_MEMBERS_CHANGED_EVENT = "SUB_TEAM_MEMBERS_CHANGED";
    
    public static String SUB_TEAM_SELF_ADDED_EVENT = "SUB_TEAM_SELF_ADDED";
    
    public static String SUB_TEAM_SELD_REMOVED_EVENT = "SUB_TEAM_SELD_REMOVED";
    
    public static String SUB_TEAM_UPDATED_EVENT = "SUB_TEAM_UPDATED";
    
    public static String TEAM_DOMAIN_CHANGE_EVENT = "TEAM_DOMAIN_CHANGE";
    
    public static String TEAM_JOIN_EVENT = "TEAM_JOIN";
    
    public static String TEAM_RENAME_EVENT = "TEAM_RENAME";
    
    public static String TOKENS_REVOKED_EVENT = "TOKENS_REVOKED";
    
    public static String URL_VERIFICATION_EVENT = "URL_VERIFICATION";
    
    public static String USER_CHANGE_EVENT = "USER_CHANGE";


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