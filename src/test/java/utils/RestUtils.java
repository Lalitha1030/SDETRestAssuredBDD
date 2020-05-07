package utils;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {

	/*
	public static String getFirstName(){
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return ("John"+generatedString);
	}
	public static String getLastName(){
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return ("Kenedy"+generatedString);
	}
	public static String getUserName(){
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return ("John"+generatedString);
	}
	*/
	
	public static String getID(){
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return ("11"+generatedString);
	}
	public static String getUsertName(){
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return ("User 11"+generatedString);
	}
	public static String getPassword(){
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return ("password11"+generatedString);
	}
	// Creating util file for Demo3_Put_Request data
	/*
	public static String getId(){
		String generatedString = RandomStringUtils.randomNumeric(4);
		return (generatedString);
	}
	*/
	public static String getTitle(){
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return ("Activity"+generatedString);
	}
	public static String getDueDate(){
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return ("2020-04-27T01:45:19.4408321+00:00"+generatedString);
	}
	
	
	
}
