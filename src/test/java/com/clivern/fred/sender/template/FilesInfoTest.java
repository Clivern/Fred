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

public class FilesInfoTest extends TestCase {

    public void testBuild() throws IOException
    {
        FilesInfo filesInfo = new FilesInfo();
        filesInfo.setToken("Token");
        filesInfo.setFile("File");
        filesInfo.setCount(5);
        filesInfo.setPage(6);
        assertEquals(filesInfo.getToken(), "Token");
        assertEquals(filesInfo.getFile(), "File");
        assertEquals(filesInfo.getCount(), new Integer(5));
        assertEquals(filesInfo.getPage(), new Integer(6));
        assertEquals(filesInfo.build(), "token=Token&file=File&count=5&page=6");
    }
}
