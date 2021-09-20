package StepDefinitions;

import Utilities.API_Utilities.ParseDynamicJson;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;

public class Demo_SD {

    @When("GET example")
    public void get_example() throws Exception {

        // APPROACH # 1
//        RestAssured.baseURI = "https://reqres.in/";
//        RestAssured.given()
//                .when()
//                .get("api/users?page=2")
//                .then()
//                .log()
//                .all()
//                .assertThat()
//                .statusCode(200); //This acts like an assertion

        //APPROACH # 2
        RestAssured.baseURI = "https://reqres.in/";
        Response response = RestAssured.given().get("api/users?page=2");
        Assert.assertTrue("Status Code is Not As Expected, Expected: 200 Actual: " + response.getStatusCode() , response.getStatusCode()==200);
        System.out.println("Response Time: " + response.getTime());
        System.out.println("Response Headers: " + response.headers());
        System.out.println("Individual Header: " + response.header("Content-Type"));
        System.out.println("RESPONSE BODY: " + response.asString());

        //Reading JSON Node Values
        JSONObject jsonObj = new JSONObject(response.asString());
        ParseDynamicJson.getKey(jsonObj, "id");
        for(String value : ParseDynamicJson.lst){
            System.out.println(value);
        }
    }

}
