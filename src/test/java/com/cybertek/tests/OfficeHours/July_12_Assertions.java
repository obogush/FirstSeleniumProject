package com.cybertek.tests.OfficeHours;

import static org.testng.Assert.*;   // this step imports all the static features from the assert class
import org.testng.Assert;
import org.testng.annotations.Test;

public class July_12_Assertions {

    /*
    Assertion class:
            used to verify the condition of the test cases

            assertTrue( boolean ):  argument must be true boolean expression, or else the remaining test steps won't be executed
            assertFalse( boolean ); argument must be false boolean expression
            assertEquals( variable1, variable2); arguments MUSt be equal
            assertNotEquals(variable1, variable 2): arguments can be equal

            they are static methods. they can be called through classname
            import static  of Assert class will import all the static features from the Assert class


     */

    @Test
    public void method1(){
       Assert.assertTrue( 1==1 );
         assertTrue(1==1);

        System.out.println("Test 1 completed ");

    }

    @Test
    public void method2(){

        assertFalse( 1 > 2 );
        System.out.println("Test 2 completed");

    }

    @Test
    public void method3(){
        assertEquals( 1,2);
        System.out.println("Test 3 completed");
    }


    @Test
    public void method4(){
        assertNotEquals( "Batch11", "Best Batch");
        System.out.println("test 4 completed");

    }





}
