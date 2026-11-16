package com.example.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.example.base.BaseTest;
import com.example.pages.LoginPage;
import com.example.pages.ServicePortal;
import com.example.pages.NewRequestPage;

public class AppTest extends BaseTest {

    @Test
    public void verifyAllRoles() {

        LoginPage loginPage = new LoginPage(driver);
        ServicePortal servicePortal = new ServicePortal(driver);
        NewRequestPage newRequestPage = new NewRequestPage(driver);

        loginPage.roleButton(0).click();
        loginPage.Login();
        
        servicePortal.newRequest().click();
        newRequestPage.SubmitRequest(
        "Water Leak", 
        "Here is any random description with at least 10 words", 
        "Water & Utilities", 
        "Random Address",
        "Sofia",
        "1000",
        "Detailed Description",
        "monkata971@gmail.com",
        "0878629847" );

        assertEquals("Submitted", newRequestPage.status().getText());
        assertEquals("High", newRequestPage.priority().getText());
    }

}
