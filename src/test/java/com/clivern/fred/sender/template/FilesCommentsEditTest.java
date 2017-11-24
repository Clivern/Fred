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

public class FilesCommentsEditTest extends TestCase {

    public void testBuild() throws IOException
    {
        FilesCommentsEdit filesCommentsEdit = new FilesCommentsEdit();
        filesCommentsEdit.setToken("Token");
        filesCommentsEdit.setComment("Comment");
        filesCommentsEdit.setFile("File");
        filesCommentsEdit.setId("ID");
        assertEquals(filesCommentsEdit.getToken(), "Token");
        assertEquals(filesCommentsEdit.getComment(), "Comment");
        assertEquals(filesCommentsEdit.getFile(), "File");
        assertEquals(filesCommentsEdit.getId(), "ID");
        assertEquals(filesCommentsEdit.build(), "token=Token&comment=Comment&file=File&id=ID");
    }
}
