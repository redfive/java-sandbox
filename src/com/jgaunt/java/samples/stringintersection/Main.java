package com.jgaunt.java.samples.stringintersection;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.HashMap;
import java.util.Set;
import java.util.Map;
import java.util.Iterator;
import java.util.Map.Entry;
import java.lang.Character;
import java.lang.Integer;

/**
 * Purpose of this class is to find the character with the greatest intersection
 *   between two Strings. 
 */
public class Main {
    public static Character findIntersection ( String aStringA, String aStringB) {

        // store the counts for each character for each string
        HashMap <Character, Integer> mapA = new HashMap<Character, Integer>();
        HashMap <Character, Integer> mapB = new HashMap<Character, Integer>();

        // build up the map for stringA
        StringCharacterIterator iterA = new StringCharacterIterator(aStringA);
        for(char c = iterA.first(); c != CharacterIterator.DONE; c = iterA.next()) {
            Character cchar = new Character(c);
            if (mapA.containsKey(cchar)) {
                Integer value = mapA.get(cchar);
                mapA.put(cchar, value+1);
            } else {
                mapA.put(cchar, new Integer(1));
            }
        }

        // build up the map for stringB
        StringCharacterIterator iterB = new StringCharacterIterator(aStringB);
        for(char c = iterB.first(); c != CharacterIterator.DONE; c = iterB.next()) {
            Character cchar = new Character(c);
            if (mapB.containsKey(cchar)) {
                Integer value = mapB.get(cchar);
                mapB.put(cchar, value+1);
            } else {
                mapB.put(cchar, new Integer(1));
            }
        }

        // the two HashMaps now have counts for each letter contained in the input strings

        // cash the current intersection character and it's count
        Character maxChar = ' ';
        Integer maxCount = 0;

        // Iterate over the first string's map and compare that to the second map
        //   directly to avoid an O(n^2) operation. Another optimization here would
        //   be to pick the shorter of the two maps but given that at most we're 
        //   talking about 26 characters, for this problem not a big gain.
        Set <Map.Entry<Character, Integer>> setA = mapA.entrySet();
        Iterator <Map.Entry<Character, Integer>> setIterA = setA.iterator();
        while ( setIterA.hasNext() ) {
            Map.Entry<Character, Integer> mapAEntry = setIterA.next();

            // look up the values only once
            Character curChar = mapAEntry.getKey();
            Integer curCount = mapAEntry.getValue();
            if ( mapB.containsKey( curChar ) ) {
                // There is an intersection now, the value will be the smaller
                // of the two counts.
                Integer intersectionCount = 0;
                Integer countB = mapB.get(curChar);
                if ( curCount < countB ) {
                    intersectionCount = curCount;
                } else {
                    intersectionCount = countB;
                }

                // Check to see if this intersection is bigger. Ties go to the
                // first one found.
                if (intersectionCount > maxCount) {
                    maxCount = intersectionCount;
                    maxChar = curChar;
                }
            }
        }
        return maxChar;
    }

    public static void main (String [] args) {
        if (args.length != 2) {
            System.out.println("Usage: com.jgaunt.java.samples.stringintersection.main <string> <string>");
            return;
        }
        System.out.println( findIntersection(args[0], args[1]) );
    }
}
