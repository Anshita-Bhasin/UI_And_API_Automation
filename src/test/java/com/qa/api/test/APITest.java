package com.qa.api.test;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class APITest {

    @Test
    public void verifyGetTEST() {
        given().when().get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .body("data[3].first_name", equalTo("Byron"));

    }

    @Test
    public void verifyPOSTTest() {

        JSONObject payload = new JSONObject();
        payload.put("name", "Bryant");
        payload.put("job", "BA");

        given()
                .body(payload.toString())
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .statusCode(201)
                .body("id", notNullValue())
                .assertThat()
                .body(matchesJsonSchemaInClasspath("schema.json"));


    }

}
