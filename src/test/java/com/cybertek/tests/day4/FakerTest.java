package com.cybertek.tests.day4;

import com.github.javafaker.Faker;

public class FakerTest {
    public static void main(String[] args) {
        Faker faker = new Faker();
        //create an object of faker class
        String fact = faker.chuckNorris().fact();
        //create a string of random methods
        System.out.println(fact);
        System.out.println(faker.artist().name());
        //another method
        String str=faker.chuckNorris().fact();

    }
}