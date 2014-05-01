package chess;

import static chess.ListHelpers.toPositionList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import chess.pieces.Moves;

public class MovesTest {
    
    private GameState emptyState;
    private GameState initialState;

    @Before
    public void setUp() {
        emptyState = new GameState();
        initialState = new GameState();
        initialState.reset();
        initialState.movePiece(new Position("a2"), new Position("a3"));
        initialState.movePiece(new Position("b2"), new Position("b3"));
        initialState.movePiece(new Position("c2"), new Position("c3"));
        initialState.movePiece(new Position("h2"), new Position("h3")); 
        initialState.movePiece(new Position("g2"), new Position("g3")); 
        initialState.movePiece(new Position("f2"), new Position("f3"));  
        
        initialState.movePiece(new Position("f7"), new Position("f2"));
        initialState.movePiece(new Position("c7"), new Position("c2"));
    }
    
    // north

    @Test
    public void returnsNorthMoves() {
        assertThat(Moves.getNorth(Player.White, emptyState, new Position("d1"), 2), is(toPositionList("d2","d3")));
    }
    
    @Test
    public void returnsNorthMovesWithinBoard() {
        assertThat(Moves.getNorth(Player.White, emptyState, new Position("d1"), 10), is(toPositionList("d2","d3","d4","d5","d6","d7","d8")));
    }
    
    @Test
    public void returnsNoNorthMoves() {
        assertThat(Moves.getNorth(Player.White, emptyState, new Position("d1"), 0), is(toPositionList()));
    }
    
    @Test
    public void returnsNorthMovesToEmptyOrOpponentPositions() {
        assertThat(Moves.getNorth(Player.White, initialState, new Position("d1"), 8), is(toPositionList()));
        assertThat(Moves.getNorth(Player.White, initialState, new Position("d2"), 8), is(toPositionList("d3","d4","d5","d6","d7","d8")));
    }
    
    
    // south
    
    @Test
    public void returnsSouthMoves() {
        assertThat(Moves.getSouth(Player.Black, emptyState, new Position("d8"), 2), is(toPositionList("d7","d6")));
    }
    
    @Test
    public void returnsSouthMovesWithinBoard() {
        assertThat(Moves.getSouth(Player.Black, emptyState, new Position("d8"), 10), is(toPositionList("d7","d6","d5","d4","d3","d2","d1")));
    }
    
    @Test
    public void returnsNoSouthMoves() {
        assertThat(Moves.getSouth(Player.Black, emptyState, new Position("d8"), 0), is(toPositionList()));
    }
    
    @Test
    public void returnsSouthMovesToEmptyOrOpponentPositions() {
        assertThat(Moves.getSouth(Player.Black, initialState, new Position("d8"), 8), is(toPositionList()));
        assertThat(Moves.getSouth(Player.Black, initialState, new Position("d7"), 8), is(toPositionList("d6","d5","d4","d3","d2","d1")));
    }
    
    // west
    
    @Test
    public void returnsWestMoves() {
        assertThat(Moves.getWest(Player.White, emptyState, new Position("h2"), 2), is(toPositionList("g2","f2")));
    }
    
    @Test
    public void returnsWestMovesWithinBoard() {
        assertThat(Moves.getWest(Player.White, emptyState, new Position("h3"), 10), is(toPositionList("g3","f3","e3","d3","c3","b3","a3")));
    }
    
    @Test
    public void returnsNoWestMoves() {
        assertThat(Moves.getWest(Player.White, emptyState, new Position("h2"), 0), is(toPositionList()));
    }
    
    @Test
    public void returnsWestMovesToEmptyOrOpponentPositions() {
        assertThat(Moves.getWest(Player.White, initialState, new Position("h1"), 8), is(toPositionList()));
        assertThat(Moves.getWest(Player.White, initialState, new Position("h2"), 3), is(toPositionList("g2","f2")));
    }
    
    // east
    
    @Test
    public void returnsEastMoves() {
        assertThat(Moves.getEast(Player.White, emptyState, new Position("a2"), 2), is(toPositionList("b2","c2")));
    }
    
    @Test
    public void returnsEastMovesWithinBoard() {
        assertThat(Moves.getEast(Player.White, emptyState, new Position("a3"), 10), is(toPositionList("b3","c3","d3","e3","f3","g3","h3")));
    }
    
