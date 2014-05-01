package chess;

import java.util.ArrayList;
import java.util.List;

public class ListHelpers {
    
    public static List<Position> toPositionList(String... positions) {
        List<Position> positionsList = new ArrayList<Position>();
        for (String position : positions) {
            positionsList.add(new Position(position));
        }
        return positionsList;
    }
    
    public static List<Move> toMovesList(String... moves) {
        List<Move> movesList = new ArrayList<Move>();
        for (String move: moves) {
            String[] tokens = move.split(",");
            movesList.add(new Move(new Position(tokens[0]), new Position(tokens[1])));
        }
        return movesList;
    }

}
