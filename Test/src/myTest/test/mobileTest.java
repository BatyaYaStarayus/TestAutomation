package myTest.test;

import org.junit.Test;

/**
 * Created by ivan.kozlov on 15.03.2017.
 */
public class mobileTest extends GameActions {

    @Test

    public void myMobileTest() throws Exception{

        initializeMobileDriver();
        openAndMaximiseBrowser();
        getPage("http://sta-all-kiv-gt4-setup01-spp-01.nix.cydmodule.com:8080/admin/tester.jsp");
        loginAdminPage("netent", "netent");
        loginTesterPage("zrada", "");
        runGame("neonstaxx_not_mobile");
        waitSpinButtonIsClickableMobile();
        clickSpinButton(210, 430);
        waitSpinButtonIsClickableMobile();
        getPage("http://sta-all-kiv-gt4-setup01-spp-01.nix.cydmodule.com:8080/admin/tester.jsp");

    }

}
