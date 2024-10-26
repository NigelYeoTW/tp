package seedu.commands;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.classes.Constants.ADD_COMMAND_FORMAT;
import static seedu.classes.Constants.INCORRECT_DATE_FORMAT;
import static seedu.classes.Constants.INDEX_NOT_INTEGER;
import static seedu.classes.Constants.INVALID_AMOUNT;
import static seedu.classes.Constants.MISSING_AMOUNT;
import static seedu.classes.Constants.MISSING_DESCRIPTION;
import static seedu.classes.Constants.TAB;

import seedu.classes.Parser;
import seedu.type.IncomeList;
import seedu.type.SpendingList;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;

public class AddCommandTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    private final IncomeList incomes = new IncomeList();
    private final SpendingList spendings = new SpendingList();
    private final LocalDate currentDate = LocalDate.now();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public void restore() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }


    @Test
    void addCommand_correctSpendingWithoutDateInput_success() {
        String userInput = "add spending 10 macs";
        String expectedOutput = "macs - 10 - " + currentDate;
        Command c = Parser.parse(userInput);
        c.execute(incomes, spendings);
        assertEquals(expectedOutput, spendings.get(0).toString());
    }

    @Test
    void addCommand_correctIncomeWithoutDateInput_success() {
        String userInput = "add income 1500 dishwasher";
        String expectedOutput = "dishwasher - 1500 - " + currentDate;
        Command c = Parser.parse(userInput);
        c.execute(incomes, spendings);
        assertEquals(expectedOutput, incomes.get(0).toString());
    }

    @Test
    void addCommand_correctSpendingWithDateInput_success() {
        String userInput = "add spending 10 macs /2024-10-10";
        Command c = Parser.parse(userInput);
        c.execute(incomes, spendings);
        assertEquals("macs - 10 - 2024-10-10", spendings.get(0).toString());
    }

    @Test
    void addCommand_correctIncomeWithDateInput_success() {
        String userInput = "add income 1500 dishwasher /2024-10-10";
        Command c = Parser.parse(userInput);
        c.execute(incomes, spendings);
        assertEquals("dishwasher - 1500 - 2024-10-10", incomes.get(0).toString());
    }

    @Test
    void addCommand_missingAmountSpendingInput_noSpendingAdded() {
        String userInput = "add spending";
        Command c = Parser.parse(userInput);
        c.execute(incomes, spendings);
        assertEquals(TAB + MISSING_AMOUNT + ADD_COMMAND_FORMAT
                        + System.lineSeparator(), outContent.toString());
    }

    @Test
    void addCommand_stringAmountSpendingInput_noSpendingAdded() {
        String userInput = "add spending randomPrice macs";
        Command c = Parser.parse(userInput);
        c.execute(incomes, spendings);
        assertEquals(TAB + INDEX_NOT_INTEGER + ADD_COMMAND_FORMAT +
                        System.lineSeparator(), outContent.toString());
    }

    @Test
    void addCommand_negativeAmountSpendingInput_noSpendingAdded() {
        String userInput = "add spending -1 macs";
        Command c = Parser.parse(userInput);
        c.execute(incomes, spendings);
        assertEquals(TAB + INVALID_AMOUNT + ADD_COMMAND_FORMAT
                        + System.lineSeparator(), outContent.toString());
    }

    @Test
    void addCommand_missingAmountIncomeInput_noIncomeAdded(){
        String userInput = "add income";
        Command c = Parser.parse(userInput);
        c.execute(incomes, spendings);
        assertEquals(TAB + MISSING_AMOUNT + ADD_COMMAND_FORMAT
                        + System.lineSeparator(), outContent.toString());
    }

    @Test
    void addCommand_invalidAmountIncomeInput_noIncomeAdded(){
        String userInput = "add income randomNum salary";
        Command c = Parser.parse(userInput);
        c.execute(incomes, spendings);
        assertEquals(TAB + INDEX_NOT_INTEGER + ADD_COMMAND_FORMAT
                + System.lineSeparator(), outContent.toString());
    }

    @Test
    void addCommand_missingDescriptionSpendingInput_noSpendingAdded(){
        String userInput = "add spending 1000";
        Command c = Parser.parse(userInput);
        c.execute(incomes, spendings);
        assertEquals(TAB + MISSING_DESCRIPTION + ADD_COMMAND_FORMAT
                        + System.lineSeparator(), outContent.toString());
    }

    @Test
    void addCommand_missingDescriptionIncomeInput_noIncomeAdded(){
        String userInput = "add income 1000";
        Command c = Parser.parse(userInput);
        c.execute(incomes, spendings);
        assertEquals(TAB + MISSING_DESCRIPTION + ADD_COMMAND_FORMAT
                        + System.lineSeparator(), outContent.toString());
    }

    @Test
    void addCommand_invalidDateInput_noIncomeAdded() {
        String userInput = "add income 1000 part-time /2024/10/10";
        Command c = Parser.parse(userInput);
        c.execute(incomes, spendings);
        assertEquals(TAB + INCORRECT_DATE_FORMAT + ADD_COMMAND_FORMAT
                        + System.lineSeparator(), outContent.toString());
    }

    @Test
    void addCommand_invalidDateInput_noSpendingAdded() {
        String userInput = "add spending 1000 ipad /2024/10/10";
        Command c = Parser.parse(userInput);
        c.execute(incomes, spendings);
        assertEquals(TAB + INCORRECT_DATE_FORMAT + ADD_COMMAND_FORMAT
                        + System.lineSeparator(), outContent.toString());
    }
}
