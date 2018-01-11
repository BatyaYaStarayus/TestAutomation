package main.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class JMXActions extends GameActions {

    protected void openJMX () throws InterruptedException {
//TODO insert JMX button id
        WebElement JMXButton = driver.findElement(By.className("interface-soundSettings_audioOff_icon_uri"));
        JMXButton.click();
        Thread.sleep(TIMEOUT); 
    }
    
    protected void clickOnButton(String buttonId) throws InterruptedException {

        WebElement button = driver.findElement(By.className(buttonId));
        button.click();
        Thread.sleep(TIMEOUT);
    }
    
    protected void closeJMX () throws InterruptedException {
        //TODO insert close JMX button id
        WebElement closeJMXButton = driver.findElement(By.className("interface-soundSettings_audioOff_icon_uri"));
        closeJMXButton.click();
        Thread.sleep(TIMEOUT);
    }

}

