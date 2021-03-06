package chess;

import static chess.ListHelpers.toPositionList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import chess.pieces.Knight;

public class KnightTest {
    
    private GameState initialState;

    @Before
    public void setUp() {
        initialState = new GameState();
    }
    
    @Test
    public void knightMoves() {
        assertThat(new Knight(Player.White).getTargets(initialState, new Position("d4")), is(toPositionList("e6", "e2", "c6", "c2", "f5", "f3", "b5", "b3")));
    }

}
