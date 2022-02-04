package br.ce.wcaquino.appium.pages.seuBarriga;

import static br.ce.wcaquino.appium.core.DriveFactory.getDriver;

import org.openqa.selenium.By;

import br.ce.wcaquino.appium.core.BasePage;

public class SBResumoPage extends BasePage{

    public void excluirMovimentacao(String descricao) throws InterruptedException {
        swipeElement(getDriver().findElement(By.xpath("//*[@text='"+descricao+"']")), 0.9, 0.1);
        // toClick(By.xpath("//android.widget.TextView[@text='Del']"));
        toClickText("Del");
    }

    public String movimentacaoRemovidaComSucesso() {
        return getTexts(By.xpath("//android.widget.TextView[@text='Movimentação removida com sucesso!']"));
    }

    public void atualizarPagina() {   
        toClick(By.xpath("//android.widget.TextView[@text='ATUALIZAR']"));
    }
    
}
