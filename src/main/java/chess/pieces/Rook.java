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
        List<Position> targets = new ArrayList<Position>();
        targets.addAll(Moves.getNorth(getOwner(), state, position, 8));
        targets.addAll(Moves.getSouth(getOwner(), state, position, 8));
        targets.addAll(Moves.getEast(getOwner(), state, position, 8));
        targets.addAll(Moves.getWest(getOwner(), state, position, 8));
        return targets;
    }
}
