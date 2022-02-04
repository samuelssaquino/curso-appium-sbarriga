package br.ce.wcaquino.appium.tests;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.pages.FormularioPage;
import br.ce.wcaquino.appium.pages.MenuPage;

public class FormularioTeste extends BaseTest{

    private MenuPage menu = new MenuPage();
    private FormularioPage formularioPage = new FormularioPage();
    
    @Before
    public void setup(){
        menu.acessarFormulario();
    }
    
    @Test
    public void devePreencherCampoTexto(){        
        formularioPage.escreverNome("Samuel");
        Assert.assertEquals("Samuel", formularioPage.obterNome());
    }    
}
