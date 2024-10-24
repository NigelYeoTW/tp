package seedu.commands;

import seedu.classes.Parser;
import seedu.classes.Ui;
import seedu.type.Income;
import seedu.type.IncomeList;
import seedu.type.SpendingList;
import seedu.type.Spending;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.classes.Constants.VALID_TEST_DATE;

class ListCommandTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    private final IncomeList incomes = new IncomeList();
    private final SpendingList spendings = new SpendingList();
    private final LocalDate currentDate = LocalDate.now();

    private void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    @BeforeEach
    public void setUp() {
        spendings.add(new Spending(10, "girlfriends", VALID_TEST_DATE));
        spendings.add(new Spending(10, "macdonalds", VALID_TEST_DATE));
        incomes.add(new Income(10, "savings", VALID_TEST_DATE));
        incomes.add(new Income(10, "dividends", VALID_TEST_DATE));
        provideInput("N");
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public void restore() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void execute_emptyList_success() {
        IncomeList emptyIncomes = new IncomeList();
        SpendingList emptySpendings = new SpendingList();
        String userInout = "list";
        Command c = Parser.parse(userInout);
        c.execute(emptyIncomes, emptySpendings);

        assertEquals("\tSpendings" + System.lineSeparator() +
                        "\tTotal spendings: 0" + System.lineSeparator() +
                        "\tIncomes" + System.lineSeparator() +
                        "\tTotal incomes: 0" + System.lineSeparator(),
                outContent.toString());
    }

    @Test
    public void execute_allLists_success() {
        String userInout = "list";
        Command c = Parser.parse(userInout);
        c.execute(incomes, spendings);

        assertEquals("\tSpendings" + System.lineSeparator() +
                        "\t1. girlfriends - 10 - " + currentDate + System.lineSeparator() +
                        "\t2. macdonalds - 10 - " + currentDate + System.lineSeparator() +
                        "\tTotal spendings: 20" + System.lineSeparator() +
                        "\tIncomes" + System.lineSeparator() +
                        "\t1. savings - 10 - " + currentDate + System.lineSeparator() +
                        "\t2. dividends - 10 - " + currentDate + System.lineSeparator() +
                        "\tTotal incomes: 20" + System.lineSeparator(),
                outContent.toString());
    }

    @Test
    public void execute_listIncome_success() {
        String userInout = "list incomes";
        Command c = Parser.parse(userInout);
        c.execute(incomes, spendings);

        assertEquals("\tIncomes" + System.lineSeparator() +
                        "\t1. savings - 10 - " + currentDate + System.lineSeparator() +
                        "\t2. dividends - 10 - " + currentDate + System.lineSeparator() +
                        "\tTotal incomes: 20" + System.lineSeparator(),
                outContent.toString());
    }

    @Test
    public void execute_randomInput_exceptionThrown() {
        String userInout = "list 1234";
        Command c = Parser.parse(userInout);
        c.execute(incomes, spendings);

        assertEquals("\tNo such category. Please enter in the form: list [spendings/incomes]" +
                System.lineSeparator(), outContent.toString());
    }

    @Test
    public void execute_tooManyInputs_exceptionThrown() {
        String userInout = "list spendings incomes";
        Command c = Parser.parse(userInout);
        c.execute(incomes, spendings);

        assertEquals("\tToo many arguments. Please enter in the form: list [spendings/incomes]" +
                System.lineSeparator(), outContent.toString());
    }

    @Test
    public void execute_listSpendingAllStatistics_correctMessage() {
        String userInout = "list spendings";
        Command c = Parser.parse(userInout);
        Ui.userInputForTest("Y");
        c.execute(incomes, spendings);

        assertEquals("\tList all statistics? [Y/N]:" + System.lineSeparator() +
                        "\t____________________________________________________________" + System.lineSeparator() +
                        "\tSpendings" + System.lineSeparator() +
                        "\t1. girlfriends - 10 - " + currentDate + System.lineSeparator() +
                        "\t2. macdonalds - 10 - " + currentDate + System.lineSeparator() +
                        "\tTotal spendings: 20" + System.lineSeparator() +
                        "\t\tDaily spendings: 20" + System.lineSeparator() +
                        "\t\tDaily Budget: 0" + System.lineSeparator() +
                        "\t\tDaily budget left: -20" + System.lineSeparator() +
                        "\t\tMonthly spendings: 20" + System.lineSeparator() +
                        "\t\tMonthly Budget: 0" + System.lineSeparator() +
                        "\t\tMonthly budget left: -20" + System.lineSeparator() +
                        "\t\tYearly spendings: 20" + System.lineSeparator() +
                        "\t\tYearly Budget: 0" + System.lineSeparator() +
                        "\t\tYearly budget left: -20" + System.lineSeparator(),
                outContent.toString());
    }

    @Test
    public void execute_listSpendingNotAllStatistics_correctMessage() {
        String userInout = "list spendings";
        Command c = Parser.parse(userInout);
        Ui.userInputForTest("N");
        c.execute(incomes, spendings);
        assertEquals("\tList all statistics? [Y/N]:" + System.lineSeparator() +
                        "\t____________________________________________________________" + System.lineSeparator() +
                        "\tSpendings" + System.lineSeparator() +
                        "\t1. girlfriends - 10 - " + currentDate + System.lineSeparator() +
                        "\t2. macdonalds - 10 - " + currentDate + System.lineSeparator() +
                        "\tTotal spendings: 20" + System.lineSeparator(),
                outContent.toString());
    }
}
