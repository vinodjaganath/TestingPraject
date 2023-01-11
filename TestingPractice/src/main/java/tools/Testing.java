package tools;

import java.io.IOException;

import org.testng.annotations.Test;

public class Testing extends BaseTest{
	
	


	@Test
	public static void testing() throws IOException, InterruptedException {
		CommonOperations.navigate("https://www.ibm.com/in-en/topics/software-testing");
	CommonOperations.takeScreenshot();
	
	CommonOperations.scrollIntoview("//*[contains(text(),'Case studies')]");
	CommonOperations.takeScreenshot();
}
}