/*
 * Copyright (C) 2017 Clivern. <https://clivern.com>
 */
package com.clivern.fred.configs;


public final class Basic  {

	// Slack Authorize URL
	public static final String authorizeURL = "https://slack.com/oauth/authorize";

	// Slack API URL
	public static final String apiURL = "https://slack.com/api/";

	// Checks API calling code.
	public static final String apiTestMethod = "api.test";

	// Returns list of permissions this app has on a team.
	public static final String appsPermissionsInfoMethod = "apps.permissions.info";
	// Allows an app to request additional scopes
	public static final String appsPermissionsRequestMethod = "apps.permissions.request";

	// Revokes a token.
	public static final String authRevokeMethod = "auth.revoke";
	// Checks authentication & identity.
	public static final String authTestMethod = "auth.test";

	// Gets information about a bot user.
	public static final String botsInfoMethod = "bots.info";

	// Archives a channel.
	public static final String channelsArchiveMethod = "channels.archive";
	// Creates a channel.
	public static final String channelsCreateMethod = "channels.create";
	// Fetches history of messages and events from a channel.
	public static final String channelsHistoryMethod = "channels.history";
	// Gets information about a channel.
	public static final String channelsInfoMethod = "channels.info";
	// Invites a user to a channel.
	public static final String channelsInviteMethod = "channels.invite";
	// Joins a channel, creating it if needed.
	public static final String channelsJoinMethod = "channels.join";
	// Removes a user from a channel.
	public static final String channelsKickMethod = "channels.kick";
	// Leaves a channel.
	public static final String channelsLeaveMethod = "channels.leave";
	// Lists all channels in a Slack team.
	public static final String channelsListMethod = "channels.list";
	// Sets the read cursor in a channel.
	public static final String channelsMarkMethod = "channels.mark";
	// Renames a channel.
	public static final String channelsRenameMethod = "channels.rename";
	// Retrieve a thread of messages posted to a channel
	public static final String channelsRepliesMethod = "channels.replies";
	// Sets the purpose for a channel.
	public static final String channelsSetPurposeMethod = "channels.setPurpose";
	// Sets the topic for a channel.
	public static final String channelsSetTopicMethod = "channels.setTopic";
	// Unarchives a channel.
	public static final String channelsUnarchiveMethod = "channels.unarchive";

	// Deletes a message.
	public static final String chatDeleteMethod = "chat.delete";
	// Share a me message into a channel.
	public static final String chatMeMessageMethod = "chat.meMessage";
	// Sends an ephemeral message to a user in a channel.
	public static final String chatPostEphemeralMethod = "chat.postEphemeral";
	// Sends a message to a channel.
	public static final String chatPostMessageMethod = "chat.postMessage";
	// Provide custom unfurl behavior for user-posted URLs
	public static final String chatUnfurlMethod = "chat.unfurl";
	// Updates a message.
	public static final String chatUpdateMethod = "chat.update";

	// Archives a conversation.
	public static final String conversationsArchiveMethod = "conversations.archive";
	// Closes a direct message or multi-person direct message.
	public static final String conversationsCloseMethod = "conversations.close";
	// Initiates a public or private channel-based conversation
	public static final String conversationsCreateMethod = "conversations.create";
	// Fetches a conversation's history of messages and events.
	public static final String conversationsHistoryMethod = "conversations.history";
	// Retrieve information about a conversation.
	public static final String conversationsInfoMethod = "conversations.info";
	// Invites users to a channel.
	public static final String conversationsInviteMethod = "conversations.invite";
	// Joins an existing conversation.
	public static final String conversationsJoinMethod = "conversations.join";
	// Removes a user from a conversation.
	public static final String conversationsKickMethod = "conversations.kick";
	// Leaves a conversation.
	public static final String conversationsLeaveMethod = "conversations.leave";
	// Lists all channels in a Slack team.
	public static final String conversationsListMethod = "conversations.list";
	// Retrieve members of a conversation.
	public static final String conversationsMembersMethod = "conversations.members";
	// Opens or resumes a direct message or multi-person direct message.
	public static final String conversationsOpenMethod = "conversations.open";
	// Renames a conversation.
	public static final String conversationsRenameMethod = "conversations.rename";
	// Retrieve a thread of messages posted to a conversation
	public static final String conversationsRepliesMethod = "conversations.replies";
	// Sets the purpose for a conversation.
	public static final String conversationsSetPurposeMethod = "conversations.setPurpose";
	// Sets the topic for a conversation.
	public static final String conversationsSetTopicMethod = "conversations.setTopic";
	// Reverses conversation archival.
	public static final String conversationsUnarchiveMethod = "conversations.unarchive";

