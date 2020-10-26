package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class Base {

    public static WebDriver browser;
    public static Properties prop;

    public Base() {
        try{
            prop = new Properties();
            FileInputStream fis = new FileInputStream((
                    "src/main/config.properties"));
            prop.load(fis);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.getMessage();
        }
    }


    public static void initialization(){
        String browserName = prop.getProperty("browser");

        if(browserName.equals("chrome")){
            browser = new ChromeDriver();
        }else if(browserName.equals("firefox")){
            browser = new FirefoxDriver();
        }
//        browser.manage().window().maximize();
//        browser.manage().deleteAllCookies();
//        browser.get(prop.getProperty("url"));
    }



    public void Visit(String url){
        browser.get(url);
    }

    public WebElement GetElement(By by_locator, int waitfor){
        WebDriverWait wait = new WebDriverWait(browser, waitfor);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by_locator));
    }


    public List<WebElement> GetElements(By by_locator, int waitfor){
        WebDriverWait wait = new WebDriverWait(browser, waitfor);
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by_locator));
    }

    public void SendText(By by_locator, String text){
        WebDriverWait wait = new WebDriverWait(browser, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by_locator)).sendKeys(text);
    }

    public void Click(By by_locator){
        WebDriverWait wait = new WebDriverWait(browser, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by_locator)).click();
    }

    public void DeleteByIndex(int index){
        String locator = "/html/body/div[2]/div/ul/li["+index+"]/a";
        By by_locator = By.xpath(locator);
        Click(by_locator);
    }

    public void ClickProductByIndex(int index){
        String locator = "/html/body/div[2]/div/ul/li["+index+"]/span/a";
        By by_locator = By.xpath(locator);
        Click(by_locator);
    }
}
