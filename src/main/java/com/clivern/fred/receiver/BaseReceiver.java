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
package com.clivern.fred.receiver;

import java.util.HashMap;
import java.util.Map;
import com.clivern.fred.util.Config;
import com.clivern.fred.util.Log;
import org.json.JSONObject;
import org.json.JSONArray;
import com.clivern.fred.exception.CommandNotFound;
import com.clivern.fred.contract.receiver.command.CommandTemplate;

/**
 * Base Receiver Class
 *
 * @author A.F
 * @since 1.0.0
 */
public class BaseReceiver {

    protected Config configs;

    protected Log log;

    protected Map<String, CommandTemplate> commands = new HashMap<String, CommandTemplate>();


    /**
     * Class Constructor
     *
     * @param configs
     * @param log
     */
    public BaseReceiver(Config configs, Log log)
    {
        this.configs = configs;
        this.log = log;
    }

    /**
     * Set Command
     *
     * @param command
     * @param template
     */
    public void setCommand(String command, CommandTemplate template)
    {
        this.commands.put(command, template);
    }

    /**
     * Get Command
     *
     * @param  command
     * @return String
     * @throws CommandNotFound
     */
    public CommandTemplate getCommand(String command) throws CommandNotFound
    {
        if( this.commandExists(command) ){
            return this.commands.get(command);
        }

        throw new CommandNotFound("Error! Slack Command Not Found.");
    }

    /**
     * Check if Command Exists
     *
     * @param  command
     * @return Boolean
     */
    public Boolean commandExists(String command)
    {
        return this.commands.containsKey(command);
    }
}