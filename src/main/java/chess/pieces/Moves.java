package chess.pieces;

import java.util.ArrayList;
import java.util.List;

import chess.GameState;
import chess.Player;
import chess.Position;

public class Moves {

    public static List<Position> getNorth(Player player, GameState state, Position currentPosition, int count) {
        List<Position> targets = new ArrayList<Position>();
        for (int i = 1; i <= Math.min(Position.MAX_ROW - currentPosition.getRow(), count); i++) {
            Position tentativePosition = new Position(currentPosition.getColumn(), currentPosition.getRow() + i);
            if (!canMoveTo(tentativePosition, state, player)) {
                break;
            }
            targets.add(tentativePosition);
        }
        return targets;
    }

    public static List<Position> getSouth(Player player, GameState state, Position currentPosition, int count) {
        List<Position> targets = new ArrayList<Position>();
        for (int i = 1; i <= Math.min(currentPosition.getRow() - Position.MIN_ROW, count); i++) {
            Position tentativePosition = new Position(currentPosition.getColumn(), currentPosition.getRow() - i);
            if (!canMoveTo(tentativePosition, state, player)) {
                break;
            }
            targets.add(tentativePosition);
        }
        return targets;
    }

    public static List<Position> getWest(Player player, GameState state, Position currentPosition, int count) {
        List<Position> targets = new ArrayList<Position>();
        for (int i = 1; i <= Math.min(currentPosition.getColumnNumber() - Position.MIN_COLUMN_NUMBER, count); i++) {
            Position tentativePosition = new Position(currentPosition.getColumnNumber() - i, currentPosition.getRow());
            if (!canMoveTo(tentativePosition, state, player)) {
                break;
            }
            targets.add(tentativePosition);
        }
        return targets;
    }

    public static List<Position> getEast(Player player, GameState state, Position currentPosition, int count) {
        List<Position> targets = new ArrayList<Position>();
        for (int i = 1; i <= Math.min(Position.MAX_COLUMN_NUMBER - currentPosition.getColumnNumber(), count); i++) {
            Position tentativePosition = new Position(currentPosition.getColumnNumber() + i, currentPosition.getRow());
            if (!canMoveTo(tentativePosition, state, player)) {
                break;
            }
            targets.add(tentativePosition);
        }
        return targets;
    }

    public static List<Position> getNorthWest(Player player, GameState state, Position currentPosition, int count) {
        List<Position> targets = new ArrayList<Position>();
        for (int i = 1; i <= min(Position.MAX_ROW - currentPosition.getRow(), currentPosition.getColumnNumber() - Position.MIN_COLUMN_NUMBER, count); i++) {
            Position tentativePosition = new Position(currentPosition.getColumnNumber() - i, currentPosition.getRow() + i);
            if (!canMoveTo(tentativePosition, state, player)) {
                break;
            }
            targets.add(tentativePosition);
        }
        return targets;
    }

    public static List<Position> getNorthEast(Player player, GameState state, Position currentPosition, int count) {
        List<Position> targets = new ArrayList<Position>();
        for (int i = 1; i <= min(Position.MAX_ROW - currentPosition.getRow(), Position.MAX_COLUMN_NUMBER - currentPosition.getColumnNumber(), count); i++) {
            Position tentativePosition = new Position(currentPosition.getColumnNumber() + i, currentPosition.getRow() + i);
            if (!canMoveTo(tentativePosition, state, player)) {
                break;
            }
            targets.add(tentativePosition);
        }
        return targets;
    }

    public static List<Position> getSouthWest(Player player, GameState state, Position currentPosition, int count) {
        List<Position> targets = new ArrayList<Position>();
        for (int i = 1; i <= min(currentPosition.getRow() - Position.MIN_ROW, currentPosition.getColumnNumber() - Position.MIN_COLUMN_NUMBER, count); i++) {
            Position tentativePosition = new Position(currentPosition.getColumnNumber() - i, currentPosition.getRow() - i);
            if (!canMoveTo(tentativePosition, state, player)) {
                break;
            }
            targets.add(tentativePosition);
        }
        return targets;
    }

    public static List<Position> getSouthEast(Player player, GameState state, Position currentPosition, int count) {
        List<Position> targets = new ArrayList<Position>();
        for (int i = 1; i <= min(currentPosition.getRow() - Position.MIN_ROW, Position.MAX_COLUMN_NUMBER - currentPosition.getColumnNumber(), count); i++) {
            Position tentativePosition = new Position(currentPosition.getColumnNumber() + i, currentPosition.getRow() - i);
            if (!canMoveTo(tentativePosition, state, player)) {
                break;
            }
            targets.add(tentativePosition);
        }
        return targets;
    }

    private static boolean canMoveTo(Position tentativePosition, GameState state, Player player) {
        Piece p = state.getPieceAt(tentativePosition);
        return (p==null || !p.getOwner().equals(player));
    }

    private static int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

}
