package kz.essc.test;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class App {
    
    public Map<String, Double> process() throws IOException {
    	Scanner in = new Scanner(new File("INPUT.TXT"));
    	
    	StringBuilder builder = new StringBuilder("");
    	
    	while(in.hasNextLine())
    		builder.append(in.nextLine());
    	
    	in.close();

		StringTokenizer str = new StringTokenizer(builder.toString(), " .,;");
		
		Map <String, ArrayList<Integer>> map = new TreeMap<String, ArrayList<Integer>>(Collections.reverseOrder());
		
		while(str.hasMoreTokens()) {
			String word = str.nextToken();
			Map<Character, Integer> wordMap = countVowels(word);
			
			String key = "("+wordMap.keySet().toString().replace('[', '{').replace(']', '}')+","+ word.length() + ")";
			
			if (!map.containsKey(key))
				map.put(key, new ArrayList<Integer>());
			
			int vowels = 0;
			for (int i: wordMap.values())
				vowels += i;
			map.get(key).add(vowels);
		}
		
		
		Map<String, Double> answer = new HashMap<String, Double>();
		
		PrintWriter out = new PrintWriter(new File("OUTPUT.TXT"));
		for (String key: map.keySet()) {
			double average = 0;
			for (Integer i:map.get(key))
				average += i;
			
			average = average/map.get(key).size();
			answer.put(key, average);
			
			out.print(key + "->");
			
			int intValue = 0;
			if (average%1==0) {
				intValue = (int)average;
				out.println(intValue);
			}
			else
				out.println(average);
		}
		out.close();
		
		return answer;
	}
	
	private Map<Character,Integer> countVowels(String word) {
		Map<Character, Integer> map = new TreeMap<Character, Integer>();
		
		for (char iterator: word.toCharArray()) {
			char c = Character.toLowerCase(iterator);
			switch (c) {
				case 'a':
				case 'e':
				case 'i':
				case 'o':
				case 'u':
					if (map.containsKey(c))
						map.put(c, map.get(c).intValue()+1);
					else
						map.put(c, new Integer(1));
					break;
			}
		}
		
		return map;
	}
}
