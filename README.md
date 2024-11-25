•Appium Project Overview

This personal project is focused on automating test cases for General Store, a demo e-commerce android app, using Appium with the Page Object Model (POM) design pattern and TestNG. It includes various page objects for interacting with different sections of the application, a configuration class for setting up the WebDriver, and test cases for executing the automated tests.

•Test Cases:
https://docs.google.com/spreadsheets/d/1J8PG6RX7NOmLY7BsYBn9He6ZeVsJumMPcQ-YbOtwo8w/edit?pli=1&gid=0#gid=0

    •/AppiumProject/src/main/java/GeneralStore/PageObject
        This directory contains the page object classes representing various pages of the application. These classes encapsulate the logic for interacting with page elements (buttons, fields, etc.) and provide methods to perform actions.
            AndroidActions.java: contains methods to perform Android-specific actions.
	    CartPage.java: Contains methods for interacting with the cart page.
            FormPage.java: Contains methods for setting up name, country and gender.
            ProductCatalogue.java: Contains methods for interacting with the product catalog page.

    •/AppiumProject/src/main/java/GeneralStore/Config
        This directory contains configuration files and base test classes needed for setting up the testing environment.
            BaseTest.java: A base test class that initializes the  Appium server and AndroidDriver and provides common test setup and teardown methods.
	    BaseTestUtils.java: Method to start the Appium server with a specified IP address and port, using a local Appium driver service
            data.properties: A properties file where you can set the ip address, port, device name and build name.

    •/AppiumProject/src/main/java/GeneralStore/TestCases
        This directory contains the test case classes responsible for executing the test logic. Each class corresponds to specific scenarios and uses the page objects to carry out the tests.
            TestExecution.java: The main class that contains the execution logic for running the tests. It integrates the page objects and performs actions in sequence to test the application.