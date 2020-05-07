package restassuredTest;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.*;
//import static org.hamcrest.Matchers.hasSize;

public class Demo_Get_request {

	@Test
	public void getWeatherDetails(){
		given()
		.when()
		   .get("http://fakerestapi.azurewebsites.net/api/Users/2")
		.then()
		   .statusCode(200)
		   .statusLine("HTTP/1,200 OK")
		   .assertThat().body("UserName", equalTo("User 2"))
		.header("Content-type", "application/json");
	}
}
