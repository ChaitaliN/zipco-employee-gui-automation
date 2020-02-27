# Cafe Townsend UI automation

Cafe townsend UI automation testing

## Prerequisite

- Java 1.8
- Maven 3.6
- Chrome 80
- Firefox 73
- NOTE: Chrome / Firefox drivers are bundled as part of framework

## Framework

- Testing approach - BDD

  - [Feature files](./src/test/resources/feature/)
  - [Step definitions](./src/test/java/stepDefinition)

- Browser automation - Selenium WebDriver
- BDD tool - Cucumber
- Test tool - JUnit
- Build tool - Maven
- [Configuration management - Properties file to change browser, driver location etc](./src/test/resources/test.config.properties)

## Usage

- Run all tests

  ```sh
  mvn test

  ```

- Run specific scenario by tags

  ```sh
  mvn test -Dcucumber.options="--tags @login-employee"
  mvn test -Dcucumber.options="--tags @create-employee"
  mvn test -Dcucumber.options="--tags @delete-employee"
  mvn test -Dcucumber.options="--tags @update-employee"
  mvn test -Dcucumber.options="--tags @logout-employee"

  ```

## Reports

- HTML report

  ```sh
  target/cucumber-html-report/index.html
  ```

- Json report

  ```sh
  target/cucumber.json
  ```

- Steps report

  ```sh
  target/cucumber-pretty.txt
  ```

- XML report

  ```sh
  target/cucumber-results.xml
  ```

