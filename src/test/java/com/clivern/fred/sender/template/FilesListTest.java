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

public class FilesListTest extends TestCase {

    public void testBuild() throws IOException
    {
        FilesList filesList = new FilesList();
        filesList.setToken("Token");
        filesList.setChannel("Channel");
        filesList.setCount(5);
        filesList.setPage(6);
        filesList.setTsFrom("TsFrom");
        filesList.setTsTo("TsTo");
        filesList.setTypes("Types");
        filesList.setUser("User");
        assertEquals(filesList.getToken(), "Token");
        assertEquals(filesList.getChannel(), "Channel");
        assertEquals(filesList.getCount(), new Integer(5));
        assertEquals(filesList.getPage(), new Integer(6));
        assertEquals(filesList.getTsFrom(), "TsFrom");
        assertEquals(filesList.getTsTo(), "TsTo");
        assertEquals(filesList.getTypes(), "Types");
        assertEquals(filesList.getUser(), "User");
        assertEquals(filesList.build(), "token=Token&channel=Channel&count=5&page=6&ts_from=TsFrom&ts_to=TsTo&types=Types&user=User");
    }
}
