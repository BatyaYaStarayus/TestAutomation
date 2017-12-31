package test.java;

import main.java.GameActions;
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
        loginTesterPage("zrada", "");

        for (String allLanguagesArray : LANGUAGES) {
            selectLanguage(allLanguagesArray);
            for (String gameId : gamesId) {
                runGame(gameId);
                waitGameLoaded();

//                TODO insert variables into next function
                changePagesAndMakeScreenShots();

                clickButtonFSS(850, 850);
                makeScreenShot("Keypad");

                openGameSettings();
                makeScreenShot("GameSettings");

                openAutoplaySettings();
                makeScreenShot("Autoplay");

                openAdvancedAutoplaySettings();
                makeScreenShot("AutoplayAdvanced");

                openPaytable();
//                TODO insert variables into next function
                changePagesAndMakeScreenShots();

//                TODO add FS + Wild button Id
                openJMX();
                clickOnButton();
                closeJMX();
                clickSpinButton();




                driver.navigate().back();
            }
        }

        logoutTesterPage();
    }
}
