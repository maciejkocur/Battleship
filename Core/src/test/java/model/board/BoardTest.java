package model.board;

import model.coordinate.Coordinate;
import model.field.Field;
import org.testng.Assert;
import org.testng.annotations.Test;

import static model.coordinate.Sign.A;

/**
 * Created by Hawk on 2016-07-15.
 */
public class BoardTest {

    @Test
    public void testPlacePlayerMoveAndGetCoordinates() {
        // given
        Board board = new Board();
        Coordinate coordinate = new Coordinate(A, 1);
        Field field = new Field(coordinate, Boolean.TRUE);

        // when
        board.placePlayerMove(field);

        // then
        Assert.assertEquals(board.getFieldForCoordinate(coordinate), field);
    }

}
