package seedu.commands;

import seedu.classes.Ui;
import seedu.type.IncomeList;
import seedu.type.SpendingList;

public class ByeCommand extends Command {
    @Override
    public void execute(IncomeList incomes, SpendingList spendings) {
        Ui.printWithTab("Bye. Hope to see you again soon!");
    }
}