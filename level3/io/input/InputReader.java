package level3.io.input;

import java.util.Map;
import java.util.Scanner;
import java.util.function.Supplier;

public class InputReader {
    // Scanner 객체 생성
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * FIXME: 제네릭을 사용하지 않고, Number 타입으로 숫자 입력값을 검증하는 메서드
     * ✅FEEDBACK: Number 최상위 클래스를 핸들링은 어려움이 많음
     * public Number getNumberInput() {
     *     return getValidInput(() -> {
     *         if (!scanner.hasNextDouble()) {
     *             scanner.next(); // 잘못된 입력 제거
     *             return null; // ⚡ getValidInput()이 errorMessage 출력 후 다시 입력 요청
     *         }
     *         return scanner.hasNextInt() ? scanner.nextInt() : scanner.nextDouble();
     *     }, "숫자를 입력하세요!: ");
     * }
     */

    // ✅ 사용자의 숫자 입력 값을 검증하는 제네릭 메서드
    @SuppressWarnings("unchecked")
    public <T extends Number> T getNumberInput() {
        return getValidInput(() -> {
            // hasNextDouble()은 입력값이 double, int 일 경우 true 반환
            if (!scanner.hasNextDouble()) {
                scanner.next(); // 잘못된 입력 제거
                return null; // getValidInput() 메서드에서 error message 출력
            }

            // 입력값이 int, double 일 경우 변수에 저장
            double number = scanner.nextDouble();

            // 개행 문자 제거
            scanner.nextLine();

            // ✅ 해당 메서드의 반환 값은 제네릭 T 타입을 유지하면서 Integer 타입만 반환하고 싶음
            // 1️⃣ Integer.valueOf((int) number)는 Integer 타입으로 형변환
            // 2️⃣ 하지만 컴파일은 T 타입으로 반환하라고 요구함 (T extends Number)
            // 3️⃣ 따라서 (T)로 캐스팅하여 제네릭 타입을 유지해야 함
            // 4️⃣ 결국, 반환값은 Integer 이지만, 제네릭 T로 변환하여 반환
            // 💡 (T)는 컴파일러에게 "이 값은 T 타입이야!"라고 알려주는 역할을 함
            return (T) Integer.valueOf((int) number);
        }, "올바른 숫자를 입력하세요!: ");
    }

    /**
     * ✅입력값을 검증하고 유효한 값이 입력될 때까지 반복하는 제네릭 메서드
     * (Supplier<T>는 매개변수를 받지 않고 새로운 값을 반환하는 기능에 적합한 함수형 인터페이스)
     *
     * @param inputProvider 입력을 처리하는 함수 (유효한 값이면 반환, 무효한 값이면 null 반환)
     * @param errorMessage  잘못된 입력이 들어왔을 때 출력할 메시지
     * @return 검증된 유효한 입력값 (T)
     */
    private <T> T getValidInput(Supplier<T> inputProvider, String errorMessage) {
        while (true) {
            // 함수의 결과값을 변수에 저장
            T input = inputProvider.get();

            // 변수가 유효하면 return
            if (input != null) {
                return input;
            }

            // 변수가 null 이면 다시 입력 요청
            System.out.print(errorMessage);
        }
    }

    // ✅ 사용자의 사칙연산 값을 검증하는 메서드
    public String getOperatorInput() {
        return getValidInput(() -> {
            // 사용자의 입력값을 operator 변수에 저장
            String operator = scanner.next().trim();

            // 입력값이 사칙연산 기호일 경우 return
            return operator.matches("[+\\-*/]") ? operator : null;
        },"사칙연산 기호를 입력하세요! (+, -, *, /): ");
    }

    // ✅ 사용자의 계산중첩 여부를 검증하는 메서드
    public boolean confirmContinue() {
        // 사용자의 입력값이 Y, N 일 경우 true, false 반환하는 Map 컬렉션
        Map<String, Boolean> response = Map.of("Y", true, "N", false);

        return getValidInput(() -> {
            // 사용자의 입력값을 userResponse 변수에 저장
            String userResponse = scanner.next().trim().toUpperCase();

            // 입력값이 Y, N 일 경우 return
            return response.getOrDefault(userResponse, null);

        }, "올바른 문자를 입력하세요! (Y, N): ");
    }

    // ✅ 사용자의 삭제 입력 값을 검증하는 메서드
    public int getDeleteInput() {
        System.out.print("삭제할 항목을 선택하세요! (1: 최근 결과 삭제, 2: 전체 결과 삭제): ");
        return getValidInput(() -> {
            // 입력 값이 숫자가 아닐 경우 다시 입력 받음
            if (!scanner.hasNextInt()) {
                scanner.next();
                return null; // getValidInput() 메서드에서 error message 출력
            }

            // 입력 값이 숫자일 경우, 변수에 숫자 저장
            int number = scanner.nextInt();

            // 개행 문자 제거
            scanner.nextLine();

            // 올바른 값이라면 반환 (1: 최근 결과 삭제, 2: 전체 결과 삭제)
            return (number == 1 || number == 2) ? number : null;

        }, "올바른 번호를 입력하세요! (1 또는 2): ");
    }
}
