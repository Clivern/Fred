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

public class SearchMessagesTest extends TestCase {

    public void testBuild() throws IOException
    {
        SearchMessages searchMessages = new SearchMessages();
        searchMessages.setToken("Token");
        searchMessages.setQuery("Query");
        searchMessages.setCount(23);
        searchMessages.setPage(34);
        searchMessages.setHighlight(true);
        searchMessages.setSort("Sort");
        searchMessages.setSortDir("SortDir");
        assertEquals(searchMessages.getToken(), "Token");
        assertEquals(searchMessages.getQuery(), "Query");
        assertEquals(searchMessages.getCount(), new Integer(23));
        assertEquals(searchMessages.getPage(), new Integer(34));
        assertTrue(searchMessages.getHighlight());
        assertEquals(searchMessages.getSort(), "Sort");
        assertEquals(searchMessages.getSortDir(), "SortDir");
        assertEquals(searchMessages.build(), "token=Token&query=Query&count=23&page=34&highlight=true&sort=Sort&sort_dir=SortDir");
    }
}
