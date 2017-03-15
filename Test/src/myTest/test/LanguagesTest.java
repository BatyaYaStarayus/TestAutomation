package myTest.test;

import org.junit.Test;

/**
 * Created by ivan.kozlov on 24.02.2017.
 */
public class LanguagesTest extends GameActions {


    @Test
    public void googleTest() throws Exception {
        initializeDriver("Chrome");
        openAndMaximiseBrowser();
        getPage("http://sta-kiv-gt2-setup01-spp-01.nix.cydmodule.com:8080/admin/tester.jsp");
        loginAdminPage("netent", "netent");
        loginTesterPage("zrada", "");

        for (String allLanguagesArray : LANGUAGES) {
            selectLanguage(allLanguagesArray);
            runGame("neonstaxx_not_mobile");
            waitGameLoaded();
            clickButtonFSS(850, 850);
            getBalanceAfterSpin();
            clickSpinButton(850, 820);
            enteringIdleState();
            getBalanceInCurrency();
            clickButtonWithId("gameRulesButton");
            getPage("http://sta-kiv-gt2-setup01-spp-01.nix.cydmodule.com:8080/admin/tester.jsp");
        }

        logoutTesterPage();
    }
}
