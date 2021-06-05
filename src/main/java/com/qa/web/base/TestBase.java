package com.qa.web.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static com.qa.web.utils.TestUtil.IMPLICITLY_WAIT;
import static com.qa.web.utils.TestUtil.Page_Load_Timeout;

public class TestBase {


     public static WebDriver driver;
     static Properties properties;



    public TestBase() {
        try {
            properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/com/qa/web/config/config.properties");
            properties.load(fileInputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException IO) {
            IO.printStackTrace();
        }

    }

    public static void Initialization() {
        String browser = properties.getProperty("browser");

        if (browser.equals("Chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        } else if (browser.equals("ff")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Page_Load_Timeout, TimeUnit.SECONDS);
         driver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT, TimeUnit.SECONDS);

        driver.get(properties.getProperty("url"));

    }


}
