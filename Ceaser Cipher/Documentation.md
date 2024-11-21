# *Caesar Cipher Documentation*

## *Overview*

This Java program implements the Caesar Cipher encryption, decryption, and brute-force attack techniques. The program is interactive and menu-driven, allowing users to easily choose their desired operation. Additionally, it displays random motivational quotes upon exiting.

## *Features*

- *Encryption*: Encrypts plaintext messages using a shift key.
- *Decryption*: Decrypts ciphertext messages using the same key.
- *Brute-Force*: Determines the key by comparing plaintext and ciphertext.
- *Random Quotes*: Displays a motivational quote from a file on exit.
- *Error Handling*: Handles invalid inputs gracefully.

## *Requirements*

- Java Development Kit (JDK)
- A text file containing quotes (quotes.txt) in the specified directory.

## *Usage*

### *Compiling and Running*

1. Save the code to a file named ceaser.java.
2. Ensure the quotes file is present at the specified path in the code.
3. Compile and run the program using:
   bash
   javac ceaser.java
   java ceaser
   

### *Menu Options*

Upon running the program, you will see the following menu:

1. *Encryption*: Encrypts a plaintext message using a shift key.
2. *Decryption*: Decrypts a ciphertext message using a shift key.
3. *Brute-Force*: Finds the key by comparing plaintext and ciphertext.
4. *Exit*: Exits the program and displays a random motivational quote.

## *Functions*

### **1. main(String[] args)**

- *Description*: Entry point of the program. Handles the interactive menu and calls other functions.
- *Parameters*: String[] args - Command-line arguments (not used).

### **2. encrypt(String plaintext, int key)**

- *Description*: Encrypts plaintext by shifting characters based on the given key.
- *Parameters*:
  - plaintext (String): The text to encrypt.
  - key (int): The shift key (0–25).
- *Returns*: Encrypted ciphertext (String).

### **3. decrypt(String cipher_text, int cipher_key)**

- *Description*: Decrypts ciphertext by reversing the shift applied during encryption.
- *Parameters*:
  - cipher_text (String): The text to decrypt.
  - cipher_key (int): The shift key (0–25).
- *Returns*: Decrypted plaintext (String).

### **4. brute_force(String plain_text, String cipher_Text, int key)**

- *Description*: Attempts to match the ciphertext with the plaintext using all possible keys.
- *Parameters*:
  - plain_text (String): The original plaintext.
  - cipher_Text (String): The ciphertext to match.
  - key (int): The current key being tested.
- *Returns*: The valid key (int) if found, otherwise -1.

## *Error Handling*

- *Invalid Key Input*: Ensures that encryption and decryption keys are between 0–25.
- *Input Mismatch*: Prevents crashes when non-numeric inputs are provided for numeric prompts.

## *Random Quotes Feature*

- The program reads motivational quotes from a quotes.txt file located at:
  
  C:\Users\HP\Desktop\GitHub\Basic-Ciphers\Ceaser Cipher\quotes.txt
  
- A random quote is displayed upon exiting the program.

## *Example Usage*

### *Encryption*

Input:


[-] Enter Plain Text: hello
[-] Enter Encryption Key: 3


Output:


[-] Encrypted Text is: khoor


### *Decryption*

Input:


[-] Enter Cipher Text: khoor
[-] Enter Cipher Key: 3


Output:


[-] Decrypted Text: hello


### *Brute-Force*

Input:


[-] Enter Plain Text: hello
[-] Enter Cipher Text: khoor


Output:


[-] Valid Key is: 3


## *Author*

Developed as an educational implementation of the Caesar Cipher algorithm by *@rootxarjun*.

## *License*

This program is free to use for educational purposes.