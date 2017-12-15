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
package com.clivern.fred.receiver.command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.clivern.fred.config.Basic;
import com.clivern.fred.contract.receiver.command.CommandTemplate;
import java.util.function.Function;

/**
 * App Defined Commands
 *
 * <a href="https://api.slack.com/slash-commands">For More Info</a>
 *
 * @author A.F
 * @since 1.0.0
 */
public class Command extends CommandTemplate {

    /**
     * Class Constructor
     *
     * @param command
     * @param requestURL
     * @param expandedText
     */
    public Command(String command, String requestURL, Boolean expandedText, Function<CommandTemplate,String> callback)
    {
        super(command, requestURL, expandedText, callback);
    }

    /**
     * Class Constructor
     *
     * @param command
     * @param requestURL
     * @param expandedText
     * @param shortDescription
     * @param usageHint
     */
    public Command(String command, String requestURL, Boolean expandedText, String shortDescription, String usageHint, Function<CommandTemplate,String> callback)
    {
        super(command, requestURL, expandedText, shortDescription, usageHint, callback);
    }

    /**
     * Do Further Processing
     *
     * @param Boolean
     */
    public Boolean process()
    {
        return true;
    }
}