package com.libraryCT.libraryLoginFunction;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LibrarianLoginSuccessfullyFunction {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        List<String> credentials=new ArrayList<>();
        credentials.addAll(Arrays.asList("librarian47@library","librarian14@library"));

        for(String eachCredential : credentials){

            WebDriver driver =new ChromeDriver();
            driver.get("https://library2.cybertekschool.com/login.html");

            String pageTitle= driver.getTitle();

            if(pageTitle.equals("Login - Library")){
                System.out.println("Test passed, actual page title is the same with expected result");
            }else {
                System.out.println("Test failed. Actual page title is: "+pageTitle);
            }

            Thread.sleep(2000);

            WebElement inputUsername=driver.findElement(By.id("inputEmail"));
            inputUsername.sendKeys(eachCredential);

            Thread.sleep(2000);

            WebElement inputPassword=driver.findElement(By.id("inputPassword"));
            inputPassword.sendKeys("Sdet2022*");

            Thread.sleep(2000);

            WebElement signInBtn=driver.findElement(By.tagName("button"));
            signInBtn.click();

            Thread.sleep(2000);

            List<WebElement> modules= driver.findElements(By.className("title"));

            if(modules.size()==3){
                System.out.println("Test passed, actual number of modules are matching with expected result ");
            }else {
                System.out.println("Test failed. Actual number of modules are: "+modules.size());
            }

            Thread.sleep(2000);

            for(WebElement eachModule: modules){
                System.out.println("eachModule.getText() = " + eachModule.getText());
            }

            driver.quit();


        }


    }
}
/*
AC #1:
Given librarian is on the home Page
“https://library2.cybertekschool.com/login.html”
--librarian47@library
--librarian14@library
password: Sdet2022*
 Then verify that the title is “Login - Library”
 When librarian enters valid email address and password
--librarian47@library
--librarian14@library
-- password: Sdet2022*
 And librarian click sign in button
 Then verify that there are 3 models on the page
 */