/*
 * Copyright (C) 2017 Clivern. <https://clivern.com>
 */
package com.clivern.fred.receivers;

import java.util.HashMap;
import java.util.Map;
import com.clivern.fred.utils.Config;
import com.clivern.fred.utils.Log;
import org.json.JSONObject;
import org.json.JSONArray;

/**
 * Base Receiver Class
 */
public class BaseReceiver {

    protected Config configs;

    protected Log log;


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
}