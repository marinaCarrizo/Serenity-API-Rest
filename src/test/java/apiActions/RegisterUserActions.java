package apiActions;

import io.restassured.response.Response;
import model.WebServiceEndpoints;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.reports.adaptors.specflow.ScenarioStep;
import net.thucydides.core.steps.ScenarioSteps;

import java.util.List;


public class RegisterUserActions extends ScenarioSteps {
    public Response response;

   @Step("the user sents a POST request to register API with valid request")
    public void withDetails(String trade) {
        SerenityRest.given()
                .contentType("application/json")
                .header("Content-Type", "application/json")
                .body(trade)
                .when()
                .post(WebServiceEndpoints.TRADE.getUrl());
    }
    @Step
    public String getContentType() throws Exception {
        return response.then().extract().contentType();
    }

}
