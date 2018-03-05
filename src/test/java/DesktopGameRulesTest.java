import org.junit.Test;

/**
 * Created by ivan.kozlov on 20.03.2017.
 */
public class DesktopGameRulesTest extends DesktopGameActions {

    @Test

    public void gameRulesTest() throws Exception {
            runGame(gameId);
            waitGameLoaded();
            closeFSS();
            openAutoplaySettings();
            autoplayAndVerification(10);
            enteringIdleState();
            openGameRules();
            Thread.sleep(TIMEOUT);
    }

}
