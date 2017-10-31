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
package com.clivern.fred.utils;

import com.clivern.fred.configs.Basic;
import com.clivern.fred.utils.Config;
import com.clivern.fred.utils.Log;

import com.mashape.unirest.http.*;
import com.mashape.unirest.http.async.Callback;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.http.options.Options;
import com.mashape.unirest.request.GetRequest;
import com.mashape.unirest.request.HttpRequest;

import java.util.Random;
import java.lang.StringBuilder;

import org.json.JSONObject;
import org.json.JSONArray;

/**
 * Oauth Utils Class
 *
 * For More Info, Please Visit <https://api.slack.com/docs/oauth>
 */
public class Oauth {

    protected Config configs;
    protected Log log;
    protected String redirectURL;
    protected String clientId;
    protected String clientSecret;
    protected String verificationToken;
    protected String scope;
    protected String redirectUri;
    protected String stateType;
    protected String state;
    protected String team;
    protected String incomingCode;
    protected String incomingState;
    protected String incomingError;

    protected Boolean incomingOk;
    protected String incomingAccessToken;
    protected String incomingScope;
    protected String incomingUserId;
    protected String incomingTeamName;
    protected String incomingTeamId;

    protected String incomingWebhookUrl;
    protected String incomingWebhookChannel;
    protected String incomingWebhookConfigUrl;

    protected String incomingBotUserId;
    protected String incomingBotAccessToken;


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

