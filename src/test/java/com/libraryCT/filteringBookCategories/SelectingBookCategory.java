package com.libraryCT.filteringBookCategories;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class SelectingBookCategory {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();


        List<String> credentials=new ArrayList<>();
        credentials.addAll(Arrays.asList("librarian47@library","librarian14@library",
                "student34@library","student35@library","student36@library"));

        for (String eachCredential : credentials) {

            WebDriver driver =new ChromeDriver();
            driver.get("https://library2.cybertekschool.com/login.html");

            WebElement inputUsername = driver.findElement(By.id("inputEmail"));
            inputUsername.sendKeys(eachCredential);

            Thread.sleep(2000);

            WebElement inputPassword = driver.findElement(By.id("inputPassword"));
            //WebElement inputPassword=driver.findElement(By.xpath("//label[text()='Email address']"));
            inputPassword.sendKeys("Sdet2022*");

            Thread.sleep(2000);

            WebElement signInBtn = driver.findElement(By.tagName("button"));
            signInBtn.click();

            Thread.sleep(3000);
            String expectedPageTitle="Library";

            if(driver.getTitle().equals(expectedPageTitle)){
                System.out.println("Actual page title is matching with expecting result");
                System.out.println("Page title is: "+driver.getTitle());
            }

           if(eachCredential.equals("student36@library")){
               WebElement bookCategory = driver.findElement(By.cssSelector("#book_categories"));
               bookCategory.click();
           }else {
               WebElement booksModule = driver.findElement(By.xpath("//span[@class='title' and text()='Books']"));
               booksModule.click();

               Thread.sleep(2000);
               WebElement bookCategory = driver.findElement(By.cssSelector("#book_categories"));
               bookCategory.click();
           }

            Thread.sleep(2000);

            //verify user chose "Drama" category
            Select dramaOption=new Select(driver.findElement(By.cssSelector("#book_categories")));
            dramaOption.selectByVisibleText("Drama");

            WebElement chosenOption=dramaOption.getFirstSelectedOption();

            if(chosenOption.getText().equals("Drama")){
                System.out.println("Test passed. Actual chosen book category option is mathcing with expected result");
                System.out.println("User chose the option is: " + chosenOption.getText());
            }

            // optional :
            List<WebElement> allBookCategories = driver.findElements(By.cssSelector("#book_categories > option"));
            //List<WebElement> allBookCategories = driver.findElements(By.xpath("//*[@id=\"book_categories\"]/option"));

            int num=1;
            for (WebElement eachBookCategory : allBookCategories) {
                if(eachBookCategory.isEnabled()){
                    System.out.println("Name of "+num++ +" book category is: "+eachBookCategory.getText());
                }else{
                    System.out.println("Test didn't pass. Not all categories are enable to click");
                    System.out.println("Not clickable book category is: "+eachBookCategory.getText());
                }
            }

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
  AC #2:
  Given user is on the homePage
  When user click Books module
  And user click book category dropdown
  Then verify user is able to selected the “Drama” option
 */