package com.blockchain.util;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class Helper {
    static String chars = "abcdefghijklmnopqrstuvwxyz";
    static String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static String NUMS = "1234567890";
    static String SPEC = "@#$%^&+=";


    public static String passwordGenerator() {
        int index;
        String pass = "";
        Random rnd = new Random();

        // 2 random chars from 'chars'
        index = rnd.nextInt(chars.length());
        pass += chars.charAt(index);
        index = rnd.nextInt(chars.length());
        pass += chars.charAt(index);

        // 2 random chars from 'CHARS'
        index = rnd.nextInt(CHARS.length());
        pass += CHARS.charAt(index);
        index = rnd.nextInt(CHARS.length());
        pass += CHARS.charAt(index);

        // 2 random chars from 'NUMS'
        index = rnd.nextInt(NUMS.length());
        pass += NUMS.charAt(index);
        index = rnd.nextInt(NUMS.length());
        pass += NUMS.charAt(index);

        // 2 random chars from 'SPEC'
        index = rnd.nextInt(SPEC.length());
        pass += SPEC.charAt(index);
        index = rnd.nextInt(SPEC.length());
        pass += SPEC.charAt(index);

        return pass;
    }

    public static String generateRandomEmail() {
        String email = "";
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        email = "crypto"+ randomInt +"@gmail.com";
        return email;
    }
}
