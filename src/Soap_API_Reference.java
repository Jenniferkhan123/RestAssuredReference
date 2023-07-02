import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

import org.testng.Assert;

import io.restassured.path.xml.*;

public class Soap_API_Reference {

	public static void main(String[] args) {
    //Declare the base URL
	RestAssured.baseURI="https://www.dataaccess.com";
	//Declare RequestBody
	String RequestBody="<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n"
			+ "<soap12:Envelope xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\r\n"
			+ "  <soap12:Body>\r\n"
			+ "    <NumberToWords xmlns=\"http://www.dataaccess.com/webservicesserver/\">\r\n"
			+ "      <ubiNum>100</ubiNum>\r\n"
			+ "    </NumberToWords>\r\n"
			+ "  </soap12:Body>\r\n"
			+ "</soap12:Envelope>";
	
     //Extract ResponseBody
	 String ResponseBody=given().header("Content-Type","text/xml; charset=utf-8").body(RequestBody).
			 when().post("webservicesserver/NumberConversion.wso").then().extract().response().asString();
	 System.out.println(ResponseBody);
	 //Parse the ResponseBody
	 XmlPath XmlResponse = new XmlPath(ResponseBody);
	 String ResponseParameter = XmlResponse.getString("NumberToWordsResult");
     System.out.println(ResponseParameter);
     //Validate the ResponseBody
     Assert.assertEquals(ResponseParameter, "one hundred ");
     }

}
