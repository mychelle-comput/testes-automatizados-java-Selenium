package br.com.leilao.lance;

import br.com.leilao.PageObject;

public class LancesPage extends PageObject {

    private static final String URL_LANCES = "http://localhost:8080/leilao/2";
    public LancesPage() {
        super(null);
        this.browser.navigate().to(URL_LANCES);
    }

    public boolean isPaginaAtual() {
        return browser.getCurrentUrl().contains(URL_LANCES);
    }

    public boolean isTituloLeilaoVisivel() {
        return browser.getPageSource().contains("Dados do Leilão");
    }

}
