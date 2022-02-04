package br.ce.wcaquino.appium.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.pages.MenuPage;
import br.ce.wcaquino.appium.pages.seuBarriga.SBLoginPage;
import br.ce.wcaquino.appium.pages.seuBarriga.SBMenuPage;
import br.ce.wcaquino.appium.pages.seuBarriga.SBMovimentacoesPage;
import br.ce.wcaquino.appium.pages.seuBarriga.SBResumoPage;
import br.ce.wcaquino.appium.pages.seuBarriga.SBcontasPage;

public class SBTeste extends BaseTest{

    private MenuPage menu = new MenuPage();
    private SBLoginPage sbLogin = new SBLoginPage();
    private SBcontasPage sbContas = new SBcontasPage();
    private SBMenuPage sbMenu = new SBMenuPage();
    private SBMovimentacoesPage sbMov = new SBMovimentacoesPage();
    private SBResumoPage sbResumoPage = new SBResumoPage();

    @Before
    public void setup(){
        
        menu.acessarSBNativo();
        sbLogin.setEmail("ts@ts.com");
        sbLogin.setSenha("ts123456");
        sbLogin.entrar();
        sbLogin.reset();
    }

    @Test
    public void deveInserirConta(){

        sbMenu.acessarContas();
        sbContas.informarNomeConta("Conta inserida");
        sbContas.salvar();
        Assert.assertEquals("Conta adicionada com sucesso", sbContas.contaAdicionadaComSucesso());    
    }
    
    @Test
    public void deveExcluirConta(){
        
        sbMenu.acessarContas();
        sbContas.selecionarConta("Conta para alterar");
        sbContas.excluirConta();
        Assert.assertEquals("Conta excluída com sucesso", sbContas.contaExcluidaComSucesso());
    }

    @Test
    public void deveValidarInclusaoMov(){

        sbMenu.acessarMovimentacoes();

        sbMov.salvarMovimentacao();
        Assert.assertEquals("Descrição é um campo obrigatório", sbMov.descricaoObrigatorio());

        sbMov.preencherDescricao("Movimentacao A");
        sbMov.salvarMovimentacao();
        Assert.assertEquals("Interessado é um campo obrigatório", sbMov.interessadoObrigatorio());

        sbMov.preencherInteressado("Interessado A");
        sbMov.salvarMovimentacao();
        Assert.assertEquals("Valor é um campo obrigatório", sbMov.valorObrigatorio());

        sbMov.preencherValor("100.00");
        sbMov.salvarMovimentacao();
        Assert.assertEquals("Conta é um campo obrigatório", sbMov.contaObrigatorio());

        sbMov.selecionarConta("Conta para alterar");
        sbMov.salvarMovimentacao();
        Assert.assertEquals("Movimentação cadastrada com sucesso", sbMov.movimentacaoCadastradaComSucesso());
    }

    // @Test
    // public void deveAtualizarSaldoAoExcluirMovimentacao() throws InterruptedException{

    //     //acessar home
    //     sbMenu.acessarHome();
        
    //     //verificar saldo "Conta para saldo" = 534.00
    //     Assert.assertEquals("534.00", sbMov.valorContaParaSaldoInicial());

    //     //ir para o resumo
    //     sbMenu.acessarResumo();

    //     //clicar em atualizar
    //     //sbResumoPage.atualizarPagina();

    //     //excluir movimentacao 3
    //     sbResumoPage.excluirMovimentacao("Movimentacao 3, calculo saldo");

    //     // //validar mensagem "Movimentação removida com sucesso!"
    //     Assert.assertEquals("Movimentação removida com sucesso!", sbResumoPage.movimentacaoRemovidaComSucesso());
        
    //     //voltar para o home
    //     sbMenu.acessarHome();

    //     //atualizar saldos (scroll down)
    //     sbMov.scroll(0.2, 0.9);

    //     //verificar saldo = -1000.00
    //     Assert.assertEquals("-1000.00", sbMov.valorContaParaSaldoFinal());
    // }
}
