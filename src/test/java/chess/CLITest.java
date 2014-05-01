package chess;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CLITest {

    @Mock
    private PrintStream testOut;

    @Mock
    private InputStream testIn;

    private String initialBoard;

    @Before
    public void setUp() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("    a   b   c   d   e   f   g   h  \n");
        sb.append("  +---+---+---+---+---+---+---+---+\n");
        sb.append("8 | R | N | B | Q | K | B | N | R | 8\n");
        sb.append("  +---+---+---+---+---+---+---+---+\n");
        sb.append("7 | P | P | P | P | P | P | P | P | 7\n");
        sb.append("  +---+---+---+---+---+---+---+---+\n");
        sb.append("6 |   |   |   |   |   |   |   |   | 6\n");
        sb.append("  +---+---+---+---+---+---+---+---+\n");
        sb.append("5 |   |   |   |   |   |   |   |   | 5\n");
        sb.append("  +---+---+---+---+---+---+---+---+\n");
        sb.append("4 |   |   |   |   |   |   |   |   | 4\n");
        sb.append("  +---+---+---+---+---+---+---+---+\n");
        sb.append("3 |   |   |   |   |   |   |   |   | 3\n");
        sb.append("  +---+---+---+---+---+---+---+---+\n");
        sb.append("2 | p | p | p | p | p | p | p | p | 2\n");
        sb.append("  +---+---+---+---+---+---+---+---+\n");
        sb.append("1 | r | n | b | q | k | b | n | r | 1\n");
        sb.append("  +---+---+---+---+---+---+---+---+\n");
        sb.append("    a   b   c   d   e   f   g   h  \n");
        initialBoard = sb.toString();
    }

    @Test
    public void testCLIWritesWelcomeMessage() {
        new CLI(testIn, testOut);
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(testOut, times(1)).println(captor.capture());
        String message = captor.getValue();
        assertEquals("The CLI should initially print a welcome message", "Welcome to Chess!", message);
    }

    @Test
    public void testHelpCommand() throws Exception {
        runCliWithInput("help");

        List<String> output = captureOutput();
        List<String> expectedOutput = new ArrayList<String>();
        expectedOutput.add("Welcome to Chess!");
        expectedOutput.add("Type 'help' for a list of commands.");
        expectedOutput.add(initialBoard);
        expectedOutput.add("White's Move");
        expectedOutput.add("Possible commands: ");
        expectedOutput.add("    'help'                       Show this menu");
        expectedOutput.add("    'quit'                       Quit Chess");
        expectedOutput.add("    'new'                        Create a new game");
        expectedOutput.add("    'board'                      Show the chess board");
        expectedOutput.add("    'list'                       List all possible moves");
        expectedOutput.add("    'move <colrow> <colrow>'     Make a move");
        expectedOutput.add(initialBoard);
        expectedOutput.add("White's Move");
        assertThat(output, is(expectedOutput));
    }

    @Test
    public void testListCommand() throws Exception {
        runCliWithInput("list");
        List<String> output = captureOutput();
        List<String> expectedOutput = new ArrayList<String>();
        expectedOutput.add("Welcome to Chess!");
        expectedOutput.add("Type 'help' for a list of commands.");
        expectedOutput.add(initialBoard);
        expectedOutput.add("White's Move");
        expectedOutput.add("White's Possible Moves:");
        expectedOutput.add("a2,a4");
        expectedOutput.add("a2,a3");
        expectedOutput.add("b2,b4");
        expectedOutput.add("b2,b3");
        expectedOutput.add("c2,c4");
        expectedOutput.add("c2,c3");
        expectedOutput.add("d2,d4");
        expectedOutput.add("d2,d3");
        expectedOutput.add("e2,e4");
        expectedOutput.add("e2,e3");
        expectedOutput.add("f2,f4");
        expectedOutput.add("f2,f3");
        expectedOutput.add("g2,g4");
        expectedOutput.add("g2,g3");
        expectedOutput.add("h2,h4");
        expectedOutput.add("h2,h3");
        expectedOutput.add("b1,c3");
        expectedOutput.add("b1,a3");
        expectedOutput.add("g1,h3");
        expectedOutput.add("g1,f3");
        expectedOutput.add(initialBoard);
        expectedOutput.add("White's Move");
        assertThat(output, is(expectedOutput));
    }

    @Test
    public void testNewCommand() throws Exception {
        runCliWithInput("new");
        List<String> output = captureOutput();
        List<String> expectedOutput = new ArrayList<String>();
        expectedOutput.add("Welcome to Chess!");
        expectedOutput.add("Type 'help' for a list of commands.");
        expectedOutput.add(initialBoard);
        expectedOutput.add("White's Move");
        expectedOutput.add(initialBoard);
        expectedOutput.add("White's Move");
        assertThat(output, is(expectedOutput));
    }

    @Test
    public void testBoardCommand() throws Exception {
        runCliWithInput("new", "board");
        List<String> output = captureOutput();
        List<String> expectedOutput = new ArrayList<String>();
        expectedOutput.add("Welcome to Chess!");
        expectedOutput.add("Type 'help' for a list of commands.");
        expectedOutput.add(initialBoard);
        expectedOutput.add("White's Move");
        expectedOutput.add(initialBoard);
        expectedOutput.add("White's Move");
        expectedOutput.add("Current Game:");
        expectedOutput.add(initialBoard);
        expectedOutput.add("White's Move");
        assertThat(output, is(expectedOutput));
    }

    private List<String> captureOutput() {
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(testOut, atLeastOnce()).println(captor.capture());
        return captor.getAllValues();
    }

    private CLI runCliWithInput(String... inputLines) {
        StringBuilder builder = new StringBuilder();
        for (String line : inputLines) {
            builder.append(line).append(System.getProperty("line.separator"));
        }

        ByteArrayInputStream in = new ByteArrayInputStream(builder.toString().getBytes());
        CLI cli = new CLI(in, testOut);
        cli.startEventLoop();

        return cli;
    }

}
