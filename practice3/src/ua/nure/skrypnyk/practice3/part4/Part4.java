package ua.nure.skrypnyk.practice3.part4;

import java.security.*;

public class Part4 {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println(hash("password", "SHA-256"));
        System.out.println(hash("passwort", "SHA-256"));
    }

    public static String hash(String input, String algorithm) throws NoSuchAlgorithmException {
        String result;
        MessageDigest digest = MessageDigest.getInstance(algorithm);
        digest.update(input.getBytes());
        byte[] hash = digest.digest();
        result = byteToInt16(hash);

        return result;
    }

    public static String byteToInt16(byte[] hash) {
        StringBuilder sb = new StringBuilder();
        for (byte b : hash){
            sb.append(String.format("%02X ", b));
        }
       return sb.toString();
    }

}
