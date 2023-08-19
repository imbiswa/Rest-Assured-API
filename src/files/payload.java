package files;

public class payload {

	public static String AddPlace()
	{
		return "{\n" + 
				"  \"location\": {\n" + 
				"    \"lat\": -38.383494,\n" + 
				"    \"lng\": 33.427362\n" + 
				"  },\n" + 
				"  \"accuracy\": 50,\n" + 
				"  \"name\": \"Frontline house\",\n" + 
				"  \"phone_number\": \"(+91) 983 893 3937\",\n" + 
				"  \"address\": \"29, side layout, cohen 09\",\n" + 
				"  \"types\": [\n" + 
				"    \"shoe park\",\n" + 
				"    \"shop\"\n" + 
				"  ],\n" + 
				"  \"website\": \"http://google.com\",\n" + 
				"  \"language\": \"French-IN\"\n" + 
				"}\n" + 
				"";
	}
	public static String coursePrice()
	{
		return "{\r\n"
				+ "	\"dashboard\": {\r\n"
				+ "		\"purchaseamount\": 910,\r\n"
				+ "		\"website\": \"rahulshettyacademy.com\"\r\n"
				+ "	},\r\n"
				+ "	\"courses\": [{\r\n"
				+ "		\"title\": \"selenium python\",\r\n"
				+ "		\"price\": \"50\",\r\n"
				+ "		\"copies\": \"6\"\r\n"
				+ "	}, {\r\n"
				+ "		\"title\": \"cypress\",\r\n"
				+ "		\"price\": \"40\",\r\n"
				+ "		\"copies\": \"4\"\r\n"
				+ "	}, {\r\n"
				+ "		\"title\": \"RPA\",\r\n"
				+ "		\"price\": \"45\",\r\n"
				+ "		\"copies\": \"10\"\r\n"
				+ "	}]\r\n"
				+ "}";
	}
	public static String Addbook()
	{
		
		return "{ \r\n"
				+ "\r\n"
				+ "\"name\":\"Learn Appium Automation with java\",\r\n"
				+ "\"isbn\":\"bczd\",\r\n"
				+ "\"aisle\":\"22570\",\r\n"
				+ "\"author\":\"john foe\"\r\n"
				+ "}";
	}
}
