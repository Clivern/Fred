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
package com.clivern.fred;

import junit.framework.TestCase;
import java.io.IOException;

public class BotPlatformTest extends TestCase {

    public void testGetName() throws IOException
    {
        BotPlatform bp = new BotPlatform("src/main/java/resources/test_config.properties");
        assertEquals(bp.getName(), "Fred");
    }
}