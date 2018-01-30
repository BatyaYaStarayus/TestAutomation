


import org.junit.Test;

/**
 * Created by ivan.kozlov on 24.02.2017.
 */
public class DesktopLanguagesTest extends DesktopGameActions {

    @Test
    public void languagesTest() throws Exception {
        initializeDesktopDriver("Chrome");
        openAndMaximiseBrowser();
        getPage();
        loginAdminPage("netent", "netent");
        loginTesterPage("stest6", "");

        for (String allLanguagesArray : LANGUAGES) {
            selectLanguage(allLanguagesArray);
            for (String gameId : gamesId) {
                runGame(gameId);
                waitGameLoaded();

                changePagesAndMakeScreenShots("FSS", 798, 673, 3, 35);

                clickToDisableSounds();

                clickButtonFSS(959, 801);
                makeScreenShot("Keypad");

                openGameSettings();
                makeScreenShot("GameSettings");

                openAutoplaySettings();
                makeScreenShot("Autoplay");

                openAdvancedAutoplaySettings();
                makeScreenShot("AutoplayAdvanced");

                closeAutoplaySettings();

                openPaytable(132, 863);
                changePagesAndMakeScreenShots("Paytable", 649, 694, 10, 40);

//                TODO fix scrolling build 106 output
//                openGameRules();
//                makeScreenShotsOfAllPageParts("GameRules", "Desktop");
//
//                closeGameRules();

//              FS activated pop-up

                openJMX();
                setJMXOn("JMXFreeSpins+Wild");
                closeJMX();
                clickSpinButton(959, 863);
                clickSpinButton(959, 863);
                skipGameAnimations();

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
                closeJMX();
//              TODO add FS intro button coordinates
                clickFSIntroButton(832, 702);
                waitFSIntoDisappears();
                waitReelsAreSpinning();
                makeScreenShot("FSKeypad");

//              FS Outro

                waitFSOutroAppears();
                makeScreenShot("FSOutro");

                clickFSOutroButton(832, 702);
//                waitFSOutroDisappears();
//                enteringIdleState();

//              FS OutroNoWin

                openJMX();
                setNeededGameMode("basic3");
                setJMXOn("JMXFreespins");
                closeJMX();
                clickSpinButton(959, 863);
                skipGameAnimations();
                waitFSIntroAppears();

                openJMX();
                setNeededGameMode("freespin1");
                setJMXOn("JMXNoWin");
                closeJMX();

//              TODO add FS intro button coordinates
                clickFSIntroButton(832, 702);
                waitFSOutroAppears();
                makeScreenShot("FSOutroNoWin");

//              TODO add FS intro button coordinates
                clickFSOutroButton(832, 702);
//                waitFSOutroDisappears();
//                enteringIdleState();

//              Big Win text

                openJMX();
                setNeededGameMode("basic3");
                setBigWinType("BigWin");
                closeJMX();
                clickSpinButton(959, 863);
                skipGameAnimations();
                enteringBigWinState();
                skipGameAnimations();
                makeScreenShot("BigWin");
                enteringIdleState();

//              Mega Win text

                openJMX();
                setBigWinType("MegaWin");
                closeJMX();
                clickSpinButton(959, 863);
                skipGameAnimations();
                enteringBigWinState();
                skipGameAnimations();
                makeScreenShot("MegaWin");
                enteringIdleState();

//              Super Mega Win text

                openJMX();
                setBigWinType("SuperMegaWin");
                closeJMX();
                clickSpinButton(959, 863);
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
