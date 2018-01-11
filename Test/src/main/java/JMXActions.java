package main.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class JMXActions extends GameActions {

    protected void openJMX () throws InterruptedException {
//TODO insert JMX button id
        WebElement JMXButton = driver.findElement(By.className("JMXHandle"));
        JMXButton.click();
        Thread.sleep(TIMEOUT); 
    }
    
    protected void clickOnJMXButton(String buttonId) throws InterruptedException {

        WebElement button = driver.findElement(By.className(buttonId));
        button.click();
        Thread.sleep(TIMEOUT);
    }
    
    protected void closeJMX () throws InterruptedException {
        WebElement closeJMXButton = driver.findElement(By.className("JMXClose"));
        closeJMXButton.click();
        Thread.sleep(TIMEOUT);
    }

    protected void setJMXOnFReeSpins () throws InterruptedException {

        WebElement closeJMXButton = driver.findElement(By.className("JMXClose"));
        closeJMXButton.click();
        Thread.sleep(TIMEOUT);

    }

}

