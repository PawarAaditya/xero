package com.xero.test.helper;

import org.openqa.selenium.By;

public interface AccountPageObjectIds {

    By searchForBank = By.xpath("//input[contains(@placeholder,'Search for your bank')]");
    By addbankanyway = By.xpath("//a[@href='#' and @data-automationid='addItAnywayLink']");
    By searchbank=By.xpath("//div[@id='xui-searchfield-1018-trigger-trigger']");
    By AccountName= By.xpath("//input[@id ='accountname-1037-inputEl']");
    By AccountType= By.xpath("//input[@id='accounttype-1153-inputEl']");
    By selectAccountType=By.xpath("//div[@id=\"accounttype-1039-inputWrap\"]");






}
