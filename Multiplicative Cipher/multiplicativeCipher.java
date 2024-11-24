import java.util.InputMismatchException;
import java.util.Scanner;

public class multiplicativeCipher {
    public static void main(String[] args) {
        Scanner userinput = new Scanner(System.in);
        while (true) {
            System.out.print("\n-------------------------------------------------------------------\n");
            System.out.println("\n 1. Encryption \n 2. Decryption \n 3. Brute-Force \n 4. Exit \n ");
            System.out.print("[-] Enter the Task to be Performed: ");
            int choice;
            // Selecting User's Choice..
            try {
                choice = userinput.nextInt();
            } catch (InputMismatchException e) {
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
                            System.out.print("[-] Please Enter A Encryption Key Between 0-25");
                            continue;
                        }

                    } catch (Exception e) {
                        System.out.print("[-] Error Invalid Values Detected.");
                        continue;
                    }

                    //String encrypted = encrypt(plaintext, encrypt_key);
                    System.out.print("[-] Encrypted Text is: " + encrypted + "\n");
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
                            System.out.print("[-] Please Enter A Encryption Key Between 0-25");
                            continue;
                        }

                    } catch (Exception e) {
                        System.out.print("[-] Error Invalid Values Detected.");
                        continue;
                    }
                    // String decrypted = decrypt(cipher_text, cipher_key);
                    //System.out.print("[-] Decrypted Text: " + decrypted + "\n");
                    break;

                // This case if for Brute-Forcing..
                case 3:
                    System.out.print("[-] Enter Plain Text: ");
                    String plain_text = userinput.nextLine();
                    System.out.print("[-] Enter Cipher Text: ");
                    String cipher_Text = userinput.nextLine();
                    int expected_key = 0;
                    int count = -1;
                    for (int i = 0; i < 26; i++) {
                      //  expected_key = brute_force(plain_text, cipher_Text, i);
                        if (expected_key != -1) {
                            System.out.println("[-] Valid Key is: " + expected_key);
                            break;
                        } else {
                            count++;
                        }
                    }
                    if (count == 25) {
                        System.out.println("[-] Key Not Found. Or Plain Text and Cipher Text is wrong.. ");
                    }
                    break;

                // This case is for Exiting Our prompt..
                case 4:
                    System.out.print("[-] ThankYou For using Ceaser Cipher.\n");
                    System.out.print("[-] Exiting....");
                    userinput.close();
                    System.exit(0);
                    break;

                // Default to this prompt if user tries to enter Numeric options other than provided..
                default:
                    System.out.print("[-] Error: Invalid input. Please enter a number (1-4).");
                    break;
            }
        }

    }
    
}
