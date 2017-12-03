package Dec2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ChecksumCalculator {
	
	public static int calculate(List<List<Integer>> ss){
		int min, max, next, sum;	
		sum = 0;
		
		for (List<Integer> row : ss){
			Iterator<Integer> iter = row.iterator();
			min = iter.next();
			max = min;		
			
			while (iter.hasNext()){
				next = iter.next();
				
				if (next < min){
					min = next;
				}
				else if (next > max){
					max = next;
				}
			}
			sum += (max - min);
		}		
		return sum;
	}
	
	public static void main(String[] args) {
		File ssFile = new File("src/Dec2/input.txt");
		List<List<Integer>> ss = new ArrayList<List<Integer>>();
		int answer;
		
		try{
			BufferedReader reader = new BufferedReader(new FileReader(ssFile));
			String row;			
			
			while ((row = reader.readLine()) !=  null){
				ArrayList<Integer> parsedRow = new ArrayList<Integer>();
				
				for (String strNum : row.split("\t")){
					parsedRow.add(Integer.parseInt(strNum));
				}
				
				ss.add(parsedRow);
			}
			
			answer = calculate(ss);
			System.out.println(answer);
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
