package org.syntax;

/**
 * String and methods for working with Strings
 */
public class Strings {
    public static void main(String[] args) {
        String str = "Hello World!";
        String str2 = "This is \"me\" again\n";

        System.out.println("String is " + str);
        System.out.println("String length is: " + str.length());
        System.out.println("Uppercase string is: " + str.toUpperCase());
        System.out.println("Lowercase string is: " + str.toLowerCase());
        System.out.println("Index of 'World' is: " + str.indexOf("World"));
        System.out.println("String concatenation is: " + str + " " + str2);
        System.out.println("Character at position 1 is: " + str.charAt(1));
        System.out.println("String repeated 3 times is: " + str.repeat(3));
        System.out.println("String starts with He: " + str.startsWith("He"));
        System.out.println("String ends with ???: " + str.endsWith("???"));
        System.out.println("Str1 equals Str2: " + str.equals(str2));
        System.out.println("String is empty: " + str.isEmpty());
        System.out.println("All ! are replaced with ???: " + str.replace("!", "???"));
        System.out.println("All leading and trailing spaces are trimmer: " + str2.trim());
        System.out.println("Substring starting from index 6 is: " + str.substring(5));
        System.out.println("Substring starting from index 6 and ending with index 10 is: " + str.substring(6, 10));

        String string1 = new String("string");     //creates a separate object in memory
        String string2 = new String("string");     //creates a separate object in memory
        String string3 = "string";                        //creates a separate object in memory
        String string4 = "string";                        //will use same object in memory as object string3
        System.out.println(string1.equals(string2));      //prints true - compares value of string
        System.out.println(string1 == string2);           //prints false - compares references to objects
        System.out.println(string3 == string4);           //prints true - compares references to objects
    }
}
