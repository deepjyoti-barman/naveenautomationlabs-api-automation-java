package com.academy.naveenautomationlabs.apis.get;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class RA01_GetBddApi {

    @Test
    public void getApiCircuitTest001() {
        // Logging will be applied on only three methods: given(), when(), then()
        given()
                .log().all()
        .when()
                .log().all()
                .get("http://ergast.com/api/f1/2023/circuits.json")
        .then()
                .log().all()
                .assertThat().body("MRData.CircuitTable.Circuits.circuitId", hasSize(23));
    }

    @Test
    public void getApiCircuitTest002() {
        Response response = given().when().get("http://ergast.com/api/f1/2023/circuits.json");
        int statusCode = response.getStatusCode();
        System.out.println("API Response Status Code: " + statusCode);
        Assertions.assertThat(statusCode).isEqualTo(200);
        response.prettyPrint();
    }

    @Test
    public void getApiCircuitTest003() {
        RestAssured.baseURI = "http://ergast.com";

        given()
                .log().all()
        .when()
                .log().all()
                .get("/api/f1/2023/circuits.json")
        .then()
                .log().all()
                .assertThat().statusCode(200).and()
                .contentType(ContentType.JSON).and()
                .header("Content-Length", equalTo("5235"));
    }

    @Test
    public void getApiCircuitTest004() {
        RestAssured.baseURI = "http://md5.jsontest.com";

        given()
                .queryParam("text", "test")
                .log().all()
        .when()
                .log().all()
                .get()
        .then()
                .log().all()
                .assertThat().body("md5", equalTo("098f6bcd4621d373cade4e832627b4f6"));
    }

    @Test
    public void getApiCircuitTest005() {
        RestAssured.baseURI = "http://md5.jsontest.com";
        String paramValue = "test";
        String expectedMd5Value = "098f6bcd4621d373cade4e832627b4f6";

        given()
                .log().all()
                .param("text", "test")
        .when()
                .log().all()
                .get()
        .then()
                .log().all()
                .assertThat().body("md5", equalTo(expectedMd5Value));
    }

    @DataProvider(name="getCircuitYearData")
    public Object[][] getCircuitYearInfo() {
        return new Object[][] { {"2017",  20}, {"2016", 21}, {"1966", 9}, {"2023", 23} };
    }

    @Test(dataProvider="getCircuitYearData")
    public void getApiCircuitTest006(String  seasonYear, int circuitNumber) {
        RestAssured.baseURI = "http://ergast.com";

        given()
                .log().all()
                .pathParam("raceSeason", seasonYear)
        .when()
                .log().all()
                .get("/api/f1/{raceSeason}/circuits.json")
        .then()
                .log().all()
                .assertThat().body("MRData.total", equalTo(String.valueOf(circuitNumber)));
    }
}
