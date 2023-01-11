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

## Resources

- [REST-Assured GitHub](https://github.com/rest-assured/rest-assured)
- [REST-Assured Official Documentation](https://github.com/rest-assured/rest-assured/wiki/GettingStarted)
- [REST-Assured User Guide](https://github.com/rest-assured/rest-assured/wiki/Usage)
- [POST Call with json Dependency](https://naveenautomationlabs.com/http-post-method-using-restassured/)
- [POST Call with json-simple Dependency](https://www.toolsqa.com/rest-assured/post-request-using-rest-assured/)
- [POST Call Different Approaches](http://www.eliasnogueira.com/the-best-way-to-add-a-request-body-to-a-post-request-using-rest-assured/)
- [REST-Assured Validation Tutorial](https://www.baeldung.com/rest-assured-tutorial)