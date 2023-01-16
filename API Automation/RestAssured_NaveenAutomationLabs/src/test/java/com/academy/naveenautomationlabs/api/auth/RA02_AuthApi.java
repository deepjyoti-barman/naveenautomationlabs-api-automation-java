package com.academy.naveenautomationlabs.api.auth;

import io.restassured.RestAssured;
import io.restassured.authentication.FormAuthConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class RA02_AuthApi {

    // Preemptive Authentication
    // The preemptive () directive has to be added after auth ()
    @Test
    public void basicPreemptiveAuthApiTest001() {

        given()
                .log().all()
                .auth().preemptive().basic("admin", "admin")
        .when()
                .log().all()
                .get("http://the-internet.herokuapp.com/basic_auth")
        .then()
                .log().all()
                .assertThat().statusCode(200);
    }

    @Test
    public void basicAuthApiTest002() {

        given()
                .log().all()
                .auth().basic("admin", "admin")
        .when()
                .log().all()
                .get("http://the-internet.herokuapp.com/basic_auth")
        .then()
                .log().all()
                .assertThat().statusCode(200);
    }

    @Test
    public void digestAuthApiTest003() {

        given()
                .log().all()
                .auth().digest("admin", "admin")
        .when()
                .log().all()
                .get("http://the-internet.herokuapp.com/basic_auth")
        .then()
                .log().all()
                .assertThat().statusCode(200);
    }

    @Test
    public void formAuthApiTest004() {

        given()
                .log().all()
                .auth().form("qa9988",
                        "makemytrip@123",
                        new FormAuthConfig(
                                "https://classic.freecrm.com/system/authenticate.cfm",
                                "username",
                                "password"))
        .when()
                .log().all()
                .post("https://classic.freecrm.com/system/authenticate.cfm")
        .then()
                .log().all()
                .assertThat().statusCode(302);
    }

    // OAuth2.0 Authentication
    @Test
    public void oauth2ApiTest005() {

        String jsonPayload = "{\n" +
                "    \"name\": \"Micky Mouse\",\n" +
                "    \"email\": \"mickymouse@disney.in\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"status\": \"inactive\"\n" +
                "}";
        given()
                .log().all()
                .auth().oauth2("fd7c373f58ed71bf6f081977bf4bf4b5a47272554dfbeabfa5eff87b83a6e064")
                .contentType(ContentType.JSON)
                .body(jsonPayload)
        .when()
                .post("https://gorest.co.in/public/v2/users")
        .then()
                .log().all()
                .assertThat().statusCode(201);
    }

    @Test
    public void oauth2ApiTest006() {

        String jsonPayload = "{\n" +
                "    \"name\": \"Micky Mouse\",\n" +
                "    \"email\": \"mickymouse@disney.in\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"status\": \"inactive\"\n" +
                "}";
        given()
                .log().all()
                .header("Authorization", "Bearer fd7c373f58ed71bf6f081977bf4bf4b5a47272554dfbeabfa5eff87b83a6e064")
                .contentType(ContentType.JSON)
                .body(jsonPayload)
        .when()
                .post("https://gorest.co.in/public/v2/users")
        .then()
                .log().all()
                .assertThat().statusCode(201).and()
                .header("Server", "cloudflare");
    }

    @Test
    public void oauth2ApiTest007() {
        RequestSpecification request = given().auth().oauth2("72a266d8db2931c03557fa61b5c150c21d76a672");
        Response response = request.post("http://coop.apps.symfonycasts.com/api/4195/chickens-feed");
        System.out.println(response.getStatusCode());
        response.prettyPrint();
    }

    // 1. Generate a token at the runtime by using token api
    // 2. Extract tokenID from the response
    // 3. Hit the next api with this tokenID
    @Test
    public void oauth2ApiTest008() {

        // Request 1 - generate the tokenID
        RequestSpecification request = RestAssured.given()
                .formParam("client_id", "Chicken Feed App")
                .formParam("client_secret", "1a00dddbb5ad192e1e117f7ec8b5c9f3")
                .formParam("grant_type", "client_credentials")
                .formParam("redirect_uri", "https://naveenautomationlabs.com");

        Response response = request.post("http://coop.apps.symfonycasts.com/token");
        System.out.println(response.getStatusCode());
        response.prettyPrint();
        String tokenID = response.jsonPath().getString("access_token");
        System.out.println("API Token ID: " + tokenID);

        // Request 2 - get the actual response
        RequestSpecification req = given().auth().oauth2(tokenID);
        Response resp = req.post("http://coop.apps.symfonycasts.com/api/4195/chickens-feed");
        System.out.println(resp.getStatusCode());
        resp.prettyPrint();
    }

    // OAuth1.0 Authentication
    @Test
    // p1 = Consumer Key, p2 = Consumer Secret, p3 = Access Token, p4 = Token Secret
    // In order to use OAuth 1 and OAuth 2 (for query parameter signing) you need to add Scribe to your classpath
    public void oauth1ApiTest009() {
        RequestSpecification request = RestAssured.given().auth().oauth("HGgqWV2t6YnEhhBvuDnAcYlli",
                "LTqWrkWEkcW7FsZ093gq1Z9IfnED8LSY4cpCBAiQGY8AXrLloQ",
                "220976784-2eQZmLlaEPxeNb3Wywy24dXldUlq1ge29afKA2AR",
                "SgXmzqweFoaSilrWLCwYXCYKme4Rk80X1K4rtE1CUrJN7");

        Response response = request.post("https://api.twitter.com/1.1/statuses/update.json?status=Hello World");
        System.out.println(response);
        response.prettyPrint();
    }
}
