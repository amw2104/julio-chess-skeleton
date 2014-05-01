package chess;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Move {

    private Position from;
    private Position to;

    public Move(Position from, Position to) {
        this.from = from;
        this.to = to;
    }

    public Position getFrom() {
        return from;
    }

    public Position getTo() {
        return to;
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public String toString() {
        return "" + from.getColumn() + from.getRow() + "," + to.getColumn() + to.getRow();
    }

}
