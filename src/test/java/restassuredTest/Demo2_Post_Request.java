package restassuredTest;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import utils.RestUtils;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.hasSize;
public class Demo2_Post_Request {

	public static HashMap map = new HashMap();
	@BeforeClass
	public void postData(){
		map.put("Id", RestUtils.getID());
		map.put("UserName", RestUtils.getUsertName());
		map.put("Password", RestUtils.getPassword());
		
		RestAssured.baseURI = "http://fakerestapi.azurewebsites.net";
		RestAssured.basePath = "/api/Users";
		
	}
	@Test
	public void testPost(){
		
		given()
		.contentType("application/json")
		.body(map)
		.when()
			.post()
		.then()
			.statusCode(201)
			.body("ID", equalTo(11))
			.and()
			.body("UserName", equalTo("User 11"))
			.and()
			.body("Password", equalTo("Password11"));
		
		
		
	}
}
