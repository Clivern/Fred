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
package com.clivern.fred.util;

import java.util.HashMap;
import java.util.Map;
import java.io.IOException;
import java.lang.*;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Logger Utils Class
 *
 * @author A.F
 * @since 1.0.0
 */
public class Log {

    protected Logger log = Logger.getLogger(Log.class.getName());

    protected Handler consoleHandler;

    protected Handler fileHandler;

    protected Config config;

    /**
     * Constructor
     */
    public Log(Config config) throws IOException
    {
        this.config = config;
        this.config();
    }

    /**
     * Log Fine Messages
     *
     * @param message
     */
    public void fine(String message)
    {
        this.log.fine(message);
    }

    /**
     * Log Fine Messages
     *
     * @param message
     */
    public void finer(String message)
    {
        this.log.finer(message);
    }

    /**
     * Log Finest Messages
     *
     * @param message
     */
    public void finest(String message)
    {
        this.log.finest(message);
    }

    /**
     * Log Info Messages
     *
     * @param message
     */
    public void info(String message)
    {
        this.log.info(message);
    }

    /**
     * Log Severe Messages
     *
     * @param message
     */
    public void severe(String message)
    {
        this.log.severe(message);
    }

    /**
     * Log Warning Messages
     *
     * @param message
     */
    public void warning(String message)
    {
        this.log.warning(message);
    }

    /**
     * Close File Handler
     */
    public void close()
    {
        if( this.fileHandler != null ){
            this.fileHandler.close();
        }
    }

    /**
     * Configure Logger
     *
     * @throws IOException
     */
    protected void config() throws IOException
    {
        if( Boolean.parseBoolean(this.config.get("log_console_status", "false")) ){
            this.consoleHandler = new ConsoleHandler();
            this.log.addHandler(this.consoleHandler);
            if( this.config.get("log_console_level", "SEVERE").equals("ALL") ){
                this.consoleHandler.setLevel(Level.ALL);
            }else if( this.config.get("log_console_level", "SEVERE").equals("CONFIG") ){
                this.consoleHandler.setLevel(Level.CONFIG);
            }else if( this.config.get("log_console_level", "SEVERE").equals("FINE") ){
                this.consoleHandler.setLevel(Level.FINE);
            }else if( this.config.get("log_console_level", "SEVERE").equals("FINER") ){
                this.consoleHandler.setLevel(Level.FINER);
            }else if( this.config.get("log_console_level", "SEVERE").equals("FINEST") ){
                this.consoleHandler.setLevel(Level.FINEST);
            }else if( this.config.get("log_console_level", "SEVERE").equals("INFO") ){
                this.consoleHandler.setLevel(Level.INFO);
            }else if( this.config.get("log_console_level", "SEVERE").equals("OFF") ){
                this.consoleHandler.setLevel(Level.OFF);
            }else if( this.config.get("log_console_level", "SEVERE").equals("SEVERE") ){
                this.consoleHandler.setLevel(Level.SEVERE);
            }else if( this.config.get("log_console_level", "SEVERE").equals("WARNING") ){
                this.consoleHandler.setLevel(Level.WARNING);
            }
        }

        if( Boolean.parseBoolean(this.config.get("log_file_status", "false")) ){
            this.fileHandler  = new FileHandler(this.config.get("log_file_path", "src/main/java/resources/app.log"),
                Integer.parseInt(this.config.get("log_file_limit", "1")),
                Integer.parseInt(this.config.get("log_file_count", "200000")),
                Boolean.parseBoolean(this.config.get("log_file_append", "true"))
            );
            this.log.addHandler(this.fileHandler);
            if( this.config.get("log_file_level", "SEVERE").equals("ALL") ){
                this.fileHandler.setLevel(Level.ALL);
            }else if( this.config.get("log_file_level", "SEVERE").equals("CONFIG") ){
                this.fileHandler.setLevel(Level.CONFIG);
            }else if( this.config.get("log_file_level", "SEVERE").equals("FINE") ){
                this.fileHandler.setLevel(Level.FINE);
            }else if( this.config.get("log_file_level", "SEVERE").equals("FINER") ){
                this.fileHandler.setLevel(Level.FINER);
            }else if( this.config.get("log_file_level", "SEVERE").equals("FINEST") ){
                this.fileHandler.setLevel(Level.FINEST);
            }else if( this.config.get("log_file_level", "SEVERE").equals("INFO") ){
                this.fileHandler.setLevel(Level.INFO);
            }else if( this.config.get("log_file_level", "SEVERE").equals("OFF") ){
                this.fileHandler.setLevel(Level.OFF);
            }else if( this.config.get("log_file_level", "SEVERE").equals("SEVERE") ){
                this.fileHandler.setLevel(Level.SEVERE);
            }else if( this.config.get("log_file_level", "SEVERE").equals("WARNING") ){
                this.fileHandler.setLevel(Level.WARNING);
            }
        }
    }
}