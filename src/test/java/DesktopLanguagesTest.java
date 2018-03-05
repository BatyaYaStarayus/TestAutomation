


import org.junit.Test;

/**
 * Created by ivan.kozlov on 24.02.2017.
 */
public class DesktopLanguagesTest extends DesktopGameActions {

    @Test
    public void languagesTest() throws Exception {

        for (String allLanguagesArray : LANGUAGES) {
            selectLanguage(allLanguagesArray);
                runGame(gameId);
                waitGameLoaded();

                changePagesAndMakeScreenShotsFSS(3,5);

                clickToDisableSounds();

                closeFSS();
                makeScreenShot("Keypad");

                openGameSettings();
                makeScreenShot("GameSettings");

                openAutoplaySettings();
                makeScreenShot("Autoplay");

                openAdvancedAutoplaySettings();
                makeScreenShot("AutoplayAdvanced");

                closeAutoplaySettings();

                showPaytable();
                changePagesAndMakeScreenShotsPaytable(10);

//                TODO fix scrolling build 106 output
                openGameRules();
                makeScreenShotsOfAllPageParts("GameRules", "Desktop");

                closeGameRules();

//              FS activated pop-up

                openJMX();
                setJMXOn("JMXFreeSpins+Wild");
                closeJMX();
                startSpin();
                quickStop();
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

                closeFSOutro();
//                waitFSOutroDisappears();
//                enteringIdleState();

//              FS OutroNoWin

                openJMX();
                setNeededGameMode("basic3");
                setJMXOn("JMXFreespins");
                closeJMX();
                startSpin();
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
                closeFSOutro();

//              Big Win text

                openJMX();
                setNeededGameMode("basic3");
//              to avoid wilds
                setJMXOn("JMXWildTop");
                closeJMX();

                for(String allBigWinTypes : BIGWINTYPES) {
                    openJMX();
                    setBigWinType(allBigWinTypes);
                    closeJMX();
                    startSpin();
                    skipGameAnimations();
                    enteringBigWinState();
                    skipGameAnimations();
                    makeScreenShot(allBigWinTypes);
                    enteringIdleState();
                }

//                setBigWinType("BigWin");
//                closeJMX();
//                startSpin();
//                skipGameAnimations();
//                enteringBigWinState();
//                skipGameAnimations();
//                makeScreenShot("BigWin");
//                enteringIdleState();
//
////              Mega Win text
//
//                openJMX();
//                setBigWinType("MegaWin");
//                closeJMX();
//                startSpin();
//                skipGameAnimations();
//                enteringBigWinState();
//                skipGameAnimations();
//                makeScreenShot("MegaWin");
//                enteringIdleState();
//
////              Super Mega Win text
//
//                openJMX();
//                setBigWinType("SuperMegaWin");
//                closeJMX();
//                startSpin();
//                skipGameAnimations();
//                enteringBigWinState();
//                skipGameAnimations();
//                makeScreenShot("SuperMegaWin");
//                enteringIdleState();

                goToPreviosPage();
        }

        logoutTesterPage();
    }
}
