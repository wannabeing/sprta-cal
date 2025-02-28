package level2.operations;

public class Subtraction implements Operation {
    @Override
    public int calculate(int firstNumber, int secondNumber) {
        return firstNumber - secondNumber;
    }
}
