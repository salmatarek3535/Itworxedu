package stepsDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import models.BoredApi;

public class BoredApiSteps {

    private BoredApi boredApi= new BoredApi();

    @Given("user gets a random activity from bored API")
    public void userGetsARandomActivityFromBoredAPI() {
        boredApi.getRandomActivity();
    }

    @Then("validate the response schema")
    public void validateTheResponseSchema() {
        boredApi.validateResponseSchema();
    }

    @Then("validate the response code")
    public void validateTheResponseCode() {
        boredApi.validateResponseStatusCode();
    }
}
