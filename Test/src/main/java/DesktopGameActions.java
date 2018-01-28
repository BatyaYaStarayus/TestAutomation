import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;

public class DesktopGameActions extends CommonGameActions {

    @Override
    protected void makeScreenShot(String testedElement) throws IOException, InterruptedException {
        super.makeScreenShot(testedElement, "Desktop");
    }

    protected void clickButtonFSS (int positionX, int positionY) {

//        850,850 for Neon Staxx

        clickOnElementByCoordinates(positionX, positionY);

    }

    protected void openPaytable (int positionX, int positionY) {

//        850,820 for Neon Staxx

        clickOnElementByCoordinates(positionX, positionY);

    }

    protected void changePagesAndMakeScreenShots (String openedElement, int positionX, int positionY, int pagesAmount, int distanceBetweenIndicators) throws IOException, InterruptedException {

        WebElement canvasGameArea = driver.findElement(By.id("canvasAnimationManager"));
        Actions hoverFirstPageIndicator = new Actions(driver);
        hoverFirstPageIndicator.moveToElement(canvasGameArea, positionX, positionY).click().perform();

        for (int i = 0; i < pagesAmount; i++, positionX += distanceBetweenIndicators) {
            hoverFirstPageIndicator = new Actions(driver);
            hoverFirstPageIndicator.moveToElement(canvasGameArea, positionX, positionY).click().perform();
            makeScreenShot(openedElement + "/Page" + (i + 1) );
        }

    }

    protected void openGameRules() {

        WebElement enabledGameRulesButton = driver.findElement(By.className("interface-gameRules_icon_uri"));
        enabledGameRulesButton.click();

    }

    //    TODO closing via openGR method
//    is it OK? :)

    protected void closeGameRules() {
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

        //@TODO add advancedButton id
        WebElement autoplayAdvancedButton = driver.findElement(By.id("advancedAutoplaySettingsToggle_button_handle"));
        autoplayAdvancedButton.click();

    }

    protected void openGameSettings () {

        // action
        WebElement gameSettingsButton = driver.findElement(By.id("gameSettingsSettingsButton"));
        gameSettingsButton.click();

        // verification
        WebElement gameSettingsBlock = driver.findElement(By.id("gameSettings"));
        Assert.assertEquals(true, gameSettingsBlock.isDisplayed());

    }

    protected void startAutoplay(int roundsAmount) {

        String roundsAmountString = Integer.toString(roundsAmount);
        WebElement roundsAmountButton = driver.findElement(By.id(roundsAmountString));
        roundsAmountButton.click();

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

}
