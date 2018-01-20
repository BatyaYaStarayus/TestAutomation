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

//                TODO add FS + Wild button Id
                openJMX();
                clickOnJMXButton("JMXFreespins");
                closeJMX();
                clickSpinButton(959, 863);




                driver.navigate().back();
            }
        }

        logoutTesterPage();
    }
}
