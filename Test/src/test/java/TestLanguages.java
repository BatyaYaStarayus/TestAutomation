package test.java;

import main.java.GameActions;
import org.junit.Test;

/**
 * Created by ivan.kozlov on 24.02.2017.
 */
public class TestLanguages extends GameActions {

    @Test
    public void languagesTest() throws Exception {
        initializeDesktopDriver("Chrome");
        openAndMaximiseBrowser();
        getPage("http://sta-kiv-gt2-setup01-spp-01.nix.cydmodule.com:8080/admin/tester.jsp");
        loginAdminPage("netent", "netent");
        loginTesterPage("zrada", "");

        for (String allLanguagesArray : LANGUAGES) {
            selectLanguage(allLanguagesArray);
            for (String gameId : gamesId) {
                runGame(gameId);
                waitGameLoaded();
                clickButtonFSS(850, 850);
                clickSpinButton(850, 820);
                enteringIdleState();
                getBalanceInCurrency();
                clickButtonWithId("gameRulesButton");
                //getPage("http://sta-all-kiv-gt5-setup01-spp-01.nix.cydmodule.com:8080/admin/tester.jsp");
                driver.navigate().back();
            }
        }

        logoutTesterPage();
    }
}
