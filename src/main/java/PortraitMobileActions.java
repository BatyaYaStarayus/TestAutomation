import org.junit.Before;

public class PortraitMobileActions extends MobileGameActions{

    @Before

    public void prepareToLaunchGameMobile() throws InterruptedException {
        initializeMobileDriverPortrait();
//        openAndMaximiseBrowser();
        getPage();
        loginAdminPage();
        loginTesterPage(MOBILECHANNEL);
    }

}
