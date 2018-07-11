package project1;
import java.util.*;

public class Hangman {

	public static void main(String[]args) {
		
		while(true) {
			String difficulty = "";
			int diffLevel;
			String secretWord = "";
			System.out.println("Enter your difficulty: Easy (e), Intermediate (i), or Hard (h)");    //creates a random word and
																									//sets the difficulty level
			Scanner sc = new Scanner(System.in);
			difficulty = sc.nextLine();
			diffLevel = difficulty(difficulty);
			RandomWord word = new RandomWord();                                 //sets the word for the game
			secretWord = word.newWord();
			System.out.println("the secret word is " + secretWord);
			
			if(diffLevel == 1) {
				easyGame(secretWord);                                      //executes the easy level game
			}
			
		}
	}
	
	
	
	public static int difficulty(String d) {          //method takes in a letter e, i, or h and turns it into an int 1, 2, or 3
		
		int result = 0;
		
		for(int i = 0;i < d.length();i++) {
			if(d.charAt(i) == 'e') {
				result = 1;
			}else if(d.charAt(i) == 'i') {
				result = 2;
			}else if(d.charAt(i) == 'h') {
				result = 3;
			}
		}
		
		return result;
	}
	
	public static int easyGame(String secretWord) {                       //method executes easy game 
		int numGuesses = 0;
		char[] wordArr = new char[secretWord.length()]; 
		String[] dashedArr = new String[wordArr.length];
		
		for(int i = 0; i < wordArr.length;i++) {
			wordArr[i] = secretWord.charAt(i);
		}
		for(int i = 0; i < dashedArr.length;i++) {
			dashedArr[i] = "- ";
		}		
		
		while(numGuesses < 15) {
			String letterGuess;
			String spacesGuess;
			
			Scanner sc = new Scanner(System.in);
			Scanner sc2 = new Scanner(System.in);
			
			System.out.print("Please enter he letter you want to guess: ");
			letterGuess = sc.next();
			System.out.println("Please enter the spaces you want to check (seperated by spaces):");   
			spacesGuess = sc2.nextLine();
			String[] spacesArr = spacesGuess.split("\\s+");			
			
			for(int i = 0; i < spacesArr.length;i++) {
				System.out.println(spacesArr[i]);
			}
		
			System.out.print("the word is: ");
			for(int i = 0; i < dashedArr.length;i++) {
				System.out.print(dashedArr[i]);
			}
			System.out.println("");
			numGuesses = numGuesses + 20;
		}
		return 1;
	}
}
