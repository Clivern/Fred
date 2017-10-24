/*
 * Copyright (C) 2017 Clivern. <https://clivern.com>
 */
package com.clivern.fred;

import java.util.HashMap;
import java.util.Map;
import java.io.IOException;
import com.clivern.fred.utils.Config;
import com.clivern.fred.utils.Log;

/**
 * Bot Platform Base Class
 */
public class BotPlatform {

    protected Config configs;

    protected Log log;


    /**
     * Class Constructor
     *
     * @param  poperties_file_path
     */
    public BotPlatform(String poperties_file_path) throws IOException
    {
        this.configs = new Config();
        this.configs.loadPropertiesFile(poperties_file_path);
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