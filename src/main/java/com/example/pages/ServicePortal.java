
package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ServicePortal {

    private WebDriver driver;

    public ServicePortal(WebDriver driver) {
        this.driver = driver;
    }



    public WebElement myProfile() {return driver.findElement(By.xpath("//header[@class='MuiPaper-root MuiPaper-elevation MuiPaper-elevation4 MuiAppBar-root MuiAppBar-colorPrimary MuiAppBar-positionStatic css-101k3ct-MuiPaper-root-MuiAppBar-root']//button[2]"));}
    public WebElement logOut() {return driver.findElement(By.xpath("//li[@role='menuitem']//span[@class='MuiTypography-root MuiTypography-body1 MuiListItemText-primary css-1y3ghvl-MuiTypography-root'][normalize-space()='Logout']"));}
    public WebElement newRequest() {return driver.findElement(By.xpath("//a[normalize-space()='New Request']"));}
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

        public void SubmitRequest(String title, String description, String category, String address, String city, String postCode, String locationDescription, String email, String phone) {
        
        newRequest().click();

        requestTitle().sendKeys(title);

        description().sendKeys(description);
        selectCategory(category);

        highPriority().click();
        next().click();
        

        streetAddress().sendKeys(address);
        city().sendKeys(city);
        postCode().sendKeys(postCode);
        locationDescription().sendKeys(locationDescription);
        next().click();

        email().sendKeys(email);
        phone().sendKeys(phone);
        next().click();

        termsAndConditions().click();
        next().click();

        submitRequest().click();


    }

    public void LogOut() {
        myProfile().click();
        logOut().click();
    }
    public String getTitle() {
        return driver.getTitle();
    }

    public void selectCategory(String category) {
    category().click();

    driver.findElement(
        By.xpath("//li[normalize-space()='"+category+"']")
    ).click();
}
}