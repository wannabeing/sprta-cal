package level3.calculator;

import level3.io.input.InputReader;
import level3.io.output.OutputPrinter;
import level3.operations.*;

import java.util.LinkedList;
import java.util.Queue;

public class Calculator {
    // 연산 결과를 저장하는 Queue 컬렉션 생성
    private final Queue<Integer> results = new LinkedList<>();

    // InputReader, OutputPrinter 객체 생성
    InputReader inputReader = new InputReader();
    OutputPrinter outputPrinter = new OutputPrinter();


    // ✅ 계산기 시작 메서드
    public void start(){
        // 1번째 숫자 입력 받음
        outputPrinter.printNumberPrompt(1);
        int initialNumber = inputReader.getNumberInput();

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
            int secondNumber = inputReader.getNumberInput();

            // Scanner 객체를 통하여 사칙연산 기호를 입력 받음
            outputPrinter.printOperatorPrompt();
            String userOperator = inputReader.getOperatorInput();

            // 연산 후, 출력
            int result = executeOperation(userOperator, initialNumber, secondNumber);
            outputPrinter.printCalculatePrompt(initialNumber, secondNumber, userOperator, result);

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
    public int executeOperation(String userOperator, int firstNumber, int secondNumber) {
        Operator operator = Operator.findByOperator(userOperator);

        return operator.calculate(firstNumber, secondNumber);
    }

    // ✅ 연산 결과 출력 메서드
    public void printResults() {
        outputPrinter.printResultsPrompt(results);
    }

    // ✅ 연산 결과 삭제 메서드
    public void delete(){
        boolean isSuccess = false; // ✅삭제 성공 여부

        if(results.isEmpty()){
            outputPrinter.printDeletePrompt(isSuccess, results);
        } else {
            // 삭제 메뉴 출력
            outputPrinter.printDeleteMenuPrompt();

            // 사용자 입력 받는 변수 (1: 최근 결과 삭제, 2: 전체 결과 삭제)
            int deleteOption = inputReader.getDeleteInput();

            switch (deleteOption){
                case 1 -> {
                    isSuccess = (results.poll() != null); // poll() 반환 값이 null 아니면 true 값을 isSuccess 에 저장
                }
                case 2 -> {
                    results.clear();
                    isSuccess = true;
                }
            }
            // 삭제 결과 출력
            outputPrinter.printDeletePrompt(isSuccess, results);
        }
    }

    // ✅ 계산기 종료 메서드
    public void exit(){
        // 종료 메시지 출력
        outputPrinter.printExitPrompt();

        System.exit(0);
    }
}
