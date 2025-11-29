import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BudgetManager manager = new BudgetManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== PERSONAL BUDGET MANAGER =====");
            System.out.println("1) Add income");
            System.out.println("2) Add expense");
            System.out.println("3) List all transactions");
            System.out.println("4) Show summary");
            System.out.println("5) Clear ALL data");
            System.out.println("0) Exit");
            System.out.print("Your choice: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.print("Amount (₺): ");
                    double incomeAmount = Double.parseDouble(scanner.nextLine());
                    System.out.print("Category (e.g. Salary): ");
                    String incomeCat = scanner.nextLine();
                    System.out.print("Description: ");
                    String incomeDesc = scanner.nextLine();
                    manager.addIncome(incomeAmount, incomeCat, incomeDesc);
                    break;

                case "2":
                    System.out.print("Amount (₺): ");
                    double expenseAmount = Double.parseDouble(scanner.nextLine());
                    System.out.print("Category (e.g. Market, Bills): ");
                    String expenseCat = scanner.nextLine();
                    System.out.print("Description: ");
                    String expenseDesc = scanner.nextLine();
                    manager.addExpense(expenseAmount, expenseCat, expenseDesc);
                    break;

                case "3":
                    manager.listTransactions();
                    break;

                case "4":
                    manager.showSummary();
                    break;

                case "0":
                    System.out.println("C-ya👋");
                    scanner.close();

                case "5":
                    System.out.println("Are you sure? This will delete ALL transactions! (y/n)");
                    String confirm = scanner.nextLine().trim().toLowerCase();
                    if (confirm.equals("y")) {
                        manager.clearAllTransactions();
                    } else {
                        System.out.println("Cancelled.");
                    }
                    break;

                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }
}



