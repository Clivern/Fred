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
 * File Created Event
 *
 * A file was created. It Works with RTM and Events API
 *
 * Expected scopes: files:read
 *
 * <a href="https://api.slack.com/events/file_created">For More Info</a>
 *
 * @author Clivern
 * @since 1.0.0
 */
public class FileCreated extends EventTemplate {

    protected Function<FileCreated,String> callback;

    /**
     * Class Constructor
     *
     * @param callback
     */
    public FileCreated(Function<FileCreated,String> callback)
    {
        this.callback = callback;
    }

    /**
     * Set Event Type. It should be file_created
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
     * Get Event Type. It should be file_created
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
     * Check if This Event Is Called
     *
     * @return Boolean
     */
    public Boolean isCalled()
    {
        JSONObject requestData = new JSONObject(this.getPlainRequest());

        return (requestData.has("type") && requestData.getString("type").equals("file_created"));
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
        if( requestData.has("file_id") && !requestData.getString("file_id").equals("") ){
            this.setFileId(requestData.getString("file_id"));
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