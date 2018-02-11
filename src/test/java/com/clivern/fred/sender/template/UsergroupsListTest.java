/*
 * Copyright (C) 2017 Clivern <http://clivern.com>
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
package com.clivern.fred.sender.template;

import junit.framework.TestCase;
import java.io.IOException;

public class UsergroupsListTest extends TestCase {

    public void testBuild() throws IOException
    {
        UsergroupsList usergroupsList = new UsergroupsList();
        usergroupsList.setToken("Token");
        usergroupsList.setIncludeCount(true);
        usergroupsList.setIncludeDisabled(false);
        usergroupsList.setIncludeUsers(true);
        assertEquals(usergroupsList.getToken(), "Token");
        assertTrue(usergroupsList.getIncludeCount());
        assertFalse(usergroupsList.getIncludeDisabled());
        assertTrue(usergroupsList.getIncludeUsers());
        assertEquals(usergroupsList.build(), "token=Token&include_count=true&include_disabled=false&include_users=true");
    }
}
