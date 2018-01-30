

import java.io.IOException;

public class MobileGameActions extends CommonGameActions{

    protected void makeScreenShot(String testedElement) throws IOException, InterruptedException {
        makeScreenShot(testedElement, "Mobile");
    }

    protected void closeDeviceDetectionMessage() {



    }

    protected void openGameSettings() {
        clickOnElementByClassName("interface-settingsButton_baseButton");
    }

    protected void openSoundSettingsTab() {
        clickOnElementByClassName("interface-settingsMenu_child_soundSettings_uri");
    }

    protected void openSpinSettingsTab() {
        clickOnElementByClassName("interface-settingsMenu_child_spinSettings_uri");
    }

    protected void openBetSettingsTab() {
        clickOnElementByClassName("interface-settingsMenu_child_betSettings_uri");
    }

    protected void openPaytableTab() {
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
