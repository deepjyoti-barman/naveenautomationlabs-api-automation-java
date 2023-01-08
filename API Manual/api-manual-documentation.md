# API Manual Documentation

## Basics

- API - Application Programming Interface
- API is always used to communicate between two systems
  - With in the same company - different teams, assuming one system is written in one language e.g. Java and another is using some other language e.g. React etc
  - Outside of the company - third party systems, e.g. Amazon interacting with ICICI Bank for payment gateway
- In the backend Java is used to hide the business logic
- But, when it comes to read data analytics results executing the Python code - Java can't read / render code written in Python
- Other example, A1 is can ask for data from A2 system, but A1 system can't access the business logic written in A2
- the following method also works like an API, as this guy will work like a producer, when we pass in valid data it returns back the sum of them

  ```java
  public int sum(int a, int b) {
    int z = a + b;
    return z;
  }
  ```

- Producer vs Consumer:
  - Producer: A system which is producing the data
  - Consumer: The system which is going to consume the data
- JSON Wired protocol will work like a mediator between Selenium client bindings (System1) and the web browser (System2). The best way to make two different systems communicate with each other is via JSON/XML.
- JSON/XML is not a programming language, it is a communication protocol, a way to represent the data.
- Use of API:
  - MakeMyTrip (takes inputs from user, like departure date, return date, from, to, no of passengers, business or economy class) -> passes the information to different vendor systems (Indigo, Kingfisher Airways, AirIndia, Jet Airways, SpiceJet, Vistara, Emirates) -> Shows that into their system (Web, Mobile-Web, Mobile-App - android and ios), all the information (flight timings, price, flight route, flight no) in one place so that we can compare the prices with various other options
- API vs WebService:
  - API: Is a business logic written in a system
  - WebService: API when exposed to the outside world over the internet (HTTP protocol) in the form of URL is called a web service

## CRUD Operations

- CRUD Operations:
  - C : Create the resource/data - create a user - Naveen - createUser - POST
  - R : Retrieve the resource/data - get the user - Naveeen/Any - getUser - GET
  - U : Update/Create the resource/data - update the user - Naveen/Any- updateUser - PUT
  - D : Delete the resource/data - delete the user - Naveen/Any - deleteUser - DELETE
- An API request contains:
  - HTTP Method
  - URI = URL + Service URL
  - Headers
  - Parameters - Path, Query Params
  - Request Body - JSON/XML
