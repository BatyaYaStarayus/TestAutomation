package myTest.test;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class BasicBrowserActions {

    protected  WebDriver driver;

    public BasicBrowserActions() {
        super();
        this.driver = driver;
    }

//    protected WebDriver driver;

    @Before
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "chromedriver/chromedriver.exe");
    }

    @After
    public void tearDown() {
        driver.close();
    }

    protected void initializeDriver(String browser) {
        switch (browser) {
            case "Chrome" :
               driver = new ChromeDriver();
               System.setProperty("webdriver.chrome.driver", "chromedriver/chromedriver.exe");
               break;

            case "FireFox" :
                driver = new FirefoxDriver();
                break;

            case "Explorer" :
                driver = new InternetExplorerDriver();
                break;

            default :
                break;
        }
    }

    protected void openAndMaximiseBrowser() {

    driver.manage().window().maximize();

    }

    protected void getPage(String pageURL) throws  InterruptedException {

        driver.get(pageURL);
        Thread.sleep(2000);

    }


//    @Test
//    public void googleTest() throws Exception {
//
//        initializeDriver("Chrome");
//
//        openAndMaximiseBrowser();
//
//        getPage("http://sta-kiv-gt2-setup01-spp-01.nix.cydmodule.com:8080/admin/tester.jsp");
//
//        loginAdminPage("netent", "netent");
//
//        loginTesterPage("zrada", "");
//
//        runGame("neonstaxx_not_mobile");
//
//        waitGameLoaded();
//        //waitForStartButton();
//
//        getPage("http://sta-kiv-gt2-setup01-spp-01.nix.cydmodule.com:8080/admin/tester.jsp");
//
//        logoutTesterPage();
//    }

}