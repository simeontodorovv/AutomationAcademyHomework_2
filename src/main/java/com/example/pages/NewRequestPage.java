package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewRequestPage {

    private WebDriver driver;

    public NewRequestPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement requestTitle() {return driver.findElement(By.name("title"));}
    public WebElement description() {return driver.findElement(By.name("description"));}
    public WebElement category() {return driver.findElement(By.xpath("//div[@id='mui-component-select-category']"));}
    public WebElement categoryName(String categoryName) {return driver.findElement(By.xpath("//li[normalize-space()='"+ categoryName +"']"));}
    public WebElement highPriority() {return driver.findElement(By.xpath("//input[@value='HIGH']"));}    
    public WebElement next() {return driver.findElement(By.xpath("//button[normalize-space()='Next']"));}
    public WebElement streetAddress() {return driver.findElement(By.name("streetAddress"));}
    public WebElement city() {return driver.findElement(By.name("city"));}
    public WebElement postCode() {return driver.findElement(By.name("postalCode"));}
    public WebElement locationDescription() {return driver.findElement(By.name("locationText"));}
    public WebElement email() {return driver.findElement(By.name("email"));}
    public WebElement phone() {return driver.findElement(By.name("phone"));}
    public WebElement termsAndConditions() {return driver.findElement(By.xpath("//input[@type='checkbox']"));}
    public WebElement submitRequest() {return driver.findElement(By.xpath("//button[normalize-space()='Submit Request']"));}
    public WebElement titleToCheck() {return driver.findElement(By.xpath("//div[@title='Title']"));}
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