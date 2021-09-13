package com.libraryCT.librarianSelectStatus;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectingStudentsStatus {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        List<String> credentials = new ArrayList<>();
        credentials.addAll(Arrays.asList("librarian47@library", "librarian14@library"));

        for (String eachCredential : credentials) {

            WebDriver driver = new ChromeDriver();
            driver.get("https://library2.cybertekschool.com/login.html");

            driver.manage().window().maximize();

            Thread.sleep(2000);

            WebElement inputUsername = driver.findElement(By.id("inputEmail"));
            inputUsername.sendKeys("librarian14@library");

            Thread.sleep(2000);

            WebElement inputPassword = driver.findElement(By.id("inputPassword"));
            inputPassword.sendKeys("Sdet2022*");

            Thread.sleep(2000);

            WebElement signInBtn = driver.findElement(By.tagName("button"));
            signInBtn.click();

            Thread.sleep(3000);

            WebElement userModule=driver.findElement(By.xpath("//*[@id='menu_item']/li[2]/a/span[1]"));
            userModule.click();

            Thread.sleep(3000);

            WebElement  activStatus=driver.findElement(By.id("user_status"));
            activStatus.click();

            Thread.sleep(2000);

            List<WebElement> allStatusOptions=driver.findElements(By.xpath("//*[@id='user_status']//option"));
            int number=1;
            if(allStatusOptions.size()==2){
                System.out.println("Test passed. Actual number of activity status are matching with expecting result");
                System.out.println("Number of activity status options are: "+allStatusOptions.size());
                for (WebElement eachStatusOption : allStatusOptions) {
                    System.out.println("Option "+number++ +" is: " + eachStatusOption.getText());
                    if(eachStatusOption.isEnabled()){
                        System.out.println("Option is clickable, function is fully  working");
                    }else {
                        System.out.println("Not all options are clickable, function is not fully working");
                    }
                }
            }else {
                System.out.println("Test did not pass. Actual size of activity status modules are " +
                        "not matching with expected result");
                System.out.println("Number of activity status modules are: "+allStatusOptions.size());
                for (WebElement eachStatusOption : allStatusOptions) {
                    System.out.println("Option "+number++ +" is: " + eachStatusOption.getText());
                }
            }

            Select selectStatus=new Select(activStatus);
            selectStatus.selectByValue("ACTIVE");
            Thread.sleep(2000);
            selectStatus.selectByValue("INACTIVE");
            Thread.sleep(2000);
            selectStatus.selectByValue("ACTIVE");

            Thread.sleep(3000);

            driver.findElement(By.id("navbarDropdown")).click();

            Thread.sleep(3000);

            WebElement logOutBtn=driver.findElement(By.linkText("Log Out"));
            logOutBtn.click();

            Thread.sleep(3000);

            driver.quit();


        }
    }
}
/*
TODO:
 <<https://library2.cybertekschool.com/login.html>>
 Credentials:
 --librarian47@library,
 --librarian14@library,
 --student34@library,
 --student35@library,
 --student36@library
  AC #1:
 Given  librarian is on the homePage
 When  librarian click Users module
 And  librarian click Status dropdown
 Then verify there are 2 status options
 */