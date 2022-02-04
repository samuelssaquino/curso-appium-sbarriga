package br.ce.wcaquino.appium.pages;

import br.ce.wcaquino.appium.core.BasePage;
import io.appium.java_client.MobileBy;

public class FormularioPage extends BasePage{

    public void escreverNome(String nome){
        toWrite(MobileBy.AccessibilityId("nome"), nome);
    }

    public String obterNome(){
        return getTexts(MobileBy.AccessibilityId("nome"));
    }
}
