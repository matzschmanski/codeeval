package easy;

import jsonMenuIds.Main;

import org.junit.Assert;
import org.junit.Test;

public class JsonMenuIdsTest {
	@Test
	public void test() {
		// input sample
		String[] sampleInput = new String[] {
				"{\"menu\": {\"header\": \"menu\", \"items\": [{\"id\": 27}, {\"id\": 0, \"label\": \"Label 0\"}, null, {\"id\": 93}, {\"id\": 85}, {\"id\": 54}, null, {\"id\": 46, \"label\": \"Label 46\"}]}}",
				"{\"menu\": {\"header\": \"menu\", \"items\": [{\"id\": 81}]}}",
				"{\"menu\": {\"header\": \"menu\", \"items\": [{\"id\": 70, \"label\": \"Label 70\"}, {\"id\": 85, \"label\": \"Label 85\"}, {\"id\": 93, \"label\": \"Label 93\"}, {\"id\": 2}]}}" };

		String[] sampleOutput = new String[] { "46", "0", "248" };

		for (int i = 0; i < sampleInput.length; i++) {
			String mySolution = Main.doShizzl(sampleInput[i]);
			Assert.assertEquals(mySolution, sampleOutput[i]);
		}
	}
}
