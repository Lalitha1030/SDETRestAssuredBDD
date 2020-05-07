package restassuredTest;

import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.hasSize;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import utils.RestUtils;

public class Demo3_Put_Request {
	
	public static HashMap map = new HashMap();
	
	//String Id = RestUtils.getId();
	String  Title = RestUtils.getTitle();
	String DueDate = RestUtils.getDueDate();
	int ID = 4;
	
	@BeforeClass
	public void putData(){
		map.put("title", Title);
		
		map.put("dueDate", DueDate);
		
		RestAssured.baseURI="http://fakerestapi.azurewebsites.net/";
		RestAssured.basePath="api/Activities/"+ID;
	
	}
	@Test
	public void testPut(){
		given()
		.contentType("application/json")
		.body(map)
		.when()
		.put()
		.then()
		.statusCode(200)
		.log().all();
				
	}

}
