

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CoordinatesTest {

    @DataProvider
    public Object[][] CoordinatesProvider() {
        return new Object[][]{{"1A", new Coordinates("1", "A")},
                {"10A", new Coordinates("10", "A")},
                {"5H", new Coordinates("5", "H")},
        };
    }

    @Test(dataProvider = "CoordinatesProvider")
    public void SettingCoordinatesTest(String s, Coordinates coordinates) {
        // Then
        Assert.assertEquals(s, coordinates.toString());
    }

}
