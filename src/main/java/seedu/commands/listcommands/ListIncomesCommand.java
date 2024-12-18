package seedu.commands.listcommands;

import seedu.classes.Ui;
import seedu.commands.Command;
import seedu.exception.WiagiMissingParamsException;
import seedu.type.IncomeList;
import seedu.type.SpendingList;

import static seedu.classes.Constants.INCORRECT_PARAMS_NUMBER;
import static seedu.classes.Constants.LIST_COMMAND_FORMAT;
import static seedu.classes.Constants.LIST_TYPE_INDEX;
import static seedu.classes.Constants.LIST_COMPULSORY_ARGUMENTS_LENGTH;

public class ListIncomesCommand extends Command {

    public static final String COMMAND_WORD = "incomes";
    private final String[] arguments;

    public ListIncomesCommand(String[] fullCommands) {
        this.arguments = fullCommands;
    }

    @Override
    public void execute(IncomeList incomes, SpendingList spendings) {
        assert arguments[LIST_TYPE_INDEX].equals(COMMAND_WORD) : "command should be to list incomes";
        try {
            handleCommand(incomes);
        } catch (WiagiMissingParamsException e) {
            Ui.printWithTab(e.getMessage());
        }
    }

    private void handleCommand(IncomeList incomes) throws WiagiMissingParamsException {
        if (arguments.length != LIST_COMPULSORY_ARGUMENTS_LENGTH) {
            throw new WiagiMissingParamsException(INCORRECT_PARAMS_NUMBER + LIST_COMMAND_FORMAT);
        }
        boolean isListAllIncomes =  Ui.printListOfTimeRange(incomes);
        if (isListAllIncomes) {
            Ui.printArrList(incomes);
        }
    }
}
