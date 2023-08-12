import files.payload;
import io.restassured.path.json.JsonPath;
public class ComplexJsonParse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		JsonPath js =new JsonPath(payload.coursePrice());
		
		int count= js.getInt("courses.size()");
		System.out.println(count);
		
		int totalAmount=js.getInt("dashboard.purchaseamount");
		System.out.println(totalAmount);
		
		String titleFirsatCources=js.get("courses[2].title");
		System.out.println(titleFirsatCources);
		
		for(int i=0;i<=count;i++)
			
		{
		//String s=js.get("courses[i].title");
			String coursetitle=js.get("courses["+i+"].title");
			String coursePrice=js.get("courses["+i+"].price");
			System.out.println(coursetitle+"-"+coursePrice);
		} 
		
		
	}

}
