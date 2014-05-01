package chess.pieces;

import java.util.ArrayList;
import java.util.List;

import chess.GameState;
import chess.Player;
import chess.Position;

public class Knight extends Piece {
    public Knight(Player owner) {
        super(owner);
    }

    @Override
    protected char getIdentifyingCharacter() {
        return 'n';
    }
    
    @Override    
    public List<Position> getTargets(GameState state, Position position) {
        List<Position> tentative = new ArrayList<Position>();
        
        addPosition(tentative, position.getColumnNumber() + 1, position.getRow() + 2);
        addPosition(tentative, position.getColumnNumber() + 1, position.getRow() - 2);
        
        addPosition(tentative, position.getColumnNumber() - 1, position.getRow() + 2);
        addPosition(tentative, position.getColumnNumber() - 1, position.getRow() - 2);
        
        addPosition(tentative, position.getColumnNumber() + 2, position.getRow() + 1);
        addPosition(tentative, position.getColumnNumber() + 2, position.getRow() - 1);
        
        addPosition(tentative, position.getColumnNumber() - 2, position.getRow() + 1);
        addPosition(tentative, position.getColumnNumber() - 2, position.getRow() - 1);
        
        List<Position> targets = new ArrayList<Position>();
        for (Position p : tentative) {
            if (isInBoard(p) && (state.getPieceAt(p)==null || !state.getPieceAt(p).getOwner().equals(getOwner()))) {
                targets.add(p);
            }
        }
        return targets;
    }

    private boolean isInBoard(Position p) {
        return p.getRow()<=Position.MAX_ROW && p.getRow()>=Position.MIN_ROW && p.getColumnNumber()<=Position.MAX_COLUMN_NUMBER && p.getColumnNumber()>=Position.MIN_COLUMN_NUMBER;
    }

    private void addPosition(List<Position> positions, int column, int row) {
        positions.add(new Position(column, row));
    }
}
