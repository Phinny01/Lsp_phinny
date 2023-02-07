package org.howard.edu.hw2;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import java.util.List;

public class word_count {

	public static void main(String[] args) {
		FileReader fr = new FileReader();
		Map<String, Integer> track = new HashMap<>();
		try {
			String temp = (fr.readToString("main/java/resources/words.txt"));
			List<String> list = Arrays.asList(temp.split(" "));
			for (String s : list) {
				if (track.containsKey(s) && s.length() >=4 && !isNumeric(s) ) {
					track.put(s, track.get(s)+1);}
				else if(s.length() >=4 && !isNumeric(s)){
					track.put(s, 1);
				}	
			}
			for (Map.Entry<String, Integer> entry : track.entrySet()) {
			      System.out.println(entry.getKey() + " " + entry.getValue());
			    }
		} catch (FileNotFoundException e) {
			System.out.println("Unable to open resource");
		}
	}

	private static boolean isNumeric(String str) {
		try {
		      Double.parseDouble(str);
		      return true;
		    } catch (NumberFormatException e) {
		      return false;
		    }
		  }

	}
