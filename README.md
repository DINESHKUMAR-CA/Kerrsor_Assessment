# Selenium with Java - TestNG Framework
This project is a Selenium-based automation framework built using Java and the TestNG testing framework. It is designed to enable structured and maintainable test automation with features like test grouping, parameterization, and parallel execution. The framework supports robust and scalable test case development for UI regression and smoke testing across multiple browsers. With the use of TestNG annotations and assertions, it simplifies test execution flow, enhances reporting capabilities, and integrates seamlessly with build tools like Maven and CI/CD pipelines for continuous testing. 

## Tools and Technologies Used:
1. **Automation Tool**: [Selenium WebDriver](https://www.simplilearn.com/tutorials/selenium-tutorial/what-is-selenium-webdriver)
2. **Programming Language**: [Java SE 21](https://www.oracle.com/in/java/technologies/downloads/#jdk23-windows)  
3. **Testing Framework**: [TestNG](https://mvnrepository.com/artifact/io.cucumber/cucumber-testng)  
4. **Build Tool**: [Maven](https://maven.apache.org/)  
5. **Modular Design**: [POM](https://maven.apache.org/guides/introduction/introduction-to-the-pom.html) (Page Object Model)  
6. **Logging Framework**: [Log4j](https://testsigma.com/blog/log4j-selenium/) 

## Prerequisites:
1.	Java Development Kit (JDK) 8 **or** Higher
2.	Maven 3.8 **or** higher
3.	IDE (Intellij IDEA Community Edition **or** Eclipse)
4.	Compatible web browser (Ex: Chrome, Firefox, safari, etc.)

## Steps to Setup the prerequisties:
#### STEP 1: Java Development Kit (JDK) 8 **or** Higher
- Install JDK 8 or higher from the [official Oracle website](https://www.oracle.com/in/java/technologies/downloads/#jdk23-windows). This project is built using Java, and JDK is necessary to compile and run the tests.
- Follow the instruction provided in this [YouTube video](https://youtu.be/R6MoDMASwag?si=3eZOx12oEFkiDfRW)
- Verify the installation by running the following command in your terminal:
  
  ```bash
  java -version

#### STEP 2: Maven 3.8 **or** Higher
- Create a Maven project either in eclipse or in Intellij. Maven is used to manage project dependencies and build lifecycle.
- Follow the instructions provided in this [YouTube Video](https://youtu.be/i0ACQF8yX9E?si=fr01yXov68DbKqjV)
- Verify the installation by running:

  ```bash
  mvn -version

#### STEP 3:  IDE (IntelliJ IDEA or Eclipse)
- Use an Integrated Development Environment (IDE) like IntelliJ IDEA or Eclipse for writing and managing the automation code. Both IDEs support Java and Maven integration.
- You can download IntelliJ IDEA Community Edition from [here](https://www.jetbrains.com/idea/download/?section=windows) or Eclipse from [here](https://www.eclipse.org/downloads/download.php?file=/oomph/epp/2024-09/R/eclipse-inst-jre-win64.exe).
- Follow the instructions to setup IDE in this [YouTube Video](https://youtu.be/j6mLD6e75Go?si=KjORnMvATkEikUBM)

#### STEP 4: Compatible Web Browser
- Ensure a compatible web browser (Chrome, Firefox, Safari, etc.) is installed on your machine for Selenium WebDriver to interact with.
- Adding the following dependency in the `pom.xml` file will automatically download all the necessary drivers for supported browsers such as Chrome, Firefox (Gecko), Edge, etc., when you build the project using Maven:

  ```xml
  <dependency>
      <groupId>org.seleniumhq.selenium</groupId>
      <artifactId>selenium-java</artifactId>
      <version>4.33.0</version>
  </dependency>

## Steps to run on your system
**STEP 1: Clone this Repository**
Open your terminal/command prompt.
   - Run the following command to clone the project:
     ```bash
     git clone <repository_url>
     ```
   - Replace `<repository_url>` with the URL of this repository.

<p align="center"><b>[OR]</b></p>

- You can also clone the repository directly from your IDE. Refer to this YouTube video for detailed instructions: [How to Clone GitHub Repository from Itellij IDE](https://youtu.be/ILSQeAOK0gs?si=HXYv52tv5ONPwcEP)

**STEP 2: Clone this Repository**
Navigate to the Project Directory
- Change to the cloned project directory:
     ```bash
     cd <project-folder-name>
     ```
**STEP 3: Verify Your Environment is Set Up**  
 - Make sure that you have the necessary prerequisites installed (JDK, Maven, and compatible browser)
 - All the required dependencies are already included in the repository's pom.xml file, so there is no need to manually add them.

**STEP 4: Run the test**  
 - To execute all tests
     ```bash
     mvn test
















