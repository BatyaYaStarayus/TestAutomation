package main.java;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.w3c.dom.html.HTMLInputElement;

/**
 * Created by ivan.kozlov on 21.02.2017.
 */
public class PagesActions extends BasicBrowserActions {

    public String[] LANGUAGES = {"bg", "br", "cn", "cs", "da", "de", "el", "en", "es", "et", "fi", "fr", "hr", "hu", "it", "nl", "no", "pl", "pt", "ro", "ru", "sk", "sv", "tr"};

//    public String[] gamesId = System.getProperty("GameId").split(",");
    public String[] gamesId = {"neonstaxx_not_mobile"};

//    admin page actions

    protected void login(String user, String password, WebElement userField, WebElement passwordField, WebElement loginButton) {

        userField.click();
        userField.sendKeys(user);

        passwordField.click();
        passwordField.sendKeys(password);

        loginButton.click();

    }

//    admin page actions

    protected void loginAdminPage(String user, String password) throws InterruptedException {

        WebElement userField = driver.findElement(By.xpath("//*[@id=\"content\"]/table/tbody/tr/td/form/table/tbody/tr[1]/td[2]/input"));
        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"content\"]/table/tbody/tr/td/form/table/tbody/tr[2]/td[2]/input"));
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

       //TODO Assert.assertEquals(gameName, driver.getTitle());

    }

    protected void selectLanguage(String language) {

        WebElement languageDropDownList = driver.findElement(By.id("languageid"));

        Select selectLanguage = new Select(languageDropDownList);
        selectLanguage.selectByValue(language);

    }

}
