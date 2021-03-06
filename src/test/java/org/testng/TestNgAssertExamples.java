package org.testng;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;
import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertNull;
import static org.testng.AssertJUnit.assertNotNull;

/**
 * TestNG asserts lets you test if actual objects or values within one test are as expected.
 * If yes -> test will succeed
 * If no  -> test will fail
 *
 * Hard assert -> test will stop execution when assert statement fails (other asserts are not validated) - default assert type
 * Soft assert -> test will continue with execution even when assert fails (other asserts are still validated)
 *
 * Important: there are multiple asserts package in TestNG, and they have different syntax, so watch out for which one
 * do you import and use. See method {@link TestNgAssertExamples#differentAsserts()}
 */
public class TestNgAssertExamples {

    @Test
    public void hardAssertsExampleThatWillSucceed() {
        assertEquals("true is true", true, true);
        assertEquals("int 10 is 10", 10, 10);
        assertEquals("String ABC is ABC", "ABC", "ABC");
        assertTrue("Expression is true", true);
        assertFalse("Expression is false", false);
        assertNull("Expression is null", null);
        assertNotNull("Expression is not null", 42);

        System.out.println("All hard asserts were successfully executed");
    }

    @Test
    public void hardAssertsExampleThatWillFail() {
        assertEquals("true is true", true, true);
        assertEquals("int 10 is 10", 10, 10);
        assertEquals("String ABC is ABC", "ABC", "OTHER ASSERTS WON'T BE PROCESSED");
        assertTrue("Expression is true", true);
        assertFalse("Expression is false", false);
        assertNull("Expression is null", null);
        assertNotNull("Expression is not null", 42);
        assertTrue(false);  //We won't see result of this assert, because 3rd hard assert will fail

        System.out.println("NOT all hard asserts were successfully executed - test method is skipped after first fail");
    }

    @Test
    public void softAssertsExampleThatWillFail() {
        //We need to create object of class SoftAssert for each method
        SoftAssert softassert = new SoftAssert();

        softassert.assertEquals(true, true, "true is true");
        softassert.assertEquals(10, 10, "int 10 is 10");
        softassert.assertEquals("ABC", "other asserts will still be processed", "String ABC is ABC");
        softassert.assertTrue(true, "Expression is true");
        softassert.assertFalse(false, "Expression is false");
        softassert.assertNull(null, "Expression is null");
        softassert.assertNotNull(42, "Expression is not null");
        softassert.assertTrue(false); //We will see result even of this assert

        System.out.println("All soft asserts were successfully executed");

        //You need to run soft assert manually, otherwise test will pass even if asserts failed!!!
        //All assertion errors will be printed
        softassert.assertAll();
    }

    @Test
    public void softAssertsExampleThatWillSucceed() {
        //We need to create object of class SoftAssert for each method
        SoftAssert softassert = new SoftAssert();

        softassert.assertEquals(true, true, "true is true");
        softassert.assertEquals(10, 10, "int 10 is 10");
        softassert.assertEquals("ABC", "ABC", "String ABC is ABC");
        softassert.assertTrue(true, "Expression is true");
        softassert.assertFalse(false, "Expression is false");
        softassert.assertNull(null, "Expression is null");
        softassert.assertNotNull(42, "Expression is not null");

        System.out.println("All soft asserts were successfully executed");

        //You need to run soft assert manually, otherwise test will pass even if asserts failed!!!
        //All assertion errors will be printed
        softassert.assertAll();
    }

    /**
     * This test demonstrates different syntax of asserts with identical name in different packages.
     * You must check what assert you import, because on import you use, different syntax may be used.
     * Also, be aware of not switching actual and expected objects. It will help you out with debugging application.
     */
    @Test
    public void differentAsserts() {
        //This assert from package org.testng.AssertJUnit uses syntax: assertEquals(message, expected, actual);
        org.testng.AssertJUnit.assertEquals("Strings are equal", "str1", "str1");
        //This assert from package org.testng.Assert uses syntax: assertEquals(actual, expected, message)
        org.testng.Assert.assertEquals("str1", "str1", "Strings are equal");
        //This assert from package org.junit.Assert uses syntax: assertEquals(message, expected, actual
        org.junit.Assert.assertEquals("Strings are equal", "str1", "str1");
    }
}
