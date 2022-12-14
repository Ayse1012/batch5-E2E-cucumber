package com.sauce.stepDefs;

import com.sauce.pages.CheckoutPage;
import com.sauce.pages.LoginPage;
import com.sauce.pages.ProductsPage;
import com.sauce.utilities.ConfigurationReader;
import com.sauce.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.util.zip.CheckedInputStream;

public class LoginStepDefs {
   LoginPage loginPage=new LoginPage();
   ProductsPage productsPage=new ProductsPage();
   CheckoutPage checkoutPage=new CheckoutPage();

    @Given("The user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));

    }
    @When("The user is enters {string} and {string}")
    public void the_user_is_enters_and(String username, String password) {

        loginPage.login(username,password);
    }
    @Then("The user should be able to login and see {string} header")
    public void the_user_should_be_able_to_login_and_see_header(String expectedHeader) {

   Assert.assertEquals("verify that header is ",expectedHeader,productsPage.productsHeader.getText());
    }

    @And("The user should be able to sort products high to low")
    public void theUserShouldBeAbleToSortProductsHighToLow() throws InterruptedException {
        Select select=new Select(productsPage.dropDownSort);
        select.selectByVisibleText("Price (high to low)");

        Thread.sleep(3000);
    }

    @And("The user should be able to sort products {string}")
    public void theUserShouldBeAbleToSortProducts(String sortType) throws InterruptedException {
     productsPage.sortProducts(sortType);
        Thread.sleep(3000);

    }

    @And("The user clicks cheapest as {string} and second costliest as {string} product")
    public void theUserClicksCheapestAsAndSecondCostliestAsProduct(String cheapest, String secondProduct) {
        productsPage.addProducts(cheapest);
        productsPage.addProducts(secondProduct);
    }

    @Then("The user open basket")
    public void theUserOpenBasket() {
        productsPage.basketBtn.click();
    }

    @And("The user clicks checkout")
    public void theUserClicksCheckout() {
        checkoutPage.checkout.click();

    }

    @And("The user enters details {string} {string} {string} and finish the purchase")
    public void theUserEntersDetailsAndFinishThePurchase(String firstName, String lastName, String postCode) {
        checkoutPage.enterDetails(firstName,lastName,postCode);

        System.out.println("totalPrice.getText() = " + checkoutPage.totalPrice.getText());
    }

    @Then("The user verify that items are {string} and able to total is {string}")
    public void theUserVerifyThatItemsAreAndAbleToTotalIs(String price, String expectedTotal) {

        Assert.assertEquals(expectedTotal,checkoutPage.getTotalPrice(price));

    }
}
