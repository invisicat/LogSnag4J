<div align="center">
<img src="https://logsnag.com/og-image.png" alt="LogSnag" title="LogSnag Logo"/>
<br />
<h1>LogSnag4J</h1>
<p>Get notifications and track your project events in Java.</p>
<a href="https://discord.gg/dY3pRxgWua"><img src="https://img.shields.io/discord/922560704454750245?color=%237289DA&label=Discord" alt="Discord"></a>
<a href="https://docs.logsnag.com"><img src="https://img.shields.io/badge/Docs-LogSnag" alt="Documentation"></a>
<a href="https://javadoc.io/doc/cc.ricecx/logsnag4j/latest/index.html"><img src="https://javadoc.io/badge2/cc.ricecx/logsnag4j/javadoc.svg" alt="javadocs"/></a>
<br />
<br />
</div>
<hr />


# Table of Contents
- [Adding LogSnag4J to your project](#adding-logsnag4j-to-your-project)
- [Requirements](#requirements)
- [Documentation](#documentation)
- [Usage](#usage)
- [License](#license)
- [Disclaimer](#disclaimer)

<hr />

## Adding LogSnag4J to your project
The FQCN of LogSnag4J is `cc.ricecx.logsnag4j`. It is available on [Maven Central](https://search.maven.org/artifact/cc.ricecx/logsnag4j).To add LogSnag4J to your project,
follow the instructions below for your specified build tool.

To add LogSnag4J to your Maven project, use the following:
```xml
<dependency>
    <groupId>cc.ricecx.logsnag4j</groupId>
    <artifactId>logsnag4j</artifactId>
    <version>1.1</version>
</dependency>
```

To add LogSnag4J to your Gradle project, use the following:

> Groovy
> 
```groovy
dependencies {
    compile 'cc.ricecx.logsnag4j:logsnag4j:1.1'
}
```

> Kotlin DSL
```kotlin

implementation("cc.ricecx.logsnag4j:logsnag4j:1.1")
```

## Requirements

Minimum Java version: Java 11

## Documentation

- [LogSnag Documentation](https://docs.logsnag.com)
- [LogSnag4J Javadocs TBA]()


## Usage
You can define a `LogSnag4J` instance in your application by using the following code:
```java

import cc.ricecx.logsnag4j.LogSnagClient;
import cc.ricecx.logsnag4j.Emoji;
import cc.ricecx.logsnag4j.LogSnagRequest;

public class Main {
    
    public void main(String[] args) {
        LogSnag logSnagClient = new LogSnagClient("your-api-key", "default-project");
        
        // Simply log a message by parameters
        logSnagClient.log("money-received", "paypal", "$100 has been received!", Emoji.of("💵"));
        
        // Or you can log a message by using a LogSnagRequest object
        LogSnagRequest logSnagRequest = new LogSnagRequest("money-received", "paypal", "$100 has been received!", Emoji.of("💵"));
        
        // You can either log by using the `log` method or by using the `sendRequest` method
        
        logSnagClient.log(logSnagRequest);
        // Or
        logSnagRequest.sendRequest(logSnagClient);
        
    }
}

```

## License
```asciidoc
MIT License

Copyright (c) 2022 RiceCX

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```

## Disclaimer

This is an unofficial wrapper for the LogSnag API. Thank you Shayan for creating LogSnag.