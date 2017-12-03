package dec2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ChecksumCalculatorPart2 {
	
	public static int calculate(List<List<Integer>> ss){
		int sum = 0;
		
		for (List<Integer> row : ss){
			sum += getDivisionResult(row);
		}		
		return sum;
	}
	
	private static int getDivisionResult(List<Integer> row) {
		int num1, num2, result;
		result = 0;
		
		for (int i = 0; i < row.size(); i++){
			num1 = row.get(i);
			
			for (int j = 0; j < row.size(); j++){
				num2 = row.get(j);
				
				if (num1 != num2){	
					if (num1 % num2 == 0){
						return (num1/num2);
					}
					else if (num2 % num1 == 0){
						return (num2/num1);
					}	
				}	
			}
		}
		
		return result;
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
