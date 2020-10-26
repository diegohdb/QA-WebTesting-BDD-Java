package pages;

import org.openqa.selenium.By;

public class ProductEdition extends Base {

    By tv_product_edition = By.xpath("html/body/div[2]/div/div/div[1]/h4");
    By bt_add_component = By.xpath("/html/body/div[2]/div/div/div[3]/div[1]/a");
    By bt_list = By.xpath("/html/body/div[2]/div/div/div[3]/form/div[4]/a");
    By tv_product_name = By.id("produtonome");
    By tv_product_value = By.id("produtovalor");
    By tv_product_colors = By.id("produtocores");

    public boolean IsInScreen() {
        boolean isElement = false;
        if (super.GetElement(tv_product_edition, 10) != null) {
            isElement = true;
        }
        return isElement;
    }

    public void AddProduct() {
        super.Click(bt_add_component);
    }

    public void ListAllProducts() {
        super.Click(bt_list);
    }

    public String GetProductName() {
        return super.GetElement(tv_product_name, 10).getAttribute("value");
    }

    public String GetProductValue() {
        return super.GetElement(tv_product_value, 10).getAttribute("value");
    }

    public String GetProductColors() {
        return super.GetElement(tv_product_colors, 10).getAttribute("value");
    }

}