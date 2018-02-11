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

public class FilesUploadTest extends TestCase {

    public void testBuild() throws IOException
    {
        FilesUpload filesUpload = new FilesUpload();
        filesUpload.setToken("Token");
        filesUpload.setChannels("Channel");
        filesUpload.setContent("Content");
        filesUpload.setFile("File");
        filesUpload.setFilename("FileName");
        filesUpload.setFiletype("FileType");
        filesUpload.setInitialComment("InitialComment");
        filesUpload.setTitle("Title");
        assertEquals(filesUpload.getToken(), "Token");
        assertEquals(filesUpload.getChannels(), "Channel");
        assertEquals(filesUpload.getContent(), "Content");
        assertEquals(filesUpload.getFile(), "File");
        assertEquals(filesUpload.getFilename(), "FileName");
        assertEquals(filesUpload.getFiletype(), "FileType");
        assertEquals(filesUpload.getInitialComment(), "InitialComment");
        assertEquals(filesUpload.getTitle(), "Title");
        assertEquals(filesUpload.build(), "token=Token&channels=Channel&content=Content&file=File&filename=FileName&filetype=FileType&initial_comment=InitialComment&title=Title");
    }
}
