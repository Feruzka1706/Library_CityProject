package com.libraryCT.librarianAddsNewUserFunction;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Librarian47AddsNewUser {


    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://library2.cybertekschool.com/login.html");

        Thread.sleep(2000);

        WebElement inputUsername=driver.findElement(By.id("inputEmail"));
        inputUsername.sendKeys("librarian47@library");

        Thread.sleep(2000);

        WebElement inputPassword=driver.findElement(By.id("inputPassword"));
        inputPassword.sendKeys("Sdet2022*");

        Thread.sleep(2000);

        WebElement signInBtn=driver.findElement(By.tagName("button"));
        signInBtn.click();

        Thread.sleep(3000);

        WebElement userModule=driver.findElement(By.cssSelector("#menu_item > li:nth-child(2) > a > span.title"));
        userModule.click();

        Thread.sleep(2000);

        WebElement addUserBtn=driver.findElement(By.xpath("//*[@id='users']/div[1]/div[1]/span/a"));
        addUserBtn.click();

        Thread.sleep(2000);
        WebElement totalUsers= driver.findElement(By.id("tbl_users_info"));
        String totalUsersMessage=totalUsers.getText();

        Thread.sleep(2000);
        WebElement fullName=driver.findElement(By.name("full_name"));
        fullName.sendKeys("User User17");

        Thread.sleep(2000);

        WebElement passwordBox =  driver.findElement(By.name("password"))  ;
        passwordBox.sendKeys("UserUser17");

        Thread.sleep(2000);

        WebElement emailBox = driver.findElement(By.name("email"));
        emailBox.sendKeys("feruza17@gmail.com");

        Thread.sleep(2000);


        WebElement userGroup=driver.findElement(By.id("user_group_id"));

        Select studentOpt= new Select(userGroup);
        studentOpt.selectByIndex(1);

        Thread.sleep(3000);

        WebElement activStatus = driver.findElement(By.id("status"));
        Select userStatus=new Select(activStatus);
        userStatus.selectByVisibleText("ACTIVE");


        WebElement addressBox = driver.findElement(By.id("address"));
        addressBox.sendKeys("7925 McLean Virginia 95678");

        Thread.sleep(2000);
        WebElement saveChangesBtn=driver.findElement(By.xpath("//*[@id='add_user_form']/div[2]/button[2]"));
        saveChangesBtn.submit();

        Thread.sleep(2000);

        WebElement totalUsersAfterAdding=driver.findElement(By.id("tbl_users_info"));
        String afterAddingTotalUsers=totalUsersAfterAdding.getText();

        if (! totalUsersMessage.equals(afterAddingTotalUsers)){
            System.out.println("Test is passed. Total users number increased by one after adding new user");
            System.out.println("Total users number before: "+totalUsersMessage);
            System.out.println("Total users number after: "+afterAddingTotalUsers);
        }else {
            System.out.println("Test is failed. Total users number didn't increase after adding new user");
            System.out.println(totalUsersMessage);
            System.out.println(afterAddingTotalUsers);
        }

        driver.quit();







    }
}