    @Test
    public void returnsNoEastMoves() {
        assertThat(Moves.getEast(Player.White, emptyState, new Position("a2"), 0), is(toPositionList()));
    }
    
    @Test
    public void returnsEastMovesToEmptyOrOpponentPositions() {
        assertThat(Moves.getEast(Player.White, initialState, new Position("a2"), 3), is(toPositionList("b2","c2")));
    }
    
    // northeast
    
    @Test
    public void returnsNorthEastMoves() {
        assertThat(Moves.getNorthEast(Player.White, emptyState, new Position("a2"), 2), is(toPositionList("b3","c4")));
    }
    
    @Test
    public void returnsNorthEastMovesWithinBoard() {
        assertThat(Moves.getNorthEast(Player.White, emptyState, new Position("a2"), 10), is(toPositionList("b3","c4","d5","e6","f7","g8")));
    }
    
    @Test
    public void returnsNoNorthEastMoves() {
        assertThat(Moves.getNorthEast(Player.White, emptyState, new Position("a2"), 0), is(toPositionList()));
    }
    
    @Test
    public void returnsNorthEastEmptyMoves() {
        assertThat(Moves.getNorthEast(Player.White, initialState, new Position("a2"), 3), is(toPositionList()));
        assertThat(Moves.getNorthEast(Player.White, initialState, new Position("a1"), 3), is(toPositionList("b2")));
    }
    
    // northeast
    
    @Test
    public void returnsNorthWestMoves() {
        assertThat(Moves.getNorthWest(Player.White, emptyState, new Position("h2"), 2), is(toPositionList("g3","f4")));
    }
    
    @Test
    public void returnsNorthWestMovesWithinBoard() {
        assertThat(Moves.getNorthWest(Player.White, emptyState, new Position("h2"), 10), is(toPositionList("g3","f4","e5","d6","c7","b8")));
    }
    
    @Test
    public void returnsNoNorthWestMoves() {
        assertThat(Moves.getNorthWest(Player.White, emptyState, new Position("h2"), 0), is(toPositionList()));
    }
    
    @Test
    public void returnsNorthWestEmptyMoves() {
        assertThat(Moves.getNorthWest(Player.White, initialState, new Position("e1"), 3), is(toPositionList()));
        assertThat(Moves.getNorthWest(Player.White, initialState, new Position("h1"), 3), is(toPositionList("g2")));
    }
    
    // southEast
    
    @Test
    public void returnsSouthEastMoves() {
        assertThat(Moves.getSouthEast(Player.Black, emptyState, new Position("a7"), 2), is(toPositionList("b6","c5")));
    }
    
    @Test
    public void returnsSouthEastMovesWithinBoard() {
        assertThat(Moves.getSouthEast(Player.Black, emptyState, new Position("a7"), 10), is(toPositionList("b6","c5","d4","e3","f2","g1")));
    }
    
    @Test
    public void returnsNoSouthEastMoves() {
        assertThat(Moves.getSouthEast(Player.Black, emptyState, new Position("a7"), 0), is(toPositionList()));
    }
    
    @Test
    public void returnsSouthEastEmptyMoves() {
        assertThat(Moves.getSouthEast(Player.Black, initialState, new Position("a8"), 3), is(toPositionList()));
        assertThat(Moves.getSouthEast(Player.Black, initialState, new Position("c3"), 3), is(toPositionList("d2","e1")));
    }
    
    // southWest
    
    @Test
    public void returnsSouthWestMoves() {
        assertThat(Moves.getSouthWest(Player.Black, emptyState, new Position("h7"), 2), is(toPositionList("g6","f5")));
    }
    
    @Test
    public void returnsSouthWestMovesWithinBoard() {
        assertThat(Moves.getSouthWest(Player.Black, emptyState, new Position("h7"), 10), is(toPositionList("g6","f5","e4","d3","c2","b1")));
    }
    
    @Test
    public void returnsNoSouthWestMoves() {
        assertThat(Moves.getSouthWest(Player.Black, emptyState, new Position("h7"), 0), is(toPositionList()));
    }
    
    @Test
    public void returnsSouthWestEmptyMoves() {
        assertThat(Moves.getSouthWest(Player.Black, initialState, new Position("h8"), 3), is(toPositionList()));
        assertThat(Moves.getSouthWest(Player.Black, initialState, new Position("h3"), 3), is(toPositionList("g2","f1")));
    }

}
