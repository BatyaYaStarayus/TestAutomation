import org.junit.Test;

/**
 * Created by ivan.kozlov on 24.02.2017.
 */
public class MobileLanguagesTest extends MobileGameActions {

    @Test
    public void languagesTest() throws Exception {

        for (String allLanguagesArray : LANGUAGES) {
            selectLanguage(allLanguagesArray);

            runGame(gameId);
            waitGameLoaded();

            makeScreenShot("Keypad");

//                openGameSettings();
//
//                openSpinSettingsTab();
//
//                goToLeftMostTab();
//
//                openSoundSettingsTab();
//                makeScreenShot("SoundSettings");
//
//                openSpinSettingsTab();
//                makeScreenShot("SpinSettings");
//
//                openBetSettingsTab();
//                makeScreenShot("BetSettings");
//
//                openPaytableTab();
//                makeScreenShotsOfAllPageParts("Paytable", "Mobile");
//
//                openGameRulesTab();
//                makeScreenShotsOfAllPageParts("GameRules", "Mobile");
//
//                openGameHistoryTab();
//                makeScreenShot("GameHistory");
//
//                openSpinSettingsTab();
//                openAdvancedAutoplaySettings();
//                makeScreenShotsOfAllPageParts("AdvancedAutoplayOptions", "Mobile");
//
//                setIfCashDecreasesValue();
//                makeScreenShot("IfCashDecreases");
//                closeAdvancedSettingValueWindow();
//
//                setIfSingleWinExceedsValue();
//                makeScreenShot("IfSingleWinExceeds");
//                closeAdvancedSettingValueWindow();
//
//                setIfCashInreasesValue();
//                makeScreenShot("IfCashIncreases");
//                closeAdvancedSettingValueWindow();
//
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
//          For portrait mode
//            clickFSIntroButton(205, 549);

//            For landscape mode
            clickFSIntroButton(300, 258);
            waitFSIntoDisappears();
            makeScreenShot("FSKeypad");

//              FS Outro

            waitFSOutroAppears();
            makeScreenShot("FSOutro");

//          For portrait mode
//            clickFSOutroButton(205, 549);

            clickFSOutroButton(300, 258);
//                enteringIdleState();

//              FS Outro

            openJMX();
            setNeededGameMode("basic3");
            setJMXOn("JMXFreespins");
            closeJMX();
            clickSpinButton();
            skipGameAnimations();
            waitFSIntroAppears();
            openJMX();
            setNeededGameMode("freespin1");
            setJMXOn("JMXNoWin");
            closeJMX();
            clickFSIntroButton(300, 258);
            waitFSOutroAppears();
            makeScreenShot("FSOutroNoWin");
            clickFSOutroButton(300, 258);
//                enteringIdleState();

//              Big Win text

            openJMX();
            setNeededGameMode("basic3");
            setBigWinType("BigWin");
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
            setBigWinType("MegaWin");
            closeJMX();
            clickSpinButton();
            skipGameAnimations();
            enteringBigWinState();
            skipGameAnimations();
            makeScreenShot("MegaWin");
            enteringIdleState();

//              Super Mega Win text

            openJMX();
            setBigWinType("SuperMegaWin");
            closeJMX();
            clickSpinButton();
            skipGameAnimations();
            enteringBigWinState();
            skipGameAnimations();
            makeScreenShot("SuperMegaWin");
            enteringIdleState();

            driver.navigate().back();
        }
        logoutTesterPage();
    }
}