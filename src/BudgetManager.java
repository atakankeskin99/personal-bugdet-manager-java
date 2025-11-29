import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BudgetManager {
    public void clearAllTransactions() {
        transactions.clear();
        nextId = 1;
        saveToFile();
        System.out.println("🧹 All transactions have been cleared.");
    }


    private List<Transaction> transactions = new ArrayList<>();
    private int nextId = 1;
    private final String DATA_FILE = "budget-data.csv";

    public BudgetManager() {
        loadFromFile();
    }

    public void addIncome(double amount, String category, String description) {
        Transaction t = new Transaction(
                nextId++,
                LocalDate.now(),
                amount,
                category,
                description,
                true
        );
        transactions.add(t);
        System.out.println("✅ Income added.");
        saveToFile();
    }

    public void addExpense(double amount, String category, String description) {
        Transaction t = new Transaction(
                nextId++,
                LocalDate.now(),
                -Math.abs(amount), // store as negative
                category,
                description,
                false
        );
        transactions.add(t);
        System.out.println("✅ Expense added.");
        saveToFile();
    }

    public void listTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions yet.");
            return;
        }
        System.out.println("📜 All transactions:");
        for (Transaction t : transactions) {
            System.out.println(t);
        }
    }

    public void showSummary() {
        double totalIncome = 0;
        double totalExpense = 0;

        for (Transaction t : transactions) {
            if (t.isIncome()) {
                totalIncome += t.getAmount();
            } else {
                totalExpense += t.getAmount(); // negative
            }
        }

        double balance = totalIncome + totalExpense; // expense negative

        System.out.println("===== SUMMARY =====");
        System.out.printf("Total income : %.2f ₺%n", totalIncome);
        System.out.printf("Total expense: %.2f ₺%n", Math.abs(totalExpense));
        System.out.printf("Balance      : %.2f ₺%n", balance);

        if (balance > 0) {
            System.out.println("Status: 💚 You are in plus, nice.");
        } else if (balance < 0) {
            System.out.println("Status: 🔴 You are in minus, be careful.");
        } else {
            System.out.println("Status: ⚪ Balanced.");
        }
    }

    private void saveToFile() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(DATA_FILE))) {
            for (Transaction t : transactions) {
                pw.println(t.toCsv());
            }
        } catch (IOException e) {
            System.out.println("❌ Error while saving file: " + e.getMessage());
        }
    }

    private void loadFromFile() {
        File file = new File(DATA_FILE);
        if (!file.exists()) {
            return; // first run, no file yet
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int maxId = 0;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                Transaction t = Transaction.fromCsv(line);
                transactions.add(t);
                if (t.getId() > maxId) {
                    maxId = t.getId();
                }
            }
            nextId = maxId + 1;
        } catch (IOException e) {
            System.out.println("❌ Error while reading file: " + e.getMessage());
        }
    }
}

