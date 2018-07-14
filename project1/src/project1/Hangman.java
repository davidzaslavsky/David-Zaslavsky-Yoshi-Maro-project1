package project1;
import java.util.*;
 
public class Hangman {
    private static  final boolean   testingMode = true;
   
    public static void main(String[]args) {
        int replay = 1;
       //while the user wants to keep playing
        while(replay == 1) {
            String difficulty = "";
            int diffLevel;
            String secretWord = "";
            //creates a random word and sets the difficulty level
            System.out.println("Enter your difficulty: Easy (e), Intermediate (i), or Hard (h)");
            Scanner sc = new Scanner(System.in);
            difficulty = sc.nextLine();
            diffLevel = difficulty(difficulty);
            RandomWord word = new RandomWord();
            secretWord = word.newWord();
            secretWord = secretWord.toLowerCase();
           if(testingMode == true)
               System.out.println("the secret word is " + secretWord);
           //starts a game of chosen difficulty
            if(diffLevel == 1) {
                replay = easyGame(secretWord);
            }else if(diffLevel == 2) {
                replay = intermediateGame(secretWord);
            }else {
                replay = hardGame(secretWord);
            }
           
        }
    }
   
    //Method used to determine difficulty and represent it as an integer
    public static int difficulty(String d) {
       
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
   
    //Method for easy difficulty
    public static int easyGame(String secretWord) {
    	//initializes all variables
    	int goodAnswer = 0;
    	int numGuesses = 15;
        int remainingGuess = secretWord.length();
        char[] wordArr = new char[secretWord.length()];
        String[] dashedArr = new String[wordArr.length];
        for(int i = 0; i < wordArr.length;i++) {
            wordArr[i] = secretWord.charAt(i);
        }
        for(int i = 0; i < dashedArr.length;i++) {
            dashedArr[i] = "- ";
        }        
       
        //While the game is still running
        while(numGuesses > 0 && remainingGuess != 0) {
           
            String letterGuess;
            String spacesGuess;
            Scanner sc = new Scanner(System.in);
            Scanner sc2 = new Scanner(System.in);
           //asks user for input
            System.out.println("You have the following the number of guesses: " + numGuesses);
            System.out.print("Please enter he letter you want to guess: ");
            letterGuess = sc.next();
           while (true) {
               System.out.println("Please enter the spaces you want to check (seperated by spaces):");  
               spacesGuess = sc2.nextLine();
             
               String[] spaceInputArr = spacesGuess.split("\\s+");   //.trim()
               int[] spaceArr = new int[spaceInputArr.length];            
               //Converts individual string inputs for spaces to integer
               
               for(int a = 0; a < spaceArr.length; a++) {
                   if(Character.isDigit(spaceInputArr[a].charAt(0)))
                   spaceArr[a] = Integer.parseInt(spaceInputArr[a]);
               }
           
               //Runs through the array to check multiple spaces within the word.
               
               for(int b=0; b < spaceArr.length; b++) {
                   int space = spaceArr[b];
                   if(wordArr[space] == letterGuess.charAt(0)) {
                       String s = Character.toString(letterGuess.charAt(0));
                       dashedArr[space] = s;                      
                       goodAnswer = 1;
                   }
               }
 
               if(spaceInputArr.length <= 4){
                   break;
               }else {
                   System.out.println("Your input is not valid. Try again.");
               }          
           }
            //Prints what is known of the word (including dashes)
            System.out.println("the word is: ");
            for(int i = 0; i < dashedArr.length;i++) {
                System.out.print(dashedArr[i]);
            }
            if(goodAnswer == 0)
            	numGuesses -= 1;
            goodAnswer = 0;
            System.out.println();
            
 
           
            //If the player fails to guess the correct word.
            if (numGuesses == 0) {
                System.out.println("You have failed to guess the word... :(");
                System.out.println("do you want to play again? Yes(y) or No(n)");          
                break;
            }
            //If the player guesses the correct word.
            else if(remainingGuess == 0) {
                System.out.println("You have guessed the word! Congratulations");
                System.out.println("do you want to play again? Yes(y) or No(n)");
                break;
            }
        }    
       
        //Based on user input, handles the end of the game.
        Scanner sc3 = new Scanner(System.in);
        String replay = sc3.next();
        if(replay.equals("y")) {
            return 1;
        }else {
            return 0;
        }
 
    }
 
    //Method for intermediate difficulty
    public static int intermediateGame(String secretWord) {
    	//initializes all variables
    	int goodAnswer = 0;
    	int numGuesses = 12;
        int remainingGuess = secretWord.length();
        char[] wordArr = new char[secretWord.length()];
        String[] dashedArr = new String[wordArr.length];
        for(int i = 0; i < wordArr.length;i++) {
            wordArr[i] = secretWord.charAt(i);
        }
        for(int i = 0; i < dashedArr.length;i++) {
            dashedArr[i] = "- ";
        }        
       
        //While the game is still running
        while(numGuesses > 0 && remainingGuess != 0) {
           
            String letterGuess;
            String spacesGuess;
            Scanner sc = new Scanner(System.in);
            Scanner sc2 = new Scanner(System.in);
           //asks user for input
            System.out.println("You have the following the number of guesses: " + numGuesses);
            System.out.print("Please enter he letter you want to guess: ");
            letterGuess = sc.next();
           while (true) {
               System.out.println("Please enter the spaces you want to check (seperated by spaces):");  
               spacesGuess = sc2.nextLine();
             
               String[] spaceInputArr = spacesGuess.split("\\s+");   //.trim()
               int[] spaceArr = new int[spaceInputArr.length];            
               //Converts individual string inputs for spaces to integer
               
               for(int a = 0; a < spaceArr.length; a++) {
                   if(Character.isDigit(spaceInputArr[a].charAt(0)))
                   spaceArr[a] = Integer.parseInt(spaceInputArr[a]);
               }
           
               //Runs through the array to check multiple spaces within the word.
               for(int b=0; b < spaceArr.length; b++) {
                   int space = spaceArr[b];
                   if(wordArr[space] == letterGuess.charAt(0)) {
                       String s = Character.toString(letterGuess.charAt(0));
                       dashedArr[space] = s;
                       goodAnswer = 1;
                   }
               }
 
               if(spaceInputArr.length <= 3){
                   break;
               }else {
                   System.out.println("Your input is not valid. Try again.");
               }          
           }
            //Prints what is known of the word (including dashes)
            System.out.println("the word is: ");
            for(int i = 0; i < dashedArr.length;i++) {
                System.out.print(dashedArr[i]);
            }
 
            if(goodAnswer == 0)
            	numGuesses -= 1;
            goodAnswer = 0;          
            System.out.println();

 
           
            //If the player fails to guess the correct word.
            if (numGuesses == 0) {
                System.out.println("You have failed to guess the word... :(");
                System.out.println("do you want to play again? Yes(y) or No(n)");          
                break;
            }
            //If the player guesses the correct word.
            else if(remainingGuess == 0) {
                System.out.println("You have guessed the word! Congratulations");
                System.out.println("do you want to play again? Yes(y) or No(n)");
                break;
            }
        }    
       
        //Based on user input, handles the end of the game.
        Scanner sc3 = new Scanner(System.in);
        String replay = sc3.next();
        if(replay.equals("y")) {
            return 1;
        }else {
            return 0;
        }
 
    }
   
    //Method for hard difficulty
    public static int hardGame(String secretWord) {
    	//initializes all variables
    	int goodAnswer = 0;
    	int numGuesses = 10;
        int remainingGuess = secretWord.length();
        char[] wordArr = new char[secretWord.length()];
        String[] dashedArr = new String[wordArr.length];
        for(int i = 0; i < wordArr.length;i++) {
            wordArr[i] = secretWord.charAt(i);
        }
        for(int i = 0; i < dashedArr.length;i++) {
            dashedArr[i] = "- ";
        }        
       
        //While the game is still running
        while(numGuesses > 0 && remainingGuess != 0) {
           
            String letterGuess;
            String spacesGuess;
            Scanner sc = new Scanner(System.in);
            Scanner sc2 = new Scanner(System.in);
           //asks user for input
            System.out.println("You have the following the number of guesses: " + numGuesses);
            System.out.print("Please enter he letter you want to guess: ");
            letterGuess = sc.next();
           while (true) {
               System.out.println("Please enter the spaces you want to check (seperated by spaces):");  
               spacesGuess = sc2.nextLine();
             
               String[] spaceInputArr = spacesGuess.split("\\s+");   
               int[] spaceArr = new int[spaceInputArr.length];            
               //Converts individual string inputs for spaces to integer
               
               for(int a = 0; a < spaceArr.length; a++) {
                   if(Character.isDigit(spaceInputArr[a].charAt(0)))
                   spaceArr[a] = Integer.parseInt(spaceInputArr[a]);
               }
           
               //Runs through the array to check multiple spaces within the word.
               for(int b=0; b < spaceArr.length; b++) {
                   int space = spaceArr[b];
                   if(wordArr[space] == letterGuess.charAt(0)) {
                       String s = Character.toString(letterGuess.charAt(0));
                       dashedArr[space] = s;
                       goodAnswer = 1;
                   }
               }
 
               if(spaceInputArr.length <= 2){
                   break;
               }else {
                   System.out.println("Your input is not valid. Try again.");
               }          
           }
            //Prints what is known of the word (including dashes)
            System.out.println("the word is: ");
            for(int i = 0; i < dashedArr.length;i++) {
                System.out.print(dashedArr[i]);
            }
 
            if(goodAnswer == 0)
            	numGuesses -= 1;
            goodAnswer = 0;          
            System.out.println();

 
           
            //If the player fails to guess the correct word.
            if (numGuesses == 0) {
                System.out.println("You have failed to guess the word... :(");
                System.out.println("do you want to play again? Yes(y) or No(n)");          
                break;
            }
            //If the player guesses the correct word.
            else if(remainingGuess == 0) {
                System.out.println("You have guessed the word! Congratulations");
                System.out.println("do you want to play again? Yes(y) or No(n)");
                break;
            }
        }    
       
        //Based on user input, handles the end of the game.
        Scanner sc3 = new Scanner(System.in);
        String replay = sc3.next();
        if(replay.equals("y")) {
            return 1;
        }else {
            return 0;
        }
 
    }    
 
}
 
