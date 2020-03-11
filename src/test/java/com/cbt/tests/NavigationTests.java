package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.WebDriver;


public class NavigationTests {
   static WebDriver driver;

    public static void main(String[] args)  {
        chromeTest();
      //firefoxTest();
       // edgeTest();

    }

    public static void chromeTest() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://google.com");
        String titleGoogle = driver.getTitle();

        driver.get("https://etsy.com");
        String titleEtsy = driver.getTitle();

        driver.navigate().back();
        String titleGoogle1 = driver.getTitle();
        StringUtility.verifyEquals(titleGoogle, titleGoogle1);

        driver.navigate().forward();
        String titleEtsy1 = driver.getTitle();
        StringUtility.verifyEquals(titleEtsy, titleEtsy1);
        driver.close();
    }
    public static void firefoxTest() {
        driver = BrowserFactory.getDriver("firefox");
        driver.get("http://google.com");
        String titleG1 = driver.getTitle();

        driver.get("https://etsy.com");
        String titleE1 = driver.getTitle();

        driver.navigate().back();
        String titleG2 = driver.getTitle();
        StringUtility.verifyEquals(titleG1, titleG2);

        driver.navigate().forward();
        String titleE2 = driver.getTitle();
        StringUtility.verifyEquals(titleE1, titleE2);

        driver.close();
    }
    public static void edgeTest() {
        driver = BrowserFactory.getDriver("edge");
        driver.get("http://google.com");
        String titleG1 = driver.getTitle();

        driver.get("https://etsy.com");
        String titleE1 = driver.getTitle();

        driver.navigate().back();
        String titleG2 = driver.getTitle();
        StringUtility.verifyEquals(titleG1, titleG2);

        driver.navigate().forward();
        String titleE2 = driver.getTitle();
        StringUtility.verifyEquals(titleE1, titleE2);

        driver.close();
    }
}
