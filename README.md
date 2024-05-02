
| CS-665       | Software Design & Patterns |
|--------------|----------------------------|
| Name         | Mukul Jangid               |
| Date         | 04/12/2024                 |
| Course       | Spring                     |
| Assignment # | 6                          |

# Assignment Overview
The Delivery System is a Java-based application designed for a collaborative environment involving 
a collection of retailers and local drivers to efficiently manage the delivery of products to 
customer destinations. This system allowsshops to create delivery requests which are then broadcasted
 to all subscribed drivers, ensuring that delivery operations are streamlined and efficient.


# GitHub Repository Link:
https://github.com/mkljngd/CS665-Assignment-6


# Improvements

### 1. **Implementation of Observer and Observable Interfaces**

**Improvement:** Both `Driver` and `Shop` were updated to adhere to formally defined `Observer` and `Observable` interfaces. `Driver` implements the `Observer` interface, responding to updates (notifications about delivery requests), while `Shop` implements the `Observable` interface, managing a list of observers (drivers) and notifying them of changes.

**Significance:** This formal adherence to the Observer design pattern through explicit interfaces enhances the decoupling between the shop (subject) and drivers (observers). This separation of concerns ensures that each component only knows as much as it needs to about the other, making the codebase easier to manage, extend, and maintain. It also makes the interaction between components predictable and organized, facilitating easier testing and debugging.

### 2. **Direct Notification from Shop to Drivers**

**Improvement:** The `Shop` class is now an `Observable`, directly managing its list of `Observers` (drivers). This change allows the `Shop` to notify `Driver` instances directly about new delivery requests, eliminating the need for an intermediary like the `NotificationService` in direct notification scenarios.

**Significance:** This modification aligns the software design more closely with real-world business processes where a shop would directly contact drivers for deliveries. It simplifies the flow of information and reduces the complexity of the system, making it easier to understand and maintain. Moreover, it allows for a more natural extension in scenarios where different types of notifications are needed, as `Shop` now fully controls its notification logic.

### 3. **Introduction of Proper Logging**

**Improvement:** The system now uses Java’s built-in logging framework (`java.util.logging`) instead of `System.out.println()` for outputting information. This change introduces different levels of logging (INFO, WARNING, etc.), which can be configured to show or hide based on the deployment environment (development, testing, production).

**Significance:** Using a logging framework provides a more flexible and powerful way to handle output, facilitating easier debugging and monitoring of the system’s operation. Logs can be directed to various outputs (like files, network, console) and can be formatted or filtered according to the needs of the system administrators or developers. This makes the application more suitable for professional environments and practical usage.

### 4. **Error Handling and Validation**

**Improvement:** Input validation and error handling were added to ensure that null references or invalid states do not lead to runtime errors. For instance, the `subscribe` method in both `Shop` and `NotificationService` now checks for null observers before adding them to the observer list.

**Significance:** Robust error handling prevents the application from crashing unexpectedly and helps maintain stable operation under various conditions. By checking for invalid inputs, the system guards against corrupt data states and provides more informative error messages, improving the developer’s ability to diagnose issues and the user’s understanding of what went wrong.

### 5. **Maintaining Notification Service for Future Extensibility**

**Improvement:** Although the `NotificationService` is somewhat redundant in the current scenario, keeping it allows for future extensions where different types of observables or more complex notification systems might be required.

**Significance:** This foresight in design ensures that the system can evolve without major rewrites. If the business requirements change or expand to include different types of notifications (like promotions or alerts separate from delivery requests), the `NotificationService` can be enhanced or repurposed effectively.




## Design Pattern
The application implements the Observer Design Pattern, which is evident in the relationship between the 
NotificationService (subject) and Drivers (observers). This pattern provides a robust framework where subjects notify 
observers about state changes without the observers needing to poll the subjects for updates. The use of this pattern
enhances the system's flexibility and extensibility, as new observers can be conveniently added or removed.


# Maven Commands

