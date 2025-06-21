import java.util.Scanner;

public class FinancialForecasting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Enter initial investment amount: ");
        double principal = sc.nextDouble();

        System.out.print("Enter annual interest rate (%): ");
        double annualRate = sc.nextDouble() / 100;

        System.out.print("Enter number of years: ");
        int years = sc.nextInt();

        System.out.print("Enter annual contribution: ");
        double annualContribution = sc.nextDouble();

        // Forecasting
        System.out.println();
        for (int i = 1; i <= years; i++) {
            principal += annualContribution; 
            principal *= (1 + annualRate);    
            System.out.printf("Year %d: ₹%.2f%n", i, principal);
        }
        System.out.printf("%nFuture Value after %d years: ₹%.2f%n", years, principal);

        sc.close();
    }
}
