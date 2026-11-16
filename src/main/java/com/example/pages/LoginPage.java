
package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

        private final WebElement loginButton() { return driver.findElement(By.cssSelector("button[type='submit']") );}
        private final String getTitle() { return driver.getTitle(); }

        String[] types = {"Citizen", "Clerk", "Supervisor", "Field Agent", "Administrator"};

        public WebElement roleButton(int index) {
        return driver.findElement(
            By.xpath("//p[normalize-space()='" + types[index] + "']")
        );
    }
        public void Login() {
            loginButton().click();
        }
}