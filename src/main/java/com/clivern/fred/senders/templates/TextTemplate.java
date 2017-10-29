/*
 * Copyright (C) 2017 Clivern. <https://clivern.com>
 */
package com.clivern.fred.senders.templates;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Text Template Class
 */
public class TextTemplate {

    /*
        curl -X POST -H 'Content-type: application/json' --data '{
            "text": "New comic book alert! _The Further Adventures of Slackbot_, Volume 1, Issue 3."
        }' https://hooks.slack.com/services/T00000000/B0000000000/XXXXXXXXXXXX


        curl -X POST -H 'Content-type: application/json' --data '{
            "text":"This is a line of text.\nAnd this is another one."
        }' https://hooks.slack.com/services/T00000000/B0000000000/XXXXXXXXXXXX

        curl -X POST -H 'Content-type: application/json' --data '{
            "text":"After @episod pushed exciting changes to a devious new branch back in Issue 1, Slackbot notifies @don about an unexpected deploy..."
        }' https://hooks.slack.com/services/T00000000/B0000000000/XXXXXXXXXXXX


        curl -X POST -H 'Content-type: application/json' --data '{
            "text": "```\n{Code Block}\n```"
        }' https://hooks.slack.com/services/T00000000/B0000000000/XXXXXXXXXXXX


        curl -X POST -H 'Content-type: application/json' --data '{
            "text":"We should be concerned if the variable value for `radioactive` is `true`."
        }' https://hooks.slack.com/services/T00000000/B0000000000/XXXXXXXXXXXX


        curl -X POST -H 'Content-type: application/json' --data '{
            "text":"The spent cents are tails\nI will never see wag again"
        }' https://hooks.slack.com/services/T00000000/B0000000000/XXXXXXXXXXXX


        curl -X POST -H 'Content-type: application/json' --data '{
            "text":"My _spidey sense_ tells me I will have to skip lunch today."
        }' https://hooks.slack.com/services/T00000000/B0000000000/XXXXXXXXXXXX
    */

    protected String url;
    protected String body;

    /**
     * Set URL
     *
     * @param  url
     */
    public String setURL(String url)
    {
        this.url = url;
    }

    /**
     * Set Message Body
     *
     * @param  body
     */
    public String setBody(String body)
    {
        this.body = body;
    }

    /**
     * Get URL
     *
     * @return String
     */
    public String getURL()
    {
        return this.url;
    }

    /**
     * Get Body
     *
     * @return String
     */
    public String getBody()
    {
        return this.body;
    }

    /**
     * Build Message Body
     */
    public Boolean build()
    {
        this.body = "";
    }
}