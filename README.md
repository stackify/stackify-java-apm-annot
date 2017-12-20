# stackify-java-apm-annot

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.stackify/stackify-java-apm-annot/badge.svg)](http://mvnrepository.com/artifact/com.stackify/stackify-java-apm-annot)
[![Build Status](https://travis-ci.org/stackify/stackify-java-apm-annot.png)](https://travis-ci.org/stackify/stackify-java-apm-annot)

@Trace Annotation for Stackify Java APM+

Stackify APM+ Overview:

http://support.stackify.com/agent-installation-overview/

Sign Up for a Trial:

http://www.stackify.com/sign-up/

## Installation

Add it as a maven dependency:
```xml
<dependency>
    <groupId>com.stackify</groupId>
    <artifactId>stackify-java-apm-annot</artifactId>
    <version>INSERT_LATEST_MAVEN_CENTRAL_VERSION</version>
</dependency>
```

## Usage

Add custom instrumentation to classes using the @Trace annotation. The annotation needs to be added to
the class and the method to be instrumented. This is an alternative to adding a custom configuration
file (stackify-apm.json) to your application.


#### Tracked Functions
* **trackedFunction**  marks a specific method as a tracked function.
* **trackedFunctionName** gives control over how the tracked function will be identified in the dashboard. The function
name can be a `String` and can also include the variables `{{ClassName}}`, `{{MethodName}}` and `{{MethodParameters[#]}}`
(where `#` is an `int` referencing the parameter index on the annotated method, index starts at 0).

#### Custom Trace Entry Point
Stackify by default generates traces from web-requests on [supported application servers](http://support.stackify.com/hc/en-us/articles/209709913-What-Java-Application-Containers-and-Frameworks-are-Supported-) 
and non-web-requests from [supported frameworks](http://support.stackify.com/hc/en-us/articles/209709913-What-Java-Application-Containers-and-Frameworks-are-Supported-).
You can extend support by using `@Trace(start = true)` on a method; which will start a new trace. 

```
import com.stackify.apm.Trace;

@Trace
public class ClassToBeInstrumented 
{

    @Trace(start = true)
    public void methodToStartNewTrace()
    {
        ...
    }

    @Trace
    public void methodToBeInstrumented()
    {
        ...
    }
    
    @Trace
    public void anotherMethodToBeInstrumented()
    {
        ...
    }

    @Trace(trackedFunction = true, trackedFunctionName = "Tracked Function Identifier")
    public void anotherMethodToBeInstrumentedAndMarkedAsTrackedFunction()
    {
        ...
    }

    @Trace(trackedFunction = true, trackedFunctionName = "Tracked Function {{ClassName}} - {{MethodParameters[0]}}")
    public void anotherMethodToBeInstrumentedAndMarkedAsTrackedFunctionVariable(String value)
    {
        ...
    }

    public void notInstrumented()
    {
        ...
    }
}
```

## License

Copyright 2017 Stackify, LLC.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
