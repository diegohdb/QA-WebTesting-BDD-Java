package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Products extends Base {

    By tv_list_products = By.xpath("/html/body/div[2]/div/h3");
    By bt_add_product = By.xpath("/html/body/div[2]/div/div/a");
    By ul_products = By.xpath("/html/body/div[2]/div/ul");
    By product_names = By.xpath("/html/body/div[2]/div/ul/li/span/a");
    By toast = By.xpath("//*[@id=\"toast-container\"]/div");


    public boolean IsInScreen(){
        boolean isElement = false;
        if(super.GetElement(tv_list_products, 10)!= null){
            isElement = true;
        }
        return isElement;
    }

    public void AddProduct(){
        super.Click(bt_add_product);
    }

    public List<WebElement> GetAllProducts(){
        return super.GetElements(product_names, 10);
    }

    public List GetAllProductsNames(){
        List<WebElement> products_elements = GetAllProducts();
        List myList = new ArrayList();

        for(int i=0; i<products_elements.size(); i++){
            myList.add(products_elements.get(i).getText());
        }

        return myList;
    }

    public String GetToastMessage(){
        return super.GetElement(toast, 10).getText();
    }

    public void DeleteProduct(String product){
        List<WebElement> products = GetAllProducts();
        for(int i=0; i<products.size(); i++) {
            String name = products.get(i).getText();
            if (name.equals(product)) {
                DeleteByIndex(i + 1);
            }
        }
    }

    public void InspectProduct(String product){
        List<WebElement> products = GetAllProducts();
        for(int i=0; i<products.size(); i++) {
            String name = products.get(i).getText();
            if (name.equals(product)) {
                ClickProductByIndex(i + 1);
            }
        }
    }

}
