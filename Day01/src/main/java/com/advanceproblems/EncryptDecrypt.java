package com.advanceproblems;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.*;
import java.util.Base64;

public class EncryptDecrypt {
    private static final String CSV_FILE = "output.csv";
    private static final String ENCRYPTED_CSV_FILE = "encrypted_data.csv";
    private static SecretKey secretKey;

    public static void main(String[] args) throws Exception {
        // Generate AES key
        secretKey = generateKey();

        // Sample Data
        String[][] data = {
                {"ID", "Name", "Salary", "Email"},
                {"101", "John", "50000", "john@example.com"},
                {"102", "Alice", "60000", "alice@example.com"},
                {"103", "Bob", "70000", "bob@example.com"}
        };

        // Encrypt and Write to CSV
        encryptAndWriteCSV(data);

        // Read and Decrypt CSV
        readAndDecryptCSV();
    }

    // Generate AES Secret Key
    private static SecretKey generateKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128); // AES 128-bit key
        return keyGen.generateKey();
    }

    // Encrypt data and write to CSV
    private static void encryptAndWriteCSV(String[][] data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ENCRYPTED_CSV_FILE))) {
            for (String[] row : data) {
                String encryptedSalary = encrypt(row[2]); // Encrypt Salary
                String encryptedEmail = encrypt(row[3]);  // Encrypt Email

                writer.write(row[0] + "," + row[1] + "," + encryptedSalary + "," + encryptedEmail);
                writer.newLine();
            }
            System.out.println("Encrypted data written to " + ENCRYPTED_CSV_FILE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Read encrypted CSV and decrypt the sensitive fields
    private static void readAndDecryptCSV() {
        try (BufferedReader reader = new BufferedReader(new FileReader(ENCRYPTED_CSV_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                String decryptedSalary = decrypt(values[2]); // Decrypt Salary
                String decryptedEmail = decrypt(values[3]);  // Decrypt Email

                System.out.println(values[0] + " | " + values[1] + " | " + decryptedSalary + " | " + decryptedEmail);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // AES Encryption
    private static String encrypt(String data) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    // AES Decryption
    private static String decrypt(String encryptedData) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decodedBytes = Base64.getDecoder().decode(encryptedData);
        byte[] decryptedBytes = cipher.doFinal(decodedBytes);
        return new String(decryptedBytes);
    }
}

