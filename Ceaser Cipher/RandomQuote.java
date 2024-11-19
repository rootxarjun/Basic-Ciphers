import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RandomQuote {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> quotes = new ArrayList<>();

        try {
            File file = new File("C:\\Users\\HP\\Desktop\\GitHub\\Basic-Ciphers\\Ceaser Cipher\\quotes.txt");
            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextLine()) {
                quotes.add(fileScanner.nextLine());
            }

            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            return;
        }

        while (true) {
            System.out.print("Enter 'exit' to quit or any other key to continue: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                Random random = new Random();
                int randomIndex = random.nextInt(quotes.size());
                System.out.println("\nHere's a random quote for you:\n" + quotes.get(randomIndex));
                break;
            }
        }

        scanner.close();
    }
}