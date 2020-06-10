package test.java;

import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Api_projects {

    @Test
    public void get(){
        String firstName = "Inbox";
        Response response = (Response)
        given().header("Authorization","2544085bad6dd688c7084d9213c01b661d60b834").
        when().
                get("https://todoist.com/app/#start").
                then().
                statusCode(200);
        JsonPath path = response.jsonPath();
        System.out.println("");



    }
}
