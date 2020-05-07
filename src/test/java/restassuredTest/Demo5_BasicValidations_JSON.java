package restassuredTest;
 import static io.restassured.RestAssured.*;
 import static org.hamcrest.Matchers.equalTo;
 import static org.hamcrest.Matchers.hasSize;
 import static org.hamcrest.Matchers.hasItems;

import org.testng.annotations.Test;
 
public class Demo5_BasicValidations_JSON {
/*
  	•	Test Status code
	•	Log Response
	•	Verifying Single content in response body
	•	Verify multiple contents in response body
	•	Setting parameters and headers

 */

// Test Status Code
	@Test(priority=1)
	public void testStatusCode(){
		
		given()
		
		.when()
			.get("http://jsonplaceholder.typicode.com/posts/5")
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK");
			//.log().all();
		//given().when().get("http://jsonplaceholder.typicode.com/posts/5").then().statusCode(200)
	}
// 2. Log Response
	@Test(priority=2)
	public void testLogging(){
		given()
		
		.when()
			.get("https://reqres.in/api/users/2")
		.then()
			.statusCode(200)
			
			.log().all();
	}
//3. Verifying Single content in response body
	@Test(priority=3)
	public void testSingleContent(){
		given()
		
		.when()
			.get("https://reqres.in/api/users/2")
		.then()
			.statusCode(200)
			.body("data.first_name", equalTo("Janet"));
	}
//4. Verifying Multiple contents in response body
	@Test(priority=4)
	public void testMultipleContents(){
		given()
		
		.when()
			.get("https://reqres.in/api/users/")
		.then()
			.statusCode(200)
			.body("data.first_name", hasItems("Janet", "Emma", "Eve"));
	}
//5. Setting Parameters and headers
	@Test(priority=5)
	public void testParamsAndHeaders(){
		given()
			.param("MyName", "Lalitha")
			.header("MyHeader", "India")
		.when()
			.get("https://reqres.in/api/users/2")
		.then()
			.statusCode(200)
			.log().all();
	}
}
