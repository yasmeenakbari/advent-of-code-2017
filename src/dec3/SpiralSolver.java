package dec3;

public class SpiralSolver {
	
	public static int calculateSteps(int squareIndex){
		int closest, numSpiral;
		numSpiral = 0;
		
		if (squareIndex == 1){
			return 0;
		}
		
		for (int i = 3; i < Math.sqrt(Integer.MAX_VALUE); i=i+2){
			numSpiral++;
			if (squareIndex <= i*i){			
				int[] middleNums = getMiddleNumbers(i);
				closest = Math.abs(squareIndex - middleNums[0]);
				
				for (int num : middleNums){
					int distance = Math.abs(squareIndex - num);
					if ( distance < closest){
						closest = distance;
					}
				}
				
				return numSpiral+closest;
				
			}
		}
		
		return 0; //not sure
		
	}

	private static int[] getMiddleNumbers(int sqRoot) {
		int[] middleNumbers = new int[4];
		
		for (int i = 0; i < 4; i++){
			middleNumbers[i] = (sqRoot*sqRoot) - (sqRoot-1)*i - (sqRoot/2);
 		}
		
		return middleNumbers;
	}

	public static void main(String[] args) {
		System.out.println(calculateSteps(325489));

	}

}
