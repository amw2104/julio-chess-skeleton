package chess.pieces;

import java.util.ArrayList;
import java.util.List;

import chess.GameState;
import chess.Player;
import chess.Position;

public class Pawn extends Piece {
    public Pawn(Player owner) {
        super(owner);
    }

    @Override
    protected char getIdentifyingCharacter() {
        return 'p';
    }
    
    @Override    
    public List<Position> getTargets(GameState state, Position position) {
        List<Position> targets = new ArrayList<Position>();
        
        int nextRow = getNextRow(position);
        if (!isValidRow(nextRow)) {
            return targets;
        }
        
        Piece pieceAtNextRow = state.getPieceAt(position.getColumn(), nextRow);
        
        int firstMoveNextRow = getFirstMoveNextRow(position);
        Piece pieceAtFirstMoveRow = state.getPieceAt(position.getColumn(), firstMoveNextRow);
        if (isInitialRow(position) && (pieceAtNextRow==null || !isSameOwner(pieceAtFirstMoveRow))) {
            targets.add(new Position(position.getColumn(), firstMoveNextRow));
        }
        
        if (pieceAtNextRow == null || !isSameOwner(pieceAtNextRow)) {
            targets.add(new Position(position.getColumn(), nextRow));
        }
        
        return targets;
    }
    
    private boolean isInitialRow(Position position) {
        return position.getRow() == getInitialRow(position);
    }
    
    private int getInitialRow(Position position) {        
        return Player.White == getOwner() ? 2 : 7;
    }
    
    private int getNextRow(Position position) {        
        return Player.White == getOwner() ? position.getRow() + 1 : position.getRow() - 1;
    }
    
    private int getFirstMoveNextRow(Position position) {        
        return Player.White == getOwner() ? position.getRow() + 2 : position.getRow() - 2;
    }
    
    private boolean isValidRow(int row) {
        return row >= Position.MIN_ROW && row <= Position.MAX_ROW;
    }
    
    private boolean isSameOwner(Piece piece) {
        return piece.getOwner().equals(getOwner());
    }
}
