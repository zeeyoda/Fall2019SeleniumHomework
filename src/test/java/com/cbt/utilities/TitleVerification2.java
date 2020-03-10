package com.cbt.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TitleVerification2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        List<String> urls = Arrays.asList("https://luluandgeorgia.com/",
                "https://wayfair.com/", "https://walmart.com", "https://westelm.com/");
        List<String> titles = new ArrayList<>();
        for (String eachUrl : urls) {
            driver.get(eachUrl);
            Thread.sleep(2000);
            if (eachUrl.contains(driver.getTitle().toLowerCase().replace(" ", ""))) {
                System.out.println("Test Passed");
            } else {
                System.out.println("Test failed");
            }
            titles.add(driver.getTitle());
        }
        driver.close();
    }
}
