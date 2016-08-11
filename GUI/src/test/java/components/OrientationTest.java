package components;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static components.Orientation.Horizontal;
import static components.Orientation.Vertical;
import static org.testng.Assert.assertEquals;


public class OrientationTest {

    @DataProvider
    private Object[][] orientationNext() {
        return new Object[][]{
                {Vertical, Horizontal},
                {Horizontal, Vertical},
        };
    }

    @Test(dataProvider = "orientationNext")
    public void testOrientationNext(Orientation given, Orientation expected) {
        // given

        // when - then
        assertEquals(given.next(), expected);
    }
}