package model.coordinate;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static model.coordinate.Sign.*;
import static org.testng.Assert.assertEquals;

/**
 * Created by lucz on 18.07.16.
 */
public class SignTest {

    @DataProvider
    private static final Object[][] getNextSign(){
        return new  Object[][]{
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
    public void testGetNextSign(Sign currentSign, Sign expectedNextSign){
        // given

        // when - then
        assertEquals(currentSign.next(), expectedNextSign);
    }


    @DataProvider
    private static final Object[][] getPreviousSign(){
        return new  Object[][]{
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
    public void testGetPreviousSign(Sign currentSign, Sign expectedNextSign){
        // given

        // when - then
        assertEquals(currentSign.previous(), expectedNextSign);
    }


}
