package jsonMenuIds;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null) {
			line = line.trim();
			// Process line of input Here
			System.out.println(doShizzl(line));
		}
	}

	public static String doShizzl(String line) {
		int count = parseJsonObject(line);
		return count + "";
	}

	private static int parseJsonObject(String jsonString) {
		Pattern pattern = Pattern.compile("\"items\": \\[(.*?)\\]");
		Matcher matcher = pattern.matcher(jsonString);
		String items = "";
		while (matcher.find()) {
			items = matcher.group(1);
		}
		pattern = Pattern.compile("(\\{.*?\\})");
		matcher = pattern.matcher(items);
		int count = 0;
		while (matcher.find()) {
			count += sumItemIds(matcher.group(1));

		}
		return count;

	}

	private static int sumItemIds(String item) {
		int count = 0;
		if (item.contains("\"label\"")) {
			Pattern pattern = Pattern.compile("\"id\": (.*?),");
			Matcher matcher = pattern.matcher(item);
			while (matcher.find()) {
				count += Integer.valueOf(matcher.group(1));
			}
		}
		return count;
	}
}