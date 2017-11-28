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
 * File Unshared Event
 *
 * A file was unshared. It Works with RTM & Events API
 *
 * Expected scopes: files:read
 *
 * <a href="https://api.slack.com/events/file_unshared">For More Info</a>
 *
 * @author A.F
 * @since 1.0.0
 */
public class FileUnshared extends EventTemplate {

    /**
     * Set Event Type. It should be file_unshared
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
     * Get Event Type. It should be file_unshared
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
     * Parse Event Incoming Data
     *
     * @return Boolean
     */
    public Boolean parse()
    {
        return true;
    }
}