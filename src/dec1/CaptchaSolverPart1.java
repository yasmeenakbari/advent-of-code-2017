package dec1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CaptchaSolverPart1 {

	public static int solve(String numSequence){
		int sumMatchingDigits, curDigit, nextDigit;
		String[] digits;
		
		sumMatchingDigits = 0;
		digits = numSequence.split("");
		
		for (int i = 0; i < digits.length; i++){
			curDigit = Integer.parseInt(digits[i]);
			
			if (i+1 < digits.length){		
				nextDigit = Integer.parseInt(digits[i+1]);				
			}
			else{
				//compare last against the first
				nextDigit = Integer.parseInt(digits[0]);
			}
			
			if (curDigit == nextDigit){
				sumMatchingDigits += curDigit;
			}
		}
				
		return sumMatchingDigits;
	}
	
	public static void main(String[] args) {
		int solution;
		File numberFile = new File("src/Dec1/input.txt");
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(numberFile));
			String numberString;
			
			while((numberString = reader.readLine()) != null){
				solution = solve(numberString);
				System.out.println(solution);
			}
			
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
	}

}
