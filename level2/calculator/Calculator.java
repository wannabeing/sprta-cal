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

    // 연산 결과를 저장하는 Queue 컬렉션 생성
    private final Queue<Integer> results = new LinkedList<>();

    // InputReader, OutputPrinter 객체 생성
    InputReader inputReader = new InputReader();
    OutputPrinter outputPrinter = new OutputPrinter();

    // ✅ 생성자
    public Calculator() {
        // FIXME: 추후 레벨 3에서 수정이 필요한 부분
        // 사칙연산 기호와 Operation 객체를 생성 및 연결
        operations = Map.of(
                "+", new Addition(),
                "-", new Subtraction(),
                "*", new Multiplication(),
                "/", new Division()
        );
    }

    // ✅ 계산기 시작 메서드
    public void startCalculate(){
        // 1번째 숫자 입력 받음
        outputPrinter.printNumberPrompt(1);
        int initialNumber = inputReader.getIntInput();

        // 연산 결과
        int resultNumber = continueCalculate(initialNumber);

        // 연산 결과 저장
        results.add(resultNumber);
    }

    // ✅ 계산기 반복 메서드 (Calculator 객체에서만 사용)
    private int continueCalculate(int initialNumber){
        // 누적 연산의 경우를 위해 무한루프
        while(true){
            // 2번째 숫자 입력 받음
            outputPrinter.printNumberPrompt(2);
            int secondNumber = inputReader.getIntInput();

            // Scanner 객체를 통하여 사칙연산 기호를 입력 받음
            outputPrinter.printOperatorPrompt();
            String operator = inputReader.getOperatorInput();

            // 연산 후, 출력
            int result = this.executeOperation(operator, initialNumber, secondNumber);
            outputPrinter.printCalculatePrompt(initialNumber, secondNumber, operator, result);

            // 연산을 계속할지 여부 체크
            outputPrinter.printContinuePrompt();
            boolean isContinue = inputReader.confirmContinue();

            // 연산을 계속할 경우, 2번째 숫자부터 받음
            // 그만둘 경우, 결과를 저장하고 루프 탈출
            if(isContinue) {
               initialNumber = result;
            } else {
                return result;
            }
        }
    }

    // ✅ 연산(계산) 메서드
    public int executeOperation(String operator, int firstNumber, int secondNumber) {
        // 연산자에 해당하는 Operation 객체를 찾아 가져옴
        Operation operation = operations.get(operator);

        // operation.get()으로 찾을 수 없는 경우(사칙연산이 아닐 경우), null 반환됨
        if (operation == null){
            throw new IllegalArgumentException("올바르지 않은 연산자입니다: " + operator);
        }

        // 연산 결과를 반환
        return operation.calculate(firstNumber, secondNumber);
    }

    // ✅ 연산 결과 출력 메서드
    public void printResults() {
        outputPrinter.printResultsPrompt(results);
    }

    // ✅ 연산 결과 삭제 메서드
    public void deleteResults(){
        if(results.isEmpty()){
            outputPrinter.printDeletePrompt(false, results);
        } else {
            outputPrinter.printDeleteMenuPrompt();

            // 삭제할 항목 선택 (1: 최근 결과 삭제, 2: 전체 결과 삭제)
            int deleteOption = inputReader.getDeleteInput();

            // 1: 최근 결과 삭제
            if(deleteOption == 1){
                results.poll();
                outputPrinter.printDeletePrompt(true, results);
            }
            // 2: 전체 결과 삭제
            else if (deleteOption == 2) {
                results.clear();
                outputPrinter.printDeletePrompt(true, results);
            }
            // 잘못된 입력일 경우
            else {
                outputPrinter.printDeletePrompt(false, results);
            }

        }
    }

    // ✅ 계산기 종료 메서드
    public void exitCalculate(){
        outputPrinter.printExitPrompt();

        // 프로그램 종료
        System.exit(0);
    }
}
