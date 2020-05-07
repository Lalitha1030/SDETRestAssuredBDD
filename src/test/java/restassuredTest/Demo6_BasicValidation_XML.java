package restassuredTest;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

/*
 	•	Verifying Single content in XML Response
	•	Verifying Multiple contents in SML Response
	•	Verifying all the content in XML response in one go
	•	Find values using XML Path in XML response
	•	XPath with text() function

 */
public class Demo6_BasicValidation_XML {
	
//1. Verifying Single content in XML Response
	@Test(priority=1)
	public void testSingleContent(){
		given()
		.when()
		  .get("http://thomas-bayer.com/sqlrest/CUSTOMER/15")
		 .then()
		 .body("CUSTOMER.ID", equalTo("15"))
		 .log().all();
		
		
	}
//2. Verifying Multiple contents in SML Response
	@Test(priority=2)
	public void testMultipleContents(){
		given()
		.when()
		  .get("http://thomas-bayer.com/sqlrest/CUSTOMER/15")
		 .then()
		 
		 .body("CUSTOMER.ID", equalTo("15"))
		 .body("CUSTOMER.FIRSTNAME", equalTo("Bill"))
		 .body("CUSTOMER.LASTNAME", equalTo("Clancy"))
		 .body("CUSTOMER.STREET", equalTo("319 Upland Pl."))
		 .body("CUSTOMER.CITY", equalTo("Seattle"));
		
		 
		
	}
//3. Verifying all the content in XML response in one go	
	@Test(priority=3)
	public void testMultipleContentsInOneGo(){
		given()
		.when()
		  .get("http://thomas-bayer.com/sqlrest/CUSTOMER/15")
		 .then()
		 .body("CUSTOMER.text()", equalTo("15BillClancy319 Upland Pl.Seattle"));
		
	}
//4. Find values using XML Path in XML response
	@Test(priority=4)
	public void testUsingXPath1(){
		given()
		.when()
		  	.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15")
		.then()
		 	.body(hasXPath("/CUSTOMER/FIRSTNAME"), containsString("Bill"));
		
	}
//5. XPath with text() function	
	@Test(priority=5)
	public void testUsingXPath(){
		given()
		.when()
		  	.get("http://thomas-bayer.com/sqlrest/INVOICE/")
		.then()
		 	.body(hasXPath("/INVOICEList/INVOICE[text()='30']"))
		 	.log().all();
	}
	
}
