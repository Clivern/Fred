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

public class StarsRemoveTest extends TestCase {

    public void testBuild() throws IOException
    {
        StarsRemove starsRemove = new StarsRemove();
        starsRemove.setToken("Token");
        starsRemove.setChannel("Channel");
        starsRemove.setFile("File");
        starsRemove.setFileComment("FileComment");
        starsRemove.setTimestamp("Timestamp");
        assertEquals(starsRemove.getToken(), "Token");
        assertEquals(starsRemove.getChannel(), "Channel");
        assertEquals(starsRemove.getFile(), "File");
        assertEquals(starsRemove.getFileComment(), "FileComment");
        assertEquals(starsRemove.getTimestamp(), "Timestamp");
        assertEquals(starsRemove.build(), "token=Token&channel=Channel&file=File&file_comment=FileComment&timestamp=Timestamp");
    }
}
