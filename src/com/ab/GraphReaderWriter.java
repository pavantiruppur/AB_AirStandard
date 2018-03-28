package com.ab;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
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
	
	public static Double[] readValues(String fileName) {
		List<Double> list = new ArrayList<>();
		try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(GraphReaderWriter.class.getResourceAsStream("/resources/graph/" + fileName + ".txt")))) {
			String read = bufferedReader.readLine();
			if(read != null) {
				Arrays.asList(read.split(",")).forEach(val -> list.add(Double.parseDouble(val)));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list.toArray(new Double[list.size()]);
	}
	
	private static String checkAndAddValues(Double[] oldValues, String value) {
		List<Double> list = new ArrayList<>();
		list.addAll(Arrays.asList(oldValues));
		if(list.size() > 30) {
			list = list.subList(1, 29);
		}
		list.add(Double.parseDouble(value));
		return list.toString();
	}
	
}
