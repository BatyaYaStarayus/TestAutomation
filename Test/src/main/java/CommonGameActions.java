import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

/**
 * Created by ivan.kozlov on 17.02.2017.
 */

public class CommonGameActions extends JMXActions {

    private Map<String, String> eventsMap = new HashMap<>();
    private Map<String, String> gettersMap = new HashMap<>();

    public CommonGameActions() {
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

//    TODO just fix it later:)
//    protected void waitSpinButtonIsClickableMobile() {
//
//        WebDriverWait wait = new WebDriverWait(driver,10);
//        WebElement spinButtonMobile = wait.until(elementToBeClickable(By.id("spinButton")));
//
//    }

//    TODO add event for FS Intro appearance into waitFor method's argument
    protected void waitFSIntoAppears() throws Exception {

        this.waitFor("");

    }

//    TODO add event for FS Outro appearance into waitFor method's argument
    protected void waitFSOutoAppears() throws Exception {

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

    protected void closeMessage() {

        //    WebElement popUp = driver.findElement(By.id("dialogWindowContainer"));
        WebElement continueButton = driver.findElement(By.xpath("//*[@value='Continue']"));
        continueButton.click();

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

    protected void clickFSIntroButton (int positionX, int positionY) {

        clickOnElementByCoordinates(positionX, positionY);

    }

    protected void clickFSOutroButton(int positionX, int positionY) {

        clickOnElementByCoordinates(positionX, positionY);

    }


}



