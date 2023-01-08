package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.PizzaAppPage;
import utilities.BrowserUtils;
import utilities.Driver;

import java.util.Map;

public class PizzaAppSteps {

    WebDriver driver = Driver.getDriver();
    PizzaAppPage pizzaAppPage = new PizzaAppPage();
    String price;

    @When("user creates pizza order with data")
    public void user_creates_pizza_order_with_data(DataTable dataTable) {
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.

        Map<String, String> data = dataTable.asMap(String.class, Object.class);
        for (String value : data.values()) {
            System.out.println(value);
        }
        BrowserUtils.selectDropdownByValue(pizzaAppPage.pizzaDropdown, data.get("Pizza"));//selecting small pizza
        BrowserUtils.selectDropdownByValue(pizzaAppPage.topping1Dropdown, data.get("Topping1"));//mushroom
        BrowserUtils.selectDropdownByValue(pizzaAppPage.topping2Dropdown, data.get("Topping2"));//extra cheese
        pizzaAppPage.pizzaQtyBox.sendKeys(Keys.BACK_SPACE);
        pizzaAppPage.pizzaQtyBox.sendKeys(data.get("Quantity"));//1
        pizzaAppPage.nameBox.sendKeys(data.get("Name"));//Patel Harsh
        price=pizzaAppPage.pizzaCostBox.getAttribute("value");
        pizzaAppPage.emailBox.sendKeys(data.get("Email"));//patel@gmail.com
        pizzaAppPage.phoneBox.sendKeys(data.get("Phone"));//123456789
        if(data.get("Payment").equals("Cash on Pickup")){
            pizzaAppPage.cashRadioButton.click();
        }else {
            pizzaAppPage.creditCardRadioButton.click();
        }
        pizzaAppPage.placeOrderButton.click();

    }


    @Then("user validates that order is created with message {string} {string}")
    public void userValidatesThatOrderIsCreatedWithMessage(String expectedMessage, String expectedMessage2) {
        String actualMessage=pizzaAppPage.dialogWindow.getText();
        System.out.println(actualMessage);
        Assert.assertEquals(expectedMessage+price+" "+expectedMessage2,actualMessage);
    }
}
