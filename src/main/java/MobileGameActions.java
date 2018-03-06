

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;

public class MobileGameActions extends GameActionsViaRequests{

    protected void makeScreenShot(String testedElement) throws IOException, InterruptedException {
        makeScreenShot(testedElement, "Mobile");
    }

    protected void openGameSettings() throws InterruptedException {
        clickOnElementByClassName("interface-settingsButton_baseButton");
    }

    protected void closeGameSettings() throws InterruptedException {
        clickOnElementByClassName("interface-settingsButton_baseButton");
    }

    protected void openSoundSettings() {
        clickOnElementByClassName("interface-settingsMenu_child_soundSettings_uri");
    }

    protected void openSpinSettings() throws InterruptedException {
        clickOnElementByClassName("interface-settingsMenu_child_spinSettings_uri");
    }

    protected void openBetSettings() {
        clickOnElementByClassName("interface-settingsMenu_child_betSettings_uri");
    }

    protected void openPaytableTab() {
        clickOnElementByClassName("interface-settingsMenu_child_paytable_uri");
    }

    protected void openGameRules() {
        clickOnElementByClassName("interface-settingsMenu_child_gameRules_uri");
    }

    protected void openGameHistory() {
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
