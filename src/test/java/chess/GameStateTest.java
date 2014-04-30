package chess;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertTrue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import chess.pieces.King;
import chess.pieces.Knight;
import chess.pieces.Piece;
import chess.pieces.Queen;
import chess.pieces.Rook;

public class GameStateTest {

    private GameState state;

    @Before
    public void setUp() {
        state = new GameState();
    }

    @Test
    public void testStartsEmpty() {
        // Make sure all the positions are empty
        for (char col = Position.MIN_COLUMN; col <= Position.MAX_COLUMN; col++) {
            for (int row = Position.MIN_ROW; row <= Position.MAX_ROW; row++) {
                assertNull("All pieces should be empty", state.getPieceAt(String.valueOf(col) + row));
            }
        }
    }

    @Test
    public void testInitialGame() {
        // Start the game
        state.reset();

        // White should be the first player
        Player current = state.getCurrentPlayer();
        assertEquals("The initial player should be White", Player.White, current);

        // Spot check a few pieces
        Piece whiteRook = state.getPieceAt("a1");
        assertTrue("A rook should be at a1", whiteRook instanceof Rook);
        assertEquals("The rook at a1 should be owned by White", Player.White, whiteRook.getOwner());


        Piece blackQueen = state.getPieceAt("d8");
        assertTrue("A queen should be at d8", blackQueen instanceof Queen);
        assertEquals("The queen at d8 should be owned by Black", Player.Black, blackQueen.getOwner());
    }
    
    @Test
    public void testAllMoves() {
        state.placePiece(new King(Player.White), new Position("d4"));
        state.placePiece(new Knight(Player.White), new Position("e4"));
        
        List<Move> allMoves = state.getPossibleMoves();
        List<Move> expectedAllMoves = toMovesList("d4,d5","d4,d3","d4,c4","d4,e5","d4,c5","d4,e3","d4,c3","e4,f6","e4,f2","e4,d6","e4,d2","e4,g5","e4,g3","e4,c5","e4,c3");
        
        assertThat(allMoves, is(expectedAllMoves));
    }
    
    private List<Move> toMovesList(String... moves) {
        List<Move> movesList = new ArrayList<Move>();
        for (String move: moves) {
            String[] tokens = move.split(",");
            movesList.add(new Move(new Position(tokens[0]), new Position(tokens[1])));
        }
        return movesList;
    }
}


