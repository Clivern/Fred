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

public class ReactionsGetTest extends TestCase {

    public void testBuild() throws IOException
    {
        ReactionsGet reactionsGet = new ReactionsGet();
        reactionsGet.setToken("Token");
        reactionsGet.setChannel("Channel");
        reactionsGet.setFile("File");
        reactionsGet.setFileComment("FileComment");
        reactionsGet.setFull(false);
        reactionsGet.setTimestamp("Timestamp");
        assertEquals(reactionsGet.getToken(), "Token");
        assertEquals(reactionsGet.getChannel(), "Channel");
        assertEquals(reactionsGet.getFile(), "File");
        assertEquals(reactionsGet.getFileComment(), "FileComment");
        assertFalse(reactionsGet.getFull());
        assertEquals(reactionsGet.getTimestamp(), "Timestamp");
        assertEquals(reactionsGet.build(), "token=Token&channel=Channel&file=File&file_comment=FileComment&full=false&timestamp=Timestamp");
    }
}
