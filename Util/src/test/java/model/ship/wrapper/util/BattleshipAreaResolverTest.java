package model.ship.wrapper.util;

import model.coordinate.Coordinate;
import model.ship.impl.Battleship;
import model.ship.wrapper.util.BattleshipAreaResolver;
import org.apache.commons.collections4.ListUtils;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static model.coordinate.Sign.*;
import static org.testng.Assert.assertTrue;

public class BattleshipAreaResolverTest {

    @Test
    public void testFindCoordinatesAroundShipInLeftTopCorner(){
        // given
        Battleship smallShip = new Battleship(Arrays.asList(new Coordinate(A, 1)));
        List<Coordinate> expectedCoordinatesAroundShip = Arrays.asList(new Coordinate(A, 2), new Coordinate(B, 1), new Coordinate(B, 2));

        // when - then
        assertTrue(ListUtils.isEqualList(BattleshipAreaResolver.findCoordinatesAroundShip(smallShip), expectedCoordinatesAroundShip));
    }

    @Test
    public void testFindCoordinatesAroundShipInLeftBottomCorner(){
        // given
        Battleship smallShip = new Battleship(Arrays.asList(new Coordinate(J, 1)));
        List<Coordinate> expectedCoordinatesAroundShip = Arrays.asList(new Coordinate(I, 1), new Coordinate(I, 2), new Coordinate(J, 2));

        // when - then
        assertTrue(ListUtils.isEqualList(BattleshipAreaResolver.findCoordinatesAroundShip(smallShip), expectedCoordinatesAroundShip));
    }

    @Test
    public void testFindCoordinatesAroundShipInRightTopCorner(){
        // given
        Battleship smallShip = new Battleship(Arrays.asList(new Coordinate(A, 10)));
        List<Coordinate> expectedCoordinatesAroundShip = Arrays.asList(new Coordinate(A, 9), new Coordinate(B, 9), new Coordinate(B, 10));

        // when - then
        assertTrue(ListUtils.isEqualList(BattleshipAreaResolver.findCoordinatesAroundShip(smallShip), expectedCoordinatesAroundShip));
    }

    @Test
    public void testFindCoordinatesAroundShipInRightBottomCorner(){
        // given
        Battleship smallShip = new Battleship(Arrays.asList(new Coordinate(J, 10)));
        List<Coordinate> expectedCoordinatesAroundShip = Arrays.asList(new Coordinate(I, 9), new Coordinate(I, 10), new Coordinate(J, 9));

        // when - then
        assertTrue(ListUtils.isEqualList(BattleshipAreaResolver.findCoordinatesAroundShip(smallShip), expectedCoordinatesAroundShip));
    }
}
