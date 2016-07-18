package model.board.initializer;

import org.testng.annotations.Test;

import static org.testng.Assert.assertSame;

/**
 * Created by Hawk on 2016-07-15.
 */
public class BoardFieldsInitializerTest {

    @Test
    public void testInitialization(){
        // given
        BoardFieldsInitializer boardFieldsInitializer = new BoardFieldsInitializer();

        // when - then
        assertSame(boardFieldsInitializer.getInitialFields().size(), 100);
    }


}




