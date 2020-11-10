package vsu.cs.ru.num9;

public class Result {
    private double sumOfSummands;
    private int numberOfSummands;

    public Result(double sumOfSummands, int numberOfSummands) {
        this.sumOfSummands = sumOfSummands;
        this.numberOfSummands = numberOfSummands;
    }

    public double getSumOfSummands() {
        return sumOfSummands;
    }

    public int getNumberOfSummands() {
        return numberOfSummands;
    }
}

