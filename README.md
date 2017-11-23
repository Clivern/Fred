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

```
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
import com.clivern.fred.sender.BaseSender;
import com.clivern.fred.sender.template.RemindersAdd;
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