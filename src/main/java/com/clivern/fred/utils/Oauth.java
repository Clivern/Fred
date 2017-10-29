/*
 * Copyright (C) 2017 Clivern. <https://clivern.com>
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
	protected String scope;
	protected String redirectUri;
	protected String stateType;
	protected String state;
	protected String team;
	protected String incomingCode;
	protected String incomingState;
	protected String incomingError;

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
        this.scope = this.configs.get("scope", "");
        this.redirectUri = this.configs.get("redirect_uri", "");
        this.stateType = this.configs.get("state_type", "");
        this.state = this.configs.get("state", "");
        this.team = this.configs.get("team", "");
    }

    /**
     * Set State
     *
     * @param  state
     * @return String
     */
    public Boolean setState(String state)
    {
    	if( this.stateType != "vary" ){
    		return false;
    	}

    	if( state.isEmpty() ){
    		state = this.buildState();
    	}
    	this.state = state;

    	return true;
    }

    /**
     * Get State
     *
     * @return String
     */
    public String getState()
    {
    	if( this.stateType != "vary" ){
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

    	if( this.state != this.getIncomingState() ){
    		return false;
    	}

    	return (this.incomingError.isEmpty()) ? true : false;
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
     * Fetch Access Token
     *
     * @return Boolean
     */
    public Boolean fetchAccessToken() throws UnirestException
    {
        String url = Basic.methodURL(Basic.oauthAccessMethod);
        String body = "client_id=" + this.clientId + "&client_secret=" + this.clientSecret + "&code=" + this.incomingCode + "&redirect_uri=" + this.redirectUri;
        this.log.info("curl -X POST -H \"Content-Type: application/x-www-form-urlencoded\" -d '" + body + "' \"" + url + "\"");
        HttpResponse<String> response = Unirest.post(url).header("Content-Type", "application/json").body(body).asString();

        return true;
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