import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import sun.awt.windows.ThemeReader;

import java.io.IOException;

public class DesktopGameActions extends GameActionsViaRequests {

    @Before

    public void prepareToLaunchGameDesktop() throws InterruptedException {
        initializeDesktopDriver("Chrome");
        openAndMaximiseBrowser();
        getPage();
        loginAdminPage();
        loginTesterPage(DESKTOPCHANNEL);
    }

    protected void makeScreenShot(String testedElement) throws IOException, InterruptedException {
        makeScreenShot(testedElement, "Desktop");
    }

    protected void clickButtonFSS (int positionX, int positionY) {
        clickOnElementByCoordinates(positionX, positionY);
    }

    protected void openPaytable (int positionX, int positionY) {
        clickOnElementByCoordinates(positionX, positionY);
    }

//    via clicking buttons

//    protected void changePagesAndMakeScreenShots (String openedElement, int positionX, int positionY, int pagesAmount, int distanceBetweenIndicators) throws IOException, InterruptedException {
//        WebElement canvasGameArea = driver.findElement(By.id("canvasAnimationManager"));
//        Actions hoverFirstPageIndicator = new Actions(driver);
//        hoverFirstPageIndicator.moveToElement(canvasGameArea, positionX, positionY).click().perform();
//
//        for (int i = 0; i < pagesAmount; i++, positionX += distanceBetweenIndicators) {
//            hoverFirstPageIndicator = new Actions(driver);
//            hoverFirstPageIndicator.moveToElement(canvasGameArea, positionX, positionY).click().perform();
//            makeScreenShot(openedElement + "/Page" + (i + 1) );
//        }
//    }

//    via requests

    protected void changePagesAndMakeScreenShotsFSS(int pagesAmount, int timeoutSeconds) throws IOException, InterruptedException {
        for (int i = 0; i < pagesAmount; i++) {
            makeScreenShot("FSS/Page" + (i + 1) );
            Thread.sleep(1000*timeoutSeconds);
        }
    }

    protected void changePagesAndMakeScreenShotsPaytable(int pagesAmount) throws IOException, InterruptedException {
        for (int i = 0; i < pagesAmount; i++) {
            makeScreenShot("Paytable/Page" + (i + 1) );
            showNextPagePaytable();
        }
    }




    protected void openGameRules() throws InterruptedException {
        clickOnElementByClassName("interface-gameRules_icon_uri");
        Thread.sleep(TIMEOUT);
    }

    //    TODO closing via openGR method
//    is it OK? :)

    protected void closeGameRules() throws InterruptedException {
        openGameRules();
    }

    protected void openAutoplaySettings () {
        // action
        WebElement autoplayButton = driver.findElement(By.id("autoplaySettingsSettingsButton"));
        autoplayButton.click();

        // verification
        WebElement autoplaySettingsBlock = driver.findElement(By.id("autoplaySettings"));
        Assert.assertEquals(true, autoplaySettingsBlock.isDisplayed());
    }

    protected void closeAutoplaySettings () {
        // action
        WebElement autoplayButton = driver.findElement(By.id("autoplaySettingsSettingsButton"));
        autoplayButton.click();

        // verification
        WebElement autoplaySettingsBlock = driver.findElement(By.id("autoplaySettings"));
        Assert.assertEquals(false, autoplaySettingsBlock.isDisplayed());
    }

    protected void openAdvancedAutoplaySettings() {
        clickOnElementById("advancedAutoplaySettingsToggle_button_handle");
    }

    protected void openGameSettings () {
        // action
        clickOnElementById("gameSettingsSettingsButton");

        // verification
        WebElement gameSettingsBlock = driver.findElement(By.id("gameSettings"));
        Assert.assertEquals(true, gameSettingsBlock.isDisplayed());
    }

    protected void startAutoplay(int roundsAmount) {
        String roundsAmountString = Integer.toString(roundsAmount);
        clickOnElementById(roundsAmountString);
    }

    protected void verifyAutoplayRoundsAmountDecreased(int roundsAmount) throws Exception {
        for (int i = (roundsAmount - 1); i > 0; i--) {
            WebElement spinsAmountField = driver.findElement(By.id("autoplayStopControlsSpinsCounter"));
            int spinsLeft = Integer.parseInt(spinsAmountField.getText());
            System.out.println(i);
            System.out.println(spinsLeft);
            Assert.assertTrue(i == spinsLeft);
            waitFor("enteringIdleState");
        }
    }

    protected void autoplayAndVerification(int roundsAmount) throws Exception {
        startAutoplay(roundsAmount);
        verifyAutoplayRoundsAmountDecreased(roundsAmount);
    }

    protected void clickSpinButton (int positionX, int positionY) {
        clickOnElementByCoordinates(positionX, positionY);
    }

    protected void clickFSIntroButton() {
        clickOnElementByCoordinates(
                GameElementsCoordinates.FSIntroContinueButtonCoordinateXDesktop,
                GameElementsCoordinates.FSIntroContinueButtonCoordinateYDesktop);
    }

    protected void clickFSOutroButton() {
        clickOnElementByCoordinates(
                GameElementsCoordinates.FSOutroContinueButtonCoordinateXDesktop,
                GameElementsCoordinates.FSOutroContinueButtonCoordinateYDesktop);
    }

}
