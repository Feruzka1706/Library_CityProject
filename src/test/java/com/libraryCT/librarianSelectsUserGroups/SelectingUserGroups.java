package com.libraryCT.librarianSelectsUserGroups;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectingUserGroups {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        List<String> credentials=new ArrayList<>();
        credentials.addAll(Arrays.asList("librarian47@library","librarian14@library"));

        for (String eachCredential : credentials) {

            WebDriver driver=new ChromeDriver();
            driver.get("https://library2.cybertekschool.com/login.html");

            Thread.sleep(2000);

            WebElement inputUsername=driver.findElement(By.id("inputEmail"));
            inputUsername.sendKeys("librarian14@library");

            Thread.sleep(2000);

            WebElement inputPassword=driver.findElement(By.id("inputPassword"));
            inputPassword.sendKeys("Sdet2022*");

            Thread.sleep(2000);

            WebElement signInBtn=driver.findElement(By.tagName("button"));
            signInBtn.click();

            Thread.sleep(3000);

            WebElement userModule=driver.findElement(By.xpath("//*[@id='menu_item']/li[2]/a/span[1]"));
            userModule.click();

            Thread.sleep(2000);

            WebElement userGroupDropDown= driver.findElement(By.id("user_groups"));
            userGroupDropDown.click();

            Thread.sleep(2000);

            List<WebElement> allOptions=driver.findElements(By.xpath("//select[@id='user_groups']//option"));

            if(allOptions.size()==3){
                System.out.println("Test passed. User modules are matching with expected result");
                System.out.println("Number of user modules are: "+allOptions.size());
                int numbers=1;
                for (WebElement eachOption : allOptions) {
                    if(eachOption.isEnabled()){
                        System.out.println("Each user module is clickable" );
                    }else {
                        System.out.println("Each user module is not clickable");
                    }
                    System.out.println("User module "+numbers++ +" = " + eachOption.getText());
                }
            }else {
                System.out.println("Test did not pass. Actual numbers of modules are not matching with expecting result");
                System.out.println("Actual number of user modules are: "+allOptions.size());
                for (WebElement eachOption : allOptions) {
                    System.out.println("eachOption.getText() = " + eachOption.getText());
                }
            }

            Select userOption=new Select(userGroupDropDown);
            userOption.selectByIndex(1);
            Thread.sleep(2000);
            userOption.selectByValue("2");
            Thread.sleep(2000);
            userOption.selectByVisibleText("Students");

            Thread.sleep(2000);

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
 Password:
 --Sdet2022*
AC #1:
--Given librarian is on the homePage
--When librarian click Users module
--And librarian click user group dropdown
--Then verify librarian have 3 options
 */