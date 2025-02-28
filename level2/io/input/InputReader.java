package level2.io.input;

import java.util.Scanner;


public class InputReader {
    // FIXME: validation 메서드 분리 필요
    // Scanner 객체 생성
    private static final Scanner scanner = new Scanner(System.in);

    // ✅ 사용자의 숫자 입력 값을 검증하는 메서드
    public int validateIntInput() {
        // 입력 값이 숫자가 아닐 경우 다시 입력 받음
        while (!scanner.hasNextInt()) {
            System.out.print("올바른 숫자를 입력하세요!: ");
            scanner.next(); // 잘못된 입력 제거
        }

        // 입력 값이 숫자일 경우, 변수에 숫자 저장
        int number = scanner.nextInt();

        // 개행 문자 제거
        scanner.nextLine();

        // 입력 값이 올바를 경우, 반환
        return number;
    }

    // ✅ 사용자의 사칙연산 값을 검증하는 메서드
    public String validateOperatorInput() {
        while (true) {
            String operator = scanner.next();
            // 입력 값이 사칙연산 기호일 경우 반환
            if (operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/")) {
                return operator;
            }
            // 입력 값이 사칙연산 기호가 아닐 경우 다시 입력 받음
            System.out.print("올바른 사칙연산 기호를 입력하세요! (+, -, *, /): ");
        }
    }

    // ✅ 사용자의 계속 여부를 검증하는 메서드
    public boolean confirmContinue(){
        while (true) {
            String yesOrNo = scanner.next().trim().toUpperCase();

            switch (yesOrNo) {
                case "Y": return true;
                case "N": return false;
                default:
                    System.out.print("올바른 문자를 입력하세요! (Y, N): ");
            }
        }
    }

}
