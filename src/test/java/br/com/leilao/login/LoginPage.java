package br.com.leilao.login;

import br.com.leilao.PageObject;
import br.com.leilao.leiloes.LeiloesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


//padrão Page Object e uma classe que representa uma pagina.
public class LoginPage extends PageObject {
    public static final String URL_LOGIN = "http://localhost:8080/login";

    //Esse metodo e um construtor que configura o ambiente de teste e inicializa o ChromeDriver e navega na pagina de Login!
    public LoginPage() {
        super(null);
        this.browser.navigate().to(URL_LOGIN);
    }

    public void preencheFormularioDeLogin(String username, String password) {
        // Preenche os campos de usuário e senha no formulário de login
        browser.findElement(By.id("username")).sendKeys(username);
        browser.findElement(By.id("password")).sendKeys(password);
    }

    public LeiloesPage efetuaLogin() {
        // Submete o formulário de login
        browser.findElement(By.id("login-form")).submit();
        return new LeiloesPage(browser);
    }

    public boolean isPaginaDeLogin() {
        //Verifica se a URL atual é a página de login
        return browser.getCurrentUrl().equals(URL_LOGIN);
    }

    public String getNomeUsuarioLogado() {
        try {
            // Obtém o nome do usuário logado!
            return browser.findElement(By.id("usuario-logado")).getText();
        } catch (NoSuchElementException e) {
            // Retorna null se o elemento não for encontrado!
            return null;
        }
    }

    public void navegaParaPaginaDeLances() {
        this.browser.navigate().to("http://localhost:8080/leiloes/2");
    }

    public boolean contemTexto(String texto) {
        // Verifica se a página contém o texto especificado!
        return browser.getPageSource().contains(texto);
    }

    public boolean paginaDeLoginComDadosInvalidos() {
        // Verifica se a URL atual é a página de login com mensagem de erro!
        return browser.getCurrentUrl().equals(URL_LOGIN + "?error");
    }
}

