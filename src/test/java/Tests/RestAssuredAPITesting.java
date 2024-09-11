package Tests;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class RestAssuredAPITesting {


   @Test
    public void GetBooksDetails() {
        // Specify the base URL to the RESTful web service
        RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
        // Get the RequestSpecification of the request to be sent to the server.
        RequestSpecification httpRequest = given();
        // specify the method type (GET) and the parameters if any.
        //In this case the request does not take any parameters
        Response response = httpRequest.request(Method.GET, "");
        // Print the status and message body of the response received from the server
        System.out.println("Status received => " + response.getStatusLine());
        System.out.println("Response=>" + response.prettyPrint());
    }
    @Test
    public  void getResponseBody(){

        given().queryParam("CUSTOMER_ID","68195")
                .queryParam("PASSWORD","1234!")
                .queryParam("Account_No","1")
                .when().get("http://demo.guru99.com/V4/sinkministatement.php").then().log()
                .body();
    }
    @Test
    public  void getResponseStatus(){
       int statusCode = given().queryParam("CUSTOMER_ID","68195")
               .queryParam("PASSWORD","1234")
               .queryParam("Account_No","1")
               .when()
               .get("http://demo.guru99.com/V4/sinkministatement.php").getStatusCode();
        System.out.println("statusCode == "+ statusCode);

    }
    @Test
    public void createNewEmployee(){
        try {
            RestAssured.baseURI = "https://reqres.in/";
            String strURITokenForPost = "api/users";
            RequestSpecification request = RestAssured.given().queryParam("name","Kelly")
            .queryParam("jop","IT")
            .header("Content-Type", "application/json");
            Response response = request.post(strURITokenForPost); // here we are hitting the uri
            System.out.println("\n Status Code: " + response.getStatusCode()); // Response status code is printed here
            System.out.println("---> Response JSON Body: " + response.getBody().asString());
        } catch (Exception ex) {
            System.out.println("WARNING: " + ex.getMessage() + " In API Util class file.");
        }
    }
}
