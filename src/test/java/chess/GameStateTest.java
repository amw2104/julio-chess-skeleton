package chess;

import static chess.ListHelpers.toMovesList;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertTrue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import chess.pieces.Bishop;
import chess.pieces.King;
import chess.pieces.Knight;
import chess.pieces.Pawn;
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
        state.placePiece(new Bishop(Player.White), new Position("f4"));
        state.placePiece(new Rook(Player.White), new Position("g4"));
        state.placePiece(new Queen(Player.White), new Position("c4"));
        state.placePiece(new Pawn(Player.White), new Position("b2"));
        state.placePiece(new Pawn(Player.White), new Position("b4"));
        state.placePiece(new Pawn(Player.Black), new Position("a1"));
        
        List<Move> allMoves = state.getPossibleMoves(Player.White);
        List<Move> expectedAllMoves = toMovesList(
                "c4,c5", "c4,c6", "c4,c7", "c4,c8", "c4,c3", "c4,c2", "c4,c1", "c4,d5", "c4,e6", "c4,f7", "c4,g8", "c4,b5", "c4,a6", "c4,d3", "c4,e2", "c4,f1", "c4,b3", "c4,a2", 
                "d4,d5", "d4,d3", "d4,e5", "d4,c5", "d4,e3", "d4,c3", 
                "e4,f6", "e4,f2", "e4,d6", "e4,d2", "e4,g5", "e4,g3", "e4,c5", "e4,c3", 
                "f4,g5", "f4,h6", "f4,e5", "f4,d6", "f4,c7", "f4,b8", "f4,g3", "f4,h2", "f4,e3", "f4,d2", "f4,c1", 
                "g4,g5", "g4,g6", "g4,g7", "g4,g8", "g4,g3", "g4,g2", "g4,g1", "g4,h4", 
                "b2,b4", "b2,b3", "b4,b5");
        
        assertThat(allMoves, is(expectedAllMoves));
    }
    
}


