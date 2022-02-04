package br.ce.wcaquino.appium.pages.seuBarriga;

import org.openqa.selenium.By;

import br.ce.wcaquino.appium.core.BasePage;

public class SBcontasPage extends BasePage{
    
    

    public void informarNomeConta(String conta) {
        toWrite(By.xpath("//android.widget.EditText[@text='Conta']"), conta);
    }

    public void salvar() {
        toClick(By.xpath("//android.widget.TextView[@text='SALVAR']"));
    }

    public String contaAdicionadaComSucesso() {
        return getTexts(By.xpath("//android.widget.TextView[@text='Conta adicionada com sucesso']"));
    }

    public void selecionarConta(String conta){
        longClick(By.xpath("//*[@text='"+conta+"']"));
    }

    public void excluirConta(){
        toClickText("EXCLUIR");
    }

    public Object contaExcluidaComSucesso() {
        return getTexts(By.xpath("//android.widget.TextView[@text='Conta excluída com sucesso']"));
    }

}
