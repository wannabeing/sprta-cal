package level2;

import level2.calculator.Calculator;
import level2.io.input.InputReader;
import level2.io.output.OutputPrinter;

public class Main {
    public static void main(String[] args) {
        while (true) {
            InputReader inputReader = new InputReader();
            OutputPrinter outputPrinter = new OutputPrinter();

            Calculator calculator = new Calculator();

            // 메뉴 출력
            outputPrinter.printMenuPrompt();

            // 1. 계산하기, 2. 출력하기(All), 3. 삭제하기, 4. 종료하기
            int choiceNumber = inputReader.validateIntInput();

            switch (choiceNumber) {
                case 1 -> calculator.startCalculate();
                case 2 -> System.out.println(2); // FIXME: 미구현
                case 3 -> System.out.println(3); // FIXME: 미구현
                case 4 -> outputPrinter.printExitPrompt();
                default -> System.out.println("올바른 번호를 입력하세요.");
            }
        }
    }



}
