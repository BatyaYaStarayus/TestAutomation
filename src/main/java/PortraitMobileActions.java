import org.junit.Before;

public class PortraitMobileActions extends MobileGameActions{

    @Before

    public void prepareToLaunchGameMobile() throws InterruptedException {
        initializeMobileDriverPortrait();
        openAndMaximiseBrowser();
        getPage();
        loginAdminPage();
        loginTesterPage(MOBILECHANNEL);
    }

    protected void clickFSIntroButton() {
        clickOnElementByCoordinates(
                GameElementsCoordinates.FSIntroContinueButtonCoordinateXMobilePortrait,
                GameElementsCoordinates.FSIntroContinueButtonCoordinateYMobilePortrait);
    }

    protected void clickFSOutroButton() {
        clickOnElementByCoordinates(
                GameElementsCoordinates.FSOutroContinueButtonCoordinateXMobilePortrait,
                GameElementsCoordinates.FSOutroContinueButtonCoordinateYMobilePortrait);
    }

}
