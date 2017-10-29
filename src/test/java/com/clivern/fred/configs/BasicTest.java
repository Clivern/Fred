/*
 * Copyright (c) 2017 Clivern. <https://clivern.com>.
 */

package com.clivern.fred.configs;

import junit.framework.TestCase;

public class BasicTest extends TestCase {

    public void testConfigs()
    {
        assertEquals(Basic.authorizeURL, "https://slack.com/oauth/authorize");
        assertEquals(Basic.methodURL(Basic.usersSetPhotoMethod), Basic.apiURL + Basic.usersSetPhotoMethod);
    }
}