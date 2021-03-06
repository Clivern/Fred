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

public class ImHistoryTest extends TestCase {

    public void testBuild() throws IOException
    {
        ImHistory imHistory = new ImHistory();
        imHistory.setToken("Token");
        imHistory.setChannel("Channel");
        imHistory.setCount(70);
        imHistory.setInclusive(true);
        imHistory.setLatest("Latest");
        imHistory.setOldest("Oldest");
        imHistory.setUnreads(false);
        assertEquals(imHistory.getToken(), "Token");
        assertEquals(imHistory.getChannel(), "Channel");
        assertEquals(imHistory.getCount(), new Integer(70));
        assertTrue(imHistory.getInclusive());
        assertEquals(imHistory.getLatest(), "Latest");
        assertEquals(imHistory.getOldest(), "Oldest");
        assertFalse(imHistory.getUnreads());
        assertEquals(imHistory.build(), "token=Token&channel=Channel&count=70&inclusive=true&latest=Latest&oldest=Oldest&unreads=false");
    }
}
