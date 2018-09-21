package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class test {

public static void main(String[]args) {

    System.setProperty("webdriver.chrome.driver","C:\\Users\\aditya_pawar01\\IdeaProjects\\Xero\\src\\main\\resources\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.get("https://login.xero.com/");
    driver.findElement(By.id("email")).sendKeys("aaditya.pawar778@gmail.com");
    driver.findElement(By.id("password")).sendKeys("xero@123");
    driver.findElement(By.id("submitButton")).click();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.findElement(By.xpath("//button[contains(text(),'Use another')]")).click();
    driver.findElement(By.xpath("//button[starts-with(@data-automationid,'auth-authwithsecurityquestionsbutton')]")).click();
    String firstquestion = driver.findElement(By.xpath("//span[contains(@class,'first')]")).getText();
    String secondquestion = driver.findElement(By.xpath("//span[contains(@class,'second')]")).getText();





}


}
