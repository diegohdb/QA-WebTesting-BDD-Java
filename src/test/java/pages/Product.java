package pages;

import org.openqa.selenium.By;

public class Product extends Base{
    By et_product_name = By.id("produtonome");
    By et_product_value = By.id("produtovalor");
    By et_product_colors = By.id("produtocores");
    By bt_save = By.xpath("/html/body/div[2]/div/div/form/div[5]/button");
    By toast = By.xpath("//*[@id=\"toast-container\"]/div");

    public void SetName(String product_name){
        super.SendText(et_product_name, product_name);
    }

    public void SetValue(String product_value){
        super.SendText(et_product_value, product_value);
    }

    public void SetColors(String product_colors){
        super.SendText(et_product_colors, product_colors);
    }

    public void SaveProduct(){
        super.Click(bt_save);
    }

    public String GetToastMessage(){
        return super.GetElement(toast, 10).getText();
    }
}
