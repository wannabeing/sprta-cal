package level2.io.input;

import java.util.Scanner;

public class InputReader {
    // Scanner 객체 생성
    private static final Scanner scanner = new Scanner(System.in);

    // ✅ 사용자의 숫자 입력 값을 검증하는 메서드
    public int getIntInput() {
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
    public String getOperatorInput() {
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

    // ✅ 사용자의 계산중첩 여부를 검증하는 메서드
    public boolean confirmContinue() {
        while (true) {
            String yesOrNo = scanner.next().trim().toUpperCase();

            switch (yesOrNo) {
                case "Y":
                    return true;
                case "N":
                    return false;
                default:
                    System.out.print("올바른 문자를 입력하세요! (Y, N): ");
            }
        }
    }

    // ✅ 사용자의 삭제 입력 값을 검증하는 메서드
    public int getDeleteInput() {
        while (true) {
            System.out.print("삭제할 항목을 선택하세요! (1: 최근 결과 삭제, 2: 전체 결과 삭제): ");

            // 입력 값이 숫자가 아닐 경우 다시 입력 받음
            if (!scanner.hasNextInt()) {
                System.out.println("숫자를 입력하세요! (1 또는 2)");

                // 잘못된 입력 제거
                scanner.next();

                // 밑으로 이동
                continue;
            }

            // 입력 값이 숫자일 경우, 변수에 숫자 저장
            int number = scanner.nextInt();

            // 개행 문자 제거
            scanner.nextLine();

            // 올바른 값이라면 반환 (1: 최근 결과 삭제, 2: 전체 결과 삭제)
            if (number == 1 || number == 2){
                return number;
            }
            // 올바른 값이 아니라면, 에러메시지 출력
            else {
                System.out.println("올바른 번호를 입력하세요! (1 또는 2)");
            }
        }
    }
}
