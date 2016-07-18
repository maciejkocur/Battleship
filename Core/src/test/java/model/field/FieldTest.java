package model.field;

import model.coordinate.Coordinate;
import org.testng.annotations.Test;

import static model.coordinate.Sign.A;
import static org.testng.Assert.assertEquals;

/**
 * Created by Hawk on 2016-07-15.
 */
public class FieldTest {

    @Test
    public void testEqualityOfFields() {
        // given
        Field firstFieldA1 = new Field(new Coordinate(A, "1"));
        Field secondFieldA1 = new Field(new Coordinate(A, "1"));
        Field thirdFieldA1 = new Field(new Coordinate(A, "1"));

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

