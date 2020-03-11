package com.cbt.utilities;

import org.openqa.selenium.WebDriver;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TitleVerification {
    static WebDriver driver;
    public static void main(String[] args) throws Exception{
        List<String> urls = Arrays.asList("http://practice.cybertekschool.com/",
                "http://practice.cybertekschool.com/dropdown",
                "http://practice.cybertekschool.com/login");
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://google.com");

        List<String> urlsTitles = new ArrayList<>();

        for (String eachUrl : urls) {
            driver.get(eachUrl);
            urlsTitles.add(driver.getTitle());
            if (eachUrl.startsWith("http://practice.cybertekschool.com")) {
                System.out.println("Test Passed");
            } else {
                System.out.println("Test Failed");
            }
        }


        for (int i = 0; i < urlsTitles.size()-1; i++) {
            StringUtility.verifyEquals(urlsTitles.get(i), urlsTitles.get(i + 1));
            Thread.sleep(3000);
        }
        driver.close();

    }
}
