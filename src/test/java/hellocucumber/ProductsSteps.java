package hellocucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Base;
import pages.Product;
import pages.ProductEdition;
import pages.Products;

import java.util.List;

import static org.junit.Assert.*;

public class ProductsSteps extends Base {
    Products productsPage;
    Product productPage;
    ProductEdition productEditionPage;


    @And("I click on ADICIONAR PRODUTO")
    public void iClickOnADICIONARPRODUTO() {
        productsPage = new Products();
        productsPage.AddProduct();
    }

    @And("I insert {string}, {string}, {string}")
    public void iInsert(String arg0, String arg1, String arg2) {
        productPage = new Product();
        productPage.SetName(arg0);
        productPage.SetValue(arg1);
        productPage.SetColors(arg2);
    }

    @When("I click on SALVAR")
    public void iClickOnSALVAR() {
        productPage.SaveProduct();
    }


    @Then("a toast shows the register confirmation and the product edition page is loaded")
    public void aToastShowsTheRegisterConfirmationAndTheProductEditionPageIsLoaded() {
        assert productPage.GetToastMessage().equals("Produto adicionado com sucesso");
        productEditionPage = new ProductEdition();
        assert productEditionPage.IsInScreen();
        Base.closeBrowser();
    }

    @Given("I insert {string}")
    public void iInsert(String arg0) {
        productPage = new Product();
        productPage.SetName(arg0);
    }


    @Then("the product list is loaded and the {string} is not added")
    public void theProductListIsLoadedAndTheIsNotAdded(String arg0) {
        List products = productsPage.GetAllProductsNames();
        assertFalse(products.contains(arg0));
        Base.closeBrowser();
    }

    @And("I go to products list")
    public void iGoToProductsList() {
        productEditionPage = new ProductEdition();
        productEditionPage.ListAllProducts();
    }


    @When("I delete the {string}")
    public void iDeleteThe(String arg0) {
        productsPage.DeleteProduct(arg0);
    }


    @Then("a toast shows the delete confirmation and the {string} is not is seen in the product list")
    public void aToastShowsTheDeleteConfirmationAndTheIsNotIsSeenInTheProductList(String arg0) {
        String message = productsPage.GetToastMessage();
        assert message.equals("Produto removido com sucesso");
        List products = productsPage.GetAllProductsNames();
        assertFalse(products.contains(arg0));
        Base.closeBrowser();
    }

    @When("I click on the {string}")
    public void iClickOnThe(String arg0) {
        productsPage.InspectProduct(arg0);
    }


    @Then("the Edit product page is loaded with {string}, {string}, and {string}")
    public void theEditProductPageIsLoadedWithAnd(String arg0, String arg1, String arg2) {
        String name = productEditionPage.GetProductName();
        String value = productEditionPage.GetProductValue();
        String colors = productEditionPage.GetProductColors();

        String v1 = arg1.substring(0, arg1.length()-2);
        String v2 = arg1.substring(arg1.length()-2, arg1.length());
        arg1 = v1+","+v2;
        assert name.equals(arg0);
        assert value.equals(arg1);
        assert colors.equals(arg2);
        Base.closeBrowser();
    }
}
