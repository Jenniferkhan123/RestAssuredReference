package Practice;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

import java.time.LocalDateTime;

import io.restassured.path.json.JsonPath;


public class Post {

	public static void main(String[] args) {
	//Declare the base URL
	RestAssured.baseURI  ="https://reqres.in/";
	
	//Declare the RequestBody string variable
	String RequestBody = "{\r\n"
			+ "    \"name\": \"morpheus\",\r\n"
			+ "    \"job\": \"leader\"\r\n"
			+ "}";
	//Expected RequestBody results
	JsonPath JspRequest = new JsonPath(RequestBody);
	String Req_name = JspRequest.getString("name");
	String Req_job = JspRequest.getString("job");
	LocalDateTime currentdate =  LocalDateTime.now();
String expecteddate = currentdate.toString().substring(0,11);

	// Using given, when and then method
	//String ResponseBody = given()header.("Content-Type","application/json").body(RequestBody).log().all().when().post("api/users").then().log().all().extract().response().asString();
	String ResponseBody = given().header("Content-Type","application/json").body(RequestBody)
			.when().post("api/users").then().extract().response().asString();
	//System.out.println(ResponseBody);
	
	//Create the JsonPath Parse the ResponseBody
	JsonPath JspResponse = new JsonPath(ResponseBody);
	String Res_name = JspResponse.getString("name");
	String Res_job = JspResponse.getString("job");
	String Res_createdAt = JspResponse.getString("currentdate");
	
	

	}

}
