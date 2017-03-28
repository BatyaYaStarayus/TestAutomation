package test.java;

import main.java.GameActions;
import org.junit.Test;

/**
 * Created by ivan.kozlov on 20.03.2017.
 */
public class TestAutoplay extends GameActions {

    @Test

    public void autoplayTest() throws Exception {

        initializeDesktopDriver("Chrome");
        openAndMaximiseBrowser();
        getPage("http://sta-kiv-gt2-setup01-spp-01.nix.cydmodule.com:8080/admin/tester.jsp");
        loginAdminPage("netent", "netent");
        loginTesterPage("zrada", "");

        for (String gameId : gamesId) {
            runGame(gameId);
            waitGameLoaded();
            clickButtonFSS(850, 850);
            clickButtonWithId("autoplaySettingsSettingsButton");
            autoplayAndVerification(10);
            enteringIdleState();
            openGameRules();
            Thread.sleep(TIMEOUT);

        }

    }

}
