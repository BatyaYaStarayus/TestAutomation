

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class JMXActions extends PagesActions {

    private WebElement gameModeButton;

    protected void openJMX () throws InterruptedException {
        clickOnElementById("JMXHandle");
        Thread.sleep(TIMEOUT); 
    }
    
    protected void setJMXOn(String buttonId) throws InterruptedException {
       clickOnElementById(buttonId);
       Thread.sleep(TIMEOUT);
    }
    
    protected void closeJMX () throws InterruptedException {
        clickOnElementById("JMXClose");
        Thread.sleep(TIMEOUT);
    }

    protected void setJMXOnFreeSpins () throws InterruptedException {
        openJMX();
        setJMXOn("JMXFreespins");
        closeJMX();
    }

    protected void setOneFreeSpinLeft () throws InterruptedException {
        setJMXOn("JMXFreespinsLeft1");
    }

    protected String getCurrentGameMode() {
        WebElement gameModeButton = driver.findElement(By.id("JMXGameMode"));

        return gameModeButton.getText();
    }

    protected void setNeededGameMode(String neededGameMode) throws InterruptedException {
        String gameModeString = "Current game mode: ";

        while (!getCurrentGameMode().equals(gameModeString + neededGameMode)) {
            setJMXOn("JMXGameMode");
        }
    }

    protected String getBigWinType() {
        WebElement bigWinsButton = driver.findElement(By.id("JMXBigWins..."));
        String bigWinsButtonText = bigWinsButton.getText();

        return bigWinsButtonText.toLowerCase().replaceAll(" ", "");
    }

    protected void setBigWinType(String neededBigWinType) throws InterruptedException {
        do {
                setJMXOn("JMXBigWins...");
        }
        while (!getBigWinType().contains(neededBigWinType.toLowerCase()));
    }
}

