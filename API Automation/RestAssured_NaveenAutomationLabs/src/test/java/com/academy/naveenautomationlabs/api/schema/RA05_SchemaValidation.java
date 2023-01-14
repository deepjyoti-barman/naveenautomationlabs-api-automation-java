package com.academy.naveenautomationlabs.api.schema;

import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class RA05_SchemaValidation {

    @Test
    public void bookingSchemaTest001() {

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(new File("src/test/resources/payloads/booking_details.json"))
        .when()
                .post("https://restful-booker.herokuapp.com/booking")
        .then()
                .log().all()
                .assertThat().statusCode(HttpStatus.SC_OK).and()
                .body(matchesJsonSchema(new File("src/test/resources/schema/booking_schema.json")));
    }
}
