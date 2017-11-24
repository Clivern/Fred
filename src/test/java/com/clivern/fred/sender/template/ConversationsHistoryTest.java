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

public class ConversationsHistoryTest extends TestCase {

    public void testBuild() throws IOException
    {
        ConversationsHistory conversationsHistory = new ConversationsHistory();
        conversationsHistory.setToken("Token");
        conversationsHistory.setChannel("Channel");
        conversationsHistory.setCursor("Cursor");
        conversationsHistory.setLatest("Latest");
        conversationsHistory.setLimit(20);
        conversationsHistory.setOldest("Oldest");
        assertEquals(conversationsHistory.getToken(), "Token");
        assertEquals(conversationsHistory.getChannel(), "Channel");
        assertEquals(conversationsHistory.getCursor(), "Cursor");
        assertEquals(conversationsHistory.getLatest(), "Latest");
        assertEquals(conversationsHistory.getLimit(), new Integer(20));
        assertEquals(conversationsHistory.getOldest(), "Oldest");
        assertEquals(conversationsHistory.build(), "token=Token&channel=Channel&cursor=Cursor&latest=Latest&limit=20&oldest=Oldest");
    }
}
