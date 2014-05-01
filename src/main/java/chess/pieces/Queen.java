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
        List<Position> targets = new ArrayList<Position>();
        targets.addAll(Moves.getNorth(getOwner(), state, position, 8));
        targets.addAll(Moves.getSouth(getOwner(), state, position, 8));
        targets.addAll(Moves.getEast(getOwner(), state, position, 8));
        targets.addAll(Moves.getWest(getOwner(), state, position, 8));
        targets.addAll(Moves.getNorthEast(getOwner(), state, position, 8));
        targets.addAll(Moves.getNorthWest(getOwner(), state, position, 8));
        targets.addAll(Moves.getSouthEast(getOwner(), state, position, 8));
        targets.addAll(Moves.getSouthWest(getOwner(), state, position, 8));
        return targets;
    }
}
