package dec5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JumpExecutorPart2 {

	private static int calculateSteps(List<Integer> stepList) {
		int numSteps, curPos, numJumps;
		curPos = 0;
		numSteps = 0;
		
		while ( (curPos >= 0) &&  (curPos <= stepList.size()-1)) {
			numJumps = stepList.get(curPos);
			
			if (numJumps >= 3) {
				stepList.set(curPos, numJumps-1);
			}
			else {
				stepList.set(curPos, numJumps+1);
			}
			
			curPos = curPos + numJumps;
			numSteps = numSteps + 1;
		}
		
		return numSteps;
	}

	public static void main(String[] args) {
		File input = new File("src/Dec5/input.txt");
		List<Integer> stepList = new ArrayList<Integer>();
		int numSteps;
		
		try{
			BufferedReader reader = new BufferedReader(new FileReader(input));
			String stepString;
			
			while ((stepString = reader.readLine()) != null){
				stepList.add(Integer.parseInt(stepString));
			}
			
			numSteps = calculateSteps(stepList);
			System.out.println(numSteps);
			reader.close();
					
		} catch (IOException e){
			e.printStackTrace();
		}

	}

}
