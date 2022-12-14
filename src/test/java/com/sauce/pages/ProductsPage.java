package com.sauce.pages;

import com.sauce.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ProductsPage extends BasePage{
    @FindBy(xpath = "//span[text()='Products']")
    public WebElement productsHeader;

    @FindBy(css = ".product_sort_container")
    public WebElement dropDownSort;

    @FindBy(css = ".shopping_cart_link")
    public WebElement basketBtn;

    public void sortProducts(String sortType){

        Select select=new Select(dropDownSort);
        select.selectByVisibleText(sortType);

    }

    public void addProducts(String price){

        Driver.get().findElement(By.xpath("//*[text()='"+price+"']/../button")).click();


    }


}
