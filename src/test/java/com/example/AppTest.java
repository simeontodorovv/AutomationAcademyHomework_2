
package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class AppTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        //ChromeOptions options = new ChromeOptions();

        // options.addArguments("--headless");
        driver = new ChromeDriver();
        driver.get("http://localhost:5173");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    @Test
    public void verifyAllRoles() {

        LoginPage loginPage = new LoginPage(driver);
        ServicePortal servicePortal = new ServicePortal(driver);

        loginPage.roleButton(0).click();
        loginPage.Login();
        
        servicePortal.SubmitRequest(
        "Water Leak", 
        "Here is any random description with at least 10 words", 
        "Water & Utilities", 
        "Random Address",
        "Sofia",
        "1000",
        "Detailed Description",
        "monkata971@gmail.com",
        "0878629847" );

        assertEquals("Submitted", servicePortal.status().getText());
        assertEquals("High", servicePortal.priority().getText());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}