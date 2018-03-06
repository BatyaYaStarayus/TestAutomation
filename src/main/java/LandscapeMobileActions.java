import org.junit.Before;

public class LandscapeMobileActions extends MobileGameActions{

    @Before

    public void prepareToLaunchGameMobile() throws InterruptedException {
        initializeMobileDriverLandscape();
        openAndMaximiseBrowser();
        getPage();
        loginAdminPage();
        loginTesterPage(MOBILECHANNEL);
    }

    protected void clickFSIntroButton() {
        clickOnElementByCoordinates(
                GameElementsCoordinates.FSIntroContinueButtonCoordinateXMobileLandscape,
                GameElementsCoordinates.FSIntroContinueButtonCoordinateYMobileLandscape);
    }

    protected void clickFSOutroButton() {
        clickOnElementByCoordinates(
                GameElementsCoordinates.FSOutroContinueButtonCoordinateXMobileLandscape,
                GameElementsCoordinates.FSOutroContinueButtonCoordinateYMobileLandscape);
    }
}
