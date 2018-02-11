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

public class UsergroupsCreateTest extends TestCase {

    public void testBuild() throws IOException
    {
        UsergroupsCreate usergroupsCreate = new UsergroupsCreate();
        usergroupsCreate.setToken("Token");
        usergroupsCreate.setName("Name");
        usergroupsCreate.setChannels("Channels");
        usergroupsCreate.setDescription("Description");
        usergroupsCreate.setHandle("Handle");
        usergroupsCreate.setIncludeCount(true);
        assertEquals(usergroupsCreate.getToken(), "Token");
        assertEquals(usergroupsCreate.getName(), "Name");
        assertEquals(usergroupsCreate.getChannels(), "Channels");
        assertEquals(usergroupsCreate.getDescription(), "Description");
        assertEquals(usergroupsCreate.getHandle(), "Handle");
        assertTrue(usergroupsCreate.getIncludeCount());
        assertEquals(usergroupsCreate.build(), "token=Token&name=Name&channels=Channels&description=Description&handle=Handle&include_count=true");
    }
}
