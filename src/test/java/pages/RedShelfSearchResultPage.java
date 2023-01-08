package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class RedShelfSearchResultPage {

    public RedShelfSearchResultPage(){
        WebDriver driver= Driver.getDriver();
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[@data-role='card-title-url']")
    public List<WebElement> books;

    @FindBy(xpath = "//button[@data-role='offering-options-add-to-cart-button']")
    public WebElement addToCartBtn;
}