- An API response contains:
  - Body - JSON/XML/HTML
  - Status Code
  - Response Headers
  - Cookies (One of it's use is to change localization: en-us to es-mx)
- POST Call (To create user):
  - URI (Universal Resource Identifier) = URL (Base URL) + API Service URL/EndPoint
    - URL (Uniform Resource Locator) = Domain URL / Base URL (e.g. [http://www.xyz.com](http://www.xyz.com))
    - API Service URL = (/createUser)

  - Payload: JSON/XML/String
    - JSON:

      ```json
      {
        "username": "tomautomation",
        "password": "test123",
        "email": "tom@gmail.com",
        "phone": "88828392",
        "country": "USA"
      }
      ```

    - XML:

      ```xml
      <username>tomautomation</username>
      <password>test123</password>
      <email>tom@gmail.com</email>
      <phone>88828392</phone>
      <country>USA</country>
      ```

    - String:

        ```text
        tomautomation test123 tom@gmail.com 88828392 USA
        ```

  - Headers:
    - Headers are used to tell what kind of request it is and used to pass authentication data
    - Content-type: application/json, application/xml, application/text
    - Authentication Methods: username and password, authentication key, access token, no-auth
    - Authentication (Auth) key: will be created by the on the basis of your username and password by the producer (Amazon/Google/Owner who creates the service) (used in OAuth2.0)
    - Access Token: Will be created by the client (e.g. d03lsdfhj#298sS$*#sf) (used in OAuth1.0)
- GET Call (To retrieve user):
  - URI
    - [http://www.xyz.com/getUser/tomautomation](http://www.xyz.com/getUser/tomautomation) (with path params)
    - [http://www.xyz.com/getUser?firstname=naveen](http://www.xyz.com/getUser?firstname=naveen) (with query params)
    - [http://www.xyz.com/getUser?firstname=naveen&country=india](http://www.xyz.com/getUser?firstname=naveen&country=india) (with query params)
    - [http://www.xyz.com/getUsers](http://www.xyz.com/getUsers) (all the users)
  - There is no payload
  - Headers: username and password, auth key, access token, no-auth
- PUT Call:
  - URI
    - [http://www.xyz.com/users/tomautomation](http://www.xyz.com/users/tomautomation)
  - Payload:

      ```json
      {
        "username": "tomautomation",
        "password": "test123",
        "email": "tom@gmail.com",
        "phone": "99203902",
        "country": "UK"
      }
      ```

- Headers: username and password, auth key, access token and no-auth
- NOTE: PUT internally works like a POST call, so if in the JSON payload we are passing data which is not present in the database instead of throwing and error message it will actually create the resource, but it actually depends on the developers if they have restricted record duplication then we may not be able to do that
- NOTE: PUT can be used to create as well as update the records
- DELETE Call:
  - URI: [http://www.xyz.com/users/testautomation](http://www.xyz.com/users/testautomation)
  - Payload: Yes / No
  - Headers: username and password, auth key, access token, no-auth
  - NOTE: DELETE APIs are mostly not created, because it may erase client data from our database because of any mistake performed through the API

## API Advanced

- Two-tier approach (Client-Database): Fire the method calls (SQL queries) from client directly and perform CRUD operation on the database.
  - This way we are exposing important data to the client which can be dangerous and more threat prone to hackers
  - Performance is another issue, millions of users accessing the database without any well defined rules (authentication) can corrupt the data
- Three-tier approach (Client-API Interface/Service Layer-Database): Fire the API call from Client, that API call will perform CRUD operation on the database
  - More secure
  - More performance, we can also limit API calls getting triggered from a specific client
- Different type of Authentications:
  - Basic Auth
    - Requires Username and Password
    - Platform to practice: [http://the-internet.herokuapp.com/basic_auth](http://the-internet.herokuapp.com/basic_auth)
    - The basic authentication pop-up is similar to the alert that pop-ups when the browser is navigated to a specific web page. To handle the basic authentication popup, we can pass the username and password along with the web page’s URL

      ```java
      // https://username:password@URL
      String URL = "https://" +username +":" +password +"@"+ "the-internet.herokuapp.com/basic_auth";
      driver.get(URL);
      ```

    - Handling of basic authentication pop-up in selenium 4

      ```java
      public class Auth {

        public static void main(String[] args) {
          System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shalini\\Downloads\\chromedriver\\chromedriver.exe");
          ChromeDriver driver = new ChromeDriver();

          DevTools dev = driver.getDevTools();
          dev.createSession();
          dev.send(Network.enable(Optional.<Integer>empty(), Optional.<Integer>empty(), Optional.<Integer>empty()));
          Map<String, Object> map = new HashMap<>();
          map.put("Authorization", "Basic " + new String(new Base64().encode("admin:admin".getBytes())));
          dev.send(Network.setExtraHTTPHeaders(new Headers(map)));
          driver.navigate().to("https://the-internet.herokuapp.com/basic_auth");
          Uninterruptibles.sleepUninterruptibly(10, TimeUnit.SECONDS);

          driver.close();
        }
      }
      ```

    - `Postman -> API Tab -> Authorization -> Type: Basic Auth -> Enter 'Username' and 'Password'`

  - OAuth1.0
    - Requires the following
      - Consumer Key / API key
      - Consumer Secret / APi Secret key
      - Access token
      - Token secret / Access token secret
    - Example: Twitter APIs
    - While logging into apps, it asks the user to Sign Up, or Login with Gmail, Login with GitHub or via other social media websites
    - Way to practice: Visit [https://developer.twitter.com/docs](https://developer.twitter.com/docs) -> Sign up and login with your account -> Click on the drop-down arrow next to Username -> Apps -> Create an App -> Give app name -> Give proper info about how the app is going to be used (Tell them that you are a student and you will be using this to for practice purposes) -> Create -> Permissions -> Under 'Access token and access token secret' click on Create
    - cURL Command of the twitter API to post a tweet: [https://developer.twitter.com/en/docs/twitter-api/v1/tweets/post-and-engage/api-reference/post-statuses-update](https://developer.twitter.com/en/docs/twitter-api/v1/tweets/post-and-engage/api-reference/post-statuses-update)
    - `Postman -> API Tab -> Authorization -> Type: OAuth 1.0 -> Provide values for Consumer Key, Consumer Secret, Access Token, Token Secret -> Add authorization data to: Request Headers`

  - OAuth2.0
    - For this type of authentication we require a Token ID/Auth Token/Access Token/Bearer Token
    - To generate the Auth Token we need:
      - Client ID
      - Client Secret
      - Grant Type
      - Access Token URL
      - Scope (Optional)
    - Example: Coop APIs [https://coop.apps.symfonycasts.com/register](https://coop.apps.symfonycasts.com/register)
    - Way to Practice: Visit Coop's website -> Register -> Login -> API -> Your Applications -> Create Another App -> Provide information and click on Submit
    - `Postman -> API Tab -> Authorization -> Type: OAuth 2.0 -> Get New Access Token -> Give Token and Provide, Grant Type: Client Credentials, Access Token URL, Client ID and Client Secret -> Request Token [Last step is to only generate the token]`
    - If you already have the Auth Token then,
      - We can directly add `Authorization: Bearer <token>` as key-value pair in the headers of the request and that is enough to make the service work
      - `Postman API -> Authorization -> Type: Bearer Token -> Token: <token>` (without the word Bearer)
  - Questions
    - OAuth1.0 vs OAuth2.0
      - Resource: [https://www.synopsys.com/blogs/software-security/oauth-2-0-vs-oauth-1-0/](https://www.synopsys.com/blogs/software-security/oauth-2-0-vs-oauth-1-0/)
      - Resource: [https://stackoverflow.com/questions/4113934/how-is-oauth-2-different-from-oauth-1](https://stackoverflow.com/questions/4113934/how-is-oauth-2-different-from-oauth-1)
      - Example: [https://medium.com/identity-beyond-borders/oauth-1-0-vs-oauth-2-0-e36f8924a835](https://medium.com/identity-beyond-borders/oauth-1-0-vs-oauth-2-0-e36f8924a835)

    - Authentication vs Authorization
      - Resource: [https://www.geeksforgeeks.org/difference-between-authentication-and-authorization/](https://www.geeksforgeeks.org/difference-between-authentication-and-authorization/)
      - Resource: [https://www.javatpoint.com/authentication-vs-authorization](https://www.javatpoint.com/authentication-vs-authorization)
      - [https://byjus.com/gate/difference-between-authentication-and-authorization/](https://byjus.com/gate/difference-between-authentication-and-authorization/)

### Status Codes

- 1xx: Informational – Communicates transfer protocol-level information.
- 2xx: Success – Indicates that the client’s request was accepted successfully.
- 3xx: Redirection – Indicates that the client must take some additional action in order to complete their request.
- 4xx: Client Error – This category of error status codes points the finger at clients.
- 5xx: Server Error – The server takes responsibility for these error status codes.
- Create API is giving 200 instead of 201, it's a bug or not?
  - It is a bug but enhancement, within the company its ok but if you are exposing API to other companies or vendors then it needs to fixed
- Difference between status code 401 and 403?
  - 401 stands for Unauthorized, that means user does not have permission to access the resource.
  - 403 stands for Forbidden, which means user is authorized but does not have access right for that particular resource (e.g. he may have read rights but does not have modification rights for a particular resource)
- Difference between 200 vs 202?
  - 200 OK means that the request has succeeded and the processing of our request is done. The response is the final payload and the service will not take further actions.
  - 202 Accepted on the other hand means that the request have been accepted for processing, and the service will now start. This does not mean that the processing itself is a success, nor that the process have ended.
- Difference between PUT and PATCH
  - PUT -> Full Update
  - PATCH -> Partial Update
  - PUT -> Update/Create
  -> PATCH -> Only Update
  - In a PUT call you need to re-send all the information required to update the record. It will re-insert all the 4 values into DB once again (old values will be overridden) e.g.

  ```json  
    {
      "username": "deepjyoti",
      "password": "deep@123",
      "dob": "04/12/1992",
      "phone": "8723824273"
    }
  ```

  - In a PATCH call you need to re-send only the information that you want to update. It will only update that particular field value e.g.

  ```json
  {
    "phoneno": "9436175496"
  }
  ```

- Example of query params (?)
  - [http://www.xyz.com/users?name=naveen](http://www.xyz.com/users?name=naveen)
  - [http://www.xyz.com/users?name=naveen&city=bangalore](http://www.xyz.com/users?name=naveen&city=bangalore)

- Example of path params (/)
  - [http://www.linkedin.com/users/profiles/images](http://www.linkedin.com/users/profiles/images)

#### Commonly Used API Codes

- 100 Continue: An interim response. Indicates to the client that the initial part of the request has been received and has not yet been rejected by the server. The client SHOULD continue by sending the remainder of the request or, if the request has already been completed, ignore this response. The server MUST send a final response after the request has been completed.
- 102 Processing (WebDAV): Indicates that the server has received and is processing the request, but no response is available yet.
- 200 OK: API call reached on the producer server and successfully executed over there, but it does not give you a guarantee we are getting proper response or not
- 201 Created: Indicates that the request has succeeded and a new resource has been created as a result.
- 202 Accepted: Indicates that the request has been received but not completed yet. It is typically used in log running requests and batch processing.
- 203 Non-Authoritative Information: Indicates that the returned meta-information in the entity-header is not the definitive set as available from the origin server, but is gathered from a local or a third-party copy. The set presented MAY be a subset or superset of the original version.
- 204 No Content: The server has fulfilled the request but does not need to return a response body. The server may return the updated meta information.
- 205 Reset Content: Indicates the client to reset the document which sent this request.
- 206 Partial Content: It is used when the Range header is sent from the client to request only part of a resource.
- 300 Multiple Choices: The request has more than one possible response. The user-agent or user should choose one of them.
- 301 Moved Permanently: The URL of the requested resource has been changed permanently. The new URL is given by the Location header field in the response. This response is cache-able unless indicated otherwise.
- 307 Temporary Redirect: Indicates the client to get the requested resource at another URI with same method that was used in the prior request. It is similar to 302 Found with one exception that the same HTTP method will be used that was used in the prior request.
- 308 Permanent Redirect (experimental): Indicates that the resource is now permanently located at another URI, specified by the Location header. It is similar to 301 Moved Permanently with one exception that the same HTTP method will be used that was used in the prior request.
- 400 Bad Request: The request could not be understood by the server due to incorrect syntax. The client SHOULD NOT repeat the request without modifications.
- 401 Unauthorized: Indicates that the request requires user authentication information. The client MAY repeat the request with a suitable Authorization header field
- 402 Payment Required (Experimental): Reserved for future use. It is aimed for using in the digital payment systems.
- 403 Forbidden: Unauthorized request. The client does not have access rights to the content. Unlike 401, the client’s identity is known to the server.
- 404 Not Found: The server can not find the requested resource.
- 405 Method Not Allowed: The request HTTP method is known by the server but has been disabled and cannot be used for that resource (e.g. Method not allowed, if Web service supports GET but we are sending POST as a request).
- 406 Not Acceptable: The server doesn’t find any content that conforms to the criteria given by the user agent in the Accept header sent in the request.
- 408 Request Timeout: Indicates that the server did not receive a complete request from the client within the server’s allotted timeout period.
- 409 Conflict: The request could not be completed due to a conflict with the current state of the resource.
- 415 Unsupported Media Type: The media-type in Content-type of the request is not supported by the server.
- 500 Internal Server Error: The server encountered an unexpected condition that prevented it from fulfilling the request.
- 501 Not Implemented: The HTTP method is not supported by the server and cannot be handled. (e.g. Service request is under development, may get completed in future)
- 502 Bad Gateway: The server got an invalid response while working as a gateway to get the response needed to handle the request.
- 503 Service Unavailable: The server is not ready to handle the request.
- 504 Gateway Timeout: The server is acting as a gateway and cannot get a response in time for a request.
- 510 Not Extended: Further extensions to the request are required for the server to fulfill it.
- 511 Network Authentication Required: Indicates that the client needs to authenticate to gain network access.
- References: [API Status Codes](https://restfulapi.net/http-status-codes/)

### cURL: Client URL

- Used when you don't have to use a tool like Postman
- cURL commands are used to execute the APIs from the command line
- Additional Options that can be passed to a cURL command:
  - `-O <url>` = Download the particular file
  - `-O <url1> -O <url2>` = Download multiple files
  - `-X, --request <command>` = Specify request command to us
  - `-i, --include` = Include protocol response headers in the output
  - `-d, --data <data>` = HTTP POST data
  - `-H, --header <header/@file>` = Pass custom header(s) to server
  - `-s, --silent` = Silent mode, mute the cURL processing
  - `-S, --show-error` = Show error even when -s is used
  - `-L, --location` = Follow redirects
  - `-v, --verbose` = Make the operation more talkative
- USAGE: Without browser we can get the source code of a webpage using curl command (i.e. `curl <website-url>`)
- USAGE: Save the source code of a website directly on a file (e.g. `curl https://www.google.com > google-homepage.html`)
- USAGE: Show entire info of a website
  - `curl --trace info https://www.facebook.com`
- Usage: Get the meaning of the word 'mute' from gcide dictionary
  - `curl dict://dict.org/d:mute:gcide`
- Get the meaning of the word 'mute' from all dictionaries
  - `curl dict://dict.org/d:mute:*`

### Practice APIs

1. [ReqRes](https://reqres.in)
2. [Go Rest](https://gorest.co.in)
3. [Restful Booker](https://restful-booker.herokuapp.com/apidoc/)

## Postman

- Postman can be used to maintain local and global environment and environment variables
- How to handle multiple environments in Postman?
- What are the different environments / What are the different environment properties we can use? (Global / Local)
- How to define environment variables in request?
  - Using double curly braces `{{}}`
- We can set the Authorization at the Collection level clicking on `'...' -> Edit -> Authorization` and then on every request's `Authorization` tab we can select `type: Inherit auth from parent`
- `Postman -> API Tab -> Tests`: We can write any script to validate anything (headers, cookies, auth) in the request or in the response, after execution of the API
- `Postman -> API Tab -> Pre-request Script`: We can write any script which will run before executing the API
  - e.g. Generate a random number append that with at end to generate a random email and set it as an environment variable every time, before you hit the request

    ```js
    let random = Math.random().toString(36).substring(2);
    let emailAddress = "tom" + random + "@gmail.com";

    pm.environment.set("emailAddress", emailAddress);
    ```

  - e.g. Run one service, get the one username/email from that service and then pass the data to another the current service
- `Postman -> Workspaces`: We can create Personal, or Team workspace. While a Personal workspace is meant for yourself, Team workspace is where you and your teammates can collaborate together
- `Postman Collection -> Click on 'Play' icon -> View on Web`: To see the documentations (details and descriptions given in the API or Collection level) of all the APIs present in the collection
- `Postman Collection -> Click on '...' -> Publish Docs`: To publish the API documentation with client or other teammates
- We can set environment variables by right clicking on the values present in the response -> Select the environment -> Select the variable to set
- We can run tests in Postman at every API level using inbuilt JS snippets
- Postman Collection Runner will execute all the API tests written for the respective APIs
- `Postman Collection -> ... -> Create a fork`: To create a new branch of the collection, which then later can be merged into the actual collection
- `Postman Collection -> ... -> Share Collection -> Get link (tab) -> Get Link (button)`: To get a unique URL which can be shared among other teammates
- `Postman Collection -> ... -> Monitor Collection`: To monitor the API behavior and responses periodically (every 5, 10, 15, 30 mins, hourly, weekly)
- `Postman Collection -> ... -> Export`: To export the entire collection as a JSON
- `Postman -> Monitors`: Monitor lets you run a collection periodically to check for its performance and response.
- `Postman -> Mock Server`: Mock servers let you simulate endpoints and their corresponding responses in a collection without actually setting up a back end.
- What is API mocking and why it's important to mock data at times?
  - To test something on our system we require response from a third-party service but the other party is not allowing us to connect to their server yet because the service is under development / they don't have any QA server (and production server access they won't be able to provide), in such cases to test the scenarios at our end we need some fake data which will exactly behave like the data we are going to get from the other third-party service. We can generate those fake data using Mock servers.
- Name a few Java mock servers
  - Mockito, Wiremock
- Create Postman Collection from API-Specification (.yaml) file:
  - YAML file will give you complete schema of the API design (what kind of body you need to pass, what kind of response we will be getting, what are the status codes defined)
  - [https://github.com/OAI/OpenAPI-Specification/blob/main/examples/v3.0/petstore.yaml](https://github.com/OAI/OpenAPI-Specification/blob/main/examples/v3.0/petstore.yaml)
  - `Postman -> Import -> Paste Raw Text -> Copy the content of .yaml file -> Import -> tick 'Import as an API' and 'Generate a Postman Collection' -> Click on 'Generate Collection' button` -> Give a name of the collection

### Newman

- CLI (Command Line Interface) runner for POSTMAN
- It is a simple command line collection runner
- Allow you to run your test cases along with the APIs whatever is present in the collection directly from the command line
- This can be integrated with Jenkins and Docker
- Requirements:
  - Node.js
  - Download newman tool via npm command, `npm install -g newman`
  - Verify the download using the command, `newman -v` / `newman --version`
- Important Newman commands:
  - To run a collection: `newman run <collection-name>.json`
  - To run a collection against an environment: `newman run <collection-name>.json -e <environment-name>.json`
  - To run a collection url against an environment: `newman run <collection-url> -e <environment-name>.json`
  - Show help menu: `newman run -h`
  - To run a specific folder in a collection url against an environment: `newman run <collection-url> -e <environment-name>.json --folder <folder-name>`
  - To run a collection 3 times (no_of_iterations=3) against an environment: `newman run <collection-name>.json -e <environment-name>.json -n 3`
  - To run a collection driving data from an .csv or .json file: `newman run <collection-name>.json -d <data-filename>.csv`
    - .csv content (first line is used for the variable names):

      ```csv
      url,firstname
      http://www.gorest.co.in,Naveen
      http://www.gorest.com,Praveen
      ```

    - .json content:

      ```json
      [
        {
          "url": "https://gorest.co.in/",
          "firstname": "Naveen"
        },
        {
          "url": "https://gorest.com/",
          "firstname": "Praveen"
        }
      ]
      ```

  - To generate HTML report download the package 'newman-reporter-html' via the command:
`npm install -g newman-reporter-html`

  - To run a collection driving data from an .csv or .json file and generate report in the form of HTML: `newman run <collection-name>.json -d <data-filename>.csv -r html`

- Other important newman options:
  - `--verbose`: Show detailed information of collection run and each request sent.
  - `--global-var "[global-variable-name]=[global-variable-value]"`: Specifies global variables on the command line, in a key=value format. Multiple global variables can be added by using --global-var multiple times, for example, --global-var "this=that" --global-var "alpha=beta".
  - `--env-var "[environment-variable-name]=[environment-variable-value]"`: Allows you to set environment variables in a key=value format on the command line. You can add multiple environment variables using --env-var multiple times, for example: --env-var "key1=value1" --env-var "key2=value2".
  - `--ignore-redirects`: Turn off automatic following of 3XX responses.
  - `-k, --insecure`: Turn off strict SSL.
  - `--silent`: Turn off terminal output.
  - `--delay-request [number]`: Specify a delay (in milliseconds) between requests [number].
  - `--timeout [number]`: Specify the time (in milliseconds) to wait for the entire collection run to complete execution.
  - `--timeout-request [number]`: Specify a request timeout (in milliseconds) for a request.
  - `--timeout-script [number]`: Specify the time (in milliseconds) to wait for scripts to complete execution.
  - `--folder [folderName]`: Specify a single folder to run from a collection.
  - `-e, --environment [file|URL]`: Specify a Postman environment as a JSON [file].
  - `-d, --iteration-data [file]`: Specify a data file to use, either JSON or CSV.
  - `-g, --globals [file]`: Specify a Postman globals file as JSON [file].
  - `-n, --iteration-count [number]`: Define the number of iterations to run.

### Running Newman in Docker

- Docker is a container which you can install on your system and use the docker engine
- We can install softwares on top of the Docker Engineer which will run in multiple different containers on the same system.
- Each and every container can hold the image of a specific application.
- Each and every container is totally isolated from the other container and each one of them uses their individual required resources from the operating system.
- Docker engine can be installed in Windows/Mac/Linux
- Docker will take care of your environment variables, configurations etc. no need to take extra burden
- Command to check if docker desktop installation is done successfully: `docker run hello-world`
- Command to pull newman docker-image: `docker pull postman/newman`
- Command to run a collection using newman tool running the docker container:
`docker run -t postman/newman run "<collectionURL>"`
- Resource: [https://learning.postman.com/docs/running-collections/using-newman-cli/newman-with-docker/](https://learning.postman.com/docs/running-collections/using-newman-cli/newman-with-docker/)
- Resource: [https://learning.postman.com/docs/running-collections/using-newman-cli/continuous-integration/](https://learning.postman.com/docs/running-collections/using-newman-cli/continuous-integration/)
- Resource: [https://learning.postman.com/docs/running-collections/using-newman-cli/integration-with-jenkins/](https://learning.postman.com/docs/running-collections/using-newman-cli/integration-with-jenkins/)
- Resource: [https://learning.postman.com/docs/running-collections/using-newman-cli/newman-options/](https://learning.postman.com/docs/running-collections/using-newman-cli/newman-options/)
- Install Jenkins via Docker and run newman from Jenkins:
  - `docker pull jenkins/jenkins`
  - Newman with Docker: [https://learning.postman.com/docs/running-collections/using-newman-cli/integration-with-jenkins/](https://learning.postman.com/docs/running-collections/using-newman-cli/integration-with-jenkins/)
  - Run newman from Jenkins running on Dockerized container: [https://hub.docker.com/_/jenkins](https://hub.docker.com/_/jenkins)

## References

- ![Chapter1](./resources/Chapter1.png)
- ![Chapter2](./resources/Chapter2.png)
- ![Chapter3](./resources/Chapter3.png)
- ![Chapter4](./resources/Chapter4.png)
- ![Chapter5](./resources/Chapter5.png)
- ![Chapter6](./resources/Chapter6.png)