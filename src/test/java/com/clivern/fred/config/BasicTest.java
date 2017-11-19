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
package com.clivern.fred.config;

import junit.framework.TestCase;

public class BasicTest extends TestCase {

    public void testConfigs()
    {
        assertEquals(Basic.authorizeURL, "https://slack.com/oauth/authorize");
        assertEquals(Basic.methodURL(Basic.usersSetPhotoMethod), Basic.apiURL + Basic.usersSetPhotoMethod);
    }
}