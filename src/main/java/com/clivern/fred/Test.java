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
package com.clivern.fred;

import static spark.Spark.*;
import com.clivern.fred.util.*;
import com.clivern.fred.sender.BaseSender;
import com.clivern.fred.sender.template.RemindersAdd;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * Test Package
 *
 * @author A.F
 * @since 1.0.0
 */
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

            if( status && fetch ){


                BaseSender baseSender = new BaseSender(config, log);

                // Build & Send A Reminder
                RemindersAdd remindersAdd = new RemindersAdd();
                remindersAdd.setToken(oauth.getIncomingAccessToken());
                remindersAdd.setText("Thumb Up Task :+1:");
                remindersAdd.setTime("in 5 minutes");
                remindersAdd.setUser(oauth.getIncomingUserId());
                remindersAdd.build();
                Boolean remindersAddSent = false;
                if( remindersAdd.isValid() ){
                    remindersAddSent = baseSender.send(remindersAdd);
                }

                return  "State: " +  oauth.getState() + "<br/>" +
                        "Client ID: " +  oauth.getClientId() + "<br/>" +
                        "Client Secret: " +  oauth.getClientSecret() + "<br/>" +
                        "Scope: " +  oauth.getScope() + "<br/>" +
                        "Redirect Uri: " +  oauth.getRedirectUri() + "<br/>" +
                        "State Type: " +  oauth.getStateType() + "<br/>" +
                        "Team: " +  oauth.getTeam() + "<br/>" +
                        "Incoming Code: " +  oauth.getIncomingCode() + "<br/>" +
                        "Incoming State: " +  oauth.getIncomingState() + "<br/>" +
                        "Incoming Error: " +  oauth.getIncomingError() + "<br/>" +
                        "Incoming Access Token: " +  oauth.getIncomingAccessToken() + "<br/>" +
                        "Incoming Scope: " +  oauth.getIncomingScope() + "<br/>" +
                        "Incoming User ID: " +  oauth.getIncomingUserId() + "<br/>" +
                        "Incoming Team Name: " +  oauth.getIncomingTeamName() + "<br/>" +
                        "Incoming Team ID: " +  oauth.getIncomingTeamId() + "<br/>" +
                        "Incoming Webhook URL: " +  oauth.getIncomingWebhookUrl() + "<br/>" +
                        "Incoming Webhook Channel: " +  oauth.getIncomingWebhookChannel() + "<br/>" +
                        "Incoming Webhook Config URL: " +  oauth.getIncomingWebhookConfigUrl() + "<br/>" +
                        "Incoming Bot User ID: " +  oauth.getIncomingBotUserId() + "<br/>" +
                        "Incoming Bot Access Token: " +  oauth.getIncomingBotAccessToken() + "<br/>" +
                        "RSent: " + ((remindersAddSent) ? "Sent" : "Not Sent");

            }else{
                return "Error";
            }
        });
    }
}