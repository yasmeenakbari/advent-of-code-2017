package dec4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class PassphraseValidator {
	
	private static boolean isValid(String passphrase) {
		String[] words = passphrase.split(" ");
		HashSet<Integer> uniqueWords = new HashSet<Integer>();
		
		for (String word : words){
			int hashcode = word.hashCode();
			
			if (uniqueWords.contains(hashcode)){
				return false;
			}
			
			uniqueWords.add(hashcode);
		}
		
		return true;
	}

	public static void main(String[] args) {
		File input = new File("src/Dec4/input.txt");
		int validCount = 0;
		
		try{
			BufferedReader reader = new BufferedReader(new FileReader(input));
			String passphrase;
			
			while ((passphrase = reader.readLine()) != null){
				if (isValid(passphrase)){
					validCount = validCount + 1;
				}
			}
			
			System.out.println(validCount);
			reader.close();
					
		} catch (IOException e){
			e.printStackTrace();
		}

	}

}
