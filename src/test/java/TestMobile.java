


import org.junit.Test;

/**
 * Created by ivan.kozlov on 15.03.2017.
 */
public class TestMobile extends CommonGameActions {

    @Test
    public void myMobileTest() throws Exception{

        initializeMobileDriver();
        openAndMaximiseBrowser();
        getPage();
        loginAdminPage();
        loginTesterPage();

            runGame(gameId);
            waitGameLoaded();
            getBetInCurrency();
            enteringIdleState();
            getBalanceInCurrency();
            getPage();
    }

}
