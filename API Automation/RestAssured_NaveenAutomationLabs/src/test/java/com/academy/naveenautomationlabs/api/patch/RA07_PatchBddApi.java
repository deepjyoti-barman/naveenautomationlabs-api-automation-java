package com.academy.naveenautomationlabs.api.patch;

import com.academy.naveenautomationlabs.api.post.User;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class RA07_PatchBddApi {

    // Create a user with POST call
    // Get the user id
    // Update the user information with PATCH call
    // Then validate:
    // 1. Other attributes should remain same
    // 2. The attribute which has been changed, need to be checked
    @Test
    public void patchApiBddTest001() {

        baseURI = "https://gorest.co.in";

        // Create the user - POST call
        User user = new User("Vivek Verma",
                "vivek.bittu007@gmail.com",
                "male",
                "inactive");

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

        // Update the user information
        user.setEmail("vivek.bittu008@gmail.com");

        // Update user information - PATCH call
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .auth().oauth2("fd7c373f58ed71bf6f081977bf4bf4b5a47272554dfbeabfa5eff87b83a6e064")
                .pathParam("userId", userId)
                .body(user)
        .when()
                .patch("/public/v2/users/{userId}")
        .then()
                .log().all()
                .assertThat().contentType(ContentType.JSON).and()
                .statusCode(HttpStatus.SC_OK).and()
                .body("id", equalTo(userId))
                .body("name", equalTo(user.getName())).and()
                .body("gender", equalTo(user.getGender())).and()
                .body("status", equalTo(user.getStatus())).and()
                .body("email", equalTo(user.getEmail()));
    }
}
