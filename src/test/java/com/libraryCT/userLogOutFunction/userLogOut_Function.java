package com.libraryCT.userLogOutFunction;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import sun.jvm.hotspot.runtime.ThreadLocalAllocBuffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class userLogOut_Function {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        List<String> credentials=new ArrayList<>();
        credentials.addAll(Arrays.asList("librarian47@library","librarian14@library",
                "student34@library","student35@library","student36@library"));

        for (String eachCredential : credentials) {

            WebDriver driver =new ChromeDriver();
            driver.get("https://library2.cybertekschool.com/login.html");

            WebElement inputUsername=driver.findElement(By.id("inputEmail"));
            inputUsername.sendKeys(eachCredential);

            Thread.sleep(2000);

            WebElement inputPassword=driver.findElement(By.id("inputPassword"));
            inputPassword.sendKeys("Sdet2022*");

            Thread.sleep(2000);

            WebElement signInBtn=driver.findElement(By.tagName("button"));
            signInBtn.click();

            Thread.sleep(3000);

           // WebElement dropDownBar=
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
AC#1
              <<credentials:>>
--librarian47@library,
--librarian14@library,
--student34@library,
--student35@library,
--student36@library
              <<Password:>>
--Sdet2022*
Given  user is on the homePage
When  user click username on the right top corner
And  user click Log Out
Then verify user navigate back to login page.
 */