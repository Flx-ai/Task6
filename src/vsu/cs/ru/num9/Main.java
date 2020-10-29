package vsu.cs.ru.num9;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        double x = readValue("x");

        if (!checkInput(x)) {
            System.out.print("You entered incorrect x!");
            return;
        }

        double epsilon = readValue("epsilon");
        double n = readValue("n");

        double sumOfSummandsThisSequence = calcSumOfSummandsThisSequence(x, n);
        printResult("Sum of n summands of this sequence = ", sumOfSummandsThisSequence);
        System.out.println();

        double[] arrayOfValues;
        arrayOfValues = calcSumOfSummandsThisSequenceGreaterThanEpsilon(x, epsilon);
        double numberOfSummandsGreaterThanEpsilon = arrayOfValues[0];
        double sumOfSummandsThisSequenceGreaterThanEpsilon = arrayOfValues[1];
        printResult("Number of summands with a value greater than epsilon = ", numberOfSummandsGreaterThanEpsilon,
                        "Sum of summands with a value greater than epsilon = ", sumOfSummandsThisSequenceGreaterThanEpsilon);

        arrayOfValues = calcSumOfSummandsThisSequenceGreaterThanEpsilon(x, epsilon / 10);
        double numberOfSummandsGreaterThanEpsilonDividedBy10 = arrayOfValues[0];
        double sumOfSummandsThisSequenceGreaterThanEpsilonDividedBy10 = arrayOfValues[1];
        printResult("Number of summands with a value greater than epsilon / 10 = ", numberOfSummandsGreaterThanEpsilonDividedBy10,
                "Sum of summands with a value greater than epsilon / 10 = ", sumOfSummandsThisSequenceGreaterThanEpsilonDividedBy10);

        double valueOfFunctionUsingMath = calcValueOfFunctionUsingMath(x);
        printResult("Value of function using the Math = ", valueOfFunctionUsingMath);
    }

    private static double readValue(String name) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Input %s: ", name);
        return scanner.nextDouble();
    }

    private static boolean checkInput(double x) {
        return x > -1 && x < 1;
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

    private static double[] calcSumOfSummandsThisSequenceGreaterThanEpsilon(double x, double epsilon) {
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

        double[] arrayOfValues = new double[2];
            arrayOfValues[0] = numberOfSummandsGreaterThanEpsilon;
            arrayOfValues[1] = sumOfSummandsThisSequenceGreaterThanEpsilon;
        return arrayOfValues;
    }

    private static double calcValueOfFunctionUsingMath(double x) {
        return 1 / Math.sqrt(1 - Math.pow(x,2));
    }

    private static void printResult(String firstPhrase, double firstResult, String secondPhrase, double secondResult) {
        System.out.printf(firstPhrase + firstResult + "\n" + secondPhrase + secondResult + "\n");
    }

    private static void printResult(String phrase, double result) {
        System.out.print(phrase + result);
    }

}
