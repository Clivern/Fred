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

public class RtmStartTest extends TestCase {

    public void testBuild() throws IOException
    {
        RtmStart rtmStart = new RtmStart();
        rtmStart.setToken("Token");
        rtmStart.setBatchPresenceAware(50);
        rtmStart.setNoLatest(60);
        rtmStart.setIncludeLocale(true);
        rtmStart.setMpimAware(false);
        rtmStart.setNoUnreads(true);
        rtmStart.setSimpleLatest(false);
        assertEquals(rtmStart.getToken(), "Token");
        assertEquals(rtmStart.getBatchPresenceAware(), new Integer(50));
        assertEquals(rtmStart.getNoLatest(), new Integer(60));
        assertTrue(rtmStart.getIncludeLocale());
        assertFalse(rtmStart.getMpimAware());
        assertTrue(rtmStart.getNoUnreads());
        assertFalse(rtmStart.getSimpleLatest());
        assertEquals(rtmStart.build(), "token=Token&batch_presence_aware=50&no_latest=60&include_locale=true&mpim_aware=false&no_unreads=true&simple_latest=false");
    }
}
