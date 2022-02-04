package br.ce.wcaquino.appium.pages.seuBarriga;

import org.openqa.selenium.By;

import br.ce.wcaquino.appium.core.BasePage;

public class SBMovimentacoesPage extends BasePage{
    
    public void salvarMovimentacao(){
        toClickText("SALVAR");
    }

    public String descricaoObrigatorio() {
        return getTexts(By.xpath("//android.widget.TextView[@text='Descrição é um campo obrigatório']"));
    }

    public void preencherDescricao(String descricao) {
        toWrite(By.xpath("//android.widget.EditText[@text='Descrição']"), descricao);
    }

    public String interessadoObrigatorio() {
        return getTexts(By.xpath("//android.widget.TextView[@text='Interessado é um campo obrigatório']"));
    }

    public void preencherInteressado(String interessado) {
        toWrite(By.xpath("//android.widget.EditText[@text='Interessado']"), interessado);
    }

    public String valorObrigatorio() {
        return getTexts(By.xpath("//android.widget.TextView[@text='Valor é um campo obrigatório']"));
    }

    public void preencherValor(String valor) {
        toWrite(By.xpath("//android.widget.EditText[@text='Valor']"), valor);
    }

    public String contaObrigatorio() {
        return getTexts(By.xpath("//android.widget.TextView[@text='Conta é um campo obrigatório']"));
    }

    public void selecionarConta(String conta) {
        selectComboMovimentacoes(By.xpath("//android.widget.Spinner[2]"), conta);
    }

    public String movimentacaoCadastradaComSucesso() {
        return getTexts(By.xpath("//android.widget.TextView[@text='Movimentação cadastrada com sucesso']"));
    }

    public String valorContaParaSaldoInicial() {
        return getTexts(By.xpath("//android.widget.TextView[@text='534.00']"));
    }

    public Object valorContaParaSaldoFinal() {
        return getTexts(By.xpath("//android.widget.TextView[@text='-1000.00']"));
    }
}
