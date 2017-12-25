package test.java;

import main.java.GameActions;
import org.junit.Test;

/**
 * Created by ivan.kozlov on 15.03.2017.
 */
public class TestMobile extends GameActions {

    @Test
    public void myMobileTest() throws Exception{

        initializeMobileDriver();
        openAndMaximiseBrowser();
        getPage();
        loginAdminPage("netent", "netent");
        loginTesterPage("zrada", "");

        for (String gameId : gamesId) {
            runGame(gameId);
            waitGameLoaded();
            getBetInCurrency();
            clickSpinButton(210, 430);
            enteringIdleState();
            getBalanceInCurrency();
            getPage();
        }

    }

}