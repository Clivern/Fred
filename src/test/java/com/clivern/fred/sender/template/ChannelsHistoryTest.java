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

public class ChannelsHistoryTest extends TestCase {

    public void testBuild() throws IOException
    {
        ChannelsHistory channelsHistory = new ChannelsHistory();
        channelsHistory.setToken("Token");
        channelsHistory.setChannel("Channel");
        channelsHistory.setCount(20);
        channelsHistory.setInclusive(true);
        channelsHistory.setLatest("Latest");
        channelsHistory.setOldest("Oldest");
        channelsHistory.setUnreads(false);
        assertEquals(channelsHistory.getToken(), "Token");
        assertEquals(channelsHistory.getChannel(), "Channel");
        assertEquals(channelsHistory.getCount(), new Integer(20));
        assertTrue(channelsHistory.getInclusive());
        assertEquals(channelsHistory.getLatest(), "Latest");
        assertEquals(channelsHistory.getOldest(), "Oldest");
        assertFalse(channelsHistory.getUnreads());
        assertEquals(channelsHistory.build(), "token=Token&channel=Channel&count=20&inclusive=true&latest=Latest&oldest=Oldest&unreads=false");
    }
}
