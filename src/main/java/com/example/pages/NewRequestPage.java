package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewRequestPage {

    private WebDriver driver;

    public NewRequestPage(WebDriver driver) {
        this.driver = driver;
    }

    private final WebElement requestTitle() {return driver.findElement(By.name("title"));}
    private final WebElement description() {return driver.findElement(By.name("description"));}
    private final WebElement category() {return driver.findElement(By.xpath("//div[@id='mui-component-select-category']"));}
    private final WebElement categoryName(String categoryName) {return driver.findElement(By.xpath("//li[normalize-space()='"+ categoryName +"']"));}
    private final WebElement highPriority() {return driver.findElement(By.xpath("//input[@value='HIGH']"));}    
    private final WebElement next() {return driver.findElement(By.xpath("//button[normalize-space()='Next']"));}
    private final WebElement streetAddress() {return driver.findElement(By.name("streetAddress"));}
    private final WebElement city() {return driver.findElement(By.name("city"));}
    private final WebElement postCode() {return driver.findElement(By.name("postalCode"));}
    private final WebElement locationDescription() {return driver.findElement(By.name("locationText"));}
    private final WebElement email() {return driver.findElement(By.name("email"));}
    private final WebElement phone() {return driver.findElement(By.name("phone"));}
    private final WebElement termsAndConditions() {return driver.findElement(By.xpath("//input[@type='checkbox']"));}
    private final WebElement submitRequest() {return driver.findElement(By.xpath("//button[normalize-space()='Submit Request']"));}
    private final WebElement titleToCheck() {return driver.findElement(By.xpath("//div[@title='Title']"));}
    public WebElement status() {return driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[5]/div[1]/span[1]"));}
    public WebElement priority() {return driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/span[1]"));}

    public void fillRequestDetails(String title, String description, String category) {
        requestTitle().sendKeys(title);
        description().sendKeys(description);
        selectCategory(category);
        highPriority().click();
        next().click();
    }

    public void fillLocation(String address, String city, String postCode, String locationDescription) {
        streetAddress().sendKeys(address);
        city().sendKeys(city);
        postCode().sendKeys(postCode);
        locationDescription().sendKeys(locationDescription);
        next().click();
    }

    public void fillContactDetails(String email, String phone) {
        email().sendKeys(email);
        phone().sendKeys(phone);
        next().click();
    }

    public void acceptTermsAndConditions() {
        termsAndConditions().click();
        next().click();
    }

    public void reviewAndSubmit() {
        submitRequest().click();
    }

    public void SubmitRequest(String title, String description, String category, String address, String city, String postCode, String locationDescription, String email, String phone) {
        fillRequestDetails(title, description, category);
        fillLocation(address, city, postCode, locationDescription);
        fillContactDetails(email, phone);
        acceptTermsAndConditions();
        reviewAndSubmit();
    }

    public void selectCategory(String category) {
        category().click();
        driver.findElement(
            By.xpath("//li[normalize-space()='" + category + "']")
        ).click();
    }
}