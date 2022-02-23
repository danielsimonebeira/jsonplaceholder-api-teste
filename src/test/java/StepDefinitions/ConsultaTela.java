package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import dataProviders.configFileReader;

import org.json.JSONException;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ConsultaTelaPage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ConsultaTela {
    String url;
    WebDriver driver = null;
    ConsultaTelaPage consultaTelaPage;
    configFileReader configFileReader;

    @Before
    public void iniciar() {
        configFileReader = new configFileReader();
        url = configFileReader.getApplicationUrl("urlSite");
        System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPath());


    }

    @After
    public void finalizar() {
        if (driver != null) {
            driver.quit();
        }

    }

    @Given("acesse o site jsonplaceholder")
    public void acesse_o_site_jsonplaceholder() {
        ligaChrome();
        driver.get(url);
    }
    @And("selecione o menu {string}")
    public void selecione_o_menu(String botaoMenu) {
        consultaTelaPage = new ConsultaTelaPage(driver);
        consultaTelaPage.clicarBotao(botaoMenu);

    }

    @When("acessar o link {string}")
    public void acessar_o_link(String linkPaginaJson) throws InterruptedException {
        consultaTelaPage.clicarBotao(linkPaginaJson);
        Thread.sleep(5000);
    }

    @Then("sistema apresenta no retorno o id {string}")
    public void sistema_apresenta_no_retorno_o_id(String string) throws JSONException, IOException, ParseException {
        consultaTelaPage.validaArrayJson();

    }

    public void ligaChrome() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

}
