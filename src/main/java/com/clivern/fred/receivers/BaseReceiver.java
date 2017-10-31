/*
 * Copyright (C) 2017 A.F <http://clivern.com>
 *
 * Licensed under the MIT License; you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * https://github.com/Clivern/Fred/blob/master/LICENSE
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.clivern.fred.receivers;

import java.util.HashMap;
import java.util.Map;
import com.clivern.fred.utils.Config;
import com.clivern.fred.utils.Log;
import org.json.JSONObject;
import org.json.JSONArray;

/**
 * Base Receiver Class
 */
public class BaseReceiver {

    protected Config configs;

    protected Log log;


    /**
     * Class Constructor
     *
     * @param configs
     * @param log
     */
    public BaseReceiver(Config configs, Log log)
    {
        this.configs = configs;
        this.log = log;
    }
}