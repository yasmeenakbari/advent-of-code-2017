package dec4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class PassphraseValidatorPart2 {
	
	private static List<String> convertPassphrase(String passphrase) {
		String[] words = passphrase.split(" ");
		List<String> wordsList = new ArrayList<String>();
		
		for (String word : words){
			char[] letterArray = word.toCharArray();
			Arrays.sort(letterArray);
			wordsList.add(new String(letterArray));
		}
		
		return wordsList;
	}
	
	private static boolean isValid(List<String> words) {
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
				List<String> wordList = convertPassphrase(passphrase);
				if (isValid(wordList)){
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
