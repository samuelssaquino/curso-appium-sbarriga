package br.ce.wcaquino.appium.pages.seuBarriga;

import org.openqa.selenium.By;

import br.ce.wcaquino.appium.core.BasePage;

public class SBLoginPage extends BasePage{
    
    public void setEmail(String email){
        toWrite(By.className("android.widget.EditText"), email);
    }

    public void setSenha(String senha){
        toWrite(By.xpath("//android.widget.EditText[2]"), senha);
    }

    public void entrar(){
        toClickText("ENTRAR");
    }

    public void reset() {
        toClickText("RESET");
    }
}
