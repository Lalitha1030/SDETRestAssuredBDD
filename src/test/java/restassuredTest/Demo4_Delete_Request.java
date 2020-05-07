package restassuredTest;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.*;
//import static org.hamcrest.Matchers.hasSize;
public class Demo4_Delete_Request {

	public static HashMap map = new HashMap();
	
	@Test
	public void testDelete(){
		RestAssured.baseURI = "http://fakerestapi.azurewebsites.net/";
		RestAssured.basePath = "api/Books/7";
		
		Response response = 
		given()
		.when()
			.delete()
			
		.then()
			.assertThat()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
		   .log().all()
		   .extract().response();
		String jsonAsString = response.asString();
		Assert.assertEquals(jsonAsString.contains("Successfully! deleted Records"),false);
		
	}
}
