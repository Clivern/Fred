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
package com.clivern.fred.receiver.command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.clivern.fred.config.Basic;
import com.clivern.fred.contract.receiver.command.CommandTemplate;

/**
 * App Defined Commands
 *
 * <a href="https://api.slack.com/slash-commands">For More Info</a>
 *
 * @author A.F
 * @since 1.0.0
 */
public class Command extends CommandTemplate {

    public Boolean parse()
    {
        return true;
    }

}