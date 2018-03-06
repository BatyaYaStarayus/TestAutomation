


import org.junit.Test;

/**
 * Created by ivan.kozlov on 24.02.2017.
 */
public class DesktopLanguagesTest extends DesktopGameActions {

    @Test
    public void languagesTest() throws Exception {

        for (String allLanguagesArray : languages) {
            selectLanguage(allLanguagesArray);
                runGame(gameId);
                waitGameLoaded();

                changePagesAndMakeScreenShotsFSS(3,8);

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
                hidePaytable();


////                TODO fix scrolling build 106 output
//                openGameRules();
//                makeScreenShotsOfAllPageParts("GameRules", "Desktop");
//
//                closeGameRules();

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
                clickFSIntroButton();
//                waitFSIntoDisappears();
                waitReelsAreSpinning();
                makeScreenShot("FSKeypad");

//              FS Outro

                waitFSOutroAppears();
                makeScreenShot("FSOutro");

                clickFSOutroButton();
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
                clickFSIntroButton();
                waitFSOutroAppears();
                makeScreenShot("FSOutroNoWin");

//              TODO add FS intro button coordinates
                clickFSOutroButton();

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
