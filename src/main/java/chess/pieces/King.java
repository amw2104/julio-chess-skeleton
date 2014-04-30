package chess.pieces;

import java.util.ArrayList;
import java.util.List;

import chess.GameState;
import chess.Player;
import chess.Position;

public class King extends Piece {
    public King(Player owner) {
        super(owner);
    }

    @Override
    protected char getIdentifyingCharacter() {
        return 'k';
    }
    
    @Override
    public List<Position> getTargets(GameState state, Position position) {
        List<Position> targets = new ArrayList<Position>();
        targets.addAll(Moves.getNorth(getOwner(), state, position, 1));
        targets.addAll(Moves.getSouth(getOwner(), state, position, 1));
        targets.addAll(Moves.getEast(getOwner(), state, position, 1));
        targets.addAll(Moves.getWest(getOwner(), state, position, 1));
        targets.addAll(Moves.getNorthEast(getOwner(), state, position, 1));
        targets.addAll(Moves.getNorthWest(getOwner(), state, position, 1));
        targets.addAll(Moves.getSouthEast(getOwner(), state, position, 1));
        targets.addAll(Moves.getSouthWest(getOwner(), state, position, 1));
        return targets;
    }

}
