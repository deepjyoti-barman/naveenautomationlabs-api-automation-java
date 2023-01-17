# API Automation using REST-Assured

## Introduction

- REST-Assured: It is a Java DSL library which will provide you some methods, interfaces or classes though which we hit the APIs, get the response and validate the response against the request sent. So, Rest-Assured is a library through which can automate the APIs
- Difference between REST API vs REST-Assured
    - REST APIs are those APIs which are built upon REST Architecture
    - REST is not a protocol it is an Architecture
    - REST-Assured (70% market capture) is a Java library through which can automate the APIs.
- Rest Assured vs HTTP Client
    - REST-Assured (70% market capture) is a Java library through which can automate the APIs
    - HTTP Client (30% market capture), OkHTTP, Jersey Client are other libraries to automate the APIs
    - Real good companies are using HTTP Client as its quite fast
    - REST-Assured is built on top of HTTP Client, so internally it will be calling HTTP client
    - REST-Assured is more user-friendly, as it provides to version to automate the APIs BDD version and Non-BDD version
    - HTTP Client supports only Non-BDD version to automate the APIs
- What is the necessity to automate the APIs when you have UI automation as well?
  - Results in API automation comes way faster than UI automation 
  - API automation test-cases have a lower chance to fail because of unnecessary flakiness
  - Before going for UI automation we should automate the APIs as it will be a smoke test for all the modules
- Non-BDD approach of writing test cases in REST-Assured is more preferable that BDD approach because it gives you more flexibility, more control over the methods and to extract information out of them.
- API Schema
  - API Schema defines and enforces structure to the data. In other words it is metadata that tells us how our data is structured
  - API Schema is defined in JSON format
  - Used to build the API contract between two systems / platforms
  - If one system violates the API schema chances are there then the other system might fail
  - During data migration API Schema validation from old system to new system has to be validated
  - JSON Schema validation is not available in HTTPClient

## Authentications

- Basic
- Preemptive
  - By default, Rest Assured uses the challenge-response mechanism. This means that it waits for the server to challenge rather than send the credentials directly. By using the preemptive directives we can avoid that additional call that the server makes and hence additional complications. In a way, it is similar to the basic auth we saw above, the only difference is that an additional preemptive () directive adds after auth ()
  - The preemptive authentication view sends the authentication details in the request header irrespective of being asked by the server
  - We've seen on a previous post on a Spring Security authentication, a server might use a challenge-response mechanism to indicate explicitly when the consumer needs authenticate to access the resource. By default, REST Assured waits for the server to challenge before sending the credentials. This can be troublesome in some cases, for example, where the server is configured to retrieve a login form instead of the challenge response. For this reason, the library provides the preemptive directive that we can use. With this in place, REST Assured will send the credentials without waiting for an Unauthorized response
- Digest
  - In digest authentication we need to pass username and password (but it is not basic authentication)
  - Digest authentication is a type of HTTP authentication
  - Whenever we send the username and password server wants to check server will check your username and password has Hashing mechanism or not.
  - Along with username and password internally a hashcode will be sent from client to server so that at the network layer these two username and password always remain secured. Meanwhile, in basic auth client will directly send the username and password to the server without any Hashing.
- Form
  - Form based means when we have to enter the username and password from the HTML login page and send the same to the server
  - In the background one POST or PUT API will be called, and it will take those username and password from the HTML form and send to the server
- OAuth1.0
- OAuth2.0

## Methods

