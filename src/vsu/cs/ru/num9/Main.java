package vsu.cs.ru.num9;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        double x = readValue("x");
        if (!checkInput(x)) return;
        double epsilon = readValue("epsilon");
        double n = readValue("n");

        double sumOfSummandsThisSequence = calcSumOfSummandsThisSequence(x,n);
        double sumOfSummandsThisSequenceWithEpsilon = calcSumOfSummandsThisSequenceWithEpsilon(x, epsilon);
        double sumOfSummandsThisSequenceWithEpsilonDividedBy10 = calcSumOfSummandsThisSequenceWithEpsilon(x, epsilon/10);
        double valueOfFunctionUsingMath = calcValueOfFunctionUsingMath(x);

        printResult("Сумма n слагаемых заданной последовательности = ", sumOfSummandsThisSequence);
        printResult("Сумма слагаемых, которые по абсолютной величине > epsilon = ", sumOfSummandsThisSequenceWithEpsilon);
        printResult("Сумма слагаемых, которые по абсолютной величине > epsilon / 10 = ", sumOfSummandsThisSequenceWithEpsilonDividedBy10);
        printResult("Значение заданной функции с помощью методов Math =  ", valueOfFunctionUsingMath);
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

    private static double calcSumOfSummandsThisSequenceWithEpsilon(double x, double epsilon) {
        double summand = 0;
        double nextSummand = 1;
        double sum = 0;
        double i = 0;

        while (Math.abs(summand - nextSummand) > epsilon) {
            summand = nextSummand;
            sum += summand;
            i += 2;
            nextSummand *= (i - 1) / i * pow(x, 2);
        }
        return sum;
    }

    private static double calcValueOfFunctionUsingMath(double x) {
        return 1 / Math.sqrt(1 - Math.pow(x,2));
    }

    private static void printResult(String str, double result) {
        System.out.println(str + result);
    }
}
