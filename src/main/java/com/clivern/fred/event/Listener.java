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
package com.clivern.fred.event;

import com.clivern.fred.util.Config;
import com.clivern.fred.util.Log;

/**
 * Events Listener
 *
 * @author A.F
 * @since 1.0.0
 */
public class Listener {

    protected Config configs;

    protected Log log;

	protected String requestURL;

	protected String verificationToken;

	protected String verificationChallenge;

	protected String verificationType;

    /**
     * Class Constructor
     *
     * @param requestURL
     */
    public Listener(Config configs, Log log, String requestURL)
    {
        this.configs = configs;
        this.log = log;
        this.requestURL = requestURL;
    }

    /**
     * Set Verification Token
     *
     * @param verificationToken
     */
    public void setVerificationToken(String verificationToken)
    {
    	this.verificationToken = verificationToken;
    }

    /**
     * Set Verification Challenge
     *
     * @param verificationChallenge
     */
    public void setVerificationChallenge(String verificationChallenge)
    {
    	this.verificationChallenge = verificationChallenge;
    }

    /**
     * Set Verification Type
     *
     * @param verificationType
     */
    public void setVerificationType(String verificationType)
    {
    	this.verificationType = verificationType;
    }

    /**
     * Get Verification Token
     *
     * @return String
     */
    public String getVerificationToken()
    {
    	return this.verificationToken;
    }

    /**
     * Get Verification Challenge
     *
     * @return String
     */
    public String getVerificationChallenge()
    {
    	return this.verificationChallenge;
    }

    /**
     * Get Verification Type
     *
     * @return String
     */
    public String getVerificationType()
    {
    	return this.verificationType;
    }
}