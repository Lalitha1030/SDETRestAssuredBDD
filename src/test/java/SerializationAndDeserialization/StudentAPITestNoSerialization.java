package SerializationAndDeserialization;

import java.util.ArrayList;
import java.util.HashMap;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class StudentAPITestNoSerialization {

	public HashMap map = new HashMap();
	
	//Post request creates a new student record
	//@Test(priority=1)
	public void createNewStudent(){
		map.put("id", "101");
		map.put("firstName", "Sruthi");
		map.put("lastName", "Challa");
		map.put("email", "sruthic@gmail.com");
		map.put("programme", "Manager");
		
		ArrayList<String> courseList = new ArrayList<String>();
		courseList.add("Java");
		courseList.add("Selenium");
		map.put("courses", courseList);
		
		given()
			.contentType(ContentType.JSON)
			.body(map)
		.when()
			.post("http://localhost:8085/student")
		.then()
			.statusCode(201)
			.assertThat()
			.body("msg", equalTo("Student added"));
		}
	@Test(priority=2)
	public void getStudentRecord(){
		given()
		.when()
			.get("http://localhost:8085/student/101")
		.then()
			.statusCode(200)
			.assertThat()
			.body("id", equalTo(101))
			.log().all();
	}
	
}
