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

public class StarsAddTest extends TestCase {

    public void testBuild() throws IOException
    {
        StarsAdd starsAdd = new StarsAdd();
        starsAdd.setToken("Token");
        starsAdd.setChannel("Channel");
        starsAdd.setFile("File");
        starsAdd.setFileComment("FileComment");
        starsAdd.setTimestamp("Timestamp");
        assertEquals(starsAdd.getToken(), "Token");
        assertEquals(starsAdd.getChannel(), "Channel");
        assertEquals(starsAdd.getFile(), "File");
        assertEquals(starsAdd.getFileComment(), "FileComment");
        assertEquals(starsAdd.getTimestamp(), "Timestamp");
        assertEquals(starsAdd.build(), "token=Token&channel=Channel&file=File&file_comment=FileComment&timestamp=Timestamp");
    }
}
