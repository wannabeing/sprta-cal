package level2.operations;

public class Addition implements Operation {
    @Override
    public int calculate(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }
}
