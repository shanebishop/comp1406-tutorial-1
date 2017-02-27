import java.util.Scanner;

public class TaxProgram {
    public static void main(String[] args) {
        double income, fedTax, provTax, baseProvTax, deductions, totalTax;
        int    dependents;

        System.out.print("Please enter your taxable income: ");
        income = new Scanner(System.in).nextDouble();

        System.out.print("Please enter your number of dependents: ");
        dependents = new Scanner(System.in).nextInt();

        fedTax  = 0.0;
        provTax = 0.0;

        if (income < 29590) {
            fedTax = income * 0.17;
        }
        else if (income < 59180) {
            fedTax = (29590 * 0.17) + ((income - 29590) * 0.26);
        }
        else {
            fedTax = (29590 * 0.17) + (29590 * 0.26) + ((income - 59180) * 0.29);
        }

        baseProvTax = fedTax * 0.425;
        deductions  = 160.5 + 328 * dependents;

        if (baseProvTax < deductions) {
            provTax = 0;
        }
        else {
            provTax = baseProvTax - deductions;
        }

        totalTax = fedTax + provTax;

        // Print statements
        System.out.println("Here is your tax breakdown:");
        System.out.println();
        System.out.println(String.format("%-18s$%,8.2f", "Income", income));
        System.out.println(String.format("%-18s%10d", "Dependents", dependents));
        System.out.println("----------------------------");
        System.out.println(String.format("%-18s$%,9.2f", "Federal Tax", fedTax));
        System.out.println(String.format("%-18s$%,9.2f", "Provincial Tax", provTax));
        System.out.println("============================");
        System.out.println(String.format("%-18s$%,9.2f", "Total Tax", totalTax));
    }
}
