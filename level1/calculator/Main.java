package level1.calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Scanner 객체를 통하여 양의 정수 2개를 입력 받습니다.
            System.out.print("첫번째 숫자를 입력하세요. (exit 입력 시 종료): ");
            int firstNumber = readInt(scanner);

            System.out.print("두번째 숫자를 입력하세요. (exit 입력 시 종료): ");
            int secondNumber = readInt(scanner);

            // 개행 문자 제거
            scanner.nextLine();

            // Scanner 객체를 통하여 사칙연산 기호를 입력 받습니다.
            System.out.print("사칙연산 기호를 입력하세요! (+, -, *, /): ");
            String operator = readOperator(scanner);

            // 입력 받은 사칙연산 기호에 따라 연산을 수행합니다.
            int result = calculate(firstNumber, secondNumber, operator);
        }
    }

    // 사용자의 숫자 입력 값을 검증하는 메서드
    private static int readInt(Scanner scanner) {
        // 입력 값이 "exit"일 경우 프로그램을 종료합니다.
        if (scanner.hasNext("exit")) {
            System.out.println("프로그램을 종료합니다.");
            System.exit(0);
        }

        // 입력 값이 숫자가 아닐 경우 다시 입력 받도록 합니다.
        while (!scanner.hasNextInt()) {
            System.out.print("올바른 숫자를 입력하세요!: ");
            scanner.next(); // 잘못된 입력 제거
        }
        // 입력 값이 올바를 경우, 반환합니다.
        return scanner.nextInt();
    }

    // 사용자의 사칙연산 값을 검증하는 메서드
    private static String readOperator(Scanner scanner) {
        while (true) {
            String operator = scanner.next();
            // 입력 값이 사칙연산 기호일 경우 반환합니다.
            if (operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/")) {
                return operator;
            }
            // 입력 값이 사칙연산 기호가 아닐 경우 다시 입력 받도록 합니다.
            System.out.print("올바른 사칙연산 기호를 입력하세요! (+, -, *, /): ");
        }
    }

    // 사칙연산 수행 메서드
    private static int calculate(int firstNumber, int secondNumber, String operator) {
        return switch (operator) {
            case "+" -> firstNumber + secondNumber;
            case "-" -> firstNumber - secondNumber;
            case "*" -> firstNumber * secondNumber;
            case "/" -> {
                // 두번째 정수가 0일 경우, 예외 처리
                if (secondNumber == 0) {
                    System.out.println("0으로 나눌 수 없습니다. 다시 입력하세요.");
                    yield 0;
                }
                yield firstNumber / secondNumber;
            } default -> {
                System.out.println("올바른 접근이 아닙니다.");
                yield 0;
            }
        };
    }
}