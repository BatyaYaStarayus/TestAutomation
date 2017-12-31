package main.java;

public class JMXActions extends GameActions {

    protected void openJMX () {
//TODO insert JMX button id
        WebElement JMXButton = driver.findElement(By.className("interface-soundSettings_audioOff_icon_uri"));
        JMXButton.click();
        Thread.sleep(TIMEOUT); 
    }
    
    protected void clickOnButton(String buttonId) {

        WebElement button = driver.findElement(By.className(buttonId));
        button.click();
        Thread.sleep(TIMEOUT);
    }
    
    protected void closeJMX () {
        //TODO insert close JMX button id
        WebElement closeJMXButton = driver.findElement(By.className("interface-soundSettings_audioOff_icon_uri"));
        closeJMXButton.click();
        Thread.sleep(TIMEOUT);
    }

}

