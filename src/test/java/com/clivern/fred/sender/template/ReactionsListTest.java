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

public class ReactionsListTest extends TestCase {

    public void testBuild() throws IOException
    {
        ReactionsList reactionsList = new ReactionsList();
        reactionsList.setToken("Token");
        reactionsList.setCount(20);
        reactionsList.setFull(true);
        reactionsList.setPage(30);
        reactionsList.setUser("User");
        assertEquals(reactionsList.getToken(), "Token");
        assertEquals(reactionsList.getCount(), new Integer(20));
        assertTrue(reactionsList.getFull());
        assertEquals(reactionsList.getPage(), new Integer(30));
        assertEquals(reactionsList.getUser(), "User");
        assertEquals(reactionsList.build(), "token=Token&count=20&full=true&page=30&user=User");
    }
}
