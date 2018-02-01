


import org.junit.Test;

/**
 * Created by ivan.kozlov on 20.03.2017.
 */
public class DesktopGameRulesTest extends DesktopGameActions {

    @Test

    public void autoplayTest() throws Exception {

        initializeDesktopDriver("Chrome");
        openAndMaximiseBrowser();
        getPage();
        loginAdminPage("netent", "netent");
        loginTesterPage("zrada", "");

        for (String gameId : gamesId) {
            runGame(gameId);
            waitGameLoaded();
            clickButtonFSS(850, 850);
            openAutoplaySettings();
            autoplayAndVerification(10);
            enteringIdleState();
            openGameRules();
            Thread.sleep(TIMEOUT);

        }

    }

}