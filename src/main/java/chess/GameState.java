package chess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import chess.pieces.Bishop;
import chess.pieces.King;
import chess.pieces.Knight;
import chess.pieces.Pawn;
import chess.pieces.Piece;
import chess.pieces.Queen;
import chess.pieces.Rook;

public class GameState {

    private Player currentPlayer = Player.White;

    private Map<Position, Piece> positionToPieceMap;

    public GameState() {
        positionToPieceMap = new HashMap<Position, Piece>();
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void reset() {
        // White Pieces
        placePiece(new Rook(Player.White), new Position("a1"));
        placePiece(new Knight(Player.White), new Position("b1"));
        placePiece(new Bishop(Player.White), new Position("c1"));
        placePiece(new Queen(Player.White), new Position("d1"));
        placePiece(new King(Player.White), new Position("e1"));
        placePiece(new Bishop(Player.White), new Position("f1"));
        placePiece(new Knight(Player.White), new Position("g1"));
        placePiece(new Rook(Player.White), new Position("h1"));
        placePiece(new Pawn(Player.White), new Position("a2"));
        placePiece(new Pawn(Player.White), new Position("b2"));
        placePiece(new Pawn(Player.White), new Position("c2"));
        placePiece(new Pawn(Player.White), new Position("d2"));
        placePiece(new Pawn(Player.White), new Position("e2"));
        placePiece(new Pawn(Player.White), new Position("f2"));
        placePiece(new Pawn(Player.White), new Position("g2"));
        placePiece(new Pawn(Player.White), new Position("h2"));

        // Black Pieces
        placePiece(new Rook(Player.Black), new Position("a8"));
        placePiece(new Knight(Player.Black), new Position("b8"));
        placePiece(new Bishop(Player.Black), new Position("c8"));
        placePiece(new Queen(Player.Black), new Position("d8"));
        placePiece(new King(Player.Black), new Position("e8"));
        placePiece(new Bishop(Player.Black), new Position("f8"));
        placePiece(new Knight(Player.Black), new Position("g8"));
        placePiece(new Rook(Player.Black), new Position("h8"));
        placePiece(new Pawn(Player.Black), new Position("a7"));
        placePiece(new Pawn(Player.Black), new Position("b7"));
        placePiece(new Pawn(Player.Black), new Position("c7"));
        placePiece(new Pawn(Player.Black), new Position("d7"));
        placePiece(new Pawn(Player.Black), new Position("e7"));
        placePiece(new Pawn(Player.Black), new Position("f7"));
        placePiece(new Pawn(Player.Black), new Position("g7"));
        placePiece(new Pawn(Player.Black), new Position("h7"));
    }

    public Piece getPieceAt(String colrow) {
        Position position = new Position(colrow);
        return getPieceAt(position);
    }

    public Piece getPieceAt(Position position) {
        return positionToPieceMap.get(position);
    }

    public Piece getPieceAt(int columnNumber, int row) {
        return positionToPieceMap.get(new Position(columnNumber, row));
    }

    protected void placePiece(Piece piece, Position position) {
        positionToPieceMap.put(position, piece);
    }

    public void movePiece(Position oldPosition, Position newPosition) {
        checkEmptyPosition(newPosition);
        checkFilledPosition(oldPosition);
        Piece piece = getPieceAt(oldPosition);
        positionToPieceMap.remove(oldPosition);
        positionToPieceMap.put(newPosition, piece);
    }

    private void checkEmptyPosition(Position newPosition) {
        if (positionToPieceMap.get(newPosition) != null) {
            throw new RuntimeException("Position " + newPosition + " is not empty");
        }
    }

    private void checkFilledPosition(Position newPosition) {
        if (positionToPieceMap.get(newPosition) == null) {
            throw new RuntimeException("Position " + newPosition + " is empty");
        }
    }

    public List<Move> getPossibleMoves(Player player) {
        List<Move> moves = new ArrayList<Move>();
        for (Position fromPosition : positionToPieceMap.keySet()) {
            Piece piece = positionToPieceMap.get(fromPosition);
            if (piece.getOwner().equals(player)) {
                for (Position toPosition : piece.getTargets(this, fromPosition)) {
                    moves.add(new Move(fromPosition, toPosition));
                }
            }
        }
        return moves;
    }
}
