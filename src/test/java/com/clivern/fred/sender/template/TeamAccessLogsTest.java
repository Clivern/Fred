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

public class TeamAccessLogsTest extends TestCase {

    public void testBuild() throws IOException
    {
        TeamAccessLogs teamAccessLogs = new TeamAccessLogs();
        teamAccessLogs.setToken("Token");
        teamAccessLogs.setBefore("Before");
        teamAccessLogs.setCount(20);
        teamAccessLogs.setPage(30);
        assertEquals(teamAccessLogs.getToken(), "Token");
        assertEquals(teamAccessLogs.getBefore(), "Before");
        assertEquals(teamAccessLogs.getCount(), new Integer(20));
        assertEquals(teamAccessLogs.getPage(), new Integer(30));
        assertEquals(teamAccessLogs.build(), "token=Token&before=Before&count=20&page=30");
    }
}
