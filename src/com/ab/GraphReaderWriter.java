package com.ab;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GraphReaderWriter {
	
	public static void storeValues(String fileName, String value) {
		
		try(FileWriter fileWriter = new FileWriter(new File(GraphReaderWriter.class.getResourceAsStream("/resources/graph/" + fileName + ".txt").toString()));
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
			value = checkAndAddValues(readValues(fileName), value);
			bufferedWriter.write(value);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String[] readValues(String fileName) {
		try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(GraphReaderWriter.class.getResourceAsStream("/resources/graph/" + fileName + ".txt")))) {
			return bufferedReader.readLine().split(",");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new String[] {};
	}
	
	private static String checkAndAddValues(String[] oldValues, String value) {
		List<String> list = new ArrayList<>();
		list.addAll(Arrays.asList(oldValues));
		if(list.size() > 30) {
			list = list.subList(1, 29);
		}
		list.add(value);
		return list.toString();
	}
	
}
