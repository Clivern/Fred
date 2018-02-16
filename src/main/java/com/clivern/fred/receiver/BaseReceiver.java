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
package com.clivern.fred.receiver;

import java.util.HashMap;
import java.util.Map;
import org.pmw.tinylog.Logger;
import com.clivern.fred.util.Config;
import com.clivern.fred.exception.CommandNotFound;
import com.clivern.fred.exception.CommandDataNotValid;
import com.clivern.fred.contract.receiver.command.CommandTemplate;

/**
 * Base Receiver Class
 *
 * @author Clivern
 * @since 1.0.0
 */
public class BaseReceiver {

    protected Config configs;

    protected Map<String, CommandTemplate> commands = new HashMap<String, CommandTemplate>();

    /**
     * Class Constructor
     *
     * @param configs
     */
    public BaseReceiver(Config configs)
    {
        this.configs = configs;
    }

    /**
     * Set Command
     *
     * @param command
     * @param template
     */
    public void setCommand(String command, CommandTemplate template)
    {
        template.setValidationToken(this.configs.get("verification_token", ""));
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

    /**
     * Get Current Command
     *
     * @param  command
     * @param  incomingData
     * @return CommandTemplate
     * @throws CommandNotFound
     */
    public CommandTemplate getCurrentCommand(String command, Map<String, String> incomingData) throws CommandNotFound
    {
        if( this.commandExists(command) ){
            CommandTemplate currentCommand = this.getCommand(command);
            currentCommand.setIncomigData(incomingData);
            return currentCommand;
        }

        throw new CommandNotFound("Error! Slack Command Not Found.");
    }

    /**
     * Call Current Command
     *
     * @param  command
     * @param  incomingData
     * @return CommandTemplate
     * @throws CommandNotFound
     */
    public String callCurrentCommand(String command, Map<String, String> incomingData) throws CommandNotFound
    {
        if( this.commandExists(command) ){
            CommandTemplate currentCommand = this.getCommand(command);
            currentCommand.setIncomigData(incomingData);
            return currentCommand.call();
        }

        throw new CommandNotFound("Error! Slack Command Not Found.");
    }
}