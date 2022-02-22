package StepDefinitions;

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
import org.json.JSONException;
import org.json.JSONObject;

import static org.junit.Assert.assertEquals;

public class EditarApi {
    private String url;
    private RequestSpecification request;
    private Response response;
    private JSONObject reqParams;
    dataProviders.configFileReader configFileReader;

    @Before
    public void before(Scenario scenario) {
        configFileReader = new configFileReader();
        url = configFileReader.getApplicationUrl("urlSite");
        System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPath());
        request = RestAssured.given();

    }

    @Given("usuario deseje alterar um dado do usuario via put na api jsonplaceholder")
    public void usuario_deseje_alterar_um_dado_do_usuario_via_put_na_api_jsonplaceholder() {
        request.contentType(ContentType.JSON).baseUri(url);
        System.out.println("Adiciona URL: " + url);

    }

    @When("inserir no eindpoint {string} a chave com o valor id {string}")
    public void inserir_no_eindpoint_a_chave_com_o_valor_id(String eindPoint, String id) {
//        response = request.get(eindPoint + id);
        response = request.post(eindPoint + id);

    }

    @And("a chave e-mail com valor {string}")
    public void a_chave_e_mail_com_valor(String email) throws JSONException {
        request.header("Content-Type", "application/json");
        reqParams.put("email", email);


    }

    @And("a chave latitude com o valor {string}")
    public void a_chave_latitude_com_o_valor(String latitude) throws JSONException {
        reqParams.put("geo","lat:" + latitude);

    }

    @And("a chave longitude com o valor {string}")
    public void a_chave_longitude_com_o_valor(String longitude) throws JSONException {
        reqParams.put("geo","lng:" + longitude);


    }

    @Then("sistema deve retornar o status como {string}")
    public void sistema_deve_retornar_o_status_como(String statuscode) {
        assertEquals(Integer.parseInt(statuscode), response.getStatusCode());
    }

    @And("o valor {string}")
    public void o_valor(String valorId) throws JSONException {
        assertEquals(valorId, response.jsonPath().getString("id"));

    }



}
