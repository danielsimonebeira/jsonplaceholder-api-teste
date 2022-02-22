package StepDefinitions;

import static org.junit.Assert.assertEquals;

import java.text.MessageFormat;

import dataProviders.configFileReader;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ConsultaApi {
    private String url;
    private RequestSpecification request;
    private Response response;
    configFileReader configFileReader;

    @Before
    public void before(Scenario scenario) {
        configFileReader = new configFileReader();
        url = configFileReader.getApplicationUrl("urlSite");
        System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPath());
        request = RestAssured.with();

    }

    @Given("usuario deseje efetuar uma consulta via get na api jsonplaceholder")
    public void usuario_deseje_efetuar_uma_consulta_via_get_na_api_jsonplaceholder() {
        request.contentType(ContentType.JSON).baseUri(url);
        System.out.println("Adiciona URL: " + url);

    }
    @When("inserir no eindpoint {string} o valor {string}")
    public void inserir_no_eindpoint_o_valor(String eindPoint, String valorEindPoint) {
        response = request.get(eindPoint + valorEindPoint);

    }
    @Then("sistema deve retornar os status como {string}")
    public void sistema_deve_retornar_os_status_como(String statuscode) {
        assertEquals(Integer.parseInt(statuscode), response.getStatusCode());

    }
    @And("o e-mail {string}")
    public void o_e_mail(String email) {
        validaJsonListado("email", email);
    }

    public void validaJsonListado(String chave, String valorEsperado) {
        java.util.List<String> listarValor = response.getBody().jsonPath().get(chave);
        for (String selecionaValor : listarValor) {
            if (selecionaValor.equals(valorEsperado)) {
                assertEquals(valorEsperado, selecionaValor);
                break;
            } else {
                assertEquals(valorEsperado, selecionaValor);
            }

        }

    }

}
