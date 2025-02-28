package level2.operations;

public class Multiplication implements Operation {
    @Override
    public int calculate(int firstNumber, int secondNumber) {
        return firstNumber * secondNumber;
    }
}
