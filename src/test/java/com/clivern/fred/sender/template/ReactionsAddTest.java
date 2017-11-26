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
package com.clivern.fred.sender.template;

import junit.framework.TestCase;
import java.io.IOException;

public class ReactionsAddTest extends TestCase {

    public void testBuild() throws IOException
    {
        ReactionsAdd reactionsAdd = new ReactionsAdd();
        reactionsAdd.setToken("Token");
        reactionsAdd.setName("Name");
        reactionsAdd.setChannel("Channel");
        reactionsAdd.setFile("File");
        reactionsAdd.setFileComment("FileComment");
        reactionsAdd.setTimestamp("Timestamp");
        assertEquals(reactionsAdd.getToken(), "Token");
        assertEquals(reactionsAdd.getName(), "Name");
        assertEquals(reactionsAdd.getChannel(), "Channel");
        assertEquals(reactionsAdd.getFile(), "File");
        assertEquals(reactionsAdd.getFileComment(), "FileComment");
        assertEquals(reactionsAdd.getTimestamp(), "Timestamp");
        assertEquals(reactionsAdd.build(), "token=Token&name=Name&channel=Channel&file=File&file_comment=FileComment&timestamp=Timestamp");
    }
}
