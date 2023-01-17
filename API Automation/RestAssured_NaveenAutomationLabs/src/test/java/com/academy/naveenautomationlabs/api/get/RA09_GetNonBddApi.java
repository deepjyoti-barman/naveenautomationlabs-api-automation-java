package com.academy.naveenautomationlabs.api.get;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class RA09_GetNonBddApi {

    @Test
    public void getApiNonBddTest001() {

        // static imports are required for writing BDD tests
        RestAssured.baseURI = "https://gorest.co.in";

        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer fd7c373f58ed71bf6f081977bf4bf4b5a47272554dfbeabfa5eff87b83a6e064");
        request.queryParam("email", "sofia.ahmed@cognizant.com");
        request.queryParam("gender", "female");
        request.log().all();

        Response response = request.get("/public/v2/users");

        System.out.println(response.getStatusCode());
        System.out.println(response.getHeader("Server"));
        response.prettyPrint();
    }

    @Test
    public void getApiNonBddTest002() {

        // static imports are required for writing BDD tests
        RestAssured.baseURI = "https://gorest.co.in";

        // Passing query parameters using HashMap
        Map<String, String> params = new HashMap<>();
        params.put("email", "sofia.ahmed@cognizant.com");
        params.put("gender", "female");

        RequestSpecification request = RestAssured.given();
        request.auth().oauth2("fd7c373f58ed71bf6f081977bf4bf4b5a47272554dfbeabfa5eff87b83a6e064");
        request.queryParams(params);
        request.log().all();

        Response response = request.get("/public/v2/users");

        response.prettyPrint();
        Assertions.assertThat(response.getStatusCode()).isEqualTo(200);
        Assertions.assertThat(response.getHeader("Server")).isEqualTo("cloudflare");

        // Get the id of the user
        String userId = response.jsonPath().getString("id");
        System.out.println("User ID: " + userId);
    }
}
