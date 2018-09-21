package com.xero.test.AccountPage;
import com.esotericsoftware.yamlbeans.YamlException;
import com.esotericsoftware.yamlbeans.YamlReader;
import com.xero.test.PageObject.PageObject;
import com.xero.test.helper.AccountPageObjectIds;
import com.xero.test.helper.EnvironmentProperties;
import com.xero.test.helper.LoginObjectIds;
import com.xero.test.helper.SecurityDataHelper;
import jnr.ffi.Struct;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.yecht.Data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.concurrent.TimeUnit;



public class AccountHome extends PageObject {

    EnvironmentProperties environmentProperties = new EnvironmentProperties();

    public static WebDriver driver;

    public WebDriver getDriver() {
        return this.driver;
    }

    public void getinitialsettings() {

        String url = environmentProperties.getProperty("xeroLoginUrl");
        getApplicationURL(url);
    }


    private void getApplicationURL(String url) {

        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\webdriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.get(url);
        login_to_xero_console();


    }

    private void login_to_xero_console() {
        String username = environmentProperties.getProperty("Username");
        String password = environmentProperties.getProperty("Password");
        setvaluesInTextbox(LoginObjectIds.Username, username);
        setvaluesInTextbox(LoginObjectIds.Password, password);
        clickOn(LoginObjectIds.Submit);

    }

    private void setvaluesInTextbox(By by, String value) {
        getDriver().findElement(by).sendKeys(value);

    }

    public void clickOn(By by) {
        getDriver().findElement(by).click();
    }

    public void ValidateFirstSecurityQuestions() {
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        clickOn(LoginObjectIds.UserAnotherloginmethod);
        clickOn(LoginObjectIds.selectSecurityQuestions);
        String question = getDriver().findElement(LoginObjectIds.firstquestion).getText();
        System.out.println(question);
        String ans=getanswersOfSecurityQuestion(question);
        String result=getanswer(ans);
        setvaluesInTextbox(LoginObjectIds.firstanswer,result);
    }

    public void ValidateSecondSecurityQuestions() {
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String question = getDriver().findElement(LoginObjectIds.secondquestion).getText();
        System.out.println(question);
        String ans=getanswersOfSecurityQuestion(question);
        String result=getanswer(ans);
       setvaluesInTextbox(LoginObjectIds.secondanswer,result);
        //String question1=getDriver().findElements(LoginObjectIds.secondquestion).getText();
        clickOn(LoginObjectIds.submitsecurity);
    }

    public void ValidateSecondQuestion() {
        String question1 = getDriver().findElement(LoginObjectIds.secondquestion).getText();
        getanswersOfSecurityQuestion(question1);
    }


    private String getanswersOfSecurityQuestion(String que) {

        String ans;

        if (que.contains("cartoon"))
            ans = "What is the name of your favourite cartoon?";

        else if (que.contains("movie"))
            ans = "What is your most disliked movie?";

        else {
            ans = "What is your most disliked holiday?";
        }

       return ans;

    }

    private String getanswer(String que) {
        String result = "NA";
        File yamlFile = new File(getClass().getClassLoader().getResource("security.yml").getFile());
        YamlReader yamlReader = null;
        try {
            yamlReader = new YamlReader(new FileReader(yamlFile));
            //Map map = (Map) yamlReader.read();
            HashMap<String, String> data = (HashMap) yamlReader.read();
            Set set = data.entrySet();
            Iterator iterator = set.iterator();
            while (iterator.hasNext()) {

                Map.Entry ques = (Map.Entry) iterator.next();
                if (ques.getKey().toString().contentEquals(que)) {
                    result = ques.getValue().toString();
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (YamlException e) {
            e.printStackTrace();
        }
        return result;

    }


    public void clickonAccount() {
        getDriver().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        clickOn(LoginObjectIds.Account);
        clickOn(LoginObjectIds.BankAccount);
        getDriver().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        clickOn(LoginObjectIds.addBankAccount);
        setvaluesInTextbox(AccountPageObjectIds.searchForBank,"ANZ (NZ)");
        //clickOn(AccountPageObjectIds.searchForBank);
        WebDriverWait wait = new WebDriverWait(getDriver(), 20);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(AccountPageObjectIds.addbankanyway));
        //driver.findElement(By.id("Passwd")).sendKeys("xyz");
        clickOn(AccountPageObjectIds.addbankanyway);
        setvaluesInTextbox(AccountPageObjectIds.AccountName,"Automation");
        /*Select select =new Select(driver.findElement(AccountPageObjectIds.AccountType));
        select.selectByIndex(1);*/
        //getDriver().quit();
      getDriver().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    //  getDriver().findElement(AccountPageObjectIds.AccountType).sendKeys(Keys.ARROW_DOWN,Keys.RETURN);
/*
        selectAccountType("Credit Card");
*/
    getDriver().quit();
        }

//  /*  public void selectAccountType( String type){
//        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
//
//       *//*//*/ WebElement element = getDriver().findElement(AccountPageObjectIds.AccountType);
//        Select sel = new Select(element);
//        sel.selectByVisibleText(type);*//*
//
//   *//*     Actions action = new Actions(driver);
//        WebElement optionsList = driver.findElement(AccountPageObjectIds.AccountType);
//        action.moveToElement(optionsList);
//        List<WebElement> options = driver.findElements(By.xpath("//div[@id='accounttype-1039-trigger-picker']"));
//        for(WebElement option : options) {
//            if (option.) {
//                option.click();
//            }
//        }*//*


//    }*/
}
























