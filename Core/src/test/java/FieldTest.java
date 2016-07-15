import model.field.Field;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by Hawk on 2016-07-15.
 */
public class FieldTest {

    @Test
    public void testShowCoordinates(){
        // given
        Field field = new Field("A", "1");

        // when - then
        Assert.assertEquals(field.showCoordinates(), "A1");
    }
}
