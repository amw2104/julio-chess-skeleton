package chess.pieces;

import java.util.ArrayList;
import java.util.List;

import chess.GameState;
import chess.Player;
import chess.Position;

public class Queen extends Piece{
    public Queen(Player owner) {
        super(owner);
    }

    @Override
    protected char getIdentifyingCharacter() {
        return 'q';
    }
    
    @Override    
    public List<Position> getTargets(GameState state, Position position) {
        List<Position> tentative = new ArrayList<Position>();
        return tentative;
    }
}
