package org.packages;


import org.packages.packageA.ClassName;  //import a single class from package
import org.packages.packageC.*;          //import the whole package

/**
 * Package in Java is used to group related classes (think of it as a folder in a file directory)
 * We use packages to avoid name conflicts.
 * There can be multiple classes in different package(see packageA,packageB).
 * Based on which class from which package we import, we can used it.
 *
 * Access modifiers (private/default/public/protected) specifies the accessibility or scope of a
 * field, method, constructor, or class.
 *
 * PRIVATE   = accessible within our class only
 * DEFAULT   = accessible within our class + within package
 * PROTECTED = accessible within our class + within package + outside package by subclass only
 * PUBLIC    = accessible from everywhere
 */
public class PackagesExample1 {
    public static void main(String[] args) {
        ClassName classObject = new ClassName();
        classObject.method();

        AccessModifiersClass accessExample = new AccessModifiersClass();

        //Only PUBLIC attributes and methods will be working, because AccessModifierClass is in different package
        //System.out.println("Private attribute: " + accessExample.privateAttribute);     //Won't work - not in same class
        //System.out.println("Default attribute: " + accessExample.defaultAttribute);     //Won't work - not in same package
        //System.out.println("Protected attribute: " + accessExample.protectedAttribute); //Won't work - not in same package or in subclass
        System.out.println("Public attribute: " + accessExample.publicAttribute);

        //accessExample.privateMethod();     //Won't work - not in same class
        //accessExample.defaultMethod();     //Won't work - not in same package
        //accessExample.protectedMethod();   //Won't work - not in same package or in subclass
        accessExample.publicMethod();

    }
}
