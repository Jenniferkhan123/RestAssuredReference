
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

import java.time.LocalDateTime;

import org.testng.Assert;

import io.restassured.path.json.JsonPath;
public class Rest_Post_Reference {

	public static void main(String[] args) {
    //Declare the base URL
	RestAssured.baseURI="https://reqres.in/";	
	//Declare the request body string variable
	String requestBody="{\r\n"
			+ "    \"name\": \"morpheus\",\r\n"
			+ "    \"job\": \"leader\"\r\n"
			+ "}";
	//Declare the expected result
	JsonPath Jsprequest = new JsonPath(requestBody);
	String req_name = Jsprequest.getString("name");
	String req_job = Jsprequest.getString("job");
	LocalDateTime currentdate = LocalDateTime.now();
	String expecteddate = currentdate.toString().substring(0,11);
	//Declare the given when and then methods
	//String responseBody=given().header("Content-Type","application/json").body(requestBody).log().all().
			//when().post("api/users").then().log().all().extract().response().asString();
	String responseBody=given().header("Content-Type","application/json").body(requestBody).
			when().post("api/users").then().extract().response().asString();
	//System.out.println(responseBody);
	//Create an object of JSONpath to parse the response body
	JsonPath Jspresponse = new JsonPath(responseBody);
	String res_name = Jspresponse.getString("name");
	String res_job = Jspresponse.getString("job");
	String res_createdAt = Jspresponse.getString("createdAt");
	res_createdAt = res_createdAt.substring(0,11);
	//Validate the response body parameter
	Assert.assertEquals(res_name, req_name);
	Assert.assertEquals(res_job, req_job);
	Assert.assertEquals(res_createdAt , expecteddate); 
	}
}
 