/*
 * Copyright 2016 Stackify
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.stackify.apm;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Trace Annotation for Stackify Java APM+
 * <p>
 * Add custom instrumentation to classes using the @Trace annotation. The annotation
 * needs to be added to the class and the method to be instrumented. This is an
 * alternative to adding a custom configuration file (stackify-apm.json) to your
 * application.
 * <p>
 * <pre>
 * <code>
 * import com.stackify.apm.Trace;
 *
 * {@literal @}Trace
 * public class ClassToBeInstrumented
 * {
 *     {@literal @}Trace
 *     public void methodToBeInstrumented()
 *     {
 *         ...
 *     }
 *
 *     {@literal @}Trace
 *     public void anotherMethodToBeInstrumented()
 *     {
 *         ...
 *     }
 *
 *     {@literal @}Trace(trackedFunction = true, trackedFunctionName = "Function Identifier")
 *     public void anotherMethodToBeInstrumentedAndMarkedAsTrackedFunction()
 *     {
 *         ...
 *     }
 *
 *     {@literal @}Trace(trackedFunction = true, trackedFunctionName = "Tracked Function {{ClassName}} - {{MethodParameters[0]}}")
 *     public void anotherMethodToBeInstrumentedAndMarkedAsTrackedFunctionVariable(String value)
 *     {
 *          ...
 *     }
 *
 *     public void notInstrumented()
 *     {
 *         ...
 *     }
 * }
 * </code>
 * </pre>
 *
 * @author Eric Martin
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {ElementType.TYPE, ElementType.METHOD})
public @interface Trace {

    boolean trackedFunction() default false;

    String trackedFunctionName() default "";

}
