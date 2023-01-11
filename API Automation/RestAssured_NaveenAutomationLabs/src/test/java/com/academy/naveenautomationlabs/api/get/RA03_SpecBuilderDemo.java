package com.academy.naveenautomationlabs.api.get;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class RA03_SpecBuilderDemo {

    // Common items to check in the response test-cases T1, T2, T3... TN
    // Status Code
    // Content-Type
    // Header
    // Log Detail
    // NOTE: We can't use single ResponseSpecBuilder object for creating two different ResponseSpecification, in such cases one might conflict the other
    ResponseSpecBuilder resSpecBuilder1 = new ResponseSpecBuilder();
    ResponseSpecification resSpec_200_OK = resSpecBuilder1
            .expectContentType(ContentType.JSON)
            .expectStatusCode(200)
            .expectHeader("server", "cloudflare")
            .log(LogDetail.ALL)
            .build();

    ResponseSpecBuilder resSpecBuilder2 = new ResponseSpecBuilder();
    ResponseSpecification resSpec_401_AUTH_FAIL = resSpecBuilder2
            .expectContentType("application/json")
            .expectStatusCode(401)
            .expectHeader("server", "cloudflare")
            .log(LogDetail.ALL)
            .build();

    // Common items to add in the POST request test-cases T1, T2, T3... TN
    // Base URI
    // Content-Type
    // Header (Authorization)
    // Log Detail
    RequestSpecBuilder reqSpecBuilder = new RequestSpecBuilder();
    RequestSpecification reqSpec_POST = reqSpecBuilder
            .setBaseUri("https://gorest.co.in")
            .setContentType(ContentType.JSON)
            .addHeader("Authorization", "Bearer fd7c373f58ed71bf6f081977bf4bf4b5a47272554dfbeabfa5eff87b83a6e064")
            .log(LogDetail.ALL)
            .build();

    @Test
    public void respSpecSuccessTest001() {
        RestAssured.baseURI = "https://gorest.co.in";

        given()
                .log().all()
        .when()
                .get("/public/v2/posts")
        .then()
                .assertThat().spec(resSpec_200_OK);
    }

    @Test
    public void respSpecAuthFailTest002() {

        RestAssured.baseURI = "https://gorest.co.in";
        String jsonPayload = "{\n" +
                "    \"name\": \"Micky Mouse\",\n" +
                "    \"email\": \"mickymouse5@disney.in\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"status\": \"inactive\"\n" +
                "}";

        given()
                .log().all()
                .header("Authorization", "Bearer 123wrong_token-given321")
                .contentType(ContentType.JSON)
                .body(jsonPayload)
        .when()
                .post("/public/v2/users")
        .then()
                .assertThat().spec(resSpec_401_AUTH_FAIL);
    }

    @Test
    public void reqSpecTest003() {

        String jsonPayload = "{\n" +
                "    \"name\": \"Micky Mouse\",\n" +
                "    \"email\": \"mickymouse9@disney.in\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"status\": \"inactive\"\n" +
                "}";

        given()
                .spec(reqSpec_POST)
                .body(jsonPayload)
        .when()
                .post("/public/v2/users")
        .then()
                .log().all()
                .assertThat().statusCode(201);
    }
}
