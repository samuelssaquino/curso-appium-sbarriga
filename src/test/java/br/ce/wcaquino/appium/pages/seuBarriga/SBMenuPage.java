package br.ce.wcaquino.appium.pages.seuBarriga;

import br.ce.wcaquino.appium.core.BasePage;

public class SBMenuPage extends BasePage{
    
    public void acessarContas(){
        toClickText("CONTAS");
    }

    public void acessarMovimentacoes() {
        toClickText("MOV...");
    }

    public void acessarResumo() {
        toClickText("RESUMO");
    }

    public void acessarHome() {
        toClickText("HOME");
    }
  
}
