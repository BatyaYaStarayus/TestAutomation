package myTest.test;

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ivan.kozlov on 17.02.2017.
 */

public class GameActions extends PagesActions {

    private static final int TIMEOUT = 1000;
    private Map<String, String> eventsMap = new HashMap<>();
    private Map<String, String> gettersMap = new HashMap<>();

    public GameActions() {
        super();
        this.initEventsMap();
        this.getGettersMap();
    }

    public void waitFor(String eventKey) throws Exception {

        String rezult = "";
        String eventName = eventsMap.get(eventKey);

        js.executeScript("window.TEST_EVENT_FIRED = false;" +
                "window.TEST_EVENT = new Sys.Observable();" +
                "window.TEST_EVENT.addListener('" + eventName + "', " +
                "function(){" +
                "window.TEST_EVENT.removeListener('" + eventName + "');" +
                "window.TEST_EVENT_FIRED = true; " +
                "});");


        while (!("true".equals(rezult))) {
            rezult = js.executeScript("return window.TEST_EVENT_FIRED").toString();
        }
    }

    protected void waitGameLoaded() throws Exception {

        this.waitFor("gameLoaded");

    }

    protected void waitReelsStopped() throws Exception {

        this.waitFor("reelsAnimationStopped");

    }

    protected void enteringIdleState() throws Exception {

        this.waitFor("enteringIdleState");

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


    }

    protected void clickButtonFSS (int positionX, int positionY) {

//        850,850 for Neon Staxx

        WebElement canvasGameArea = driver.findElement(By.id("canvasAnimationManager"));
        Actions hoverButtonFSS = new Actions(driver);
        hoverButtonFSS.moveToElement(canvasGameArea, positionX, positionY).click().perform();

    }

    protected void clickButtonWithId (String id) throws InterruptedException {

        WebElement buttonWithId = driver.findElement(By.id(id));
        buttonWithId.click();
        Thread.sleep(TIMEOUT);

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

    protected void openGameRules () {

        WebElement enabledGameRulesButton = driver.findElement(By.className("interface-gameRules_icon_uri"));
        enabledGameRulesButton.click();

    }


    protected void clickSpinButton (int positionX, int positionY) {

//        850,820 for Neon Staxx

        WebElement canvasGameArea = driver.findElement(By.id("canvasAnimationManager"));
        Actions hoverButtonFSS = new Actions(driver);
        hoverButtonFSS.moveToElement(canvasGameArea, positionX, positionY).click().perform();

    }

    private void getGettersMap() {

        gettersMap.put("balanceInCurrency", "Services.moneyManager.getBalanceCents()");
        gettersMap.put("betInCurrency", "Services.moneyManager.getBetCents()");
        gettersMap.put("winInCurrency", "Services.storage.readData(\"cashField.winInCents\")");

    }

    protected int findInCurrency(String eventKey) throws Exception {

        String result;
        String eventName = gettersMap.get(eventKey);

        result = js.executeScript("return " + eventName).toString();

        System.out.println(result);

        return Integer.parseInt(result);

        }

    protected void findBetInCurrency () throws Exception {

        findInCurrency("betInCurrency");

    }

    protected void findBalanceInCurrency () throws Exception {

        findInCurrency("balanceInCurrency");

    }

    protected void findWinInCurrency () throws Exception {

        findInCurrency("winInCurrency");

    }

    @Test
    public void googleTest() throws Exception {

        initializeDriver("Chrome");

        openAndMaximiseBrowser();

        getPage("http://sta-kiv-gt2-setup01-spp-01.nix.cydmodule.com:8080/admin/tester.jsp");

        loginAdminPage("netent", "netent");

        loginTesterPage("zrada", "");


        for (int i = 0; i < LANGUAGES.length; i++){

            selectLanguage(LANGUAGES[i]);

            runGame("neonstaxx_not_mobile");

            waitGameLoaded();

            clickToDisableSounds();

            clickToEnableSounds();

            clickButtonFSS(850, 850);

            findInCurrency("balanceInCurrency");

            clickSpinButton(850,820);

            waitReelsStopped();

            clickButtonWithId("gameRulesButton");

            getPage("http://sta-kiv-gt2-setup01-spp-01.nix.cydmodule.com:8080/admin/tester.jsp");

        }

        findInCurrency("balanceInCurrency");

        logoutTesterPage();


    }

}



