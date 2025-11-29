import java.time.LocalDate;

public class Transaction {
    private int id;
    private LocalDate date;
    private double amount;
    private String category;
    private String description;
    private boolean income; // true = income, false = expense

    public Transaction(int id, LocalDate date, double amount,
                       String category, String description, boolean income) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.category = category;
        this.description = description;
        this.income = income;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public boolean isIncome() {
        return income;
    }

    @Override
    public String toString() {
        String type = income ? "INCOME" : "EXPENSE";
        return String.format(
                "[%d] %s | %s | %.2f ₺ | Category: %s | Description: %s",
                id, date, type, amount, category, description
        );
    }

    // Convert object to CSV format
    public String toCsv() {
        return id + ";" + date + ";" + amount + ";" +
                category.replace(";", ",") + ";" +
                description.replace(";", ",") + ";" +
                income;
    }

    // Convert CSV string to Transaction object
    public static Transaction fromCsv(String line) {
        String[] parts = line.split(";");
        if (parts.length != 6) {
            throw new IllegalArgumentException("Invalid CSV line: " + line);
        }
        int id = Integer.parseInt(parts[0]);
        LocalDate date = LocalDate.parse(parts[1]);
        double amount = Double.parseDouble(parts[2]);
        String category = parts[3];
        String description = parts[4];
        boolean income = Boolean.parseBoolean(parts[5]);
        return new Transaction(id, date, amount, category, description, income);
    }
}


