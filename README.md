## This automation testing project uses Java, Selenium, and BDD frameworks.
## 1. Set Up the Development Environment
####   1.1 Install Java and set Java Home Path in environment variables.
      In Windows OS, in the start search bar, enter " environment variable", and click "Edit system environment variable".
      Click "new" and enter variable name: JAVA_HOME, variable value: C:\Program Files\Java\jdk-17
      Edit Path variables, add a new item  %JAVA_HOME%\bin
####   1.2 Download and Install IntelliJ IDEA Community Edition 
       IntelliJ IDEA Community Edition is completely free to use, here is the download link:
       https://www.jetbrains.com/idea/download/?section=windows
       
####    1.3 Install Maven 
      Maven is a project build tool that manages dependencies.
      IntelliJ IDEA comes with Maven built-in
      
####   1.4 Download and configure browser drivers 
      like ChromeDriver, GeckoDriver, etc. which Selenium uses to interact with browsers.
   
## 2. Create a Maven Project
####    2.1 Create a new Maven project in IntelliJ IDEA.
####   2.2 Set up pom.xml for dependencies.
        <!-- https://mvnrepository.com/artifact/io.rest-assured/rest-assured -->
        <dependency>
            <groupId>io.rest-assured</groupId>
            <artifactId>rest-assured</artifactId>
            <version>5.3.2</version>
            <scope>test</scope>
        </dependency>

        <!-- https://mvnrepository.com/artifact/org.hamcrest/hamcrest -->
        <dependency>
            <groupId>org.hamcrest</groupId>
            <artifactId>hamcrest</artifactId>
            <version>2.2</version>
            <scope>test</scope>
        </dependency>
        <!-- Selenium WebDriver -->
        <!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>4.22.0</version>
        </dependency>


        <!-- TestNG -->
        <dependency>
            <groupId>org.testng</groupId>
            <artifactId>testng</artifactId>
            <version>7.8.0</version>
        </dependency>

        <!-- Cucumber -->
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-java</artifactId>
            <version>7.13.0</version>
        </dependency>
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-testng</artifactId>
            <version>7.13.0</version>
        </dependency>
        <dependency>
            <groupId>io.github.bonigarcia</groupId>
            <artifactId>webdrivermanager</artifactId>
            <version>5.5.3</version>
            <exclusions>
                <exclusion>
                    <artifactId>slf4j-api</artifactId>
                    <groupId>org.slf4j</groupId>
                </exclusion>
                <exclusion>
                    <artifactId>jcl-over-slf4j</artifactId>
                    <groupId>org.slf4j</groupId>
                </exclusion>
            </exclusions>
        </dependency>

        <!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind -->
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>2.15.2</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/commons-io/commons-io -->
        <dependency>
            <groupId>commons-io</groupId>
            <artifactId>commons-io</artifactId>
            <version>2.13.0</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/com.aventstack/extentreports -->
        <dependency>
            <groupId>com.aventstack</groupId>
            <artifactId>extentreports</artifactId>
            <version>5.1.1</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/org.apache.poi/poi-ooxml -->
        <dependency>
            <groupId>org.apache.poi</groupId>
            <artifactId>poi-ooxml</artifactId>
            <version>5.2.4</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/org.apache.poi/poi -->
        <dependency>
            <groupId>org.apache.poi</groupId>
            <artifactId>poi</artifactId>
            <version>5.2.4</version>
        </dependency>


        <!-- https://mvnrepository.com/artifact/io.appium/java-client -->
        <dependency>
            <groupId>io.appium</groupId>
            <artifactId>java-client</artifactId>
            <version>9.0.0</version>
            <exclusions>
                <exclusion>
                    <artifactId>slf4j-api</artifactId>
                    <groupId>org.slf4j</groupId>
                </exclusion>
            </exclusions>
        </dependency>

        <!-- Log4j2 Dependency -->
        <!-- https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-api -->
        <dependency>
            <groupId>org.apache.logging.log4j</groupId>
            <artifactId>log4j-api</artifactId>
            <version>2.24.0</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-core -->
        <dependency>
            <groupId>org.apache.logging.log4j</groupId>
            <artifactId>log4j-core</artifactId>
            <version>2.24.0</version>
        </dependency>
   
## 3. Add Cucumber and Selenium Configuration
  ####  3.1 Improve the project structure
       |Project
       |──logs -store the log4j logs
       |──reports - store the test result
       |──config
            └── GlobalData.properties 
            └── log4j2.xml
       |──src
            ├── main
            │   └── java
            │       └── PageObjects
                    └── Utilities
            └── test
                ├── java
                │   └── com.example.project
                └── resources
                │    └── features
                └── testComponents
                │     └── BaseTest
                └── tests
       |──testSuites
       |──pom.xml
       
####    3.2 Add Cucumber Feature Files
####    3.3 Create Step Definitions files
####    3.4 Create a Test Runner Class
## 4. Run the Test
