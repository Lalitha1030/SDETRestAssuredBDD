package SerializationAndDeserialization;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class StudentAPIWithSerialization {
	
	@Test(priority=1)
	public void createNewStudentSerialization(){
		
		ArrayList<String> coursesList = new ArrayList<String>();
		coursesList.add("ALM");
		coursesList.add("JavaScript");
		
		Student stu = new Student();
		// stu.setSId(103);
		int id = 103;
		stu.setFirstName("Sabitha");
		stu.setLastName("Konda");
		stu.setEmail("sabithak1@gmai.com");
		stu.setProgramme("Computer Science");
		stu.setCourses(coursesList);
		
		given()
		 	.contentType(ContentType.JSON)
		 	.body(stu)
		 .when()
		 	.post("http://localhost:8085/student")
		 
		 .then()
		 	.statusCode(201)
		 	.assertThat().body("msg", equalTo("Student added"));
		}
	@Test(priority=2)
	public void getStudentRecordDeSerialization(){
		Student stu=get("http://localhost:8085/student/103").as(Student.class);
		System.out.println(stu.getStudentRecord());
		Assert.assertEquals(stu.getSId(), 103);
		
	}

}
