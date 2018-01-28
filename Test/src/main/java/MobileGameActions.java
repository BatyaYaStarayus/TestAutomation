import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class MobileGameActions extends CommonGameActions{

    @Override
    protected void makeScreenShot(String testedElement) throws IOException, InterruptedException {
        super.makeScreenShot(testedElement, "Mobile");
    }

    protected void openGameSettings() {
        clickOnElementByClass("interface-settingsButton_baseButton");
    }

    protected void openSoundSettingsTab() {
        clickOnElementByClass("interface-settingsMenu_child_soundSettings_uri");
    }

    protected void openSpinSettingsTab() {
        clickOnElementByClass("interface-settingsMenu_child_spinSettings_uri");
    }

    protected void openBetSettingsTab() {
        clickOnElementByClass("interface-settingsMenu_child_betSettings_uri");
    }

    protected void openPaytableTab() {
        clickOnElementByClass("interface-settingsMenu_child_paytable_uri");
    }

    protected void openGameRulesTab() {
        clickOnElementByClass("interface-settingsMenu_child_gameRules_uri");
    }

    protected void openGameHistoryTab() {
        clickOnElementByClass("interface-settingsMenu_child_gameHistory_uri");
    }

    protected void clickSpinButton() {
        clickOnElementByClass("interface-spinButton_default_uri");
    }

    protected void openAdvancedAutoplaySettings() {
        clickOnElementByClass("interface-slider_sliderWrapper");
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
        clickOnElementByClass("button cancelButton hover");
    }

}
