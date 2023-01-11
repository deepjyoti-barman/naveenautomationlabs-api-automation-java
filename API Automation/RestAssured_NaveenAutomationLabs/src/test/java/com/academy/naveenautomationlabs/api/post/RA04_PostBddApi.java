package com.academy.naveenautomationlabs.api.post;

import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.assertj.core.api.Assertions;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class RA04_PostBddApi {

    // This approach is useful for smaller json payloads
    // or, payloads where the data is not going to change
    @Test
    public void postApiBddStringTest001() {

        baseURI = "https://restful-booker.herokuapp.com";
        String jsonPayload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(jsonPayload)
        .when()
                .post("/auth")
        .then()
                .log().all()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
    }

    // This approach is useful for lengthy and complex json payloads
    @Test
    public void postApiBddFileTest002() {

        baseURI = "https://restful-booker.herokuapp.com";

        String tokenID = given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(new File("src/test/resources/payloads/credentials.json"))
        .when()
                .post("/auth")
        .then()
                .log().all()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .extract().path("token");

        // null, "", " " = true when Blank
        // null, "" = true when Empty
        System.out.println("Token ID = " + tokenID);
        Assertions.assertThat(tokenID).isNotBlank();
    }

    @Test
    public void postApiBddJsonObjTest003() {

        baseURI = "https://restful-booker.herokuapp.com";

        JSONObject payload = new JSONObject();
        payload.put("username", "admin");
        payload.put("password", "password123");

        String statusLine = given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(payload.toString())
        .when()
                .post("/auth")
        .then()
                .log().all()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .extract().statusLine();

        System.out.println("Status Line = " + statusLine);
    }

    // For this approach to work you need either: Jackson (Databind), Gson, Johnzon or Yasson library in your classpath
    @Test
    public void postApiBddHashMapTest004() {

        baseURI = "https://restful-booker.herokuapp.com";

        Map<String, Object> payloadObj = new HashMap<>();
        payloadObj.put("username", "admin");
        payloadObj.put("password", "password123");

        String contentType = given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(payloadObj)
        .when()
                .post("/auth")
        .then()
                .log().all()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .extract().contentType();

        System.out.println("Content Type = " + contentType);
    }
}
