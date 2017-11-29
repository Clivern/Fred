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
 * File Comment Edited Event
 *
 * A file comment was edited. It Works with RTM & Events API
 *
 * Expected scopes: files:read
 *
 * <a href="https://api.slack.com/events/file_comment_edited">For More Info</a>
 *
 * @author A.F
 * @since 1.0.0
 */
public class FileCommentEdited extends EventTemplate {

    /**
     * Set Event Type. It should be file_comment_edited
     *
     * @param eventType
     */
    public void setEventType(String eventType)
    {
        this.setIncomingItem("event.type", eventType);
    }

    /**
     * Set File ID
     *
     * @param fileId
     */
    public void setFileId(String fileId)
    {
        this.setIncomingItem("event.file_id", fileId);
    }

    /**
     * Set Comment
     *
     * @param comment
     */
    public void setComment(String comment)
    {
        this.setIncomingItem("event.comment", comment);
    }

    /**
     * Get Event Type. It should be file_comment_edited
     *
     * @return String
     */
    public String getEventType()
    {
        return this.getIncomingItem("event.type", "");
    }

    /**
     * Get File ID
     *
     * @return String
     */
    public String getFileId()
    {
        return this.getIncomingItem("event.file_id", "");
    }

    /**
     * Get Comment
     *
     * @return String
     */
    public String getComment()
    {
        return this.getIncomingItem("event.comment", "");
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