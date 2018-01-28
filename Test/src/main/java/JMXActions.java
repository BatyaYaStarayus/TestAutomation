import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class JMXActions extends PagesActions {

    private WebElement gameModeButton;

    protected void openJMX () throws InterruptedException {
        WebElement JMXButton = driver.findElement(By.className("JMXHandle"));
        JMXButton.click();
        Thread.sleep(TIMEOUT); 
    }
    
    protected void setJMXOn(String buttonId) throws InterruptedException {

        WebElement button = driver.findElement(By.className(buttonId));
        button.click();
        Thread.sleep(TIMEOUT);
    }
    
    protected void closeJMX () throws InterruptedException {
        WebElement closeJMXButton = driver.findElement(By.className("JMXClose"));
        closeJMXButton.click();
        Thread.sleep(TIMEOUT);
    }

    protected void setJMXOnFreeSpins () throws InterruptedException {

//        TODO add FS button id instead of "JMXFreeSpins"
        openJMX();
        setJMXOn("JMXFreeSpins");
        closeJMX();

    }

    protected void setOneFreeSpinLeft () throws InterruptedException {


//        TODO add FSLeft:1 button id instead of "FreeSpinsLeft1"
        setJMXOn("FreeSpinsLeft1");

    }

    protected void getNeededGameMode (String neededGameMode) throws InterruptedException {

//        TODO add game mode button id instead of "JMXCurrentGameMode"
        WebElement gameModeButton = driver.findElement(By.className("JMXCurrentGameMode"));
        String currentGameMode = gameModeButton.getText();


//        TODO need to add method for getting inner text of gameModeButton
        while (!currentGameMode.equals(neededGameMode)) {
            setJMXOn(String.valueOf(gameModeButton));
        }
    }

}