- given(), when(), then(), and(), but()
- Logging will be applied on only three methods: given(), when(), then()
- oauth(): In order to use OAuth 1 and OAuth 2 (for query parameter signing) you need to add Scribe to your classpath (if you're using version 2.1.0 or older of REST Assured then please refer to the legacy documentation). In Maven you can simply add the following dependency:
- oauth() method requires 4 parameters, p1 = Consumer Key, p2 = Consumer Secret, p3 = Access Token, p4 = Token Secret as a String
- oauth2() method requires only access token as a String without appending 'Bearer' to it
- To create 'JSON Objects' then to turn them into 'JSON Payloads' in java you can use any one of the following dependencies
  
  ```xml
  <!-- https://mvnrepository.com/artifact/com.googlecode.json-simple/json-simple -->
  <dependency>
    <groupId>com.googlecode.json-simple</groupId>
    <artifactId>json-simple</artifactId>
    <version>1.1.1</version>
  </dependency>
  ```

  ```xml
  <!-- https://mvnrepository.com/artifact/org.json/json -->
  <dependency>
    <groupId>org.json</groupId>
    <artifactId>json</artifactId>
    <version>20220924</version>
  </dependency>
  ```
  
## POJO

- Reason behind POJO and not using other approaches is mostly we will be driving constant data in the form of String or file object, so we won't be able to create multiple different users, employees etc. and validate the API behaviour against different test values
- POJO stands for  "Plain Old Java Object" - where we will define some variables, some methods in the form of getters and setters and using the concepts of Object-Oriented Programming in the form of Encapsulation (Hiding the data members) -> private variables can be accessed via public methods, getter and setter methods
- Here instead of passing the JSON Body To create a user, we will use a Java Class (POJO class) -> This class's object will be converted to a JSON object, which then we will pass in the request body
- POJO Serialization of the same request given below:

  ```json
  {
    "name": "Test Automation",
    "gender": "Male",
    "email":"testAutomation6@gmail.com",
    "status":"Active"
  }
  ```
  
  ```java
  package com.restassured.vo;
  
  public class createUserDO  {
  
      private String name;
      private String gender;
      private String email;
      private String status;
  
  
      public String getName() {
          return name;
      }
  
      public void setName(String name) {
          this.name = name;
      }
  
      public String getGender() {
          return gender;
      }
  
      public void setGender(String gender) {
          this.gender = gender;
      }
  
      public String getEmail() {
          return email;
      }
  
      public void setEmail(String email) {
          this.email = email;
      }
  
      public String getStatus() {
          return status;
      }
  
      public void setStatus(String status) {
          this.status = status;
      }
  }
  ```
  
  ```java
  package com.restassured.tests;

  import org.junit.Test;
  import com.restassured.vo.createUserDO;
  import io.restassured.http.ContentType;
  
  import static io.restassured.RestAssured.given;
  
  public class SamplePostRestTest {
  
      @Test
      public void createUser_whenSuccess() {
          createUserDO cu = new createUserDO();
          cu.setName("Test Automation");
          cu.setGender("Female");
          cu.setEmail("testAutomation25@gmail.com");
          cu.setStatus("Active");
  
          String resp = given()
                  .log().all()
                  .header("authorization", "Bearer 0431655cfe7ba40a791e0ce32d83ad33363348919c11627f409a3228f205e15f")
                  .accept(ContentType.JSON)
                  .contentType("application/json")
                  .body(cu)
          .when()
                  .post("https://gorest.co.in/public-api/users") //hit the post end point
          .thenReturn()
                  .asString();
  
          System.out.println(resp);
      }
  }
  ```

- Note: we need to use @JsonIgnoreProperties(ignoreUnknown=true)as  is applicable at deserialization of JSON to Java object (POJO) only
- POJO De-Serialization of the sample response given below:

  ```json
  {
      "code": 201,
      "meta": null,
      "data": {
          "id": 1493,
          "name": "Test Automation",
          "email": "testAutomation701@gmail.com",
          "gender": "Male",
          "status": "Active",
          "created_at": "2021-01-07T12:30:58.987+05:30",
          "updated_at": "2021-01-07T12:30:58.987+05:30"
      }
  }
  ```

  ```java
  package com.restassured.vo;
  
  import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
  
  @JsonIgnoreProperties(ignoreUnknown = true)
  public class ResponseDataObjects {
  
      private Integer code;
      private Object meta;
      private Data data;
  
      public Integer getCode() {
          return code;
      }
  
      public void setCode(Integer code) {
          this.code = code;
      }
  
      public Object getMeta() {
          return meta;
      }
  
      public void setMeta(Object meta) {
          this.meta = meta;
      }
  
      public Data getData() {
          return data;
      }
  
      public void setData(Data data) {
          this.data = data;
      }
  
  }
  ```
  
  ```java
  package com.restassured.vo;
  
  import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
  
  @JsonIgnoreProperties(ignoreUnknown = true)
  public class Data {
      
      private Integer id;
      private String name;
      private String email;
      private String gender;
      private String status;
      private String createdAt;
      private String updatedAt;
      
      public Integer getId() {
          return id;
      }
  
      public void setId(Integer id) {
          this.id = id;
      }
  
      public String getName() {
          return name;
      }
  
      public void setName(String name) {
          this.name = name;
      }
  
      public String getEmail() {
          return email;
      }
  
      public void setEmail(String email) {
          this.email = email;
      }
  
      public String getGender() {
          return gender;
      }
  
      public void setGender(String gender) {
          this.gender = gender;
      }
  
      public String getStatus() {
          return status;
      }
  
      public void setStatus(String status) {
          this.status = status;
      }
  
      public String getCreatedAt() {
          return createdAt;
      }
  
      public void setCreatedAt(String createdAt) {
          this.createdAt = createdAt;
      }
  
      public String getUpdatedAt() {
          return updatedAt;
      }
  
      public void setUpdatedAt(String updatedAt) {
          this.updatedAt = updatedAt;
      }
  }
  ```

  ```java
  package com.restassured.tests;
  
  import org.junit.Test;
  import org.testng.Assert;
  import com.restassured.vo.CreateUserDO;
  import com.restassured.vo.ResponseDataObjects;
  import io.restassured.http.ContentType;
  
  import static io.restassured.RestAssured.given;
  
  public class SamplePostRestTest {
  
      @Test
      public void createUser_whenSuccess() {
          
          CreateUserDO cu = new CreateUserDO();
          cu.setName("Test Automation");
          cu.setGender("Female");
          cu.setEmail("testAutomation1465@gmail.com");
          cu.setStatus("Active");
  
          ResponseDataObjects responseDataObjects = given()
                  .log().all()
                  .header("authorization", "Bearer 0431655cfe7ba40a791e0ce32d83ad33363348919c11627f409a3228f205e15f")
                  .accept(ContentType.JSON)
                  .contentType("application/json")
                  .body(cu)
          when()
                  .post("https://gorest.co.in/public-api/users") //hit the post end point
          .thenReturn()
                  .as(ResponseDataObjects.class);
  
          Assert.assertEquals("Test Automation", responseDataObjects.getData().getName());
      }
  }
  ```

## Resources

- [REST-Assured GitHub](https://github.com/rest-assured/rest-assured)
- [REST-Assured Official Documentation](https://github.com/rest-assured/rest-assured/wiki/GettingStarted)
- [REST-Assured User Guide](https://github.com/rest-assured/rest-assured/wiki/Usage)
- [POST Call with json Dependency](https://naveenautomationlabs.com/http-post-method-using-restassured/)
- [POST Call with json-simple Dependency](https://www.toolsqa.com/rest-assured/post-request-using-rest-assured/)
- [POST Call Different Approaches](http://www.eliasnogueira.com/the-best-way-to-add-a-request-body-to-a-post-request-using-rest-assured/)
- [REST-Assured Validation Tutorial](https://www.baeldung.com/rest-assured-tutorial)
- [JSON Schema Converter](https://www.liquid-technologies.com/online-json-to-schema-converter)
- [XPath Tester 1](https://extendsclass.com/xpath-tester.html)
- [XPath Tester 2](http://xpather.com/)