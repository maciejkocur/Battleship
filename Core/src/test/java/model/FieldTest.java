package model;

import model.field.Field;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by Hawk on 2016-07-15.
 */
public class FieldTest {

    @DataProvider
    private final static Object[][] getFields() {
        return new Object[][]{
                {new Field("A", "1"), "A1"},
                {new Field("B", "2"), "B2"},
                {new Field("C", "8"), "C8"},
                {new Field("D", "5"), "D5"},
                {new Field("E", "10"), "E10"},
                {new Field("F", "3"), "F3"},
                {new Field("G", "4"), "G4"},
                {new Field("H", "7"), "H7"},
                {new Field("I", "6"), "I6"},
                {new Field("J", "9"), "J9"},
        };
    }


    @Test(dataProvider = "getFields")
    public void testShowCoordinates(Field field, String expectedCoordinates) {
        // given
        // when - then
        assertEquals(field.showCoordinates(), expectedCoordinates);
    }

    @Test
    public void testIsOccupied() {
        // given
        Field field = new Field("B", "2");

        // when
        field.makeOccupied();

        // then
        assertTrue(field.isOccupied());
    }

    @Test
    public void testEqualityOfFields(){
        // given
        Field firstFieldA1 = new Field("A", "1");
        Field secondFieldA1 = new Field("A", "1");
        Field thirdFieldA1 = new Field("A", "1");


        // when - then
        // reflexive
        assertEquals(firstFieldA1, firstFieldA1);
        // symmetric
        assertEquals(firstFieldA1, secondFieldA1);
        assertEquals(secondFieldA1, firstFieldA1);
        // transitive
        assertEquals(firstFieldA1, thirdFieldA1);
    }
}

