package com.xero.test.stepdefinition;

import com.xero.test.AccountPage.AccountHome;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import com.xero.test.helper.EnvironmentProperties;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyStepdefs extends AccountHome
{

    EnvironmentProperties envProps = new EnvironmentProperties();
    AccountHome accountHome=new AccountHome();

    @Given("^Login in Xero account with Username and Password$")
    public void GivenLoginInXeroAccountWithUsernameAndPassword() throws Throwable {

        accountHome.getinitialsettings();
    }

    @When("^Security Questions Answered$")
    public void securityQuestionsAnswered() throws Throwable {
        accountHome.ValidateFirstSecurityQuestions();
        accountHome.ValidateSecondSecurityQuestions();
        accountHome.clickonAccount();


    }
}
