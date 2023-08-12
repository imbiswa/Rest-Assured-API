import org.testng.Assert;
import org.testng.annotations.Test;

import files.payload;
import io.restassured.path.json.JsonPath;
public class Sumvalidation
{
	@Test
	public void sumofcourses() 
	{
		int sum=0;
		JsonPath js =new JsonPath(payload.coursePrice());
		int count = js.getInt("courses.size()");
		for(int i=0;i<count;i++)
		{
			int price=js.getInt("courses["+i+"].price");
			int copies=js.getInt("courses["+i+"].copies");
			int amount= price * copies;
			System.out.println(amount);
			sum=sum + amount;
		}
		System.out.println(sum);
		int purchaseamount=js.getInt("dashboard.purchaseamount");
		Assert.assertEquals(sum, purchaseamount);
	}
	

}
