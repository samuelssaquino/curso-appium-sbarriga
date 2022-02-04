package br.ce.wcaquino.appium.pages;

import br.ce.wcaquino.appium.core.BasePage;

public class MenuPage extends BasePage{

    public void acessarFormulario(){
        toClickText("Formulário");
    }

    public void acessarSBNativo(){
        toClickText("SeuBarriga Nativo");
    }
}
