# Selenium with Java - Cucumber BDD Framework
This project is a Selenium-based automation framework built using Java and the Cucumber BDD framework. It is designed to facilitate effective collaboration between cross-functional teams by leveraging Behaviour-Driven Development (BDD) practices. The framework allows both technical and non-technical stakeholders to actively participate in the development and testing process. 

## Tools and Technologies Used:
1. **Automation Tool**: [Selenium WebDriver](https://www.simplilearn.com/tutorials/selenium-tutorial/what-is-selenium-webdriver)
2. **Programming Language**: [Java SE 21](https://www.oracle.com/in/java/technologies/downloads/#jdk23-windows)  
3. **Testing Framework**: [Cucumber BDD](https://mvnrepository.com/artifact/io.cucumber/cucumber-java) **&** [TestNG](https://mvnrepository.com/artifact/io.cucumber/cucumber-testng)  
4. **Build Tool**: [Maven](https://maven.apache.org/)  
5. **Modular Design**: [POM](https://maven.apache.org/guides/introduction/introduction-to-the-pom.html) (Page Object Model)  
6. **Logging Framework**: [Log4j](https://testsigma.com/blog/log4j-selenium/) 
7. **Cross-Browser Testing**: [Hooks](https://toolsqa.com/cucumber/cucumber-hooks/)
8. **Reporting**: [Allure](https://medium.com/@sonaldwivedi/allure-reporting-in-selenium-using-testng-and-maven-8a3a5ff07856)

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
      <version>4.27.0</version>
  </dependency>

## Directory Structure
![Directory Structure](https://github.com/user-attachments/assets/11f85d3e-00ab-4930-84fc-bc24b05e6eda)

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
     
**STEP 5: Run Specific Tests or Tags**
- To run specific tests or tags,
    ```bash
    mvn test -Dcucumber.options="--tags @TagName" 

**STEP 6: Generate Allure Report** 
- After the tests are executed, generate and view the Allure report
    ```bash
    allure serve target/allure-results
- The `target/allure-results` directory contains the test results in a format that Allure can read and display.

![Allure Report](https://github.com/user-attachments/assets/589d635d-2bf6-46b3-a589-cc0e54e9906c)

![Allure Report in web](https://github.com/user-attachments/assets/05ab1bea-81dd-4675-8ee2-41775dcaa449)

## Learn Cucumber Foundations
To get a deeper understanding of Cucumber and its foundations, you can refer to the following YouTube video:
[Learn Cucumber BDD Framework - Foundation](https://youtu.be/4e9vhX7ZuCw?si=lBfCocMnYC449Ajm)

This video covers the essential concepts and steps for setting up and using the Cucumber framework in your projects. It is a great resource for beginners and for those who want to solidify their knowledge in Cucumber BDD.














