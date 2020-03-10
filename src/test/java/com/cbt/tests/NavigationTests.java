package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


public class NavigationTests {
   static WebDriver driver;

    public static void main(String[] args) throws Exception {
        chromeTest();
      //firefoxTest();
       // edgeTest();

    }
    public static void chromeTest(){
    driver = BrowserFactory.getDriver("chrome");
    driver.get("https://google.com");
    String title = driver.getTitle();
        System.out.println(title);
     driver.findElement(By.name("q")).sendKeys("https://etsy.com", Keys.ENTER);
     String title1 = driver.getTitle();
     driver.navigate().back();
     String title2 = driver.getTitle();
     if (title.equalsIgnoreCase(title2)){
         System.out.println("Pass");
     }else{
         System.out.println("Fail");
     }
     driver.navigate().forward();
     String title3 = driver.getTitle();
     if(title1.equalsIgnoreCase(title3)){
         System.out.println("Pass");
     }else{
         System.out.println("Fail");
     }
     driver.close();
    }
    public static void firefoxTest() throws Exception{
        driver = BrowserFactory.getDriver("firefox");
        driver.get("http://google.com");
        String title = driver.getTitle();
        System.out.println(title);

        driver.findElement(By.name("q")).sendKeys("https://etsy.com", Keys.ENTER);
        Thread.sleep(3000);
        String title1 = driver.getTitle();
        System.out.println("title1 "+title1);

        driver.navigate().back();
        Thread.sleep(2000);
        String title2 = driver.getTitle();
        if(title.equalsIgnoreCase(title2)){
            System.out.println("Title equals title 2 - Pass");
        }else{
            System.out.println("Fail");
        }
        driver.navigate().forward();
        Thread.sleep(2000);

        String title3 = driver.getTitle();
        System.out.println("title3 "+title3);
        if(title1.equalsIgnoreCase(title3)){
            System.out.println("Pass");
        }else{
            System.out.println("Fail");
        }
       driver.close();
    }
    public static void edgeTest() throws Exception{
        driver = BrowserFactory.getDriver("edge");
        driver.get("http://google.com");
        String title = driver.getTitle();
        Thread.sleep(2000);
        driver.findElement(By.name("q")).sendKeys("etsy", Keys.ENTER);

        String title1 = driver.getTitle();
        driver.navigate().back();
        Thread.sleep(2000);

        String title2 = driver.getTitle();
        if(title.equalsIgnoreCase(title2)) {
            System.out.println("Test Passed.");
        }else{
            System.out.println("Test Failed.");
        }
        driver.navigate().forward();
        Thread.sleep(2000);
        String title3 = driver.getTitle();

        if(title1.equalsIgnoreCase(title3)){
            System.out.println("Test passes");
        }else{
            System.out.println("Test failed");
        }
        driver.close();
    }
}
