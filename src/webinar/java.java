package webinar;
import java.util.Random;
import java.util.Scanner;

public class java {
    public static void main (String[]args) {


        final Random random= new Random ();
        final Scanner scanner= new Scanner(System.in);
        final String[] words = {"java", "sklillmea", "programing", "webinar"};
        final String wordToGuess = secelctedWord(words,random);
        String hiddenWord = generateHiddenWord(wordToGuess);
        System.out.println("Welcome to Hangman");
        System.out.println("Guess the word:"+ hiddenWord);
        final int MAX_INCORRECT_GUESSES=6;
        int incorrectGuesses=0;
        while (incorrectGuesses<MAX_INCORRECT_GUESSES && hiddenWord.contains("_")){
            System.out.println("Enter a letter: ");
            char guess = scanLetter(scanner);
            if (wordToGuess.contains(String.valueOf(guess))){
                hiddenWord = revalLetters(wordToGuess,hiddenWord, guess);
                System.out.println("Correct guess! update word:"+ hiddenWord);

            } else {
                    incorrectGuesses++;
                    System.out.println("Incorect guess You have"+(MAX_INCORRECT_GUESSES-incorrectGuesses)+"guesses left");
                }
            }
        if (hiddenWord.contains("")){
            System.out.println("Congratulation! You guessed the word "+ wordToGuess);
        } else {
            System.out.println("Sorry, you have run out of guesses! that word was" + wordToGuess);
        }

        }
        public static char scanLetter(Scanner scanner) {
          char guess;
          while(true){
          try {
              String line = scanner.nextLine();
              if (line.length()!=1){
                  throw new Exception("Line lenght is not 1. Please enter a single letter");
              }
              guess=line.charAt(0);
              if (Character.isLetter(guess)){
                  throw new Exception("Character is not a letter. Please enter a singlet letter");
              }
              break;
          }
            catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return guess;

    }
    public static String secelctedWord(String []words, Random random){
       return words [random.nextInt(words.length)];

    }
    public static String generateHiddenWord(String word){
        return " ".repeat(word.length());
    }
    public static String revalLetters(String wordToGuess, String hiddenWord, char letter){
        char []hiddenWordChars = hiddenWord.toCharArray();

        for (int i = 0; i<wordToGuess.length();i++){
            if (wordToGuess.charAt(i)==letter){
                hiddenWordChars[i]=letter;
            }
        }
        return String.valueOf(hiddenWordChars);
    }
}
