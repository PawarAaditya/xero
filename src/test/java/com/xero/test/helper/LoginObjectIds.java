package com.xero.test.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public interface LoginObjectIds {

    By Username = By.id("email");
    By Password = By.id("password");
    By Submit= By.id("submitButton");
    By UserAnotherloginmethod =By.xpath("//button[contains(text(),'Use another')]");
    By selectSecurityQuestions =By.xpath("//button[starts-with(@data-automationid,'auth-authwithsecurityquestionsbutton')]");
    By firstquestion=By.xpath("//span[contains(@class,'first')]");
    By secondquestion=By.xpath("//span[contains(@class,'second')]");
    By firstanswer=By.xpath("//input[contains(@data-automationid,'firstanswer')]");
    By secondanswer=By.xpath("//input[contains(@data-automationid,'secondanswer')]");
    By submitsecurity=By.xpath("//button[contains(@data-automationid,'submit')]");
    By Account =By.xpath("//a[contains(text(),'Accounts')]");
    By BankAccount=By.xpath("//a[contains(text(),'Bank Accounts')]");
    By addBankAccount=By.xpath("//span[contains(text(),'Add Bank Account')]");






}
