package main.java;


import org.junit.After;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

import java.util.HashMap;
import java.util.Map;


public class BasicBrowserActions {

    protected WebDriver driver;
    protected JavascriptExecutor js;
    protected DesiredCapabilities capabilities;

    protected Map<String, String> mobileEmulation = new HashMap<>();
    protected Map<String, Object> chromeOptions = new HashMap<>();

    @After
    public void tearDown() {
        driver.close();
    }

//    Initializing Drivers and jsExecutor

    protected void initializeJSExecutor() {

        if (driver instanceof JavascriptExecutor) {
            js = (JavascriptExecutor) driver;
        }else{
            throw new ClassCastException("Driver is not an instance of JavascriptExecutor");
        }

    }

    protected void initializeDesktopDriver(String browser) {
        switch (browser) {
            case "Chrome":
                System.setProperty("webdriver.chrome.driver", "chromedriver/chromedriver.exe");
                driver = new ChromeDriver();
                break;

            case "FireFox":
                driver = new FirefoxDriver();
                //@TODO add link
                break;

            case "Explorer":

                driver = new InternetExplorerDriver();
                //@TODO add link
                break;

            case "Safari":

                driver = new SafariDriver();
                //@TODO add link
                break;

            default:
                throw new IllegalArgumentException("Wrong browser");
        }

        initializeJSExecutor();

    }

    protected void initializeMobileDriver () {

        mobileEmulation.put("deviceName", "Google Nexus 6");
        chromeOptions.put("mobileEmulation", mobileEmulation);
        System.setProperty("webdriver.chrome.driver", "chromedriver/chromedriver.exe");
        capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

//        TODO try iOS and safari
//        capabilities.setCapability(CapabilityType.BROWSER_NAME, "iOS");
//        capabilities.setCapability(CapabilityType.VERSION, "10.0");

        this.driver = new ChromeDriver(capabilities);

        initializeJSExecutor();

    }

//    Browser actions

    protected void openAndMaximiseBrowser() {
        driver.manage().window().maximize();
    }

    protected void getPage() throws InterruptedException {

        String pageURL = System.getProperty("Environment");
        driver.get(pageURL);

    }

    protected void reload () {

        driver.navigate().refresh();

    }

//    TODO try more than 1 device
//    protected void devicesForEmulation() {
//        mobileEmulation.put("deviceName", "Google Nexus 6");
//    }

}