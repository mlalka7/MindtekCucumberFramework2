package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.RedShelfAddToCartPage;
import pages.RedShelfCartPage;
import pages.RedShelfMainPage;
import pages.RedShelfSearchResultPage;
import utilities.Driver;

public class RedShelfSteps {
     WebDriver driver= Driver.getDriver();

     RedShelfMainPage redShelfMainPage=new RedShelfMainPage();
     RedShelfSearchResultPage redShelfSearchResultPage=new RedShelfSearchResultPage();
     RedShelfAddToCartPage redShelfAddToCartPage=new RedShelfAddToCartPage();
     RedShelfCartPage redShelfCartPage=new RedShelfCartPage();

    private static final String IN_CART="IN CART";

    @When("user searches {string} book")
    public void user_searches_book(String book) {
        redShelfMainPage.searchCatalog.sendKeys("Purple Cow"+ Keys.ENTER);

    }
    @When("user choose first book in search result")
    public void user_choose_first_book_in_search_result() {
        redShelfSearchResultPage.books.get(0).click();

    }
    @When("user clicks on Add To Cart button")
    public void user_clicks_on_add_to_cart_button() {
        redShelfAddToCartPage.addToCartBtn.click();

    }
    @Then("user clicks on view cart button and validates book is in cart")
    public void user_clicks_on_view_cart_button_and_validates_book_is_in_cart() {
        Assert.assertEquals(redShelfAddToCartPage.inCartLabel.getText(),IN_CART);
    }


    @Then("user validates first result page having no more than {int} books.")
    public void userValidatesFirstResultPageHavingNoMoreThanBooks(int amount) {
        Assert.assertTrue(redShelfSearchResultPage.books.size()<=amount);
    }







    @When("user click on Add To Cart button")
    public void user_click_on_add_to_cart_button() {
        redShelfAddToCartPage.addToCartBtn.click();

    }

    @When("user clicks on empty cart button")
    public void user_clicks_on_empty_cart_button() throws InterruptedException {
        redShelfAddToCartPage.viewCartBtn.click();
        Thread.sleep(5000);
      redShelfCartPage.emptyCartBtn.click();


    }
    @Then("user validates “Your Cart is Empty“ message")
    public void user_validates_your_cart_is_empty_message() {
       String actual=redShelfCartPage.cartIsEmptyMsg.getText();
       String expected="Your Cart is Empty";
       Assert.assertEquals(expected,actual);

    }


    @When("user searches “Purple Cow” book")
    public void user_searches_purple_cow_book() {
    }


    @When("user clicks on purple cow book and stores ISBN number")
    public void user_clicks_on_purple_cow_book_and_stores_isbn_number() {

    }
    @When("user search for a book with stored ISBN number")
    public void user_search_for_a_book_with_stored_isbn_number() {

    }
    @Then("user validates that search result has “Purple cow“ book")
    public void user_validates_that_search_result_has_purple_cow_book() {

    }

}
