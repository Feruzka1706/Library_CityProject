package com.libraryCT.libraryLoginFunction;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoginInvalidCredentialsFunction {
    public static void main(String[] args)throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        List<String> credentials=new ArrayList<>();
        credentials.addAll(Arrays.asList("student30_library","librarian1706@com",
                "student34","student@library","cybertek@school.com"));
        int testCredential=1;

        for(String eachCredential :credentials ){

            WebDriver driver = new ChromeDriver();
            driver.navigate().to("https://library2.cybertekschool.com/login.html");

            Thread.sleep(2000);

            WebElement inputUsername=driver.findElement(By.id("inputEmail"));
            inputUsername.sendKeys(eachCredential);

            Thread.sleep(2000);

            WebElement inputPassword=driver.findElement(By.id("inputPassword"));
           if(eachCredential.equals("student34@library") || eachCredential.equals("student35@library")
                   || eachCredential.equals("student36@library")){
               inputPassword.sendKeys("SDET2123#");
           }else {
               inputPassword.sendKeys("Sdet2022*");
           }

           Thread.sleep(2000);

            WebElement signInBtn=driver.findElement(By.tagName("button"));
            signInBtn.click();

            Thread.sleep(2000);

            WebElement errorMessage =driver.findElement(By.cssSelector("#login-form > div:nth-child(2) > div"));
            WebElement invalidMessage=driver.findElement(By.cssSelector("#login-form > div:nth-child(2) > div"));

            String getErrorMessage= errorMessage.getText();
            String getInvalidMessage=invalidMessage.getText();

            if(getErrorMessage.equals("Sorry, Wrong Email or Password")){
                System.out.println("Test "+testCredential+", "+eachCredential+" passed, actual error message is matching with expected result ");
                System.out.println(getErrorMessage);
            }else{
                System.out.println("Test "+testCredential+", "+eachCredential+" failed. Actual error message is not matching with expected result");
                System.out.println("Actual error message is: "+getInvalidMessage);
            }

            driver.quit();

            testCredential++;



        }
    }
}
/*
--student34@library
--student35@library
--student36@library
password: Sdet2022*
AC #3 [negative]:
  Given  user is on the loginPage
  When  user enters invalid email address or password
   And  student click sign in button
   Then  verify the error message “Sorry, Wrong Email or Password”
 */