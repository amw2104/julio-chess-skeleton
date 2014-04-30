package chess;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Before;
import org.junit.Test;

import chess.pieces.King;

public class KingTest {
    
    private GameState initialState;

    @Before
    public void setUp() {
        initialState = new GameState();
    }
    
    @Test
    public void kingMoves() {
        assertThat(new King(Player.White).getTargets(initialState, new Position("d4")), is(toPositionList("d5", "d3", "e4", "c4", "e5", "c5", "e3", "c3")));
    }
    
    private List<Position> toPositionList(String... positions) {
        List<Position> positionsList = new ArrayList<Position>();
        for (String position: positions) {
            positionsList.add(new Position(position));
        }
        return positionsList;
    }
    
    

}
