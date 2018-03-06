import java.util.HashMap;
import java.util.Map;

public class GameActionsViaRequests extends CommonGameActions {

    private Map<String, String> requestsMap = new HashMap<>();

    public GameActionsViaRequests() {
        super();
        this.initRequestsMap();
    }

    private void initRequestsMap() {
        requestsMap.put("closeFSS", "request:featureSplash.close");
        requestsMap.put("closeFSOutro", "request:freeSpinOutro.close");
        requestsMap.put("startFS", "request:freeSpins.start");
        requestsMap.put("startSpin", "request:spin.startSpin");
        requestsMap.put("stopSpin", "request:spin.stopSpin");
        requestsMap.put("showPaytable", "request:paytable.show");
        requestsMap.put("hidePaytable", "request:paytable.hide");
        requestsMap.put("showNextPagePaytable", "request:paytable.forward");
        requestsMap.put("openBetSettingsTab", "request:betSettings.show");
        requestsMap.put("openGameHistoryTab", "request:gameHistory.show");
        requestsMap.put("openGameRulesTab", "request:gameRules.show");
        requestsMap.put("openSoundSettingsTab", "request:soundSettings.show");
        requestsMap.put("openSpinSettingsTab", "request:spinSettings.show");
        requestsMap.put("spinButtonPressed", "request:spinButton.pressed");
        requestsMap.put("spinButtonReleased", "request:spinButton.released");
        requestsMap.put("quickStop", "request:quickStopper.quickStop");
    }

    protected void fireEvent(String requestKey) {
        String requestName = requestsMap.get(requestKey);
        System.out.println(requestKey);
        executeJSScript("Game.moduleLoader.fireEvent('" + requestName + "')");
        System.out.println(requestName);
    }

    protected void closeFSS() {
        fireEvent("closeFSS");
    }

    protected void closeFSOutro() {
        fireEvent("closeFSOutro");
    }

    protected void startFS() {
        fireEvent("startFS");
    }

    protected void startSpin() {
        fireEvent("spinButtonPressed");
        fireEvent("spinButtonReleased");
    }

    protected void showPaytable() {
        fireEvent("showPaytable");
    }

    protected void hidePaytable() {
        fireEvent("hidePaytable");
    }

    protected void showNextPagePaytable() {
        fireEvent("showNextPagePaytable");
    }

    protected void quickStop() {
        fireEvent("quickStop");
    }

    protected void openSoundSettingsTab() {
        fireEvent("openSoundSettingsTab");
    }

    protected void openSpinSettingsTab() {
        fireEvent("openSpinSettingsTab");
    }

    protected void openBetSettingsTab() {
        fireEvent("openBetSettingsTab");
    }

    protected void openGameRulesTab() {
        fireEvent("openGameRulesTab");
    }

    protected void openGameHistoryTab() {
        fireEvent("openGameHistoryTab");
    }

}
