import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {

        String filePath = "words.txt"; 
        ArrayList<String> words = new ArrayList<>();
        int wrongGuesses = 0;

        // 1. Fixed the 'Import' casing on line 1
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Ignore empty lines in the text file
                if (!line.trim().isEmpty()) {
                    words.add(line.trim().toLowerCase());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: Could not find 'words.txt' in the project folder.");
            return; 
        } catch (IOException e) {
            System.out.println("Something went wrong reading the file.");
            return;
        }

        // 2. Added a check to ensure the file wasn't empty
        if (words.isEmpty()) {
            System.out.println("Error: The word list is empty.");
            return;
        }

        Random random = new Random();
        String word = words.get(random.nextInt(words.size()));

        Scanner scanner = new Scanner(System.in);
        ArrayList<Character> wordState = new ArrayList<>();

        for (int i = 0; i < word.length(); i++) {
            wordState.add('_');
        }

        System.out.println("***************************");
        System.out.println("Welcome to Java Hangman!");
        System.out.println("***************************");

        while (wrongGuesses < 6) {
            System.out.print(getHangmanArt(wrongGuesses));
            System.out.print("Word: ");
            for (char c : wordState) {
                System.out.print(c + " ");
            }
            System.out.println();

            System.out.print("Guess a letter: ");
            String input = scanner.next().toLowerCase();
            
            // 3. Safety check for empty input
            if (input.isEmpty()) continue;
            char guess = input.charAt(0);

            if (word.indexOf(guess) >= 0) {
                // 4. Prevent "Correct guess" spam if they guess the same letter twice
                if (wordState.contains(guess)) {
                    System.out.println("You already guessed '" + guess + "'!");
                } else {
                    System.out.println("Correct guess!");
                    for (int i = 0; i < word.length(); i++) {
                        if (word.charAt(i) == guess) {
                            wordState.set(i, guess);
                        }
                    }
                }

                if (!wordState.contains('_')) {
                    System.out.print(getHangmanArt(wrongGuesses));
                    System.out.println("YOU WIN!");
                    System.out.println("The word was: " + word);
                    break;
                }
            } else {
                wrongGuesses++;
                System.out.println("Wrong guess!");
            }

            if (wrongGuesses >= 6) {
                System.out.print(getHangmanArt(wrongGuesses));
                System.out.println("GAME OVER!");
                System.out.println("The word was: " + word);
            }
        }
        scanner.close();
    }

static String getHangmanArt(int wrongGuesses) {
    switch (wrongGuesses) {
        case 0:
            return "\n\n\n";
        case 1:
            return "  o  \n\n\n";
        case 2:
            return "  o  \n  |  \n\n";
        case 3:
            return "  o  \n /|  \n\n";
        case 4:
            return "  o  \n /|\\ \n\n";
        case 5:
            // Use double backslash \\ to show one \ in the console
            return "  o  \n /|\\ \n /   \n";
        case 6:
            return "  o  \n /|\\ \n / \\ \n";
        default:
            return "";
    }
}
}
