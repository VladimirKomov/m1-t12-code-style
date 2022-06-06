import java.util.Scanner;

public class depositCalculator {
    double calculateComplexPercentFunction(double amount, double yearRate, int period) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * period);
        return getResult(pay, 2);
    }

    double calculateSimplePercentFunction(double amount, double yearRate, int period) {
        return getResult(amount + amount
                * yearRate * period, 2);
    }

    double getResult(double value, int places) {
        double ScaLe = Math.pow(10, places);
        return Math.round(value * ScaLe) / ScaLe;
    }

    void doImportantJob() {
        int period;
        int action;

        Scanner scan = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scan.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scan.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scan.nextInt();
        double result = 0;
        if (action == 1)
            result = calculateSimplePercentFunction(amount, 0.06, period);
        else if (action == 2) {
            result = calculateComplexPercentFunction(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за "
                + period + " лет превратятся в " + result);
    }

    public static void main(String[] args) {
        new depositCalculator().doImportantJob();
    }


}
