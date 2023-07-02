import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import java.time.LocalDateTime;
import org.testng.Assert;
import io.restassured.path.json.JsonPath;
public class Rest_Get_Reference {

	public static void main(String[] args) {
	RestAssured.baseURI="https://reqres.in/";
		
	//Declare responsebody
		
	String responsebody = given().header("Content-Type","application/json").
			when().get("api/users/2").then().extract().response().asString();
	System.out.println(responsebody);
	}

}
