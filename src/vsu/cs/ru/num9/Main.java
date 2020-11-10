package vsu.cs.ru.num9;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        double x = readValue("x");

        if ( x < -1 && x > 1) {
            System.out.print("You entered incorrect x! Variable x must belong to the range from -1 to 1");
            return;
        }

        double epsilon = readValue("epsilon");
        double n = readValue("n");
        
        double sumOfSummandsThisSequence = calcSumOfSummandsThisSequence(x, n);
        System.out.println("Sum of n summands of this sequence = " + sumOfSummandsThisSequence);
        
        Result result = calcSumOfSummandsThisSequenceGreaterThanEpsilon(x, epsilon);
        printResult("Sum of summands with a value greater than epsilon = ", result,
                "Number of summands with a value greater than epsilon = ");

        result = calcSumOfSummandsThisSequenceGreaterThanEpsilon(x, epsilon / 10);
        printResult("Sum of summands with a value greater than epsilon / 10 = ", result,
                "Number of summands with a value greater than epsilon / 10 = ");

        double valueOfFunctionUsingMath = calcValueOfFunctionUsingMath(x);
        System.out.println("Value of function using the Math = " + valueOfFunctionUsingMath);
    }

    private static double readValue(String name) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Input %s: ", name);
        return scanner.nextDouble();
    }

    private static double pow(double x, double degree) {
        double result = 1;
        for (int i = 0; i < degree; i++) {
            result *= x;
        }
        return result;
    }

    private static double calcSumOfSummandsThisSequence(double x, double n) {
        double summand = 1;
        double sum = summand;
        for (double i = 2; i < 2 * n - 2; i += 2) {
            summand *= (i - 1) / i * pow(x, 2);
            sum += summand;
        }
        return sum;
    }

    private static Result calcSumOfSummandsThisSequenceGreaterThanEpsilon(double x, double epsilon) {
        double summand = 1;
        double sumOfSummandsThisSequenceGreaterThanEpsilon = 0;
        double i = 0;
        int numberOfSummandsGreaterThanEpsilon = 0;

        while (Math.abs(summand) > epsilon) {
            sumOfSummandsThisSequenceGreaterThanEpsilon += summand;
            i += 2;
            numberOfSummandsGreaterThanEpsilon++;
            summand *= (i - 1) / i * pow(x, 2);
        }
        return new Result(sumOfSummandsThisSequenceGreaterThanEpsilon, numberOfSummandsGreaterThanEpsilon);
    }

    private static double calcValueOfFunctionUsingMath(double x) {
        return 1 / Math.sqrt(1 - Math.pow(x, 2));
    }

    private static void printResult(String firstPhrase, Result result, String secondPhrase) {
        System.out.printf(firstPhrase + result.getSumOfSummands() + "\n" + secondPhrase + result.getNumberOfSummands() + "\n");
    }
}

