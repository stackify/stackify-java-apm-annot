# stackify-java-apm-annot

[![Maven Central](https://img.shields.io/maven-central/v/com.stackify/stackify-java-apm-annot.svg)](http://mvnrepository.com/artifact/com.stackify/stackify-java-apm-annot)
[![Build Status](https://travis-ci.org/stackify/stackify-java-apm-annot.png)](https://travis-ci.org/stackify/stackify-java-apm-annot)

@Trace Annotation for Stackify Java APM+

Stackify APM+ Overview:

http://support.stackify.com/hc/en-us/categories/200398749-APM-

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

Add custom instrumentation to classes using the @Trace annotation. The annotation needs to be added to the class and the method to be instrumented. This is an alternative to adding a custom configuration file (stackify-apm.json) to your application.

```
import com.stackify.apm.Trace;

@Trace
public class ClassToBeInstrumented 
{
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
    
    public void notInstrumented()
    {
        ...
    }
}
```

## License

Copyright 2016 Stackify, LLC.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
