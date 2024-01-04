package files;
import static io.restassured.RestAssured.given;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import Pojo.Api;
import Pojo.GetCourses;
import Pojo.WebAutomation;
import io.restassured.path.json.JsonPath;


public class OAuthbasic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String [] courseTitles = {"Selenium Web driver Java","Cypress","Protractor"};
		 
		String response=given().formParam("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.formParam("client_secret","erZOWM9g3UtwNRj340YYaK_W")
		.formParam("grant_type","client_credentials")
		.formParam("scope","trust")
		.when().log().all()
		.post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token").asString();
		
		JsonPath jsonpath = new JsonPath(response);
		String access_token=jsonpath.getString("access_token");
		

		GetCourses gc=given().queryParam("access_token", access_token)
		.when().log().all()
		.get("https://rahulshettyacademy.com/oauthapi/getCourseDetails").as(GetCourses.class);
		
		
		
		System.out.println(gc.getLinkedIn());
		System.out.println(gc.getInstructor());
		
		//this a simple way to get expected search item but this can's be used if the index is changed of that item.
		System.out.println(gc.getCourses().getApi().get(1).getCourseTitle());
		
		
		//we can use and put in a iteration to find desirable item
		
	    List<Api> apicourses =gc.getCourses().getApi();
	
	    for(int i=0;i<apicourses.size();i++)
	   {
		   if(apicourses.get(i).getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing"))
		   {
			  System.out.println(apicourses.get(i).getPrice());
		   }
	    }
	    
		//getting all the course titles of web Automation and comparing with existing and expected
	    ArrayList<String> a =  new ArrayList<String>();
	 List<WebAutomation> webcourses= gc.getCourses().getWebAutomation();
	 
	 for(int i=0;i<webcourses.size();i++)
	 {
		 a.add(webcourses.get(i).getCourseTitle());
	 }
	  List<String> EcpectedResults=  Arrays.asList(courseTitles);
	  a.equals(EcpectedResults);
	}

} 	 	
