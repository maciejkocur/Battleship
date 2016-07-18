package model.coordinate;

import model.coordinate.Coordinate;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static model.coordinate.Sign.A;
import static model.coordinate.Sign.H;
import static org.testng.Assert.assertEquals;

public class CoordinateTest {

    @DataProvider
    public Object[][] coordinatesProvider() {
        return new Object[][]{
                {new Coordinate(A, "1"), "A1"},
                {new Coordinate(A, "10"), "A10"},
                {new Coordinate(H, "5"), "H5"},
        };
    }

    @Test(dataProvider = "coordinatesProvider")
    public void testSettingCoordinates(Coordinate coordinate, String expectedValue) {
        // given

        // when - then
        assertEquals(coordinate.toString(), expectedValue);
    }

    @Test
    public void testEqualityOfCoordinates(){
        // given
        Coordinate firstCoordinateA1 = new Coordinate(A, "1");
        Coordinate secondCoordinateA1 = new Coordinate(A, "1");
        Coordinate thirdCoordinateA1 = new Coordinate(A, "1");


        // when - then
        // reflexive
        assertEquals(firstCoordinateA1, firstCoordinateA1);
        // symmetric
        assertEquals(firstCoordinateA1, secondCoordinateA1);
        assertEquals(secondCoordinateA1, firstCoordinateA1);
        // transitive
        assertEquals(firstCoordinateA1, thirdCoordinateA1);
    }

}
