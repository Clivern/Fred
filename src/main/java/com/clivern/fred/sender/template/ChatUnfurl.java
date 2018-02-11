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
package com.clivern.fred.sender.template;

import com.clivern.fred.config.Basic;
import com.clivern.fred.contract.sender.template.BasicTemplate;

/**
 * Chat Unfurl Template Class
 *
 * It Provide custom unfurl behavior for user-posted URLs.
 *
 * Supported token types: workspace, user
 * Expected scopes: links:write, post
 *
 * <a href="https://api.slack.com/methods/chat.unfurl">For More Info</a>
 *
 * @author Clivern
 * @since 1.0.0
 */
public class ChatUnfurl extends BasicTemplate {

    protected String url = Basic.methodURL(Basic.chatUnfurlMethod);

    /**
     * Build Message Body
     */
    public String build()
    {
        return "";
    }
}