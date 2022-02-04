package br.ce.wcaquino.appium.core;

import static br.ce.wcaquino.appium.core.DriveFactory.getDriver;
import static br.ce.wcaquino.appium.core.DriveFactory.getDriverWait;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

public class BasePage {

    public void toWrite(By selector, String texto) {
        getDriver().findElement(selector).clear();
        getDriver().findElement(selector).sendKeys(texto);
    }

    public String getTexts(By selector) {
        getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(selector));
        return getDriver().findElement(selector).getText();
    }

    public void toClick(By selector) {
        getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(selector));    
        getDriver().findElement(selector).click();
    }

    public void toClickText(String texto) {        
        getDriver().findElement(By.xpath("//*[@text='" + texto + "']")).click();
    }

    public void selectComboWeb(By selector, String valor) {
        getDriver().findElement(selector).click();
        getDriver().findElement(By.xpath("//select[@id='" + valor + "']")).click();
    }

    public void selectComboMobile(By selector, String valor) {
        getDriver().findElement(selector).click();
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='" + valor + "']")).click();
    }

    public void selectComboMovimentacoes(By selector, String valor){
        getDriver().findElement(selector).click();
        getDriver().findElement(By.xpath("//android.widget.CheckedTextView[@text='" + valor + "']")).click();
    }

    public boolean isCheckCliked(By selector) {
        return getDriver().findElement(selector).getAttribute("checked").equals("true");
    }

    public boolean isDisplayed(By selector) {
        return getDriver().findElement(selector).isDisplayed();
    }

    public boolean isEnable(By selector) {
        return getDriver().findElement(selector).isEnabled();
    }

    public void enterContextWeb() {
        Set<String> contextHandles = getDriver().getContextHandles();
        for (String valor : contextHandles) {
            System.out.println(valor);
        }
        getDriver().context((String) contextHandles.toArray()[1]);
    }

    public void exitContextWeb() {
        Set<String> contextHandles = getDriver().getContextHandles();
        for (String valor : contextHandles) {
            System.out.println(valor);
        }
        getDriver().context((String) contextHandles.toArray()[0]);
    }

    public void longClick(By by) {
        new TouchAction(getDriver())
                .longPress(getDriver().findElement(by))
                .perform();
    }

    public void swipeElement(MobileElement element, double inicio, double fim) throws InterruptedException{     
        
        Thread.sleep(3000);

        int y = element.getLocation().y + (element.getSize().height / 2);

        int start_x = (int) (element.getSize().width * inicio);
        int end_x = (int) (element.getSize().width * fim);

        new TouchAction(getDriver())
        .press(start_x, y)
        .waitAction(Duration.ofMillis(500))
        .moveTo(end_x, y)
        .release()
        .perform();

        Thread.sleep(3000);
    }

    public void scroll(double inicio, double fim) throws InterruptedException{

        Thread.sleep(1000);

        Dimension size = getDriver().manage().window().getSize();

        int x = size.width / 2;

        int start_y = (int) (size.height * inicio);
        int end_y = (int) (size.height * fim);

        new TouchAction(getDriver())
        .press(x, start_y)
        .waitAction(Duration.ofMillis(500))
        .moveTo(x, end_y)
        .release()
        .perform();
    }
}
