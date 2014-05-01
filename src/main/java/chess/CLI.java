package chess;

import chess.pieces.Piece;

import java.io.*;

public class CLI {
    private static final String NEWLINE = System.getProperty("line.separator");

    private final BufferedReader inReader;
    private final PrintStream outStream;

    private GameState gameState = null;

    public CLI(InputStream inputStream, PrintStream outStream) {
        this.inReader = new BufferedReader(new InputStreamReader(inputStream));
        this.outStream = outStream;
        writeOutput("Welcome to Chess!");
    }

    private void writeOutput(String str) {
        this.outStream.println(str);
    }

    private String getInput() {
        try {
            this.outStream.print("> ");
            return inReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException("Failed to read from input: ", e);
        }
    }

    void startEventLoop() {
        writeOutput("Type 'help' for a list of commands.");
        doNewGame();

        while (true) {
            showBoard();
            writeOutput(gameState.getCurrentPlayer() + "'s Move");

            String input = getInput();
            if (input == null) {
                break; // No more input possible; this is the only way to exit the event loop
            } else if (input.length() > 0) {
                if (input.equals("help")) {
                    showCommands();
                } else if (input.equals("new")) {
                    doNewGame();
                } else if (input.equals("quit")) {
                    writeOutput("Goodbye!");
                    System.exit(0);
                } else if (input.equals("board")) {
                    writeOutput("Current Game:");
                } else if (input.equals("list")) {
                    showPossibleMoves();
                } else if (input.startsWith("move")) {
                    writeOutput("====> Move Is Not Implemented (yet) <====");
                } else {
                    writeOutput("I didn't understand that.  Type 'help' for a list of commands.");
                }
            }
        }
    }

    private void doNewGame() {
        gameState = new GameState();
        gameState.reset();
    }

    private void showBoard() {
        writeOutput(getBoardAsString());
    }

    private void showCommands() {
        writeOutput("Possible commands: ");
        writeOutput("    'help'                       Show this menu");
        writeOutput("    'quit'                       Quit Chess");
        writeOutput("    'new'                        Create a new game");
        writeOutput("    'board'                      Show the chess board");
        writeOutput("    'list'                       List all possible moves");
        writeOutput("    'move <colrow> <colrow>'     Make a move");
    }
    
    private void showPossibleMoves() {
       writeOutput("White's Possible Moves:");
       for (Move move : gameState.getPossibleMoves(Player.White)) {
           writeOutput(move.toString());
       }
    }

    String getBoardAsString() {
        StringBuilder builder = new StringBuilder();
        builder.append(NEWLINE);

        printColumnLabels(builder);
        for (int i = Position.MAX_ROW; i >= Position.MIN_ROW; i--) {
            printSeparator(builder);
            printSquares(i, builder);
        }

        printSeparator(builder);
        printColumnLabels(builder);

        return builder.toString();
    }


    private void printSquares(int rowLabel, StringBuilder builder) {
        builder.append(rowLabel);

        for (char c = Position.MIN_COLUMN; c <= Position.MAX_COLUMN; c++) {
            Piece piece = gameState.getPieceAt(String.valueOf(c) + rowLabel);
            char pieceChar = piece == null ? ' ' : piece.getIdentifier();
            builder.append(" | ").append(pieceChar);
        }
        builder.append(" | ").append(rowLabel).append(NEWLINE);
    }

    private void printSeparator(StringBuilder builder) {
        builder.append("  +---+---+---+---+---+---+---+---+").append(NEWLINE);
    }

    private void printColumnLabels(StringBuilder builder) {
        builder.append("   ");
        for (char c = Position.MIN_COLUMN; c <= Position.MAX_COLUMN; c++) {
            builder.append(" ").append(c).append("  ");
        }

        builder.append(NEWLINE);
    }

    public static void main(String[] args) {
        CLI cli = new CLI(System.in, System.out);
        cli.startEventLoop();
    }
}
