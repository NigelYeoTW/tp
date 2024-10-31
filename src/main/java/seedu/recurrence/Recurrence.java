package seedu.recurrence;

import seedu.type.Income;
import seedu.type.IncomeList;
import seedu.type.Spending;
import seedu.type.SpendingList;
import seedu.type.EntryType;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;

/**
 * Abstract class for {@code DailyRecurrence}, {@code MonthlyRecurrence} and {@code YearlyRecurrence}. Used to manage
 * recurring entries in the user's {@code IncomeList} and {@code SpendingList} and add recurring entries when needed
 */
public abstract class Recurrence {
    /**
     * Retrieves the last day of the month, given the current month and year. Includes leap year as well.
     *
     * @param newEntry New entry that is added to {@code SpendingList} or {@code IncomeList} from recurrence
     * @return Last day of the month
     */
    protected int getLastDayOfMonth(LocalDate newEntry) {
        YearMonth date = YearMonth.of(newEntry.getYear(), newEntry.getMonth());
        return date.atEndOfMonth().getDayOfMonth();
    }

    /**
     * Checks if date of recurrence entry is legitimate due to varying total days in months, causing actual date of
     * recurrence to be overwritten
     *
     * @param newEntry New entry that is added to `SpendingList` or `IncomeList` from recurrence
     * @param checkDate Date to be checked if it is correct
     */
    protected <T extends EntryType> void checkIfDateAltered(T newEntry, LocalDate checkDate, ArrayList<T> list) {
        int dayOfSupposedRecurrence = newEntry.getDayOfRecurrence();
        int lastDayOfNewEntryMonth = getLastDayOfMonth(newEntry.getDate());
        int actualDayToRecur = Math.min(dayOfSupposedRecurrence, lastDayOfNewEntryMonth);
        newEntry.editDateWithLocalDate(checkDate.withDayOfMonth(actualDayToRecur));
        if (!newEntry.getDate().isAfter(LocalDate.now())) {
            list.add(newEntry);
        }
    }

    /**
     * Checks the {@code Income} entry if there is a need to add a recurring {@code Income} entry to the user's
     * {@code IncomeList}
     *
     * @param recurringIncome {@code Income} entry to be checked
     * @param incomes {@code IncomeList} of the user
     */
    public abstract void checkIncomeRecurrence(Income recurringIncome, IncomeList incomes);

    /**
     * Checks the {@code Spending} entry if there is a need to add a recurring{@code spending} entry to the user's
     * {@code SpendingList}
     *
     * @param recurringSpending {@code Spending} entry to be checked
     * @param spendings {@code SpendingList} of the user
     */
    public abstract void checkSpendingRecurrence(Spending recurringSpending, SpendingList spendings);
}
