package chess;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Position {

    public static final int MIN_ROW = 1;
    public static final int MAX_ROW = 8;
    public static final char MIN_COLUMN = 'a';
    public static final char MAX_COLUMN = 'h';
    public static final char MIN_COLUMN_NUMBER = 1;
    public static final char MAX_COLUMN_NUMBER = 8;

    private int row;
    private char column;

    public Position(char column, int row) {
        this.row = row;
        this.column = column;
    }

    public Position(int columnNumber, int row) {
        this.row = row;
        this.column = (char) ('a' + (columnNumber - 1));
    }

    public Position(String colrow) {
        this(colrow.toCharArray()[0], Character.digit(colrow.toCharArray()[1], 10));
    }

    public int getRow() {
        return row;
    }

    public char getColumn() {
        return column;
    }

    public int getColumnNumber() {
        return column - 'a' + 1;
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
        return "" + column + row;
    }

}
