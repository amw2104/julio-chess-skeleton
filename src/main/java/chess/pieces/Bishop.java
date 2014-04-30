package chess.pieces;

import java.util.ArrayList;
import java.util.List;

import chess.GameState;
import chess.Player;
import chess.Position;

/**
 * The 'Bishop' class
 */
public class Bishop extends Piece {
    public Bishop(Player owner) {
        super(owner);
    }

    @Override
    protected char getIdentifyingCharacter() {
        return 'b';
    }
    
    public List<Position> getTargets(GameState state, Position position) {
        List<Position> targets = new ArrayList<Position>();
        targets.addAll(Moves.getNorthEast(getOwner(), state, position, 8));
        targets.addAll(Moves.getNorthWest(getOwner(), state, position, 8));
        targets.addAll(Moves.getSouthEast(getOwner(), state, position, 8));
        targets.addAll(Moves.getSouthWest(getOwner(), state, position, 8));
        return targets;
    }
}
