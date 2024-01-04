package files;
import static io.restassured.RestAssured.given;

import io.restassured.path.json.JsonPath;
public class OAuth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//here selenium coce shoud be there to login
		
		
		String url="https://rahulshettyacademy.com/getCourse.php?code=4%2F0AfJohXlRnezheJcKcPD88OPd54M-Bks1lkpwmWpeQ72UcBgQi2ZjP10RNwEOH9OtmEWLqQ&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&prompt=none";
		String partialcode=url.split("code=")[1];
		String code=partialcode.split("&scope")[0];
		
		
		
		
		String accessTokenResponse=given().urlEncodingEnabled(false)
		.queryParams("code", code)
		.queryParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.queryParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
		.queryParams("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
		.queryParams("grant_type", "authorization_code")
		.when().log().all()
		.post("https://www.googleapis.com/oauth2/v4/token").asString();
		
		JsonPath js =new JsonPath(accessTokenResponse);
		String accessToken=js.getString("access_token");
		
		System.out.println("accessToken");
		
		
		String  response=given().queryParam("access_token",accessToken)
		.when()
		.get("https://rahulshettyacademy.com/getCourse.php").asString();
		
		System.out.println(response);
		
	}

}
