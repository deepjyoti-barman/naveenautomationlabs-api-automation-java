package com.academy.naveenautomationlabs.api.post;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class RA06_PostWithPojo {

    @Test
    public void createUserWithPojoTest001() {

        // Create POJO
        User user = new User("Nisha Fernandez",
                "nisha.f3@gmail.com",
                "female",
                "active");

        // Convert Java POJO to JSON/XML/Any other format - Serialization - Jackson Databind / GSON / Johnzon / Yasson API
        ObjectMapper mapper = new ObjectMapper();
        String jsonPayload = null;

        try {
            jsonPayload = mapper.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        System.out.println("JSON Payload: " + jsonPayload);

        // Hit the API
        baseURI = "https://gorest.co.in";

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .auth().oauth2("fd7c373f58ed71bf6f081977bf4bf4b5a47272554dfbeabfa5eff87b83a6e064")
//                .body(user)               // We can directly pass the POJO as well, Jackson will automatically map and serialize it
                .body(jsonPayload)
        .when()
                .post("/public/v2/users")
        .then()
                .log().all()
                .assertThat().contentType(ContentType.JSON).and()
                .statusCode(HttpStatus.SC_CREATED).and()
                .body("name", equalTo(user.getName())).and()
                .body("email", equalTo(user.getEmail()));
    }
}
