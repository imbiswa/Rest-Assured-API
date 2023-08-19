package files;
import static io.restassured.RestAssured.*;

import java.io.File;

import org.testng.Assert;

import io.restassured.RestAssured;

import io.restassured.filter.session.SessionFilter;

import io.restassured.path.json.JsonPath;


//import static org.hamcrest.Matchers.*;
//import org.hamcrest.MatcherAssert.*;
//import org.testng.asserts.*;
//import org.testng.Assert;



//import files.payload;
public class JiraTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		RestAssured.baseURI="http://localhost:8080";
		
		
		
		//SessionFilter - it is a class which object holds the session cookies which can be used for next test case
		SessionFilter session = new SessionFilter();
		
		
		String response=given().header("Content-Type","application/json").body("{\r\n"
				+ "     \"username\": \"BiswajitMallick\",\r\n"
				+ "      \"password\": \"B@9583629994b\"\r\n"
				+ " }").log().all().filter(session).when().post("rest/auth/1/session").then().log().all().assertThat()
				.statusCode(200).extract().response().asString();
		System.out.println(response);
		
		
		
		
		//Add comment
		String expectedmessage = "Hi This issue is resolved!";
		
		String addCommentResponse=given().pathParam("key", "10001").log().all().header("Content-Type","application/json")
		.body("{\r\n"
				+ "    \"body\": \""+expectedmessage+"\",\r\n"
				+ "    \"visibility\": {\r\n"
				+ "        \"type\": \"role\",\r\n"
				+ "        \"value\": \"Administrators\"\r\n"
				+ "    }\r\n"
				+ "}").filter(session).
		when().post("rest/api/2/issue/{key}/comment").then().log().all().statusCode(201).extract().response().asString();
		
		
		JsonPath js=new JsonPath(addCommentResponse);
		String commentId=js.getString("id");
		
		/*given().pathParam("key", 10001).log().all().header("Content-Type","application/json")
		
		.body("{\r\n"
				+ "    \"body\": \"hey going to add another comment through rest Assured to delete this.\",\r\n"
				+ "    \"visibility\": {\r\n"
				+ "        \"type\": \"role\",\r\n"
				+ "        \"value\": \"Administrators\"\r\n"
				+ "    }\r\n"
				+ "}").filter(session)
		.when().log().all().delete("rest/api/2/issue/10001/comment/10202")
		.then().log().all().assertThat().statusCode(202);*/
		
		//Add Attachement
		
		given().header("X-Atlassian-Token","no-check").filter(session).pathParam("key", "10001")
		.header("Content-Type","multipart/form-data")//header is in curl format
		.multiPart("file",new File("text.txt"))
		//created a file object and as text.txt is on project level no need to provide path
		//multiPart method used to send files to attachments
		.when().
		post("rest/api/2/issue/{key}/attachments").then().log().all().assertThat().statusCode(200);
		
		//get issues
		
		//path Parameter
		//String issueDeails=given().filter(session).pathParam("key", "10001").when().get("rest/api/2/issue/{key}")
		//.then().log().all().extract().response().asString();
		
	//	System.out.println(issueDeails);
		//query para meter
		String fetchingSingleValue=given().filter(session).pathParam("key", "10001").queryParam("fields", "comment").when().get("rest/api/2/issue/{key}")
				.then().log().all().extract().response().asString();
		System.out.println(fetchingSingleValue);
		
		JsonPath js1 =new JsonPath(fetchingSingleValue);
		int commentcount=js1.getInt("fields.comment.comments.size()");
		
		for(int i=0;i<commentcount;i++)
		{
			String commentIdissue=js1.get("fields.comment.comments["+i+"].id").toString();
			if(commentIdissue.equals(commentId))
			{
				String messsage=js1.get("fields.comment.comments["+i+"].body").toString();
				System.out.println(messsage);
				Assert.assertEquals(messsage, expectedmessage);
			}
			
		}
		}

}
