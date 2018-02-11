Fred
====

Fred is a Java Framework for Building Slack Bots.

*Current Version: 1.0.1*

[![Build Status](https://travis-ci.org/Clivern/Fred.svg?branch=master)](https://travis-ci.org/Clivern/Fred)
![](https://img.shields.io/maven-central/v/com.clivern/fred.svg)
[![Javadocs](http://www.javadoc.io/badge/com.clivern/fred.svg)](http://www.javadoc.io/doc/com.clivern/fred)
![](https://img.shields.io/github/license/clivern/fred.svg)

Installation
------------
To add a dependency using Maven, use the following:
```xml
<dependency>
  <groupId>com.clivern</groupId>
  <artifactId>fred</artifactId>
  <version>1.0.1</version>
</dependency>
```

To add a dependency using Gradle, use the following:
```java
dependencies {
  compile 'com.clivern:fred:1.0.1'
}
```

To add a dependency using Scala SBT, use the following:
```java
libraryDependencies += "com.clivern" % "fred" % "1.0.1"
```

Usage
-----
After adding the package as a dependency, Please read the following steps:

### Basic Configurations

In order to cofigure the package create `config.properties` file with the following data

```java
client_id=Application Client ID
client_secret=Application Client Secret
scope=Application Scope
redirect_uri=Oauth Secured URL
state_type=State Type (for example. vary)
state=State Key
team=Slack Team Name
verification_token=Verification Token Goes Here

log_console_status=true or false
log_console_level=ALL, CONFIG, FINE, FINER, FINEST, INFO, SEVERE, WARNING or OFF
log_file_status=true or false
log_file_level=ALL, CONFIG, FINE, FINER, FINEST, INFO, SEVERE, WARNING or OFF
log_file_path=app.log
log_file_limit=1
log_file_count=200000
log_file_append=true or false
```

### Build Oauth Redirect URL

Create a route to return the Oauth redirect URL like the following:

```java
import com.clivern.fred.util.*;
import com.mashape.unirest.http.exceptions.UnirestException;


Config config = new Config();
config.loadPropertiesFile("config.properties");
Log log = new Log(config);
Oauth oauth = new Oauth(config, log);
return "<a href='" + oauth.getRedirectURL() + "'>Auth</a>";
```

So let's say we use [Spark Java Framework](http://sparkjava.com/) for our bot, Our route and callback will look like the following:

```java
import static spark.Spark.*;
import com.clivern.fred.util.*;
import com.mashape.unirest.http.exceptions.UnirestException;

public class Main {

    public static void main(String[] args) throws UnirestException
    {
        get("/", (request, response) -> {
            Config config = new Config();
            config.loadPropertiesFile("config.properties");
            Log log = new Log(config);
            Oauth oauth = new Oauth(config, log);
            return "<a href='" + oauth.getRedirectURL() + "'>Auth</a>";
        });
    }
}
```

### Build Oauth Webhook

In order to verify the incoming user token and fetch the access token for that user, We will build and a route that do these tasks and we already provided this URL in the `config.properties` file as `redirect_uri`:

```java
import static spark.Spark.*;
import com.clivern.fred.util.*;
import com.mashape.unirest.http.exceptions.UnirestException;



String code = // Get code query parameter value from the current URL
String state = // Get state query parameter value from the current URL
String error = // Get error query parameter value from the current URL

Config config = new Config();
config.loadPropertiesFile("config.properties");
Log log = new Log(config);
Oauth oauth = new Oauth(config, log);

Boolean status = oauth.issueToken(code, state, error);

Boolean fetch = oauth.fetchAccessToken();

if( status && fetch ){

    return  "State: " +  oauth.getState() + "<br/>" +
            "Client ID: " +  oauth.getClientId() + "<br/>" +
            "Client Secret: " +  oauth.getClientSecret() + "<br/>" +
            "Scope: " +  oauth.getScope() + "<br/>" +
            "Redirect Uri: " +  oauth.getRedirectUri() + "<br/>" +
            "State Type: " +  oauth.getStateType() + "<br/>" +
            "Team: " +  oauth.getTeam() + "<br/>" +
            "Incoming Code: " +  oauth.getIncomingCode() + "<br/>" +
            "Incoming State: " +  oauth.getIncomingState() + "<br/>" +
            "Incoming Error: " +  oauth.getIncomingError() + "<br/>" +
            "Incoming Access Token: " +  oauth.getIncomingAccessToken() + "<br/>" +
            "Incoming Scope: " +  oauth.getIncomingScope() + "<br/>" +
            "Incoming User ID: " +  oauth.getIncomingUserId() + "<br/>" +
            "Incoming Team Name: " +  oauth.getIncomingTeamName() + "<br/>" +
            "Incoming Team ID: " +  oauth.getIncomingTeamId() + "<br/>" +
            "Incoming Webhook URL: " +  oauth.getIncomingWebhookUrl() + "<br/>" +
            "Incoming Webhook Channel: " +  oauth.getIncomingWebhookChannel() + "<br/>" +
            "Incoming Webhook Config URL: " +  oauth.getIncomingWebhookConfigUrl() + "<br/>" +
            "Incoming Bot User ID: " +  oauth.getIncomingBotUserId() + "<br/>" +
            "Incoming Bot Access Token: " +  oauth.getIncomingBotAccessToken() + "<br/>";

}else{

    return "Error";

}
```

So let's say we use [Spark Java Framework](http://sparkjava.com/) for our bot, Our route and callback will look like the following:

```java
import static spark.Spark.*;
import com.clivern.fred.util.*;
import com.mashape.unirest.http.exceptions.UnirestException;


public class Main {

    public static void main(String[] args) throws UnirestException
    {
        get("/", (request, response) -> {
            Config config = new Config();
            config.loadPropertiesFile("config.properties");
            Log log = new Log(config);
            Oauth oauth = new Oauth(config, log);
            return "<a href='" + oauth.getRedirectURL() + "'>Auth</a>";
        });

        get("/oauth", (request, response) -> {
            Config config = new Config();
            config.loadPropertiesFile("config.properties");
            Log log = new Log(config);
            Oauth oauth = new Oauth(config, log);

            Boolean status = oauth.issueToken(
                ( request.queryParams("code") != null ) ? request.queryParams("code") : "",
                ( request.queryParams("state") != null ) ? request.queryParams("state") : "",
                ( request.queryParams("error") != null ) ? request.queryParams("error") : ""
            );

            Boolean fetch = oauth.fetchAccessToken();

            if( status && fetch ){

                return  "State: " +  oauth.getState() + "<br/>" +
                        "Client ID: " +  oauth.getClientId() + "<br/>" +
                        "Client Secret: " +  oauth.getClientSecret() + "<br/>" +
                        "Scope: " +  oauth.getScope() + "<br/>" +
                        "Redirect Uri: " +  oauth.getRedirectUri() + "<br/>" +
                        "State Type: " +  oauth.getStateType() + "<br/>" +
                        "Team: " +  oauth.getTeam() + "<br/>" +
                        "Incoming Code: " +  oauth.getIncomingCode() + "<br/>" +
                        "Incoming State: " +  oauth.getIncomingState() + "<br/>" +
                        "Incoming Error: " +  oauth.getIncomingError() + "<br/>" +
                        "Incoming Access Token: " +  oauth.getIncomingAccessToken() + "<br/>" +
                        "Incoming Scope: " +  oauth.getIncomingScope() + "<br/>" +
                        "Incoming User ID: " +  oauth.getIncomingUserId() + "<br/>" +
                        "Incoming Team Name: " +  oauth.getIncomingTeamName() + "<br/>" +
                        "Incoming Team ID: " +  oauth.getIncomingTeamId() + "<br/>" +
                        "Incoming Webhook URL: " +  oauth.getIncomingWebhookUrl() + "<br/>" +
                        "Incoming Webhook Channel: " +  oauth.getIncomingWebhookChannel() + "<br/>" +
                        "Incoming Webhook Config URL: " +  oauth.getIncomingWebhookConfigUrl() + "<br/>" +
                        "Incoming Bot User ID: " +  oauth.getIncomingBotUserId() + "<br/>" +
                        "Incoming Bot Access Token: " +  oauth.getIncomingBotAccessToken() + "<br/>";

            }else{

                return "Error";

            }
        });
    }
}
```

### Build Slash Commands

Slash Command enable users to interact with your app from within Slack. We will have two tasks to do:

1. First to Create the Commnad on Slack Application and Configure its `Request URL` (The URL that slack will POST the command data once used by any user).
2. Build a New Route (Accept POST Requests) to handle all Incoming Requests from Slack.

So Lets Start by the Easy Part `Creating Commands On Slack App`:

1. Please visit [Your Apps Page from Slack.](https://api.slack.com/apps)
2. Open You App Settings Page (By clicking on the App).
3. Go to `Slash Commands` From Side Menu Under `Features`.
4. Then Click to `Create New Command`. A Command Form Will Open To be Filled.
5. Set the Commnad for example `/fred`.
6. Set `Request URL` to you Application URL Handling Slack Commands for example `https://b2f78bbb.ngrok.io/commands`.
7. Set Short Description for example `Launch The Rocket!`.
8. Set Usage Hint
9. And Finally Set to `Escape channels, users, and links sent to your app` or Not and Click `Save`.


Then Let's Build `Our Route` That will Accept and Process All Incoming Requests from Slack for example `https://b2f78bbb.ngrok.io/commands`. Our route and callback will look like the following Using [Spark Java Framework](http://sparkjava.com/):

```java
import static spark.Spark.*;
import java.util.HashMap;
import java.util.Map;
import com.clivern.fred.util.*;
import com.clivern.fred.sender.BaseSender;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.clivern.fred.receiver.BaseReceiver;
import com.clivern.fred.receiver.command.Command;


public class Main {

    public static void main(String[] args) throws UnirestException
    {

        post("/commands", (request, response) -> {
            Config config = new Config();
            config.loadPropertiesFile("config.properties");
            Log log = new Log(config);
            BaseReceiver baseReceiver = new BaseReceiver(config, log);

            // Build Our First Command (/fred Command)
            Command fredCommand = new Command("/fred", false, (ct) -> "You Typed -> " + ct.getText() + " To /fred");

            // Build Another Command (/frog Command)
            Command frogCommand = new Command("/frog", false, (ct) -> "You Typed -> " + ct.getText() + " To /frog");

            // Pass Commands To The Receiver
            baseReceiver.setCommand("/fred", fredCommand);
            baseReceiver.setCommand("/frog", frogCommand);

            // Check If Incoming Data Related to Any Configured Command (/fred or /frog)
            if( baseReceiver.commandExists(request.queryParams("command")) ){
                Map<String, String> incomingData = new HashMap<String, String>();
                incomingData.put("channel_name", request.queryParams("channel_name"));
                incomingData.put("user_id", request.queryParams("user_id"));
                incomingData.put("user_name", request.queryParams("user_name"));
                incomingData.put("trigger_id", request.queryParams("trigger_id"));
                incomingData.put("team_domain", request.queryParams("team_domain"));
                incomingData.put("team_id", request.queryParams("team_id"));
                incomingData.put("text", request.queryParams("text"));
                incomingData.put("channel_id", request.queryParams("channel_id"));
                incomingData.put("command", request.queryParams("command"));
                incomingData.put("token", request.queryParams("token"));
                incomingData.put("response_url", request.queryParams("response_url"));

                return baseReceiver.callCurrentCommand(request.queryParams("command"), incomingData);
            }
            return "Command Not Configured In App!";
        });
    }
}
```

Now You Finished, Just go to Slack Messaging and Interact With You Commands. Type `/fred Hello World` and You will Get `You Typed -> Hello World To /fred`.

### Listen To Slack Events

Slack Event API allows your app to be notified of events in Slack (for example, when a user adds a reaction or creates a file) at a URL you choose.

Let's discuss how to implement this using `Fred`.

- [URL Verification Event](docs/events/url_verification.md).


Misc
====

Todo & Contributing
-------------------
In case you want to share some love, Show your awesomeness in the following sub-packages:

- :rocket: ~~Config and Oauth `com.clivern.fred.util`.~~
- :rocket: ~~Slash Commands `com.clivern.fred.receiver`.~~
- :fire: Web API `com.clivern.fred.sender`.
- :fire: Events API `com.clivern.fred.event`.
- :rocket: Add More Test Cases.
- :rocket: Add More Docs.
- :rocket: Update and Fix Code Docs and Remove Line `32-38` in `maven-push.gradle`.
- :rocket: Add Examples & Write Tutorials.

And then please do the following:

- Fork the master branch.
- Create a feature branch `git branch my-feature`.
- Move to your branch `git checkout my-feature`.
- Do Your Changes.
- It will be great if you write some tests to your feature and check `./gradlew test` but not required ;).
- Track the changes `git add --all`.
- Commit your changes `git commit -m 'new awesome feature'`.
- Push to your newly created branch `git push origin my-feature`.
- Create a new Pull Request.

Tutorials & Examples
--------------------

> For almost all supported features you can take a look at [`examples/`](https://github.com/Clivern/Fred/tree/master/examples) folder for working examples.

Changelog
---------

Version 1.0.1:
```
Add Java 8 Support.
```

Version 1.0.0:
```
Initial Release.
```

Acknowledgements
----------------

© 2017, Clivern. Released under [The Apache Software License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.txt).

**Fred** is authored and maintained by [@clivern](http://github.com/clivern).