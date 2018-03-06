import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ivan.kozlov on 17.02.2017.
 */

public class CommonGameActions extends JMXActions {

    private Map<String, String> eventsMap = new HashMap<>();
    private Map<String, String> gettersMap = new HashMap<>();

    protected final String[] BIGWINTYPES = {"BigWin", "MegaWin", "SuperMegaWin"};

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
//        added timeout for FSS appearance
    }

    protected void waitFSIntroAppears() throws Exception {
        this.waitFor("enteringFreeSpinIntroState");
        Thread.sleep(TIMEOUT);
    }

    protected void waitFSIntoDisappears() throws Exception {
        this.waitFor("leavingFreeSpinIntroState");
    }

    protected void waitFSOutroAppears() throws Exception {
        this.waitFor("enteringFreeSpinOutroState");
    }

    protected void waitFSOutroDisappears() throws Exception {
        this.waitFor("leavingFreeSpinOutroState");
    }

    protected void enteringIdleState() throws Exception {
        this.waitFor("enteringIdleState");
    }

    protected void waitBigWinsCountUpCompleted() throws Exception {
        this.waitFor("bigWinTotalCountUpIsShown");
    }

    protected void enteringBigWinState() throws Exception {
        System.out.println("1");
        this.waitFor("enteringBigWinState");
        System.out.println("2");
    }

    protected void waitFSPopUpAppears() throws Exception {
        this.waitFor("enteringWildAnimationState");
    }

    protected void waitReelsAreSpinning() throws Exception {
        this.waitFor("spinStarted");
    }

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
        eventsMap.put("enteringFreeSpinIntroState", "notify:stateHandler.enteringFreeSpinIntroState");
        eventsMap.put("enteringFreeSpinOutroState", "notify:stateHandler.enteringFreeSpinOutroState");
        eventsMap.put("leavingFreeSpinIntroState", "notify:stateHandler.leavingFreeSpinIntroState");
        eventsMap.put("leavingFreeSpinOutroState", "notify:freeSpinOutro.closed");
        eventsMap.put("enteringBigWinState", "notify:stateHandler.enteringBigWinState");
        eventsMap.put("enteringWildAnimationState", "notify:stateHandler.enteringWildAnimationState");
        eventsMap.put("spinStarted", "notify:spin.spinAnimationStarted");
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

        return balanceInCurrency - betInCurrency;
    }

    protected void skipGameAnimations() {
        clickOnElementByCoordinates(205, 549);
        System.out.println("Clicked");
    }
}



