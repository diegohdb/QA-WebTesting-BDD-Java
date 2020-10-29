package hellocucumber;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Base;
import pages.Login;
import pages.Products;

public class LoginSteps extends Base {

    Login loginPage;
    Products productsPage;

    @Given("I open Lojinha")
    public void i_open_lojinha() {
        Base.initialization();
        loginPage = new Login();
        loginPage.LaunchLoginPage();
    }

    @When("I insert the {string} and {string}")
    public void iInsertTheAnd(String arg0, String arg1) {
        loginPage.SetUser(arg0);
        loginPage.SetPassword(arg1);
    }

    @When("I click on ENTRAR")
    public void i_click_on_entrar() {
        loginPage.ClickLogin();
    }

    @Then("the user is granteed to the website")
    public void the_user_is_granteed_to_the_website() {
        productsPage = new Products();
        assert productsPage.IsInScreen();
        Base.closeBrowser();
    }

    @Then("the user is not allowed to login the website")
    public void theUserIsNotAllowedToLoginTheWebsite() {
        assert loginPage.IsToast();
        Base.closeBrowser();
    }
}
