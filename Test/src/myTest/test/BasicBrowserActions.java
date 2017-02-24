package myTest.test;


import org.junit.After;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class BasicBrowserActions {

    protected WebDriver driver;

    protected JavascriptExecutor js;

    @After
    public void tearDown() {
        driver.close();
    }

    protected void initializeDriver(String browser) {
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

            default:
                throw new IllegalArgumentException("Wrong browser");
        }

        if (driver instanceof JavascriptExecutor) {
            js = (JavascriptExecutor) driver;
        }else{
            throw new ClassCastException("Driver is not an instance of JavascriptExecutor");
        }
    }

    protected void openAndMaximiseBrowser() {
        driver.manage().window().maximize();
    }

    protected void getPage(String pageURL) throws InterruptedException {
        driver.get(pageURL);
    }
}