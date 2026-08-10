package com.tesinglabs.com.testinglabs.test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab_7 {

    public static void main(String[] args) {

        // Setup EdgeDriver
        WebDriverManager.edgedriver().setup();

        WebDriver driver = new EdgeDriver();

        driver.manage().window().maximize();

        driver.get("https://letcode.in/alert/");

        // -------------------------------
        // Simple Alert Handling
        // -------------------------------

        driver.findElement(
                By.xpath("//button[text()='Simple Alert']")
        ).click();

        Alert alert = driver.switchTo().alert();

        System.out.println("Simple Alert: " + alert.getText());

        alert.accept();

        // -------------------------------
        // Confirm Alert Handling
        // -------------------------------

        driver.findElement(
                By.xpath("//button[text()='Confirm Alert']")
        ).click();

        alert = driver.switchTo().alert();

        System.out.println("Confirm Alert: " + alert.getText());

        alert.dismiss();

        // -------------------------------
        // Prompt Alert Handling
        // -------------------------------

        driver.findElement(
                By.xpath("//button[text()='Prompt Alert']")
        ).click();

        alert = driver.switchTo().alert();

        System.out.println("Prompt Alert: " + alert.getText());

        alert.sendKeys("Kiran");

        alert.accept();

        System.out.println(
                driver.findElement(
                        By.xpath("//p[@id='myName']")
                ).getText()
        );

        // -------------------------------
        // Modern Alert Handling
        // -------------------------------

        WebElement modernAlert = driver.findElement(
                By.xpath("//button[text()='Modern Alert']")
        );

        System.out.println("Modern Alert Button: "
                + modernAlert.getText());

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript(
                "arguments[0].scrollIntoView(true);",
                modernAlert
        );

        js.executeScript(
                "arguments[0].click();",
                modernAlert
        );

        System.out.println(
                driver.findElement(
                        By.xpath("//div[@class='card-content']//p")
                ).getText()
        );

        driver.findElement(
                By.xpath("//button[@aria-label='close']")
        ).click();

        // Close browser
        driver.quit();
    }
}