	// Open a dialog with a user
	public static final String dialogOpenMethod = "dialog.open";

	// Ends the current user's Do Not Disturb session immediately.
	public static final String dndEndDndMethod = "dnd.endDnd";
	// Ends the current user's snooze mode immediately.
	public static final String dndEndSnoozeMethod = "dnd.endSnooze";
	// Retrieves a user's current Do Not Disturb status.
	public static final String dndInfoMethod = "dnd.info";
	// Turns on Do Not Disturb mode for the current user, or changes its duration.
	public static final String dndSetSnoozeMethod = "dnd.setSnooze";
	// Retrieves the Do Not Disturb status for users on a team.
	public static final String dndTeamInfoMethod = "dnd.teamInfo";

	// Lists custom emoji for a team.
	public static final String emojiListMethod = "emoji.list";

	// Add a comment to an existing file.
	public static final String filesCommentsAddMethod = "files.comments.add";
	// Deletes an existing comment on a file.
	public static final String filesCommentsDeleteMethod = "files.comments.delete";
	// Edit an existing file comment.
	public static final String filesCommentsEditMethod = "files.comments.edit";

	// Deletes a file.
	public static final String filesDeleteMethod = "files.delete";
	// Gets information about a team file.
	public static final String filesInfoMethod = "files.info";
	// Lists & filters team files.
	public static final String filesListMethod = "files.list";
	// Revokes public/external sharing access for a file
	public static final String filesRevokePublicURLMethod = "files.revokePublicURL";
	// Enables a file for public/external sharing.
	public static final String filesSharedPublicURLMethod = "files.sharedPublicURL";
	// Uploads or creates a file.
	public static final String filesUploadMethod = "files.upload";

	// Archives a private channel.
	public static final String groupsArchiveMethod = "groups.archive";
	// Creates a private channel.
	public static final String groupsCreateMethod = "groups.create";
	// Clones and archives a private channel.
	public static final String groupsCreateChildMethod = "groups.createChild";
	// Fetches history of messages and events from a private channel.
	public static final String groupsHistoryMethod = "groups.history";
	// Gets information about a private channel.
	public static final String groupsInfoMethod = "groups.info";
	// Invites a user to a private channel.
	public static final String groupsInviteMethod = "groups.invite";
	// Removes a user from a private channel.
	public static final String groupsKickMethod = "groups.kick";
	// Leaves a private channel.
	public static final String groupsLeaveMethod = "groups.leave";
	// Lists private channels that the calling user has access to.
	public static final String groupsListMethod = "groups.list";
	// Sets the read cursor in a private channel.
	public static final String groupsMarkMethod = "groups.mark";
	// Opens a private channel.
	public static final String groupsOpenMethod = "groups.open";
	// Renames a private channel.
	public static final String groupsRenameMethod = "groups.rename";
	// Retrieve a thread of messages posted to a private channel
	public static final String groupsRepliesMethod = "groups.replies";
	// Sets the purpose for a private channel.
	public static final String groupsSetPurposeMethod = "groups.setPurpose";
	// Sets the topic for a private channel.
	public static final String groupsSetTopicMethod = "groups.setTopic";
	// Unarchives a private channel.
	public static final String groupsUnarchiveMethod = "groups.unarchive";

	// Close a direct message channel.
	public static final String imCloseMethod = "im.close";
	// Fetches history of messages and events from direct message channel.
	public static final String imHistoryMethod = "im.history";
	// Lists direct message channels for the calling user.
	public static final String imListMethod = "im.list";
	// Sets the read cursor in a direct message channel.
	public static final String imMarkMethod = "im.mark";
	// Opens a direct message channel.
	public static final String imOpenMethod = "im.open";
	// Retrieve a thread of messages posted to a direct message conversation
	public static final String imRepliesMethod = "im.replies";

	// Closes a multiparty direct message channel.
	public static final String mpimCloseMethod = "mpim.close";
	// Fetches history of messages and events from a multiparty direct message.
	public static final String mpimHistoryMethod = "mpim.history";
	// Lists multiparty direct message channels for the calling user.
	public static final String mpimListMethod = "mpim.list";
	// Sets the read cursor in a multiparty direct message channel.
	public static final String mpimMarkMethod = "mpim.mark";
	// This method opens a multiparty direct message.
	public static final String mpimOpenMethod = "mpim.open";
	// Retrieve a thread of messages posted to a direct message conversation from a multiparty direct message.
	public static final String mpimRepliesMethod = "mpim.replies";

