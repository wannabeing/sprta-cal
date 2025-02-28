package level2.calculator;

import level2.io.input.InputReader;
import level2.io.output.OutputPrinter;
import level2.operations.*;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Calculator {
    // 사칙연산 기호와 Operation 객체를 매핑하는 Map 컬렉션
    private final Map<String, Operation> operations;

    // 연산 결과를 저장하는 Queue 컬렉션
    private final Queue<Integer> results;

    // ✅ 생성자
    public Calculator() {
        // 연산 결과를 저장하는 Queue 컬렉션 생성
        results = new LinkedList<>();

        // FIXME: 추후 레벨 3에서 수정이 필요한 부분
        // 사칙연산 기호와 Operation 객체를 생성 및 연결
        operations = Map.of(
                "+", new Addition(),
                "-", new Subtraction(),
                "*", new Multiplication(),
                "/", new Division()
        );
    }

    // FIXME: 누적계산에 대한 메서드 분리 필요
    // ✅ 계산기 시작 메서드
    public void startCalculate(){
        InputReader inputReader = new InputReader();
        OutputPrinter outputPrinter = new OutputPrinter();

        // 1번째 숫자 입력 받음
        outputPrinter.printNumberPrompt(1);
        int firstNumber = inputReader.validateIntInput();

        // 중첩 연산의 경우를 위해 무한루프
        while(true){
            // 2번째 숫자 입력 받음
            outputPrinter.printNumberPrompt(2);
            int secondNumber = inputReader.validateIntInput();

            // Scanner 객체를 통하여 사칙연산 기호를 입력 받음
            outputPrinter.printOperatorPrompt();
            String operator = inputReader.validateOperatorInput();

            // 연산 후, 출력
            int result = this.calculate(operator, firstNumber, secondNumber);
            outputPrinter.printCalculatePrompt(firstNumber, secondNumber, operator, result);

            // 연산을 계속할지 여부 체크
            outputPrinter.printContinuePrompt();
            boolean isContinue = inputReader.confirmContinue();

            // 연산을 계속할 경우, 2번째 숫자부터 받음
            // 그만둘 경우, 결과를 저장하고 루프 탈출
            if (isContinue){
                firstNumber = result;
            } else {
                results.add(result);
                break;
            }
        }
    }

    // ✅ 연산 메서드
    public int calculate(String operator, int firstNumber, int secondNumber) {
        // 연산자에 해당하는 Operation 객체를 찾아 가져옴
        Operation operation = operations.get(operator);

        // operation.get()으로 찾을 수 없는 경우(사칙연산이 아닐 경우), null 반환됨
        if (operation == null){
            throw new IllegalArgumentException("올바르지 않은 연산자입니다: " + operator);
        }

        // 연산 결과를 반환
        return operation.calculate(firstNumber, secondNumber);

    }

    // ✅ 연산 결과 반환 메서드
    public Queue<Integer> getResults() {
        return results;
    }

    // FIXME: 미구현 메서드
    // ✅ 연산 결과 삭제 메서드 (1개)
    public void removeResult() {
        if (results.isEmpty()) {
            System.out.println("삭제할 연산 결과가 없습니다.");
        } else {
            int removedResult = results.poll();
            System.out.println("정상적으로 삭제되었습니다.");
            System.out.println("저장된 연산 결과: " + removedResult);
        }
    }

    // FIXME: 미구현 메서드
    // ✅ 연산 결과 삭제 메서드 (모두)
    public void removeResultAll() {
        if (results.isEmpty()) {
            System.out.println("삭제할 연산 결과가 없습니다.");
        } else {
            results.clear();
            System.out.println("모든 연산 결과가 삭제되었습니다.");
        }
    }
}
