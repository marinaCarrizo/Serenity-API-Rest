package steps;

import apiActions.RegisterUserActions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import model.RegisterUserResponse;
import net.thucydides.core.annotations.Steps;
import templates.FieldValues;
import templates.MergeFrom;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.MatcherAssert.assertThat;

public class RegisterUserSteps {

    @Steps
    RegisterUserActions registerUserActions;
    @Steps
    RegisterUserResponse registerUserResponse;

    String credsData;

    @Given("^the user has the credentials$")
    public void the_user_has_the_credentials(List<Map<String,String>> credentials) throws Exception {
       credsData= MergeFrom.template("templates/credentials.json")
               .withDefaultValuesFrom(FieldValues.in("templates/standard-credentials.properties"))
               .withFieldsFrom(credentials.get(0));

    }

    @When("^the user sents a POST request to register API with valid request$")
    public void the_user_sents_a_POST_request_to_register_API_with_valid_request() throws Exception {
        registerUserActions.withDetails(credsData);
    }


    @Then("register API should have status code as {int}")
    public void registerAPIShouldHaveStatusCodeAs(int code) {

        restAssuredThat(response -> response.statusCode(code));
    }

    @And("content-type as JSON")
    public void contentTypeAsJSON() {

        restAssuredThat(response -> response.contentType("application/json"));
    }

    @And("the register API should return proper json response {string}")
    public void theRegisterAPIShouldReturnProperJsonResponse(String token) {

        Map<String, String> actualResponse = registerUserResponse.returned();

        assertThat("has token", actualResponse.containsKey(token));

    }
}
