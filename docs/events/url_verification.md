### URL Verification Event

In order to Enable Events, Slack will ask you to provide a link and It will send HTTP POST requests to this URL when events occur.

As soon as you enter a URL, Slack will send a request with a challenge parameter, and your endpoint must respond with the challenge value.

Now Let's see how to create an Event Listener (URL Verification Event) to Pass Slack Confirmation Using [Spark Java Framework](http://sparkjava.com/).

```java
import static spark.Spark.*;
import java.util.HashMap;
import java.util.Map;
import com.clivern.fred.util.*;
import com.clivern.fred.sender.BaseSender;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.clivern.fred.receiver.BaseReceiver;
import com.clivern.fred.receiver.command.Command;
import com.clivern.fred.event.Listener;
import com.clivern.fred.event.type.UrlVerification;

public class Main {

    public static void main(String[] args) throws UnirestException
    {

        post("/events", (request, response) -> {
            Config config = new Config();
            config.loadPropertiesFile("config.properties");
            Log log = new Log(config);
            Listener listener = new Listener(config, log);
            listener.addEvent(Listener.URL_VERIFICATION_EVENT, new UrlVerification(et -> et.getChallenge()));
            return listener.callCurrentEvent(request.body());
        });
    }
}
```

If you need to know more about this event, [**Please Visit Slack Docs**](https://api.slack.com/events/url_verification).