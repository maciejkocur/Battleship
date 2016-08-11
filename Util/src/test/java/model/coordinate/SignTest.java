package model.coordinate;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;

import static model.coordinate.Sign.*;
import static org.testng.Assert.assertEquals;

/**
 * Created by lucz on 18.07.16.
 */
public class SignTest {

    @DataProvider
    private static final Object[][] getNextSign() {
        return new Object[][]{
                {A, B},
                {B, C},
                {C, D},
                {D, E},
                {E, F},
                {F, G},
                {G, H},
                {H, I},
                {I, J},
                {J, A}
        };
    }

    @Test(dataProvider = "getNextSign")
    public void testGetNextSign(Sign currentSign, Sign expectedNextSign) {
        // given

        // when - then
        assertEquals(currentSign.next(), expectedNextSign);
    }


    @DataProvider
    private static final Object[][] getPreviousSign() {
        return new Object[][]{
                {J, I},
                {I, H},
                {H, G},
                {G, F},
                {F, E},
                {E, D},
                {D, C},
                {C, B},
                {B, A},
                {A, J}
        };
    }

    @Test(dataProvider = "getPreviousSign")
    public void testGetPreviousSign(Sign currentSign, Sign expectedNextSign) {
        // given

        // when - then
        assertEquals(currentSign.previous(), expectedNextSign);
    }

    @DataProvider
    private Object[][] getValueOfInteger() {
        return new Object[][]{
                {0, A},
                {1, B},
                {2, C},
                {3, D},
                {4, E},
                {5, F},
                {6, G},
                {7, H},
                {8, I},
                {9, J},
        };
    }

    @Test(dataProvider = "getValueOfInteger")
    public void testGetValueOfInteger(int ID, Sign expectedSign) {
        // given

        // when - then
        assertEquals(Sign.valueOf(ID), expectedSign);
    }

    @Test(expectedExceptions = {NoSuchElementException.class})
    public void testValueOfNegativeInteger() {
        // given
        int ID = -1;

        // when - then;
        Sign.valueOf(ID);
    }

    @Test(expectedExceptions = {NoSuchElementException.class})
    public void testValueOfGraterThenMaxOrdinal(){
        // given
        int ID = 10;

        // when - then
        Sign.valueOf(ID);
    }

    @DataProvider
    private static final Object[][] getValueOfString() {
        return new Object[][]{
                {"A", A},
                {"B", B},
                {"C", C},
                {"D", D},
                {"E", E},
                {"F", F},
                {"G", G},
                {"H", H},
                {"I", I},
                {"J", J}
        };
    }

    @Test(dataProvider = "getValueOfString")
    public void testGetValueOfString(String givenString , Sign expectedSign){
        // given

        // when - then
        assertEquals(Sign.valueOf(givenString),expectedSign);
    }

    @Test(expectedExceptions = {IllegalArgumentException.class})
    public void testValueOfWrongString() {
        // given
        String wrongName = "W";

        // when - then;
        Sign.valueOf(wrongName);
    }



}
