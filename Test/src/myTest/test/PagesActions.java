package myTest.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by ivan.kozlov on 21.02.2017.
 */
public class PagesActions extends BasicBrowserActions {

    public PagesActions() {
        super();
    }

//    admin page actions

    protected void  loginAdminPage(String user, String password)throws  InterruptedException {

        WebElement userFieldAdminPage = driver.findElement(By.xpath("//*[@id=\"content\"]/table/tbody/tr/td/form/table/tbody/tr[1]/td[2]/input"));
        WebElement passwordFieldAdminPage = driver.findElement(By.xpath("//*[@id=\"content\"]/table/tbody/tr/td/form/table/tbody/tr[2]/td[2]/input"));
        WebElement loginButtonAdminPage = driver.findElement(By.xpath("//*[@value='Login']"));

        userFieldAdminPage.click();
        userFieldAdminPage.sendKeys(user);

        passwordFieldAdminPage.click();
        passwordFieldAdminPage.sendKeys(password);

        loginButtonAdminPage.click();

    }

//    tester page actions

    protected void loginTesterPage(String user, String password) throws  InterruptedException {

        WebElement userFieldTesterPage = driver.findElement(By.xpath("//*[@id=\"defaultForm\"]/input[1]"));
        WebElement passwordFieldTesterPage = driver.findElement(By.xpath("//*[@id=\"defaultForm\"]/input[2]"));
        WebElement loginButtonTesterPage = driver.findElement(By.xpath("//*[@value='login']"));

        userFieldTesterPage.click();
        userFieldTesterPage.sendKeys(user);

        passwordFieldTesterPage.click();
        passwordFieldTesterPage.sendKeys(password);

        loginButtonTesterPage.click();

    }

    protected void logoutTesterPage () throws InterruptedException {

        WebElement logoutButtonTesterPage = driver.findElement(By.xpath("//*[@value='logout']"));

        logoutButtonTesterPage.click();
        Thread.sleep(20000);

    }

    protected void runGame(String gameId) {

        WebElement game = driver.findElement(By.xpath("//*[.='" + gameId + "']"));
        game.click();

    }

    protected void selectLanguage (String language) {

        WebElement languageDropDownList = driver.findElement(By.id("languageid"));

        Select selectLanguage = new Select(languageDropDownList);
        selectLanguage.selectByValue(language);

    }

    String[] languagesArray = {"bg","br","cn","cs","da","de","el","en","es","et","fi","fr","hr","hu","it","nl","no","pl","pt","ro","ru","sk","sv","tr"};

}
