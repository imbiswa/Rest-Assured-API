package files;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.path.json.JsonPath;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import files.payload;
import io.restassured.response.Response;



public class DynamicJson {

	
	
		@Test
		
		public void addBook()
		{
			RestAssured.baseURI="http://216.10.245.166";
			
			 String resp=given().header("Content-Type","application/json")
			.body(payload.Addbook()).
			when()
			.post("/Library/Addbook.php")
			.then().log().all().assertThat().statusCode(200)
			.extract().response().asString();
			
			//JsonPath js=reUsableMethod.rawToJson(resp);
			//String id=js.get("ID");
			//System.out.println(id);
			JsonPath js=reUsableMethod.rawToJson(resp);
			String id=js.get("ID");
			System.out.println(id);
			
		}
	}

