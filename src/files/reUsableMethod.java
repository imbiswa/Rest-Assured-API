package files;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;




public class reUsableMethod{

		
		
		public static JsonPath rawToJson(String resp)
		{
			 
			JsonPath jp = new JsonPath(resp);
			return jp;
			 
			 
			}

	}


