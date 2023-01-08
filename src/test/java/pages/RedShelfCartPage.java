package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.Driver;

public class RedShelfCartPage {

    public RedShelfCartPage(){
        WebDriver driver= Driver.getDriver();

    }
    @FindBy(id = "empty-cart")
    public WebElement emptyCartBtn;

    @FindBy(xpath = "//p[@class='subtotal-field']")
    public WebElement cartIsEmptyMsg;
}
