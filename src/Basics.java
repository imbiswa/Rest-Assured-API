import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import files.payload;
public class Basics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//validating if add place api is working or not

		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response= given().log().all().queryParam("key", "qaclick123").header("content-Type","application/json")
		.body(payload.AddPlace()).when().post("maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).body("scope",equalTo("APP"))
		.header("Server","Apache/2.4.52 (Ubuntu)").extract().response().asString();
		
		
		System.out.println(response);
		JsonPath js =new JsonPath(response);
		String placeid = js.getString("place_id");
		System.out.println(placeid);
		
		//update place Api
		String newAddress = "Summer walk,SA-12";
		
		given().log().all().queryParam("key", "qaclick123").header("content-Type","application/json")
		.body("{ \r\n"
				+ "    \"place_id\": \""+placeid+"\",\r\n"
				+ "    \"address\": \""+newAddress+"\",\r\n"
				+ "    \"kay\": \"qaclick123\"\r\n"
				+ "}")
		.when().put("maps/api/place/update/json")
		.then().assertThat().log().all().statusCode(200);	
		
		
		//get place Api
		String getPlaceResponce=given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeid)
		.when().get("maps/api/place/get/json")
		.then().assertThat().log().all().statusCode(200).extract().response().asString();
		
		JsonPath js1=new JsonPath(getPlaceResponce);
		String actualAddress=js1.getString("address");
		System.out.println(actualAddress);
		Assert.assertEquals(actualAddress, newAddress);
		
		}

}
