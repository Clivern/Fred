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

public class MpimHistoryTest extends TestCase {

    public void testBuild() throws IOException
    {
        MpimHistory mpimHistory = new MpimHistory();
        mpimHistory.setToken("Token");
        mpimHistory.setChannel("Channel");
        mpimHistory.setCount(30);
        mpimHistory.setInclusive(true);
        mpimHistory.setLatest("Latest");
        mpimHistory.setOldest("Oldest");
        mpimHistory.setUnreads(false);
        assertEquals(mpimHistory.getToken(), "Token");
        assertEquals(mpimHistory.getChannel(), "Channel");
        assertEquals(mpimHistory.getCount(), new Integer(30));
        assertTrue(mpimHistory.getInclusive());
        assertEquals(mpimHistory.getLatest(), "Latest");
        assertEquals(mpimHistory.getOldest(), "Oldest");
        assertFalse(mpimHistory.getUnreads());
        assertEquals(mpimHistory.build(), "token=Token&channel=Channel&count=30&inclusive=true&latest=Latest&oldest=Oldest&unreads=false");
    }
}
