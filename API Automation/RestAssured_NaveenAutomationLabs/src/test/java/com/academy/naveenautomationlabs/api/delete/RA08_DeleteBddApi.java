package com.academy.naveenautomationlabs.api.delete;

import com.academy.naveenautomationlabs.api.post.User;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class RA08_DeleteBddApi {

    // Create a user with POST call
    // Get the user id
    // Delete the user with PATCH call
    // Try to get the user information with GET call - response should be 404
    @Test
    public void deleteApiBddTest001() {

        baseURI = "https://gorest.co.in";

        // Create the user - POST call
        User user = new User("Preeti Roy",
                "preeti.roy002@gmail.com",
                "female",
                "active");

        int userId = given()
                .log().all()
                .contentType(ContentType.JSON)
                .auth().oauth2("fd7c373f58ed71bf6f081977bf4bf4b5a47272554dfbeabfa5eff87b83a6e064")
                .body(user)
        .when()
                .post("/public/v2/users")
        .then()
                .log().all()
                .assertThat().contentType(ContentType.JSON).and()
                .statusCode(HttpStatus.SC_CREATED).and()
                .extract().path("id");

        // Print the user id
        System.out.println("User ID: " + userId);

        // Delete the user - DELETE call
        given()
                .log().all()
                .auth().oauth2("fd7c373f58ed71bf6f081977bf4bf4b5a47272554dfbeabfa5eff87b83a6e064")
                .pathParam("userId", userId)
        .when()
                .delete("/public/v2/users/{userId}")
        .then()
                .log().all()
                .assertThat().statusCode(HttpStatus.SC_NO_CONTENT);


        // Try to retrieve the deleted user information - DELETE call
        given()
                .log().all()
                .pathParam("userId", userId)
        .when()
                .get("/public/v2/users/{userId}")
        .then()
                .log().all()
                .assertThat().statusCode(HttpStatus.SC_NOT_FOUND);
    }
}
