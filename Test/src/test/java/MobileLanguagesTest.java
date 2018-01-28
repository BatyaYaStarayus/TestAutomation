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

//                TODO add actions for autoplay options and adding values
                openSpinSettingsTab();
                makeScreenShot("SpinSettings");

                openBetSettingsTab();
                makeScreenShot("BetSettings");

//                TODO add scrolling
                openPaytableTab();
                makeScreenShotsOfAllPageParts("Paytable");

//                TODO add scrolling
                openGameRulesTab();
                makeScreenShotsOfAllPageParts("GameRules");

                openGameHistoryTab();
                makeScreenShot("GameHistory");

                openSpinSettingsTab();
                openAdvancedAutoplaySettings();
                makeScreenShotsOfAllPageParts("AdvancedAutoplayOptions");

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
//              TODO add FS + Wild button Id to setJMXOn(); method
                setJMXOn("FS+Wild");
                closeJMX();
                clickSpinButton();

//              TODO add event after which pop up appears to waitFor(); method
                waitFor();
                makeScreenShot("FSActivatedPopUp");

//              FS Intro

                waitFSIntoAppears();
                makeScreenShot("FSIntro");

                reload();

//              FS Intro restored

                waitFSIntoAppears();
                makeScreenShot("FSIntroRestored");

//              FS Keypad

                openJMX();
                setOneFreeSpinLeft();
//                TODO need to fill with JMXNoWin button id in method below
                setJMXOn("JMXNoWin");
                closeJMX();
                clickFSIntroButton();
//                TODO need to fill with event of FS Intro disappears in method below
                waitFor();
                makeScreenShot("FSKeypad");

//              FS Outro NoWin text

                waitFSOutoAppears();
                makeScreenShot("FSOutroNoWin");

                enteringIdleState();

//              FS Outro

                openJMX();
                setJMXOn("Freespins");
                closeJMX();
                clickSpinButton();
                waitFSIntoAppears();
                clickFSIntroButton();
                waitFSOutoAppears();
                makeScreenShot("FSOutro");
                clickFSOutroButton();
                enteringIdleState();

//              Big Win text

                openJMX();
                setJMXOn("JMXBigWin");
                closeJMX();
                clickSpinButton();
//                TODO should add event for "Big Win" text appearance as a parameter for the method below
                waitFor();
                makeScreenShot("BigWin");
                enteringIdleState();

//              Mega Win text

                openJMX();
                setJMXOn("JMXMegaWin");
                closeJMX();
                clickSpinButton();
//                TODO should add event for "Mega Win" text appearance as a parameter for the method below
                waitFor();
                makeScreenShot("MegaWin");
                enteringIdleState();

//              Super Mega Win text

                openJMX();
                setJMXOn("JMXSuperMegaWin");
                closeJMX();
                clickSpinButton();
//                TODO should add event for "Super Mega Win" text appearance as a parameter for the method below
                waitFor();
                makeScreenShot("SuperMegaWin");
                enteringIdleState();

                driver.navigate().back();
            }
        }

        logoutTesterPage();
    }
}