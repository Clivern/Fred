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

public class ConversationsCreateTest extends TestCase {

    public void testBuild() throws IOException
    {
        ConversationsCreate conversationsCreate = new ConversationsCreate();
        conversationsCreate.setToken("Token");
        conversationsCreate.setName("Channel");
        conversationsCreate.setIsPrivate(true);
        assertEquals(conversationsCreate.getToken(), "Token");
        assertEquals(conversationsCreate.getName(), "Channel");
        assertTrue(conversationsCreate.getIsPrivate());
        assertEquals(conversationsCreate.build(), "token=Token&name=Channel&is_private=true");
    }
}
