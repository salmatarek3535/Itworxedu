package models;

import io.restassured.response.Response;
import org.testng.Assert;
import wrappers.PropertiesFileReader;
import java.io.File;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;


public class BoredApi {

    private static final String baseApiUrl= PropertiesFileReader.getValue("baseApiUrl");
    private static final String randomActivityPath= PropertiesFileReader.getValue("randomActivityPath");
    private Response response;
    private File schemaFile= new File("");


    public void getRandomActivity()
    {
       response= given().baseUri(baseApiUrl).
                when().get(randomActivityPath).thenReturn();
    }

    public void validateResponseSchema()
    {
       response.then().assertThat().body(matchesJsonSchemaInClasspath("APISchemas/BoredApi.json"));
    }

    public void validateResponseStatusCode()
    {
        int statusCode= response.statusCode();
        Assert.assertEquals(statusCode,200,"Status Code isn't correct");
    }


}
