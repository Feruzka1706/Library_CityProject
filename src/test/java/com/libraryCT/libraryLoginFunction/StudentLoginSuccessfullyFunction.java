package com.libraryCT.libraryLoginFunction;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentLoginSuccessfullyFunction {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        List<String> credentials=new ArrayList<>();
        credentials.addAll(Arrays.asList("student34@library","student35@library","student36@library"));

        for(String eachCredential: credentials){

            WebDriver driver =new ChromeDriver();
            driver.navigate().to("https://library2.cybertekschool.com/login.html");

            String urlTitle=driver.getCurrentUrl();

            if(urlTitle.equals("https://library2.cybertekschool.com/login.html")){
                System.out.println("Test is passed. Expected URL name and actual URL name is the same");
            }else {
                System.out.println("Test is failed: Actual URL is: "+urlTitle);
            }

            Thread.sleep(3000);

            WebElement inputUsername=driver.findElement(By.id("inputEmail"));
            inputUsername.sendKeys(eachCredential);

            Thread.sleep(3000);

            WebElement inputPassword=driver.findElement(By.id("inputPassword"));
            inputPassword.sendKeys("Sdet2022*");

            Thread.sleep(2000);

            //WebElement signInBtn=driver.findElement(By.linkText("Sign in"));
            WebElement signInBtn=driver.findElement(By.tagName("button"));
            signInBtn.click();

            Thread.sleep(3000);

          List<WebElement> modules= driver.findElements(By.className("title"));

          if(modules.size()==2){
              System.out.println("Test passed, actual number of modules are matching with expecting result");
          }else {
              System.out.println("Test failed. Actual number of modules are: "+modules.size());
          }

          Thread.sleep(2000);

          for(WebElement eachModule : modules){

              System.out.println("eachModule.getText() = " + eachModule.getText());
          }

          driver.quit();


        }


    }
}
/*
 AC#2:
 Given student is on the login Page
--student34@library
--student35@library
--student36@library
password: Sdet2022*
 Then * verify that the URL is
 “https://library2.cybertekschool.com/login.html”
 When    student enters    valid email address and   password
 And     student click sign in button  *
 Then verify* that there are 2 models on the page


 */