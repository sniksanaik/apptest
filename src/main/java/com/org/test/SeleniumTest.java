package com.org.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumTest {
    public static void main(String[] args) {
        // Set the URL for the Selenium Grid
        String gridUrl = "http://localhost:4444/wd/hub";

        // Set up Chrome options
        ChromeOptions options = new ChromeOptions();

        // Create the RemoteWebDriver instance with ChromeOptions
        WebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL(gridUrl), options);

            // Open a website
            driver.get("https://www.google.com");

            // Print the title of the page
            System.out.println("Title: " + driver.getTitle());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            if (driver != null) {
                driver.quit();
            }
        }
    }
}