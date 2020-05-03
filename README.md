# Using Dagger in your Android app

This folder contains the source code for the "Using Dagger in your Android app" codelab


# Introduction
Dependency injection is a technique widely used in programming and well suited
to Android development. By following the principles of dependency injection, you
lay the groundwork for a good app architecture.

Implementing dependency injection provides you with the following advantages:
* Reusability of code.
* Ease of refactoring.
* Ease of testing.

# Notes
1. Start with using @Inject constructor()

2. Go for field injection and write AppComponent interface so that Dagger can build a dependency graph at compile-time

A @Component interface gives the information Dagger needs to generate the graph at compile-time. The parameter of the interface methods define what classes request injection.

3. Object of interfaces are injected using @Binds annotation ( we need to write modules for that )

 A Dagger Module is a class that is annotated with @Module. There, you can define how to provide dependencies with the @Provides or @Binds annotations.
 Use @Binds on function inside module class tell Dagger which implementation it needs to use when providing an interface.
 Function providing object of interface will take the class ( which is impl the interface ) as parameter 

Next step is include module into AppComponent so that Dagger builds a graph at compile time to satisfy interface dependency

@BindsInstance annotation is used for objects which is outside of graph such as objects provided by android framework e.g. Context

@Component.Factory is used to annotate factory interface e.g factory for AppComponent


Now, we need to inject application graph into activity which requests injection

Note: Dagger doesn't support field injection for private member variables

Scoping: @Singleton is the only scope which comes with javax.inject package. if we want the same object everytime it's requested from dagger, we need to

1. Use @Singleton annotation at AppComponent interface i.e. annotate application graph to support Singleton pattern
2. Use @Singleton annotation at object creation which we want to scope i.e. places such as @Inject contructor(...) or @Provides


Important - Best practices

An Activity injects Dagger in the onCreate method before calling super.

A Fragment injects Dagger in the onAttach method after calling super.


SubComponents:
Subcomponents are components that inherit and extend the object graph of a parent component (e.g appComponent). Thus, all objects provided in the parent component will be provided in the subcomponent too. In this way, an object from a subcomponent can depend on an object provided by the parent component.

These are used e.g. when we want to scope videmodel to an activity rather than application


@SubComponent annotation is used to notify Dagger that this is a Subcomponent

There are two different ways to interact with the Dagger graph:

Declaring a function that returns Unit and takes a class as a parameter allows field injection in that class (e.g. fun inject(activity: MainActivity)).
Declaring a function that returns a type allows retrieving types from the graph (e.g. fun registrationComponent(): RegistrationComponent.Factory).

Scoping subcomponets: Since we have already used Singleton scope, we can create custom scope such as Activity scope which is tied to lifecycle of the activity
using Activity scope with RegistrationComponent and Registration viewmodel ensures that same instance of registration viewmodel is used for Registration activity and it's fragments. 
Also, a new instance is used when registration activity is re-created.



# License

```
Copyright 2019 Google LLC

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    https://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
