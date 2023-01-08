# API Automation using REST-Assured

## Introduction

- REST-Assured: It is a Java DSL library which will provide you some methods, interfaces or classes though which we hit the APIs, get the response and validate the response against the request sent. So, Rest-Assured is a library through which can automate the APIs
- Difference between REST API vs REST-Assured
    - REST APIs are those APIs which are built upon REST Architecture
    - REST is not a protocol it is an Architecture
    - REST-Assured (70% market capture) is a Java library through which can automate the APIs.
- Rest Assured vs HTTP Client
    - REST-Assured (70% market capture) is a Java library through which can automate the APIs
    - HTTP Client (30% market capture), OkHTTP, Jersy Client are other libraries to automate the APIs
    - Real good companies are using HTTP Client as its quite fast
    - REST-Assured is built on top of HTTP Client, so internally it will be calling HTTP client
    - REST-Assured is more user-friendly, as it provides to version to automate the APIs BDD version and Non-BDD version
    - HTTP Client supports only Non-BDD version to automate the APIs
- What is the necessity to automate the APIs when you have UI automation as well?
  - Results in API automation comes way faster than UI automation 
  - API automation test-cases have a lower chance to fail because of unnecessary flakiness
  - Before going for UI automation we should automate the APIs as it will be a smoke test for all the modules

## Methods

- given(), when(), then(), and(), but()
- Logging will be applied on only three methods: given(), when(), then()