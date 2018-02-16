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
package com.clivern.fred.event;

import java.util.HashMap;
import java.util.Map;
import org.pmw.tinylog.Logger;
import com.clivern.fred.util.Config;
import com.clivern.fred.exception.EventNotFound;
import com.clivern.fred.exception.EventDataNotValid;
import com.clivern.fred.contract.event.type.EventTemplate;
import com.clivern.fred.event.type.*;

/**
 * Events Listener
 *
 * @author Clivern
 * @since 1.0.0
 */
public class Listener {

    protected Config configs;

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

    public static String SUB_TEAM_SELF_REMOVED_EVENT = "SUB_TEAM_SELF_REMOVED";

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
     */
    public Listener(Config configs)
    {
        this.configs = configs;
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

            }else if( key.equals(Listener.ACCOUNTS_CHANGED_EVENT) ){

                event = (AccountsChanged) this.events.get(key);

            }else if( key.equals(Listener.APP_UNINSTALLED_EVENT) ){

                event = (AppUninstalled) this.events.get(key);

            }else if( key.equals(Listener.BOT_ADDED_EVENT) ){

                event = (BotAdded) this.events.get(key);

            }else if( key.equals(Listener.BOT_CHANGED_EVENT) ){

                event = (BotChanged) this.events.get(key);

            }else if( key.equals(Listener.CHANNEL_ARCHIVE_EVENT) ){

                event = (ChannelArchive) this.events.get(key);

            }else if( key.equals(Listener.CHANNEL_CREATED_EVENT) ){

                event = (ChannelCreated) this.events.get(key);

            }else if( key.equals(Listener.CHANNEL_DELETED_EVENT) ){

                event = (ChannelDeleted) this.events.get(key);

            }else if( key.equals(Listener.CHANNEL_HISTORY_CHANGED_EVENT) ){

                event = (ChannelHistoryChanged) this.events.get(key);

            }else if( key.equals(Listener.CHANNEL_LEFT_EVENT) ){

                event = (ChannelLeft) this.events.get(key);

            }else if( key.equals(Listener.CHANNEL_MARKED_EVENT) ){

                event = (ChannelMarked) this.events.get(key);

            }else if( key.equals(Listener.CHANNEL_RENAME_EVENT) ){

                event = (ChannelRename) this.events.get(key);

            }else if( key.equals(Listener.CHANNEL_UNARCHIVE_EVENT) ){

                event = (ChannelUnarchive) this.events.get(key);

            }else if( key.equals(Listener.DND_UPDATED_EVENT) ){

                event = (DndUpdated) this.events.get(key);

            }else if( key.equals(Listener.DND_UPDATED_USER_EVENT) ){

                event = (DndUpdatedUser) this.events.get(key);

            }else if( key.equals(Listener.EMAIL_DOMAIN_CHANGED_EVENT) ){

                event = (EmailDomainChanged) this.events.get(key);

            }else if( key.equals(Listener.EMOJI_CHANGED_EVENT) ){

                event = (EmojiChanged) this.events.get(key);

            }else if( key.equals(Listener.FILE_CHANGE_EVENT) ){

                event = (FileChange) this.events.get(key);

            }else if( key.equals(Listener.FILE_COMMENT_ADDED_EVENT) ){

                event = (FileCommentAdded) this.events.get(key);

            }else if( key.equals(Listener.FILE_COMMENT_DELETED_EVENT) ){

                event = (FileCommentDeleted) this.events.get(key);

            }else if( key.equals(Listener.FILE_COMMENT_EDITED_EVENT) ){

                event = (FileCommentEdited) this.events.get(key);

            }else if( key.equals(Listener.FILE_CREATED_EVENT) ){

                event = (FileCreated) this.events.get(key);

            }else if( key.equals(Listener.FILE_DELETED_EVENT) ){

                event = (FileDeleted) this.events.get(key);

            }else if( key.equals(Listener.FILE_PUBLIC_EVENT) ){

                event = (FilePublic) this.events.get(key);

            }else if( key.equals(Listener.FILE_SHARED_EVENT) ){

                event = (FileShared) this.events.get(key);

            }else if( key.equals(Listener.FILE_UNSHARED_EVENT) ){

                event = (FileUnshared) this.events.get(key);

            }else if( key.equals(Listener.GRID_MIGRATION_FINISHED_EVENT) ){

                event = (GridMigrationFinished) this.events.get(key);

            }else if( key.equals(Listener.GRID_MIGRATION_STARTED_EVENT) ){

                event = (GridMigrationStarted) this.events.get(key);

            }else if( key.equals(Listener.GROUP_ARCHIVE_EVENT) ){

                event = (GroupArchive) this.events.get(key);

            }else if( key.equals(Listener.GROUP_CLOSE_EVENT) ){

                event = (GroupClose) this.events.get(key);

            }else if( key.equals(Listener.GROUP_HISTORY_CHANGED_EVENT) ){

                event = (GroupHistoryChanged) this.events.get(key);

            }else if( key.equals(Listener.GROUP_OPEN_EVENT) ){

                event = (GroupOpen) this.events.get(key);

            }else if( key.equals(Listener.GROUP_RENAME_EVENT) ){

                event = (GroupRename) this.events.get(key);

            }else if( key.equals(Listener.GROUP_UNARCHIVE_EVENT) ){

                event = (GroupUnarchive) this.events.get(key);

            }else if( key.equals(Listener.IM_CLOSE_EVENT) ){

                event = (ImClose) this.events.get(key);

            }else if( key.equals(Listener.IM_CREATED_EVENT) ){

                event = (ImCreated) this.events.get(key);

            }else if( key.equals(Listener.IM_HISTORY_CHANGED_EVENT) ){

                event = (ImHistoryChanged) this.events.get(key);

            }else if( key.equals(Listener.IM_OPEN_EVENT) ){

                event = (ImOpen) this.events.get(key);

            }else if( key.equals(Listener.LINK_SHARED_EVENT) ){

                event = (LinkShared) this.events.get(key);

            }else if( key.equals(Listener.MEMBER_JOINED_CHANNEL_EVENT) ){

                event = (MemberJoinedChannel) this.events.get(key);

            }else if( key.equals(Listener.MEMBER_LEFT_CHANNEL_EVENT) ){

                event = (MemberLeftChannel) this.events.get(key);

            }else if( key.equals(Listener.MESSAGE_EVENT) ){

                event = (Message) this.events.get(key);

            }else if( key.equals(Listener.MESSAGE_CHANNELS_EVENT) ){

                event = (MessageChannels) this.events.get(key);

            }else if( key.equals(Listener.MESSAGE_GROUPS_EVENT) ){

                event = (MessageGroups) this.events.get(key);

            }else if( key.equals(Listener.MESSAGE_IM_EVENT) ){

                event = (MessageIm) this.events.get(key);

            }else if( key.equals(Listener.MESSAGE_MPIM_EVENT) ){

                event = (MessageMpim) this.events.get(key);

            }else if( key.equals(Listener.PIN_ADDED_EVENT) ){

                event = (PinAdded) this.events.get(key);

            }else if( key.equals(Listener.PIN_REMOVED_EVENT) ){

                event = (PinRemoved) this.events.get(key);

            }else if( key.equals(Listener.REACTION_ADDED_EVENT) ){

                event = (ReactionAdded) this.events.get(key);

            }else if( key.equals(Listener.REACTION_REMOVED_EVENT) ){

                event = (ReactionRemoved) this.events.get(key);

            }else if( key.equals(Listener.RESOURCES_ADDED_EVENT) ){

                event = (ResourcesAdded) this.events.get(key);

            }else if( key.equals(Listener.RESOURCES_REMOVED_EVENT) ){

                event = (ResourcesRemoved) this.events.get(key);

            }else if( key.equals(Listener.SCOPE_DENIED_EVENT) ){

                event = (ScopeDenied) this.events.get(key);

            }else if( key.equals(Listener.SCOPE_GRANTED_EVENT) ){

                event = (ScopeGranted) this.events.get(key);

            }else if( key.equals(Listener.STAR_ADDED_EVENT) ){

                event = (StarAdded) this.events.get(key);

            }else if( key.equals(Listener.STAR_REMOVED_EVENT) ){

                event = (StarRemoved) this.events.get(key);

            }else if( key.equals(Listener.SUB_TEAM_CREATED_EVENT) ){

                event = (SubteamCreated) this.events.get(key);

            }else if( key.equals(Listener.SUB_TEAM_MEMBERS_CHANGED_EVENT) ){

                event = (SubteamMembersChanged) this.events.get(key);

            }else if( key.equals(Listener.SUB_TEAM_SELF_ADDED_EVENT) ){

                event = (SubteamSelfAdded) this.events.get(key);

            }else if( key.equals(Listener.SUB_TEAM_SELF_REMOVED_EVENT) ){

                event = (SubteamSelfRemoved) this.events.get(key);

            }else if( key.equals(Listener.SUB_TEAM_UPDATED_EVENT) ){

                event = (SubteamUpdated) this.events.get(key);

            }else if( key.equals(Listener.TEAM_DOMAIN_CHANGE_EVENT) ){

                event = (TeamDomainChange) this.events.get(key);

            }else if( key.equals(Listener.TEAM_JOIN_EVENT) ){

                event = (TeamJoin) this.events.get(key);

            }else if( key.equals(Listener.TEAM_RENAME_EVENT) ){

                event = (TeamRename) this.events.get(key);

            }else if( key.equals(Listener.TOKENS_REVOKED_EVENT) ){

                event = (TokensRevoked) this.events.get(key);

            }else if( key.equals(Listener.USER_CHANGE_EVENT) ){

                event = (UserChange) this.events.get(key);
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