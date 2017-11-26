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

public class SearchAllTest extends TestCase {

    public void testBuild() throws IOException
    {
        SearchAll searchAll = new SearchAll();
        searchAll.setToken("Token");
        searchAll.setQuery("Query");
        searchAll.setCount(23);
        searchAll.setPage(34);
        searchAll.setHighlight(true);
        searchAll.setSort("Sort");
        searchAll.setSortDir("SortDir");
        assertEquals(searchAll.getToken(), "Token");
        assertEquals(searchAll.getQuery(), "Query");
        assertEquals(searchAll.getCount(), new Integer(23));
        assertEquals(searchAll.getPage(), new Integer(34));
        assertTrue(searchAll.getHighlight());
        assertEquals(searchAll.getSort(), "Sort");
        assertEquals(searchAll.getSortDir(), "SortDir");
        assertEquals(searchAll.build(), "token=Token&query=Query&count=23&page=34&highlight=true&sort=Sort&sort_dir=SortDir");
    }
}
