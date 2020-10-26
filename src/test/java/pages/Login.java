package pages;

import org.openqa.selenium.By;

public class Login extends Base {

    By et_user = By.id("usuario");
    By et_pwd = By.id("senha");
    By bt_login = By.xpath("/html/body/div[2]/div[1]/div/form/div[4]/div/button");
    By toast = By.xpath("//*[@id=\"toast-container\"]/div");


    public void LaunchLoginPage(){
        super.Visit("http://165.227.93.41/lojinha-web/");
    }

    public void SetUser(String user){
        super.SendText(et_user, user);
    }

    public void SetPassword(String pwd){
        super.SendText(et_pwd, pwd);
    }

    public void ClickLogin(){
        super.Click(bt_login);
    }

    public boolean IsToast(){
        boolean isElement = false;
        if(super.GetElement(toast, 10) != null){
            isElement = true;
        }
        return isElement;
    }
}
