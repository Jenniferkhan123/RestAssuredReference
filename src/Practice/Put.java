package Practice;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

import java.time.LocalDateTime;

import org.testng.Assert;

import io.restassured.path.json.JsonPath;

public class Put {

	public static void main(String[] args) {
		//Declare the Base URL
		RestAssured.baseURI = "https://reqres.in/";
		
		//Declare the RequestBody String Variable
		String ResquestBody = "{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"zion resident\"\r\n"
				+ "}";
		 //Declare the expected result
		JsonPath JspRq = new JsonPath(ResquestBody);
		String Req_name = JspRq.getString("name");
		String Req_job = JspRq.getString("job");
		LocalDateTime currentdate = LocalDateTime.now();
		String expecteddate = currentdate.toString().substring(0,10);
		
		//Declare the given, when, then Method
		String ResponseBody = given().header("Content-Type","application/json").body(ResquestBody).
				when().put("api/users/2").then().extract().response().asString();
		//System.out.println(ResponseBody);
		
		//Create a JsonPath's object for parse the ResponseBody
		JsonPath JspRs = new JsonPath(ResponseBody);
		String Res_name = JspRs.getString("name");
		System.out.println(Res_name);
		
		String Res_job = JspRs.getString("job");
		System.out.println(Res_job);
		
		String Res_updatedAt = JspRs.getString("updatedAt");
		Res_updatedAt = Res_updatedAt.substring(0,10);
		System.out.println(Res_updatedAt);
		
		//Validate the ResponseBody
		Assert.assertEquals(Res_name, Req_name);
		Assert.assertEquals(Res_job, Req_job);
		Assert.assertEquals(Res_updatedAt, expecteddate);
	}
}
