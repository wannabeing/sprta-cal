package level3;

import level3.calculator.Calculator;
import level3.io.input.InputReader;
import level3.io.output.OutputPrinter;

public class Main {
    public static void main(String[] args) {
        // 계산기 객체 생성
        Calculator calculator = new Calculator();

        // InputReader, OutputPrinter 객체 생성
        InputReader inputReader = new InputReader();
        OutputPrinter outputPrinter = new OutputPrinter();

        // 무한 루프 시작
        while (true) {
            // 계산기 메뉴 출력
            outputPrinter.printMenuPrompt();

            // 1. 계산하기, 2. 출력하기(All), 3. 삭제하기, 4. 종료하기
            int choiceNumber = inputReader.getNumberInput();

            switch (choiceNumber) {
                case 1 -> calculator.start();
                case 2 -> calculator.printResults();
                case 3 -> calculator.delete();
                case 4 -> calculator.exit();
                default -> System.out.println("올바른 번호를 입력하세요.");
            }
        }
    }



}
