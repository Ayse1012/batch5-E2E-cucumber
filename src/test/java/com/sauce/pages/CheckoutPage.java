package com.sauce.pages;

import com.github.javafaker.Faker;
import com.sauce.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage{
    @FindBy(id = "checkout")
    public WebElement checkout;

    @FindBy(id ="first-name" )
    public WebElement inputFirstName;

    @FindBy(id = "last-name")
    public WebElement inputLastName;

    @FindBy(id = "postal-code")
    public WebElement inputPostCode;

    @FindBy(id = "continue")
    public WebElement continueBtn;

    @FindBy(xpath = "//*[text()='41.02']")
    public WebElement totalPrice;


    public void enterDetails(String firstName, String lastName, String postCode){

        inputFirstName.sendKeys(firstName);
        inputLastName.sendKeys(lastName);
        inputPostCode.sendKeys(postCode);
        continueBtn.click();

    }

    public String getTotalPrice(String price){

     return   Driver.get().findElement(By.xpath("//*[text()='"+price+"']")).getText();

    }


}
