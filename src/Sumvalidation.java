import org.testng.annotations.Test;

import files.payload;
import io.restassured.path.json.JsonPath;

public class Sumvalidation
{
	@Test
	public void sumValidation() 
	{
		JsonPath js =new JsonPath(payload.coursePrice());
		int count = js.getInt("cources.size()");
		for(int i=0;i<=count;i++)
		{
			int price=js.getInt("courses["+i+"].price");
			int copies=js.getInt("courses["+i+"].copies");
			int amount=js.getInt("courses["+i+"].amount");
		}
	}
	

}
