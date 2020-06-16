package test.java.lesson9;

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
import static org.testng.Assert.*;

public class HWApiTesting {
    long newId;
    int tasksCount = 9;

    @Test
    public void getList(){
        Response response = (Response)
        given().
                header("Authorization", "Bearer 2544085bad6dd688c7084d9213c01b661d60b834").
                when().
                get("https://api.todoist.com/rest/v1/tasks");
        JsonPath path = response.jsonPath();
        List<Map> tasksList = path.getList("");
        System.out.println("list size on start of test is: " + tasksList.size());
        System.out.println(tasksList);
        response.
                then().
          //      statusCode(200).
        assertThat().
                body(matchesJsonSchemaInClasspath("getTasksValidation.json"));
        assertTrue(tasksList.size() == tasksCount, "We have some another count than size of list");

    }

    @Test(dependsOnMethods = "getList")
    public void create() {
        newId = given().
                header("Authorization", "Bearer 2544085bad6dd688c7084d9213c01b661d60b834").
                        when().
                        get("https://api.todoist.com/rest/v1/tasks").
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
                delete("https://api.todoist.com/rest/v1/tasks/" + newId).
                then().
                statusCode(204);
    }
}
