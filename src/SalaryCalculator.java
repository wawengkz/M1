public class SalaryCalculator {
    private double baseSalary;
    private double[] allowances;
    private double[] deductions;

    public SalaryCalculator(double baseSalary, double[] allowances, double[] deductions) {
        this.baseSalary = baseSalary;
        this.allowances = allowances;
        this.deductions = deductions;
    }

    public double calculateTotalBaseSalary() {
        double totalAllowances = 0;
        for (double allowance : allowances) {
            totalAllowances += allowance;
        }
        return baseSalary + totalAllowances;
    }

    public double calculateDeductions() {
        double totalDeductions = 0;
        for (double deduction : deductions) {
            totalDeductions += deduction;
        }
        return totalDeductions;
    }

    public double calculateTaxableIncome() {
        double totalBaseSalary = calculateTotalBaseSalary();
        double totalDeductions = calculateDeductions();
        return totalBaseSalary - totalDeductions;
    }

    public double calculateNetPay() {
        // Assuming net pay is the same as salary, but you can implement a different logic here
        return calculateSalary();
    }

    public double calculateSalary() {
        double taxableIncome = calculateTaxableIncome();
        // Implement your tax calculation logic here
        // For simplicity, I'll assume a flat 20% tax rate, you can adjust as needed
        double tax = taxableIncome * 0.20;
        return taxableIncome - tax;
    }
}
