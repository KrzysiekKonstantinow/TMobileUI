# T-Mobile Tech Assessment - Java/Selenium/Selenide Project

This project is a tech assessment for the recruitment process at T-Mobile. It automates a specific scenario on the T-Mobile website using Selenium and Selenide with Java.

## Scenario

1. Go to the TMobile page
2. Choose devices from the top bar
3. Choose no subscription from the smartwatches and bands
4. Click the first product on the list
5. Add the product to the cart
6. Go to the main TMobile page
7. Main page is visible
8. There should be one element in the basket

## Requirements

- Java JDK - Ensure Java is installed on your machine.
- Maven

## Installation
Download and install latest JDK. Set Path and JAVA_HOME environment variables.

## Running Test Locally
To run the test use the 
```bash
mvn test
``` 
command. Ensure that you have the necessary dependencies installed before running the tests.

## Page Object Model (POM)

This project follows the Page Object Model (POM) design pattern to improve test structure and maintainability. The core idea is to encapsulate interactions with web pages into separate objects, known as page objects.

### Structure

- **`main/java/tmobileui/pages`**: Contains page object files, each representing a different page or component of the application.

- **`pages/HomePage.java`**: Example page object file for the "Request A Demo IFrame" on the Nobl9 website.

```java
// java/tmobileui/pages/HomePage.java

public class Home Page {
  
  public SelenideElement element = {
    return $(By.xpath("locator"));
  }
  // ... other methods and properties
}
```

## Logging
This project uses Log4j for logging. Log4j properties can be found in src/main/resources folder. Logs collected during the test run can be found in logs folder.

## BDD
This project uses BDD principles using Cucumber. Feature files can be found in test/resources folder. Step definitions can be found in test/java/stepdef folder
