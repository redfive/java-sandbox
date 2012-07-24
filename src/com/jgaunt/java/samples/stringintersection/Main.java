package com.jgaunt.java.samples.stringintersection;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.HashMap;
import java.lang.Character;
import java.lang.Integer;

public class Main {
    public static void main (String [] args) {
        String stringA = "aabbccdd";
        String stringB = "abcdd";

        HashMap <Character, Integer> mapA = new HashMap<Character, Integer>();
        HashMap <Character, Integer> mapB = new HashMap<Character, Integer>();

        StringCharacterIterator iterA = new StringCharacterIterator(stringA);
        for(char c = iterA.first(); c != CharacterIterator.DONE; c = iterA.next()) {
            Character cchar = new Character(c);
            if (mapA.containsKey(cchar)) {
                Integer value = mapA.get(cchar);
                mapA.put(cchar, value+1);
            } else {
                mapA.put(cchar, new Integer(1));
            }
        }
        System.out.println(mapA);

        StringCharacterIterator iterB = new StringCharacterIterator(stringB);
        for(char c = iterB.first(); c != CharacterIterator.DONE; c = iterB.next()) {
            Character cchar = new Character(c);
            if (mapB.containsKey(cchar)) {
                Integer value = mapB.get(cchar);
                mapB.put(cchar, value+1);
            } else {
                mapB.put(cchar, new Integer(1));
            }
        }
        System.out.println(mapB);

    }
}
