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

public class ConversationsRepliesTest extends TestCase {

    public void testBuild() throws IOException
    {
        ConversationsReplies conversationsReplies = new ConversationsReplies();
        conversationsReplies.setToken("Token");
        conversationsReplies.setChannel("Channel");
        conversationsReplies.setTs("Ts");
        conversationsReplies.setCursor("Cursor");
        conversationsReplies.setLimit(5);
        assertEquals(conversationsReplies.getToken(), "Token");
        assertEquals(conversationsReplies.getChannel(), "Channel");
        assertEquals(conversationsReplies.getTs(), "Ts");
        assertEquals(conversationsReplies.getCursor(), "Cursor");
        assertEquals(conversationsReplies.getLimit(), new Integer(5));
        assertEquals(conversationsReplies.build(), "token=Token&channel=Channel&ts=Ts&cursor=Cursor&limit=5");
    }
}
