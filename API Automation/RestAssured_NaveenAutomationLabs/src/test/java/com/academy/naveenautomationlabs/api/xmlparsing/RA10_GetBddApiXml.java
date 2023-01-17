package com.academy.naveenautomationlabs.api.xmlparsing;

import com.academy.naveenautomationlabs.util.XmlParser;
import io.restassured.path.xml.XmlPath;
import org.apache.http.HttpStatus;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;

public class RA10_GetBddApiXml {

    @Test
    public void getUserApiXmlTest001() {

        baseURI = "https://gorest.co.in";

        XmlPath xmlPath = given()
                .log().all()
                .auth().oauth2("fd7c373f58ed71bf6f081977bf4bf4b5a47272554dfbeabfa5eff87b83a6e064")
                .queryParams("email","sofia.ahmed@cognizant.com", "status", "active")
        .when()
                .get("/public/v2/users.xml")
        .then()
                .log().all()
                .assertThat().statusCode(HttpStatus.SC_OK).and()
                .header("Server", "cloudflare").and()
                .extract().xmlPath();

        String userName = xmlPath.get("objects.object.name");
        System.out.println("Username: " + userName);
        Assertions.assertThat(userName).isEqualTo("Sofia Ahmed");
    }

    @Test
    public void getUserApiXmlTest002() {

        baseURI = "https://gorest.co.in";

        XmlPath xmlPath = given()
                .log().all()
                .auth().oauth2("fd7c373f58ed71bf6f081977bf4bf4b5a47272554dfbeabfa5eff87b83a6e064")
                .queryParams("email","sofia.ahmed@cognizant.com", "status", "active")
        .when()
                .get("/public/v2/users.xml")
        .thenReturn()
                .xmlPath();

        String userName = xmlPath.get("objects.object.name");
        System.out.println("Username: " + userName);
        Assertions.assertThat(userName).isEqualTo("Sofia Ahmed");
    }

    @Test
    public void getUserApiXmlTest003() {

        baseURI = "https://gorest.co.in";

        String respXmlString = given()
                .log().all()
                .auth().oauth2("fd7c373f58ed71bf6f081977bf4bf4b5a47272554dfbeabfa5eff87b83a6e064")
                .queryParams("email","sofia.ahmed@cognizant.com", "status", "active")
        .when()
                .get("/public/v2/users.xml")
        .then()
                .log().all()
                .assertThat().statusCode(HttpStatus.SC_OK).and()
                .extract().asPrettyString();

        // To check xpath expression against the xml response use the following website
        // https://extendsclass.com/xpath-tester.html
        XmlParser xmlParser = new XmlParser(respXmlString);
        String userName = xmlParser.getTextContent("//name");
        System.out.println("Username: " + userName);
        Assertions.assertThat(userName).isEqualTo("Sofia Ahmed");
    }
}
