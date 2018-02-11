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

public class RemindersAddTest extends TestCase {

    public void testBuild() throws IOException
    {
        RemindersAdd remindersAdd = new RemindersAdd();
        remindersAdd.setToken("Token");
        remindersAdd.setText("Text");
        remindersAdd.setTime("Time");
        remindersAdd.setTimestamp("2344656676");
        remindersAdd.setUser("User");
        assertEquals(remindersAdd.getToken(), "Token");
        assertEquals(remindersAdd.getText(), "Text");
        assertEquals(remindersAdd.getTime(), "Time");
        assertEquals(remindersAdd.getTimestamp(), "2344656676");
        assertEquals(remindersAdd.getUser(), "User");
        assertEquals(remindersAdd.build(), "token=Token&text=Text&time=Time&time=2344656676&user=User");
    }
}
