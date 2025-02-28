package level2.operations;

public class Division implements Operation {
    @Override
    public int calculate(int firstNumber, int secondNumber) {
        if (secondNumber == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        return firstNumber / secondNumber;
    }
}
