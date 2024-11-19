// Importing Scanner Package..
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

// Ceaser Class..
public class ceaser {

    // Entery point to the Main Function..
public static void main(String[] args) {

    Scanner userinput = new Scanner(System.in);

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
    
    // Menu..
    while(true){
        System.out.print("\n-------------------------------------------------------------------\n");
        System.out.println("\n 1. Encryption \n 2. Decryption \n 3. Brute-Force \n 4. Exit \n ");
        System.out.print("[-] Enter the Task to be Performed: ");
        int choice;
        // Selecting User's Choice..
        try{
        choice = userinput.nextInt();
    }
        catch (InputMismatchException e) {
                System.out.println("[-] Error: Invalid input. Please enter a number (1-4).");
                userinput.nextLine(); 
                continue;
        }
        System.out.print("\n-------------------------------------------------------------------\n");

        userinput.nextLine();
        switch (choice) {

            // This case is for Encryption..
            case 1:
                int encrypt_key;
                System.out.print("[-] Enter Plain Text: ");
                String plaintext = userinput.nextLine();
                try {
                    System.out.print("[-] Enter Encryption Key: ");
                    encrypt_key = userinput.nextInt();
                    if (encrypt_key < 0 || encrypt_key > 25) {
                        System.out.print("[-] Please Enter A Encrpytion Key Between 0-25");
                        continue;
                    }
                    
                } catch (Exception e) {
                    System.out.print("[-] Error Invalid Values Detected.");
                    continue;
                }
                
                String encrypted = encrypt(plaintext, encrypt_key);
                System.out.print("[-] Encrypted Text is: "+encrypted + "\n");
                break;

            // This case is for Decryption..
            case 2:
                int cipher_key;
                System.out.print("[-] Enter Cipher Text: ");
                String cipher_text = userinput.nextLine();
                try {
                    System.out.print("[-] Enter Cipher Key: ");
                    cipher_key = userinput.nextInt();
                    if (cipher_key < 0 || cipher_key > 25) {
                        System.out.print("[-] Please Enter A Encrpytion Key Between 0-25");
                        continue;
                    }
                    
                } catch (Exception e) {
                     System.out.print("[-] Error Invalid Values Detected.");
                    continue;
                }
                String decrypted = decrypt(cipher_text, cipher_key);
                System.out.print("[-] Decrypted Text: "+decrypted + "\n");
                break;
            
            // This case if for Brute-Forcing..
            case 3:
                System.out.print("[-] Enter Plain Text: ");
                String plain_text = userinput.nextLine();
                System.out.print("[-] Enter Cipher Text: ");
                String cipher_Text = userinput.nextLine();
                int expected_key = 0;
                int count = -1;
                for (int i = 0 ; i < 26 ; i++){
                    expected_key = brute_force(plain_text, cipher_Text, i);
                    if (expected_key != -1) {
                        System.out.println("[-] Valid Key is: " + expected_key);
                        break;
                    } 
                    else {
                        count++;
                    }
            }
            if (count == 25){
                System.out.println("[-] Key Not Found. Or Plain Text and Cipher Text is wrong.. ");
            }
                break;

                // This case is for Exiting Our prompt..
                case 4:
                System.out.print("[-] ThankYou For using Ceaser Cipher.\n");
                Random random = new Random();
                int randomIndex = random.nextInt(quotes.size());
                System.out.println("[-] "+quotes.get(randomIndex));
                System.out.print("[-] Exiting....");
                System.exit(0);
            break;
            
            // Default to this prompt if user tries to enter Numeric options other than provided.. 
            default:
            System.out.print("[-] Error: Invalid input. Please enter a number (1-4).");
                break;
        }
    }
}


// This function is for encryption..
public static String encrypt(String plaintext, int key){
    StringBuilder ciphertext = new StringBuilder();
    for (int i=0; i<plaintext.length(); i++){
        char ch = plaintext.charAt(i);


        // Check for the case of the character.. 
        if(Character.isUpperCase(ch)){
            char c1 = (char) ((ch+key-'A')%26+'A');
            ciphertext.append(c1);
        }
        else if (Character.isLowerCase(ch)){
            char c1 = (char) ((ch+key - 'a')%26+'a');
            ciphertext.append(c1);
        }
        else{
            ciphertext.append(ch);
        }

    }
    return ciphertext.toString();
}


// This Function is for Decryption.. 
public static String decrypt(String cipher_text, int cipher_key) {
    StringBuilder decryptedText = new StringBuilder();
    for (int i = 0; i < cipher_text.length(); i++) {
      char ch = cipher_text.charAt(i);


      // Check for the case of the character..   
      if (Character.isUpperCase(ch)) {
        char c1 = (char) ((ch - cipher_key - 'A' + 26) % 26 + 'A');
        decryptedText.append(c1);
      } else if (Character.isLowerCase(ch)) {
        char c1 = (char) ((ch - cipher_key - 'a' + 26) % 26 + 'a');
        decryptedText.append(c1);
      } else {
        decryptedText.append(ch);
      }
    }
    return decryptedText.toString();
}


// This function is for Brute-Forcing..
public static int brute_force(String plain_text, String cipher_Text, int key) {
    String keyCipherText = encrypt(plain_text, key);


    // Checking whether Give Cipher and generated Cipher are equal or not..
    if (keyCipherText.equals(cipher_Text)) {
        return key;
    }
    return -1;
}
}                                                                                                             
                                                                                                             