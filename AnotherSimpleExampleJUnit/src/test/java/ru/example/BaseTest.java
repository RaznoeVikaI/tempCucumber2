package ru.example;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

abstract public class BaseTest {
    public static int implicitWaitTimeout = 10;
    public static int explicitWaitTimeout = 10;
    public static WebDriver driver;
    public static WebDriverWait wait;

    public static WebDriver createFirefoxDriver (){
        driver = new FirefoxDriver();
        return driver;
    }

    public static WebDriver createChromeDriver(){
        ChromeOptions options = new ChromeOptions();
        if(System.getProperty("webdriver.chrome.headless")!=null && System.getProperty("webdriver.chrome.headless").equals("on")){
            options.addArguments("--headless");
        }
        driver = new ChromeDriver(options);
        return driver;
    }

    public static WebDriver createOperaDriver(){
        OperaOptions oo = new OperaOptions();
        oo.setBinary("C:\\Program Files\\Opera\\52.0.2871.40\\opera.exe");
        driver = new OperaDriver(oo);
        return driver;
    }

    public static WebDriver createEdgeDriver(){
        driver = new EdgeDriver();
        return driver;
    }

    public static WebDriver getDriver(){
        if(driver == null){
            String value =  System.getProperty("webdriver");
            if (value == null) value = "chrome";
            if (value.equals("chrome")) {
                createChromeDriver();

            } else if (value.equals("firefox")) {
                createFirefoxDriver();

            } else if (value.equals("opera")) {
                createOperaDriver();

            } else if (value.equals("edge")) {
                createEdgeDriver();

            } else {
                createChromeDriver();

            }
            wait = new WebDriverWait(driver, explicitWaitTimeout);
            driver.manage().timeouts().implicitlyWait(implicitWaitTimeout, TimeUnit.SECONDS);
        }
        return driver;
    }

}