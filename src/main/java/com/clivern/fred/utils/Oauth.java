/*
 * Copyright (C) 2017 Clivern. <https://clivern.com>
 */
package com.clivern.fred.utils;

import com.clivern.fred.utils.Config;
import com.clivern.fred.utils.Log;
import com.mashape.unirest.http.*;
import com.mashape.unirest.http.async.Callback;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.http.options.Options;
import com.mashape.unirest.request.GetRequest;
import com.mashape.unirest.request.HttpRequest;


/**
 * Oauth Utils Class
 */
public class Oauth {

	protected Config configs;

	protected Log log;

    /**
     * Class Constructor
     *
     * @param  configs
     * @param  log
     */
    public Oauth(Config configs, Log log)
    {
        this.configs = configs;
        this.log = log;
    }

    /**
     * Send Plain Message JSON
     *
     * @param  body
     * @return Boolean
     * @throws UnirestException
     */
    public Boolean send(String body) throws UnirestException
    {
        String url = "";
        this.log.info("curl -X POST -H \"Content-Type: application/json\" -d '" + body + "' \"" + url + "\"");
        HttpResponse<String> response = Unirest.post(url).header("Content-Type", "application/json").body(body).asString();

        return true;
    }
}