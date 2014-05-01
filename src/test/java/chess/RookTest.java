package chess;

import static chess.ListHelpers.toPositionList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import chess.pieces.Rook;

public class RookTest {

    private GameState initialState;

    @Before
    public void setUp() {
        initialState = new GameState();
    }

    @Test
    public void rookMoves() {
        assertThat(
                new Rook(Player.White).getTargets(initialState, new Position("d4")),
                is(toPositionList("d5", "d6", "d7", "d8", "d3", "d2", "d1", "e4", "f4", "g4", "h4", "c4", "b4", "a4")));
    }

}


