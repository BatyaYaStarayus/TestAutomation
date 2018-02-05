

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;

public class MobileGameActions extends CommonGameActions{

    @Before

    public void prepareToLaunchGameMobile() throws InterruptedException {
        initializeMobileDriver();
//        openAndMaximiseBrowser();
        getPage();
        loginAdminPage();
        loginTesterPage(MOBILECHANNEL);
    }

    protected void makeScreenShot(String testedElement) throws IOException, InterruptedException {
        makeScreenShot(testedElement, "Mobile");
    }

    protected void openGameSettings() throws InterruptedException {
        clickOnElementByClassName("interface-settingsButton_baseButton");
        Thread.sleep(TIMEOUT*10);
    }

    protected void goToLeftMostTab() throws InterruptedException {
        js.executeScript("return document.getElementsByClassName('interface-settingsMenu_children')[0].style.transform = 'translate(180px, 0px)'");
        Thread.sleep(TIMEOUT*10);
    }

    protected void openSoundSettingsTab() {
        clickOnElementByClassName("interface-settingsMenu_child_soundSettings_uri");
    }

    protected void openSpinSettingsTab() throws InterruptedException {
        clickOnElementByClassName("interface-settingsMenu_child_spinSettings_uri");

        Thread.sleep(TIMEOUT*5);
    }

    protected void openBetSettingsTab() {
        clickOnElementByClassName("interface-settingsMenu_child_betSettings_uri");
    }

    protected void openPaytableTab() {
//        WebDriverWait wait= new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.xpath("//*[@id='gameWrapper']//*[contains(@class,'interface-settingsMenu_child_base')]")));
//        String tabsXpath = "//*[@id='gameWrapper']//*[contains(@class,'interface-settingsMenu_child_base')]";
//        List<WebElement> buttons = driver.findElements(By.xpath(tabsXpath));
//        Actions actions = new Actions(driver);
//            actions.moveToElement(buttons.get(3)).click().perform();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("paytable")));
        clickOnElementByClassName("interface-settingsMenu_child_paytable_uri");
    }

    protected void openGameRulesTab() {
        clickOnElementByClassName("interface-settingsMenu_child_gameRules_uri");
    }

    protected void openGameHistoryTab() {
        clickOnElementByClassName("interface-settingsMenu_child_gameHistory_uri");
    }

    protected void clickSpinButton() {
        clickOnElementByClassName("interface-spinButton_default_uri");
    }

    protected void openAdvancedAutoplaySettings() {
        clickOnElementByClassName("interface-slider_sliderWrapper");
    }

    protected void setIfCashDecreasesValue() {
        clickOnElementById("advancedSetting-stopAutoplayIfBalanceDecreasedBy_button");
    }

    protected void setIfSingleWinExceedsValue() {
        clickOnElementById("advancedSetting-stopAutoplayIfWinExceeds_button");
    }

    protected void setIfCashInreasesValue() {
        clickOnElementById("advancedSetting-stopAutoplayIfBalanceIncreasedBy_button");
    }

    protected void closeAdvancedSettingValueWindow() {
        clickOnElementByClassName("button cancelButton hover");
    }

}
