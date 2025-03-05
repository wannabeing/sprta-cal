package level3.operations;

import java.util.Arrays;

public enum Operator {
    // ✅ADD, SUBTRACT, MULTIPLY, DIVIDE Enum 객체 생성
    ADD("+", ((firstNumber, secondNumber) -> firstNumber + secondNumber)),
    SUBTRACT("-", ((firstNumber, secondNumber) -> firstNumber - secondNumber)),
    MULTIPLY("*", (firstNumber, secondNumber) -> firstNumber * secondNumber),
    DIVIDE("/", (firstNumber, secondNumber) -> {
        if (secondNumber == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
        return firstNumber / secondNumber;
    });

    private final String symbol; // ✅연산자 기호 (+, -, *, /)
    private final Operation operation; // ✅연산 기능 (함수형 인터페이스)

    // ✅생성자
    Operator(String userOperator, Operation operation) {
        this.symbol = userOperator;
        this.operation = operation;
    }

    // ✅Getter || 연산자 기호(Operator) 반환 메서드
    public String getSymbol() {
        return symbol;
    }

    // ✅연산 메서드
    public int calculate(int firstNumber, int secondNumber) {
        return operation.calculate(firstNumber, secondNumber);
    }

    // ✅문자열로부터 Operator 객체를 찾아 반환하는 메서드
    public static Operator findByOperator(String userOperator) {
        return Arrays.stream(values()) // 1. enum의 모든 항목(ADD, SUBTRACT, MULTIPLY, DIVIDE)을 Stream 으로 변환
                .filter(op -> op.symbol.equals(userOperator)) // 2. op.symbol == userOperator 인 경우를 찾음
                .findFirst() // 3. 찾은 첫 번째 요소 반환
                .orElseThrow(() -> new IllegalArgumentException("올바르지 않은 연산자입니다: " + userOperator)); // 4. 찾지 못한 경우 예외처리 (inputReader 에서 예외처리하므로 발생확률 ↓)
    }

}
