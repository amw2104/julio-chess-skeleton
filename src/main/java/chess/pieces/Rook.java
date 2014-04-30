package chess.pieces;

import java.util.ArrayList;
import java.util.List;

import chess.GameState;
import chess.Player;
import chess.Position;

public class Rook extends Piece {

    public Rook(Player owner) {
        super(owner);
    }

    @Override
    protected char getIdentifyingCharacter() {
        return 'r';
    }
    
    @Override    
    public List<Position> getTargets(GameState state, Position position) {
        List<Position> tentative = new ArrayList<Position>();
        return tentative;
    }
}
