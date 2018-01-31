


import org.junit.Test;

/**
 * Created by ivan.kozlov on 24.02.2017.
 */
public class MobileLanguagesTest extends MobileGameActions {

    @Test
    public void languagesTest() throws Exception {
        initializeMobileDriver();
        openAndMaximiseBrowser();
        getPage();
        loginAdminPage("netent", "netent");
        loginTesterPage("stest6", "");

        for (String allLanguagesArray : LANGUAGES) {
            selectLanguage(allLanguagesArray);
            for (String gameId : gamesId) {
                runGame(gameId);
                waitGameLoaded();

                makeScreenShot("Keypad");

                openGameSettings();

                openSoundSettingsTab();
                makeScreenShot("SoundSettings");

                openSpinSettingsTab();
                makeScreenShot("SpinSettings");

                openBetSettingsTab();
                makeScreenShot("BetSettings");

                openPaytableTab();
                makeScreenShotsOfAllPageParts("Paytable", "Mobile");

                openGameRulesTab();
                makeScreenShotsOfAllPageParts("GameRules", "Mobile");

                openGameHistoryTab();
                makeScreenShot("GameHistory");

                openSpinSettingsTab();
                openAdvancedAutoplaySettings();
                makeScreenShotsOfAllPageParts("AdvancedAutoplayOptions", "Mobile");

                setIfCashDecreasesValue();
                makeScreenShot("IfCashDecreases");
                closeAdvancedSettingValueWindow();

                setIfSingleWinExceedsValue();
                makeScreenShot("IfSingleWinExceeds");
                closeAdvancedSettingValueWindow();

                setIfCashInreasesValue();
                makeScreenShot("IfCashIncreases");
                closeAdvancedSettingValueWindow();

                openJMX();
                setJMXOn("JMXFreeSpins+Wild");
                closeJMX();
                clickSpinButton();

                waitFSPopUpAppears();
                makeScreenShot("FSActivatedPopUp");

//              FS Intro

                waitFSIntroAppears();
                makeScreenShot("FSIntro");

                reload();

//              FS Intro restored

                waitFSIntroAppears();
                makeScreenShot("FSIntroRestored");

//              FS Keypad

                openJMX();
                setOneFreeSpinLeft();
                setNeededGameMode("freespin1");
                setJMXOn("JMXNoWin");
                closeJMX();
                clickFSIntroButton(188, 504);
                waitFSIntoDisappears();
                makeScreenShot("FSKeypad");

//              FS Outro

                waitFSOutroAppears();
                makeScreenShot("FSOutro");

                clickFSOutroButton(188, 504);
//                enteringIdleState();

//              FS Outro

                openJMX();
                setNeededGameMode("basic3");
                setJMXOn("Freespins");
                closeJMX();
                clickSpinButton();
                skipGameAnimations();
                waitFSIntroAppears();
                openJMX();
                setNeededGameMode("freespin1");
                setJMXOn("JMXNoWin");
                closeJMX();
                clickFSIntroButton(188, 504);
                waitFSOutroAppears();
                makeScreenShot("FSOutroNoWin");
                clickFSOutroButton(188, 504);
//                enteringIdleState();

//              Big Win text

                openJMX();
                setNeededGameMode("basic3");
                setJMXOn("JMXBigWin");
                setJMXOn("JMXWildTop");
                closeJMX();
                clickSpinButton();
                skipGameAnimations();
                enteringBigWinState();
                skipGameAnimations();
                makeScreenShot("BigWin");
//                enteringIdleState();

//              Mega Win text

                openJMX();
                setJMXOn("JMXMegaWin");
                closeJMX();
                clickSpinButton();
                skipGameAnimations();
                enteringBigWinState();
                skipGameAnimations();
                makeScreenShot("MegaWin");
                enteringIdleState();

//              Super Mega Win text

                openJMX();
                setJMXOn("JMXSuperMegaWin");
                closeJMX();
                clickSpinButton();
                skipGameAnimations();
                enteringBigWinState();
                skipGameAnimations();
                makeScreenShot("SuperMegaWin");
                enteringIdleState();

                driver.navigate().back();
            }
        }

        logoutTesterPage();
    }
}