        this.clientId = this.configs.get("client_id", "");
        this.clientSecret = this.configs.get("client_secret", "");
        this.verificationToken = this.configs.get("verification_token", "");
        this.scope = this.configs.get("scope", "");
        this.redirectUri = this.configs.get("redirect_uri", "");
        this.stateType = this.configs.get("state_type", "");
        this.state = this.configs.get("state", "");
        this.team = this.configs.get("team", "");
    }

    /**
     * Get Redirect URL
     *
     * @return String
     */
    public String getRedirectURL()
    {
        this.redirectURL  = Basic.authorizeURL + "?client_id=" + this.clientId;
        this.redirectURL += (!this.scope.isEmpty()) ? "&scope=" + this.scope : "";
        this.redirectURL += (!this.redirectUri.isEmpty()) ? "&redirect_uri=" + this.redirectUri : "";
        this.redirectURL += (!this.state.isEmpty()) ? "&state=" + this.state : "";
        this.redirectURL += (!this.team.isEmpty()) ? "&team=" + this.team : "";

        return this.redirectURL;
    }

    /**
     * Issue Token
     *
     * @param  incomingCode
     * @param  incomingState
     * @param  incomingError
     * @return Boolean
     */
    public Boolean issueToken(String incomingCode, String incomingState, String incomingError)
    {
        this.setIncomingCode(incomingCode);
        this.setIncomingState(incomingState);
        this.setIncomingError(incomingError);

        if( !this.state.equals(this.getIncomingState()) ){
            return false;
        }

        return (this.incomingError.isEmpty()) ? true : false;
    }

    /**
     * Fetch Access Token
     *
     * @return Boolean
     */
    public Boolean fetchAccessToken() throws UnirestException
    {
        String url = Basic.methodURL(Basic.oauthAccessMethod);
        String body = "client_id=" + this.clientId + "&client_secret=" + this.clientSecret + "&code=" + this.incomingCode + "&redirect_uri=" + this.redirectUri;
        this.log.info("curl -X POST -H \"Content-Type: application/x-www-form-urlencoded\" -d '" + body + "' \"" + url + "\"");
        HttpResponse<String> responseObj = Unirest.post(url).header("Content-Type", "application/x-www-form-urlencoded").body(body).asString();

        String responseStr = responseObj.getBody();

        this.parseResponse(responseStr);
        if( responseStr.indexOf("\"ok\":true") > 0 ){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Set State
     *
     * @param  state
     * @return String
     */
    public Boolean setState(String state)
    {
        if( !this.stateType.equals("vary") ){
            return false;
        }

        if( state.isEmpty() ){
            state = this.buildState();
        }
        this.state = state;

        return true;
    }

    /**
     * Set Incoming Code
     *
     * @param incomingCode
     */
    public void setIncomingCode(String incomingCode)
    {
        this.incomingCode = incomingCode;
    }

    /**
     * Set Incoming State
     *
     * @param incomingState
     */
    public void setIncomingState(String incomingState)
    {
        this.incomingState = incomingState;
    }

    /**
     * Set Incoming Error
     *
     * @param incomingError
     */
    public void setIncomingError(String incomingError)
    {
        this.incomingError = incomingError;
    }

    /**
     * Get State
     *
     * @return String
     */
    public String getState()
    {
        if( !this.stateType.equals("vary") ){
            return this.state;
        }

        if( this.state.isEmpty() ){
            this.state = this.buildState();
        }

        return this.state;
    }

    /**
     * Get Client ID
     *
     * @return String
     */
    public String getClientId()
    {
        return this.clientId;
    }

    /**
     * Get Client Secret
     *
     * @return String
     */
    public String getClientSecret()
    {
        return this.clientSecret;
    }

    /**
     * Get Scope
     *
     * @return String
     */
    public String getScope()
    {
        return this.scope;
    }

    /**
     * Get Redirect Uri
     *
     * @return String
     */
    public String getRedirectUri()
    {
        return this.redirectUri;
    }

    /**
     * Get State Type
     *
     * @return String
     */
    public String getStateType()
    {
        return this.stateType;
    }

    /**
     * Get Team
     *
     * @return String
     */
    public String getTeam()
    {
        return this.team;
    }

    /**
     * Get Incoming Code
     *
     * @return String
     */
    public String getIncomingCode()
    {
        return this.incomingCode;
    }

    /**
     * Get Incoming State
     *
     * @return String
     */
    public String getIncomingState()
    {
        return this.incomingState;
    }

    /**
     * Get Incoming Error
     *
     * @return String
     */
    public String getIncomingError()
    {
        return this.incomingError;
    }

    /**
     * Get Incoming Ok Flag
     *
     * @return String
     */
    public Boolean getIncomingOk()
    {
        return this.incomingOk;
    }

    /**
     * Get Incoming Access Token
     *
     * @return String
     */
    public String getIncomingAccessToken()
    {
        return this.incomingAccessToken;
    }

    /**
     * Get Incoming Scope
     *
     * @return String
     */
    public String getIncomingScope()
    {
        return this.incomingScope;
    }

    /**
     * Get Incoming User ID
     *
     * @return String
     */
    public String getIncomingUserId()
    {
        return this.incomingUserId;
    }

    /**
     * Get Incoming Team Name
     *
     * @return String
     */
    public String getIncomingTeamName()
    {
        return this.incomingTeamName;
    }

    /**
     * Get Incoming Team ID
     *
     * @return String
     */
    public String getIncomingTeamId()
    {
        return this.incomingTeamId;
    }

    /**
     * Get Incoming Webhook URL
     *
     * @return String
     */
    public String getIncomingWebhookUrl()
    {
        return this.incomingWebhookUrl;
    }

    /**
     * Get Incoming Webhook Channel
     *
     * @return String
     */
    public String getIncomingWebhookChannel()
    {
        return this.incomingWebhookChannel;
    }

    /**
     * Get Incoming Webhook Config URL
     *
     * @return String
     */
    public String getIncomingWebhookConfigUrl()
    {
        return this.incomingWebhookConfigUrl;
    }

    /**
     * Get Incoming Bot User ID
     *
     * @return String
     */
    public String getIncomingBotUserId()
    {
        return this.incomingBotUserId;
    }

    /**
     * Get Incoming Bot Access Token
     *
     * @return String
     */
    public String getIncomingBotAccessToken()
    {
        return this.incomingBotAccessToken;
    }

    /**
     * Parse Response
     *
     * @param response
     */
    protected void parseResponse(String response)
    {
        JSONObject responseObj = new JSONObject(response);

        this.incomingOk = (responseObj.has("ok")) ? responseObj.getBoolean("ok") : false;
        this.incomingAccessToken = (responseObj.has("access_token")) ? responseObj.getString("access_token") : "";
        this.incomingScope = (responseObj.has("scope")) ? responseObj.getString("scope") : "";
        this.incomingUserId = (responseObj.has("user_id")) ? responseObj.getString("user_id") : "";
        this.incomingTeamName = (responseObj.has("team_name")) ? responseObj.getString("team_name") : "";
        this.incomingTeamId = (responseObj.has("team_id")) ? responseObj.getString("team_id") : "";

        if( responseObj.has("incoming_webhook") ){
            JSONObject incomingWebhook = responseObj.getJSONObject("incoming_webhook");
            this.incomingWebhookUrl = (incomingWebhook.has("url")) ? incomingWebhook.getString("url") : "";
            this.incomingWebhookChannel = (incomingWebhook.has("channel")) ? incomingWebhook.getString("channel") : "";
            this.incomingWebhookConfigUrl = (incomingWebhook.has("configuration_url")) ? incomingWebhook.getString("configuration_url") : "";
        }

        if( responseObj.has("bot") ){
            JSONObject bot = responseObj.getJSONObject("bot");
            this.incomingBotUserId = (bot.has("bot_user_id")) ? bot.getString("bot_user_id") : "";
            this.incomingBotAccessToken = (bot.has("bot_access_token")) ? bot.getString("bot_access_token") : "";
        }
    }

    /**
     * Build Random State String
     *
     * @return String
     */
    protected String buildState()
    {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 20) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }

        String saltStr = salt.toString();

        return saltStr;
    }
}