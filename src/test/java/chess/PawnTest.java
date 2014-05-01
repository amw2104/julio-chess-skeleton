package chess;

import static chess.ListHelpers.toPositionList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import chess.pieces.Pawn;

public class PawnTest {

    private GameState initialState;

    @Before
    public void setUp() {
        initialState = new GameState();
    }

    @Test
    public void pawnInitialMoves() {
        assertThat(new Pawn(Player.White).getTargets(initialState, new Position("d2")), is(toPositionList("d4", "d3")));
        assertThat(new Pawn(Player.Black).getTargets(initialState, new Position("d7")), is(toPositionList("d5", "d6")));
    }
    
    @Test
    public void pawnMoves() {
        assertThat(new Pawn(Player.White).getTargets(initialState, new Position("d3")), is(toPositionList("d4")));
        assertThat(new Pawn(Player.Black).getTargets(initialState, new Position("d6")), is(toPositionList("d5")));
    }

}


