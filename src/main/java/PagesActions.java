

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by ivan.kozlov on 21.02.2017.
 */
public class PagesActions extends BasicBrowserActions {

    protected static final int TIMEOUT = 1000;

//    public String[] LANGUAGES = {"bg"};
    public String[] LANGUAGES = {"bg", "br", "cn", "cs", "da", "de", "el", "en", "es", "et", "fi", "fr", "hr", "hu", "it", "nl", "no", "pl", "pt", "ro", "ru", "sk", "sv", "tr"};
    public String[] gamesId = System.getProperty("GameId").split(",");
//    public String[] gamesId = {"neonstaxx_not_mobile"};

//    admin page actions

    protected void login(String user, String password, WebElement userField, WebElement passwordField, WebElement loginButton) {

//        userField.click();
        userField.sendKeys(user);

//        passwordField.click();
        passwordField.sendKeys(password);

//      for desktop
        loginButton.click();

//      for mobile
        loginButton.submit();

    }

//    admin page actions

    protected void loginAdminPage(String user, String password) throws InterruptedException {

        WebElement userField = driver.findElement(By.xpath("//input[@name='login']"));
        WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));
        WebElement loginButton = driver.findElement(By.xpath("//*[@value='Login']"));

        login(user, password, userField, passwordField, loginButton);

    }

//    tester page actions

    protected void loginTesterPage(String user, String password) throws InterruptedException {

        WebElement userField = driver.findElement(By.xpath("//*[@id=\"defaultForm\"]/input[1]"));
        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"defaultForm\"]/input[2]"));
        WebElement loginButton = driver.findElement(By.xpath("//*[@value='login']"));

        login(user, password, userField, passwordField, loginButton);
    }

    protected void logoutTesterPage() throws InterruptedException {

        WebElement logoutButtonTesterPage = driver.findElement(By.xpath("//*[@value='logout']"));
        logoutButtonTesterPage.click();

    }

    protected void runGame(String gameId) {

        WebElement game = driver.findElement(By.xpath("//*[.='" + gameId + "']"));
        game.click();

    }

    protected void selectLanguage(String language) {

        WebElement languageDropDownList = driver.findElement(By.id("languageid"));

        Select selectLanguage = new Select(languageDropDownList);
        selectLanguage.selectByValue(language);

    }

//  tried to make screenshots of canvas

    protected void makeScreenShot(String testedElement, String device) throws IOException, InterruptedException {
        Thread.sleep(TIMEOUT);
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File("C://Screenshots/" + Arrays.toString(gamesId) + "/"
                + getCurrentDateAndTime() + "/" + device + "/" + testedElement + "/" + getCurrentLanguage() + ".png"));
        FileUtils.copyFile(srcFile, new File("S://SmokinAces/Screenshots/" + Arrays.toString(gamesId) + "/"
                + getCurrentDateAndTime() + "/" + device + "/" + testedElement + "/" + getCurrentLanguage() + ".png"));
        Thread.sleep(TIMEOUT);
    }

    protected String getCurrentLanguage() {
        String url = driver.getCurrentUrl();
        String[] urlParametersArray = url.split("&");
        String currentLanguage = "";

        for (int i = 0; i < urlParametersArray.length; i++) {
            if (urlParametersArray[i].startsWith("lang")) {
                currentLanguage = urlParametersArray[i].substring(urlParametersArray[i].length() - 2);
            }
        }
        return currentLanguage;
    }

    protected String getCurrentDateAndTime() {

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDateAndTime = new Date();

        return dateFormat.format(currentDateAndTime);
    }

//    added methods for scrolling pages via js.executor
//    up to method protected void makeScreenShotsOfAllPageParts()
//    not sure, if it works :)

    protected long getScreenHeight() {
        long screenHeight;
        screenHeight = (long) js.executeScript("return document.getElementById('containerWrapper').clientHeight;");

        System.out.println(screenHeight);

        return screenHeight;
    }

    protected long getScrollHeight() {
        long scrollHeight;
        scrollHeight = (long) js.executeScript("return document.getElementById('gameRules').clientHeight;");

        System.out.println(scrollHeight);

        return scrollHeight;
    }

    protected void scrollPageOnScreenHeight() {
        js.executeScript("document.getElementById('containerWrapper').scrollBy(0, " + getScreenHeight() + ")");

        System.out.println(getScreenHeight());
    }

    protected void makeScreenShotsOfAllPageParts(String elementId, String device) throws IOException, InterruptedException {
        long amountOfScrolls;
        amountOfScrolls = getScrollHeight() / getScreenHeight();

        System.out.println(amountOfScrolls);

        for(int i = 0; i <= amountOfScrolls; i++) {
            makeScreenShot((elementId + "/Page" + (i + 1)), device);
            scrollPageOnScreenHeight();
        }

    }

}