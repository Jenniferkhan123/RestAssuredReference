import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;
public class Post1 {

	public static void main(String[] args) {
		//Declare the BaseURI
		RestAssured.baseURI = "https://reqres.in/";
		
		//Declare the Requestbody
		 String RequestBody = "{\r\n"
		 		+ "    \"name\": \"morpheus\",\r\n"
		 		+ "    \"job\": \"leader\"\r\n"
		 		+ "}";
		 
		 //Extract the requestBody
		 
		 
		 
		 
		 
		 
		 //Using the given, when, then Methods
		 
		 String ResponseBody = given().header("Content Type","application/json").body(RequestBody).
				 when().post("api/users").then().extract().response().asString();
		 
		 //Parse the ResponseBody
		 
		 JsonPath JspRes = new JsonPath(ResponseBody);
		 String Res_name = JspRes.getString("name");
		 String Res_job = JspRes.getString("job");

	}

}
