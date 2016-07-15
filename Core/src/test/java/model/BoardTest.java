package model;

import model.board.Board;
import model.field.Field;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Hawk on 2016-07-15.
 */
public class BoardTest {

    @Test
    public void testPlacePlayerMove() {
        // given
        Board board = new Board();
        Field field = new Field("A", "1");
        field.makeOccupied();

        // when
        board.placePlayerMove(field);

        // then
        Assert.assertEquals(board.getFieldForCoordinates("A", "1"), field);
    }
}
