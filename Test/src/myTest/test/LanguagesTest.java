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


        for (int i = 0; i < languagesArray.length; i++){

            selectLanguage(languagesArray[i]);

//        Thread.sleep(5000);

            runGame("neonstaxx_not_mobile");

            waitGameLoaded();

//        clickToDisableSounds();
//
//        clickToEnableSounds();

            clickButtonFSS(850, 850);

//        findInCurrency("balanceInCurrency");
//
//        clickSpinButton(850,820);
//
//        waitReelsStopped();

            clickButtonWithId("gameRulesButton");

            getPage("http://sta-kiv-gt2-setup01-spp-01.nix.cydmodule.com:8080/admin/tester.jsp");

        }

//        findInCurrency("balanceInCurrency");

        logoutTesterPage();


    }
}
