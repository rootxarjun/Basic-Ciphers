# Ceaser Cipher Program Documentation

## Overview
This program implements the **Ceaser Cipher**, a basic encryption technique that shifts letters of the alphabet by a specified key. The program supports:
1. **Encryption**: Converting plaintext to ciphertext.
2. **Decryption**: Converting ciphertext back to plaintext.
3. **Brute-Force**: Identifying the encryption key by comparing plaintext and ciphertext.

---

## Features
1. **Encryption**: Shift plaintext characters using a key.
2. **Decryption**: Reverse the encryption using the same key.
3. **Brute-Force**: Find the encryption key by comparing inputs.
4. **Quotes**: Random motivational quote on exit.

---

## Input and Output Examples

### 1. **Encryption**
- **Input**:  
  - Plaintext: `Hello`  
  - Key: `5`
- **Output**:  
  - Ciphertext: `Mjqqt`

### 2. **Decryption**
- **Input**:  
  - Ciphertext: `Mjqqt`  
  - Key: `5`
- **Output**:  
  - Plaintext: `Hello`

### 3. **Brute-Force**
- **Input**:  
  - Plaintext: `Hello`  
  - Ciphertext: `Mjqqt`  
- **Output**:  
  - Key: `5`

---

## How It Works

### 1. **Encryption**  
Shifts each character of the plaintext by the encryption key.  
- **Example**:  
  Plaintext: `Hello`  
  Key: `5`  
  Encryption Formula:  
  - `Encrypted_Char = (Char + Key) mod 26`  
  Result: `Mjqqt`

### 2. **Decryption**  
Shifts each character of the ciphertext in reverse by the same key.  
- **Example**:  
  Ciphertext: `Mjqqt`  
  Key: `5`  
  Decryption Formula:  
  - `Decrypted_Char = (Char - Key + 26) mod 26`  
  Result: `Hello`

### 3. **Brute-Force**  
Tries every possible key (0-25) to match the provided ciphertext to the plaintext.  
- **Example**:  
  Plaintext: `Hello`  
  Ciphertext: `Mjqqt`  
  Output: Key = `5`

---

## Program Components

### 1. **Menu**  
The program provides a menu with four options:
- Encryption
- Decryption
- Brute-Force
- Exit  

### 2. **Error Handling**  
- Handles invalid inputs and provides prompts for correction.
- Ensures the key is within the valid range (0-25).

### 3. **File Handling**  
Reads motivational quotes from `quotes.txt` and displays a random one when the program exits.

---