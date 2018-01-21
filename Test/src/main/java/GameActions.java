package main.java;

import org.apache.commons.io.serialization.ValidatingObjectInputStream;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ivan.kozlov on 17.02.2017.
 */

public class GameActions extends PagesActions {

    private Map<String, String> eventsMap = new HashMap<>();
    private Map<String, String> gettersMap = new HashMap<>();

    public GameActions() {
        super();
        this.initEventsMap();
        this.getGettersMap();
    }

    public void waitFor(String eventKey) throws Exception {

        String result = "";
        String eventName = eventsMap.get(eventKey);

        js.executeScript("window.TEST_EVENT_FIRED = false;" +
                "window.TEST_EVENT = new Sys.Observable();" +
                "window.TEST_EVENT.addListener('" + eventName + "', " +
                "function(){" +
                "window.TEST_EVENT.removeListener('" + eventName + "');" +
                "window.TEST_EVENT_FIRED = true; " +
                "});");


        while (!("true".equals(result))) {
            result = js.executeScript("return window.TEST_EVENT_FIRED").toString();
            Thread.sleep(TIMEOUT);

        }

    }

    protected void waitGameLoaded() throws Exception {

        this.waitFor("gameLoaded");

    }

    protected void waitSpinButtonIsClickableMobile() {

        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement spinButtonMobile = wait.until(ExpectedConditions.elementToBeClickable(By.id("spinButton")));

    }

//    TODO add event for FS Intro appearance into waitFor method's argument
    protected void waitFSIntoAppears() {

        this.waitFor("");

    }

//    TODO add event for FS Outro appearance into waitFor method's argument
    protected void waitFSOutoAppears() {

        this.waitFor("");

    }

    protected void enteringIdleState() throws Exception {

        this.waitFor("enteringIdleState");

    }

//    TODO add event for FS Intro&Outro appearance, disappearance to eventsMap.put
    private void initEventsMap() {

        eventsMap.put("gameLoaded", "notify:stateHandler.leavingSetupGameState");
        eventsMap.put("roundStarted", "notify:spin.roundStart");
        eventsMap.put("reelsAnimationStopped", "notify:spin.spinAnimationComplete");
        eventsMap.put("allIsStopped", "notify:spin.AllIsStopped");
        eventsMap.put("paytableShown", "notify:paytable.shown");
        eventsMap.put("bigWinStarted", "notify:stateHandler.enteringBigWinState");
        eventsMap.put("AUTOPLAYSTOP", "notify:autoPlayer.stopped");
        eventsMap.put("enteringFeatureSplashState", "notify:stateHandler.enteringFeatureSplashState");
        eventsMap.put("spinAnimationComplete", "notify:spin.spinAnimationComplete");
        eventsMap.put("showingDialog", "notify.dialogWindow.showingDialog");
        eventsMap.put("enteringIdleState", "notify:stateHandler.enteringIdleState");


    }

    protected void clickButtonFSS (int positionX, int positionY) {

//        850,850 for Neon Staxx

        WebElement canvasGameArea = driver.findElement(By.id("canvasAnimationManager"));
        Actions hoverButtonFSS = new Actions(driver);
        hoverButtonFSS.moveToElement(canvasGameArea, positionX, positionY).click().perform();

    }

    protected void clickToEnableSounds () throws InterruptedException {

        WebElement disabledSoundsButton = driver.findElement(By.className("interface-soundSettings_audioOff_icon_uri"));
        disabledSoundsButton.click();
        Thread.sleep(TIMEOUT);

    }

    protected void clickToDisableSounds () throws InterruptedException {

        WebElement enabledSoundsButton = driver.findElement(By.className("interface-soundSettings_audioOn_icon_uri"));
        enabledSoundsButton.click();
        Thread.sleep(TIMEOUT);

    }

    protected void openPaytable (int positionX, int positionY) {

//        850,820 for Neon Staxx

        WebElement canvasGameArea = driver.findElement(By.id("canvasAnimationManager"));
        Actions hoverPaytableButton = new Actions(driver);
        hoverPaytableButton.moveToElement(canvasGameArea, positionX, positionY).click().perform();

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


    protected void closeMessage() {

        //    WebElement popUp = driver.findElement(By.id("dialogWindowContainer"));
        WebElement continueButton = driver.findElement(By.xpath("//*[@value='Continue']"));
        continueButton.click();

    }

    protected void clickSpinButton (int positionX, int positionY) {

        WebElement canvasGameArea = driver.findElement(By.id("canvasAnimationManager"));
        Actions hoverSpinButton = new Actions(driver);
        hoverSpinButton.moveToElement(canvasGameArea, positionX, positionY).click().perform();

    }

    protected void clickFSIntroButton (int positionX, int positionY) {

        WebElement canvasGameArea = driver.findElement(By.id("canvasAnimationManager"));
        Actions hoverButtonFSIntro = new Actions(driver);
        hoverButtonFSIntro.moveToElement(canvasGameArea, positionX, positionY).click().perform();

    }

    private void getGettersMap() {

        gettersMap.put("balanceInCurrency", "Services.moneyManager.getBalanceCents()");
        gettersMap.put("betInCurrency", "Services.moneyManager.getBetCents()");
        gettersMap.put("winInCurrency", "Services.storage.readData(\"cashField.winInCents\")");

    }

    protected int getInCurrency(String eventKey) throws Exception {

        String result;
        String eventName = gettersMap.get(eventKey);

        result = js.executeScript("return " + eventName).toString();

        System.out.println(result);

        return Integer.parseInt(result);

        }

    protected int getBetInCurrency() throws Exception {

        return getInCurrency("betInCurrency");

    }

    protected int getBalanceInCurrency() throws Exception {

        return getInCurrency("balanceInCurrency");

    }

    protected int getWinInCurrency() throws Exception {

        return getInCurrency("winInCurrency");

    }

    protected int getBalanceAfterSpin() throws Exception {

        int balanceInCurrency = getBalanceInCurrency();
        int betInCurrency = getBetInCurrency();

        int balanceAfterSpin = balanceInCurrency - betInCurrency;

        return balanceAfterSpin;

    }


}



