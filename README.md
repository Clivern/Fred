Fred
====

Fred is a Java Framework for Building Slack Bots.

*Current Version: Under Development*

[![Build Status](https://travis-ci.org/Clivern/Fred.svg?branch=master)](https://travis-ci.org/Clivern/Fred)
![](https://img.shields.io/github/license/clivern/fred.svg)


Installation
------------
To add a dependency using Maven, use the following:
```xml
<dependency>
  <groupId>com.clivern</groupId>
  <artifactId>fred</artifactId>
  <version>1.0.0-SNAPSHOT</version>
</dependency>
```

To add a dependency using Gradle, use the following:
```java
dependencies {
  compile 'com.clivern:fred:1.0.0-SNAPSHOT'
}
```

To add a dependency using Scala SBT, use the following:
```java
libraryDependencies += "com.clivern" % "fred" % "1.0.0-SNAPSHOT"
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

Todo
====

:rocket: Web API `/com/clivern/fred/sender`

:rocket: Slash Commands `/com/clivern/fred/receiver`

:rocket: Events API `/com/clivern/fred/event`


Misc
====

Tutorials & Examples
--------------------

> For almost all supported features you can take a look at [`examples/`](https://github.com/Clivern/Fred/tree/master/examples) folder for working examples.

Changelog
---------

Version 1.0.0:
```
Coming Soon
```

Acknowledgements
----------------

© 2017, Clivern. Released under [The Apache Software License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.txt).

**Fred** is authored and maintained by [@clivern](http://github.com/clivern).