	// Exchanges a temporary OAuth code for an API token.
	public static final String oauthAccessMethod = "oauth.access";
	// Exchanges a temporary OAuth verifier code for a workspace token.
	public static final String oauthTokenMethod = "oauth.token";

	// Pins an item to a channel.
	public static final String pinsAddMethod = "pins.add";
	// Lists items pinned to a channel.
	public static final String pinsListMethod = "pins.list";
	// Un-pins an item from a channel.
	public static final String pinsRemoveMethod = "pins.remove";

	// Adds a reaction to an item.
	public static final String reactionsAddMethod = "reactions.add";
	// Gets reactions for an item.
	public static final String reactionsGetMethod = "reactions.get";
	// Lists reactions made by a user.
	public static final String reactionsListMethod = "reactions.list";
	// Removes a reaction from an item.
	public static final String reactionsRemoveMethod = "reactions.remove";

	// Creates a reminder.
	public static final String remindersAddMethod = "reminders.add";
	// Marks a reminder as complete.
	public static final String remindersCompleteMethod = "reminders.complete";
	// Deletes a reminder.
	public static final String remindersDeleteMethod = "reminders.delete";
	// Gets information about a reminder.
	public static final String remindersInfoMethod = "reminders.info";
	// Lists all reminders created by or for a given user.
	public static final String remindersListMethod = "reminders.list";

	// Starts a Real Time Messaging session.
	public static final String rtmConnectMethod = "rtm.connect";
	// Starts a Real Time Messaging session.
	public static final String rtmStartMethod = "rtm.start";

	// Searches for messages and files matching a query.
	public static final String searchAllMethod = "search.all";
	// Searches for files matching a query.
	public static final String searchFilesMethod = "search.files";
	// Searches for messages matching a query.
	public static final String searchMessagesMethod = "search.messages";

	// Adds a star to an item.
	public static final String starsAddMethod = "stars.add";
	// Lists stars for a user.
	public static final String starsListMethod = "stars.list";
	// Removes a star from an item.
	public static final String starsRemoveMethod = "stars.remove";

	// Gets the access logs for the current team.
	public static final String teamAccessLogsMethod = "team.accessLogs";

	// Gets billable users information for the current team.
	public static final String teamBillableInfoMethod = "team.billableInfo";

	// Gets information about the current team.
	public static final String teamInfoMethod = "team.info";

	// Gets the integration logs for the current team.
	public static final String teamIntegrationLogsMethod = "team.integrationLogs";

	// Retrieve a team's profile.
	public static final String teamProfileGetMethod = "team.profile.get";

	// Create a User Group
	public static final String usergroupsCreateMethod = "usergroups.create";
	// Disable an existing User Group
	public static final String usergroupsDisableMethod = "usergroups.disable";
	// Enable a User Group
	public static final String usergroupsEnableMethod = "usergroups.enable";
	// List all User Groups for a team
	public static final String usergroupsListMethod = "usergroups.list";
	// Update an existing User Group
	public static final String usergroupsUpdateMethod = "usergroups.update";

	// List all users in a User Group
	public static final String usergroupsUsersListMethod = "usergroups.users.list";
	// Update the list of users for a User Group
	public static final String usergroupsUsersUpdateMethod = "usergroups.users.update";

	// Delete the user profile photo
	public static final String usersDeletePhotoMethod = "users.deletePhoto";
	// Gets user presence information.
	public static final String usersGetPresenceMethod = "users.getPresence";
	// Get a user's identity.
	public static final String usersIdentityMethod = "users.identity";
	// Gets information about a user.
	public static final String usersInfoMethod = "users.info";
	// Lists all users in a Slack team.
	public static final String usersListMethod = "users.list";
	// Marks a user as active.
	public static final String usersSetActiveMethod = "users.setActive";
	// Set the user profile photo
	public static final String usersSetPhotoMethod = "users.setPhoto";
	// Manually sets user presence.
	public static final String usersSetPresenceMethod = "users.setPresence";

	// Retrieves a user's profile information.
	public static final String usersProfileGetMethod = "users.profile.get";
	// Set the profile information for a user.
	public static final String usersProfileSetMethod = "users.profile.set";


	/**
	 * Get API Method URL
	 *
	 * @param  apiMethod
	 * @return String
	 */
	public static final String methodURL(String apiMethod)
	{
		return Basic.apiURL + apiMethod;
	}
}