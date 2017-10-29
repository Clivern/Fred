/*
 * Copyright (C) 2017 Clivern. <https://clivern.com>
 */
package com.clivern.fred;

import static spark.Spark.*;

import com.clivern.fred.utils.*;
import com.mashape.unirest.http.exceptions.UnirestException;

public class Test {

    public static void main(String[] args) throws UnirestException
    {
        get("/", (request, response) -> {
            Config config = new Config();
            config.loadPropertiesFile("src/main/java/resources/config_test.properties");
            Log log = new Log(config);
            Oauth oauth = new Oauth(config, log);
            return "<a href='" + oauth.getRedirectURL() + "'>Auth</a>";
        });

        get("/oauth", (request, response) -> {
            Config config = new Config();
            config.loadPropertiesFile("src/main/java/resources/config_test.properties");
            Log log = new Log(config);
            Oauth oauth = new Oauth(config, log);

            Boolean status = oauth.issueToken(
                ( request.queryParams("code") != null ) ? request.queryParams("code") : "",
                ( request.queryParams("state") != null ) ? request.queryParams("state") : "",
                ( request.queryParams("error") != null ) ? request.queryParams("error") : ""
            );

            Boolean fetch = oauth.fetchAccessToken();

            if( fetch ){
                return oauth.getIncomingAccessToken();
            }else{
                return "Error";
            }
        });
    }
}