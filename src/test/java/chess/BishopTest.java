package chess;

import static chess.ListHelpers.toPositionList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import chess.pieces.Bishop;

public class BishopTest {
    
    private GameState initialState;

    @Before
    public void setUp() {
        initialState = new GameState();
    }
    
    @Test
    public void bishopMoves() {
        assertThat(new Bishop(Player.White).getTargets(initialState, new Position("d4")), is(toPositionList("e5", "f6", "g7", "h8", "c5", "b6", "a7", "e3", "f2", "g1", "c3", "b2", "a1")));
    }
    
}




