package test.java;

import main.java.JMXActions;
import org.junit.Test;

/**
 * Created by ivan.kozlov on 24.02.2017.
 */
public class TestLanguages extends JMXActions {

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

                openGameRules();
                makeScreenShotsOfAllPageParts();

                closeGameRules();

                openJMX();
//              TODO add FS + Wild button Id to setJMXOn(); method
                clickOnJMXButton();
                closeJMX();
                clickSpinButton(959, 863);

//              TODO add event after which pop up appears to waitFor(); method
                waitFor();
                makeScreenShot("FSActivatedPopUp");

                waitFSIntroAppears();
                makeScreenShot("FSIntro");

                reload();

                waitFSIntroAppears();
                makeScreenShot("FSIntrorestored");

                openJMX();
                setOneFreeSpinLeft();
//                TODO need to fill with JMXNoWin button id in method below
                clickOnJMXButton("JMXNoWin");
                closeJMX();
                clickFSIntroButton();
//                TODO need to fill with event of FS Intro disappears in method below
                waitFor();
                makeScreenShot("FSKeypad");

                waitFSOutoAppears();
                makeScreenShot("FSOutroNoWin");

                enteringIdleState();

                openJMX();
                setJMXOn("JMXBigWin");
                closeJMX();
                clickSpinButton();
//                TODO should add event for "Big Win" text appearance as a parameter for the method below
                waitFor();
                makeScreenShot("BigWin");
                enteringIdleState();

                openJMX();
                setJMXOn("JMXMegaWin");
                closeJMX();
                clickSpinButton();
//                TODO should add event for "Mega Win" text appearance as a parameter for the method below
                waitFor();
                makeScreenShot("MegaWin");
                enteringIdleState();

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