We'll use Apache Maven to compile and run this project. You'll need to install Apache Maven (https://maven.apache.org/) on your system. 

Apache Maven is a build automation tool and a project management tool for Java-based projects. Maven provides a standardized way to build, package, and deploy Java applications.

Maven uses a Project Object Model (POM) file to manage the build process and its dependencies. The POM file contains information about the project, such as its dependencies, the build configuration, and the plugins used for building and packaging the project.

Maven provides a centralized repository for storing and accessing dependencies, which makes it easier to manage the dependencies of a project. It also provides a standardized way to build and deploy projects, which helps to ensure that builds are consistent and repeatable.

Maven also integrates with other development tools, such as IDEs and continuous integration systems, making it easier to use as part of a development workflow.

Maven provides a large number of plugins for various tasks, such as compiling code, running tests, generating reports, and creating JAR files. This makes it a versatile tool that can be used for many different types of Java projects.

## Compile
Type on the command line: 

```bash
mvn clean compile
```



## JUnit Tests
JUnit is a popular testing framework for Java. JUnit tests are automated tests that are written to verify that the behavior of a piece of code is as expected.

In JUnit, tests are written as methods within a test class. Each test method tests a specific aspect of the code and is annotated with the @Test annotation. JUnit provides a range of assertions that can be used to verify the behavior of the code being tested.

JUnit tests are executed automatically and the results of the tests are reported. This allows developers to quickly and easily check if their code is working as expected, and make any necessary changes to fix any issues that are found.

The use of JUnit tests is an important part of Test-Driven Development (TDD), where tests are written before the code they are testing is written. This helps to ensure that the code is written in a way that is easily testable and that all required functionality is covered by tests.

JUnit tests can be run as part of a continuous integration pipeline, where tests are automatically run every time changes are made to the code. This helps to catch any issues as soon as they are introduced, reducing the need for manual testing and making it easier to ensure that the code is always in a releasable state.

To run, use the following command:
```bash
mvn clean test
```


## Spotbugs 

SpotBugs is a static code analysis tool for Java that detects potential bugs in your code. It is an open-source tool that can be used as a standalone application or integrated into development tools such as Eclipse, IntelliJ, and Gradle.

SpotBugs performs an analysis of the bytecode generated from your Java source code and reports on any potential problems or issues that it finds. This includes things like null pointer exceptions, resource leaks, misused collections, and other common bugs.

The tool uses data flow analysis to examine the behavior of the code and detect issues that might not be immediately obvious from just reading the source code. SpotBugs is able to identify a wide range of issues and can be customized to meet the needs of your specific project.

Using SpotBugs can help to improve the quality and reliability of your code by catching potential bugs early in the development process. This can save time and effort in the long run by reducing the need for debugging and fixing issues later in the development cycle. SpotBugs can also help to ensure that your code is secure by identifying potential security vulnerabilities.

Use the following command:

```bash
mvn spotbugs:gui 
```

For more info see 
https://spotbugs.readthedocs.io/en/latest/maven.html

SpotBugs https://spotbugs.github.io/ is the spiritual successor of FindBugs.


## Checkstyle 

Checkstyle is a development tool for checking Java source code against a set of coding standards. It is an open-source tool that can be integrated into various integrated development environments (IDEs), such as Eclipse and IntelliJ, as well as build tools like Maven and Gradle.

Checkstyle performs static code analysis, which means it examines the source code without executing it, and reports on any issues or violations of the coding standards defined in its configuration. This includes issues like code style, code indentation, naming conventions, code structure, and many others.

By using Checkstyle, developers can ensure that their code adheres to a consistent style and follows best practices, making it easier for other developers to read and maintain. It can also help to identify potential issues before the code is actually run, reducing the risk of runtime errors or unexpected behavior.

Checkstyle is highly configurable and can be customized to fit the needs of your team or organization. It supports a wide range of coding standards and can be integrated with other tools, such as code coverage and automated testing tools, to create a comprehensive and automated software development process.

The following command will generate a report in HTML format that you can open in a web browser. 

```bash
mvn checkstyle:checkstyle
```

The HTML page will be found at the following location:
`target/site/checkstyle.html`




