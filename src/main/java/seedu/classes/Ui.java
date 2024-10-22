package seedu.classes;

import seedu.exception.WiagiInvalidInputException;
import seedu.type.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Ui {
    private final Scanner scanner;

    public Ui() {
        scanner = new Scanner(System.in);
    }
    public String readCommand() {
        String line = scanner.nextLine();
        Ui.printSeparator();
        return line;
    }
    public static void printSeparator() {
        printWithTab(Constants.SEPARATOR);
    }
    public static void printWithTab(String message) {
        System.out.println("\t" + message);
    }
    public static void welcome() {
        Ui.printSeparator();
        Ui.printWithTab("Hello from");
        printFancyWiagi();
        Ui.printSeparator();
    }
    private static void printFancyWiagi() {
        Ui.printWithTab("__        __  ___      /\\       ____   ___");
        Ui.printWithTab("\\ \\      / / |_ _|    /  \\     / ___| |_ _|");
        Ui.printWithTab(" \\ \\ /\\ / /   | |    / /\\ \\   | |  _   | |");
        Ui.printWithTab("  \\ V  V /    | |   / ____ \\  | |_| |  | |");
        Ui.printWithTab("   \\_/\\_/    |___| /_/    \\_\\  \\____| |___|");
        Ui.printSeparator();
    }

    public static void printSpendings(SpendingList spendings) {
        Ui.printWithTab("Spendings");
        Ui.printWithTab("Total spendings: " + print_list(spendings));
        Ui.printWithTab("Daily spendings: " + spendings.getDailySpending() + " Daily Budget: " +
                spendings.getDailyBudget());
        Ui.printWithTab("Monthly spendings: " + spendings.getMonthlySpending() + " Monthly Budget: " +
                spendings.getMonthlyBudget());
        Ui.printWithTab(("Yearly spendings: " + spendings.getYearlySpending() + " Yearly Budget: " +
                spendings.getYearlyBudget()));
    }

    public static void printIncomes(IncomeList incomes) {
        Ui.printWithTab("Incomes");
        Ui.printWithTab("Total incomes: " + print_list(incomes));
    }

    /**
     * Prints the elements of the given ArrayList and calculates the sum of their amounts.
     *
     * @param <T>     The type of elements in the ArrayList, which must extend the Type class.
     * @param arrList The ArrayList containing elements to be printed and summed.
     * @return The sum of the amounts of the elements in the ArrayList as a String.
     */
    public static <T> String print_list(ArrayList<T> arrList) {
        int sum = 0;
        for (int i = 0; i < arrList.size(); i++) {
            int oneIndexedI = i + 1;
            sum += ((Type) arrList.get(i)).getAmount();
            Ui.printWithTab(oneIndexedI + ". " + arrList.get(i));
        }
        return String.valueOf(sum);
    }

    public static void printAllTags(IncomeList incomes, SpendingList spendings) {
        ArrayList<String> tags = new ArrayList<>();
        tags.add("");
        for (Income income : incomes) {
            String tag = income.getTag();
            if (!tags.contains(tag)) {
                tags.add(tag);
            }
        }
        for (Spending spending : spendings) {
            String tag = spending.getTag();
            if (!tags.contains(tag)) {
                tags.add(tag);
            }
        }
        tags.remove("");
        tags.sort(String::compareTo);
        if (tags.isEmpty()) {
            throw new WiagiInvalidInputException("No tags found. Please input more tags!");
        }
        Ui.printWithTab("Tags");
        for (int i = 0; i < tags.size(); i++) {
            int oneIndexedI = i + 1;
            Ui.printWithTab(oneIndexedI + ". " + tags.get(i));
        }
    }

    public static void printSpecificTag(IncomeList incomes, SpendingList spendings, String tag) {
        StringBuilder sbIncome = new StringBuilder();
        StringBuilder sbSpending = new StringBuilder();
        int tagsCount = 0;
        int incomeCount = 0;
        int spendingCount = 0;
        sbIncome.append("\tIncomes\n");
        for (int i = 0; i < incomes.size(); i++) {
            Income income = incomes.get(i);
            if (income.getTag().equals(tag)) {
                tagsCount++;
                incomeCount++;
                int oneIndexedI = i + 1;
                sbIncome.append("\t").append(oneIndexedI).append(". ").append(income).append("\n");
            }
        }
        sbSpending.append("Spendings\n");
        for (int i = 0; i < spendings.size(); i++) {
            Spending spending = spendings.get(i);
            if (spending.getTag().equals(tag)) {
                tagsCount++;
                spendingCount++;
                int oneIndexedI = i + 1;
                sbSpending.append("\t").append(oneIndexedI).append(". ").append(spending).append("\n");
            }
        }
        if (tagsCount == 0) {
            throw new WiagiInvalidInputException("No entries with tag: " + tag + ". Please input tags first!");
        }
        Ui.printWithTab("Tag: " + tag);
        if (incomeCount > 0) {
            Ui.printWithTab(sbIncome.toString().trim());
        }
        if (spendingCount > 0) {
            Ui.printWithTab(sbSpending.toString().trim());
        }
    }
}
