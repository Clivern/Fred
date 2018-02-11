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

public class ChannelsListTest extends TestCase {

    public void testBuild() throws IOException
    {
        ChannelsList channelsList = new ChannelsList();
        channelsList.setToken("Token");
        channelsList.setCursor("Cursor");
        channelsList.setExcludeArchived(true);
        channelsList.setExcludeMembers(false);
        channelsList.setLimit(20);
        assertEquals(channelsList.getToken(), "Token");
        assertEquals(channelsList.getCursor(), "Cursor");
        assertTrue(channelsList.getExcludeArchived());
        assertFalse(channelsList.getExcludeMembers());
        assertEquals(channelsList.getLimit(), new Integer(20));
        assertEquals(channelsList.build(), "token=Token&cursor=Cursor&exclude_archived=true&exclude_members=false&limit=20");
    }
}
