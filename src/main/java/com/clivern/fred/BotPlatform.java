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
package com.clivern.fred;

import java.util.HashMap;
import java.util.Map;
import java.io.IOException;
import com.clivern.fred.util.Config;
import com.clivern.fred.util.Log;

/**
 * Bot Platform Base Class
 *
 * @author A.F
 * @since 1.0.0
 */
public class BotPlatform {

    protected Config configs;

    protected Log log;

    /**
     * Class Constructor
     *
     * @param  popertiesFilePath
     */
    public BotPlatform(String popertiesFilePath) throws IOException
    {
        this.configs = new Config();
        this.configs.loadPropertiesFile(popertiesFilePath);
        this.log = new Log(this.configs);
    }

    /**
     * Class Constructor
     *
     * @param  options
     */
    public BotPlatform(Map<String, String> options) throws IOException
    {
        this.configs = new Config();
        for (Map.Entry<String, String> entry : options.entrySet()) {
            this.configs.set(entry.getKey(), options.get(entry.getKey()));
        }
        this.log = new Log(this.configs);
    }

    /**
     * Get Configs
     *
     * @return Config
     */
    public Config getConfigs()
    {
        return this.configs;
    }

    /**
     * Get Logger
     *
     * @return Log
     */
    public Log getLogger()
    {
        return this.log;
    }

    /**
     * Get Package Name
     *
     * @return String
     */
    public String getName()
    {
        return "Fred";
    }

    /**
     * Close any connections
     */
    public void finish()
    {
        this.log.close();
    }
}