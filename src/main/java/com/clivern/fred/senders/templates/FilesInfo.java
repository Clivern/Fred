/*
 * Copyright (C) 2017 A.F <http://clivern.com>
 *
 * Licensed under the MIT License; you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * https://github.com/Clivern/Fred/blob/master/LICENSE
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.clivern.fred.senders.templates;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.clivern.fred.configs.Basic;
import com.clivern.fred.contract.templates.BasicTemplate;

/**
 * Files Info Template Class
 *
 * It Gets information about a team file.
 *
 * Supported token types: bot, workspace, user
 * Expected scopes: files:read, read
 *
 * <a href="https://api.slack.com/methods/files.info">For More Info</a>
 *
 * @author A.F
 * @since 1.0.0
 */
public class FilesInfo extends BasicTemplate {

    protected String url = Basic.methodURL(Basic.filesInfoMethod);

    /**
     * Build Message Body
     */
    public String build()
    {
        return "";
    }
}