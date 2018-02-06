

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

import javax.swing.text.Position;
import java.util.HashMap;
import java.util.Map;

public class BasicBrowserActions {

    protected WebDriver driver;
    protected JavascriptExecutor js;
    protected DesiredCapabilities capabilities;

    protected Map<String, String> mobileEmulation = new HashMap<>();
    protected Map<String, Object> chromeOptions = new HashMap<>();

    protected String portraitOrientation = "portrait-primary";

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

    protected void initializeMobileDriver (String device) {
        mobileEmulation.put("deviceName", device);
        chromeOptions.put("mobileEmulation", mobileEmulation);
        System.setProperty("webdriver.chrome.driver", "chromedriver/chromedriver.exe");
        capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

        driver = new ChromeDriver(capabilities);

        initializeJSExecutor();
    }

    protected void initializeLandscapeOrientedMobileDriver() {
        initializeMobileDriver("Nexus 7");
    }

    protected void initializePortraitOrientedMobileDriver() {
        initializeMobileDriver("Nexus 6");
    }

//    Browser actions

    protected void openAndMaximiseBrowser() {
        driver.manage().window().maximize();

        System.out.println("Maximized browser");
    }

    protected void getPage() {

        String pageURL = System.getProperty("Environment");
        driver.get(pageURL);

        System.out.println("Get page");

    }

    protected void reload () {

        driver.navigate().refresh();

        System.out.println("Reloaded");

    }

    protected void clickOnElementByClassName(String elementClassName) {
        WebElement element = driver.findElement(By.className(elementClassName));
        element.click();

        System.out.println("Clicked on button with class " + elementClassName);
    }

    protected void clickOnElementById(String elementId) {
        WebElement element = driver.findElement(By.id(elementId));
        element.click();

        System.out.println("Clicked on button with id " + elementId);
    }

    protected void clickOnElementByCoordinates (int positionX, int positionY) {

        WebElement canvasGameArea = driver.findElement(By.id("canvasAnimationManager"));
        Actions hoverElement = new Actions(driver);
        hoverElement.moveToElement(canvasGameArea, positionX, positionY).click().perform();

        System.out.println("Clicked on coordinates: X = " + positionX + ", Y = " + positionY);

    }

    protected String getScreenOrientation() {
        return (String) js.executeScript("return window.screen.orientation.type");
    }

    protected boolean isPortraitOrientation() {
        return getScreenOrientation().equals(portraitOrientation);
    }



}