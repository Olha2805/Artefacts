package test.java;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertEquals;

public class Api_projects {
    long newId;

    @Test
    public void get(){
        String firstName = "Inbox";
        Response response = (Response)
        given().header("Authorization","Bearer 2544085bad6dd688c7084d9213c01b661d60b834").
                when().
                get("https://api.todoist.com/rest/v1/projects");
        JsonPath path = response.jsonPath();
        List<Map> list = path.getList("");
        List<String> actualNames = new ArrayList<>();
        for (Map project: list) {
            actualNames.add((String) project.get("name"));
        }
        response.
                then().
                statusCode(200).
                assertThat().
                body(matchesJsonSchemaInClasspath("getBodyValidation.json"));;
        assertEquals(actualNames.get(0), "Inbox");
        actualNames.remove(0);
        for (String name: actualNames) assertFalse(name.equals("Inbox"), String.format("Expected name '%s' not to be Inbox", name));
    }

    @Test
    public void create() {
        /*String jsonBody = "{" +
                "\"name\": \"AQA\"," +
                "\"comment_count\": 0," +
                "\"color\": 47," +
                "\"shared\": false," +
                "\"sync_id\": 0," +
                "\"order\": 1" +
                "}";*/
        newId = given().
                header("Authorization", "Bearer 2544085bad6dd688c7084d9213c01b661d60b834").
                contentType(ContentType.JSON).
                //header("Content-Type", "application/json").
                //body(jsonBody).
                        body(new File("createProjectBody.json")).
                        when().
                        post("https://api.todoist.com/rest/v1/projects").
                        then().
                        statusCode(200).
                        extract().
                        path("id");
    }

    @Test(dependsOnMethods = "create")
    public void delete() {

        given().
                header("Authorization", "Bearer 2544085bad6dd688c7084d9213c01b661d60b834").
                when().
                delete("https://api.todoist.com/rest/v1/projects/" + newId).
                then().
                statusCode(204);
    }
}
