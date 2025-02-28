package level2.io.output;

public class OutputPrinter {
    // ✅계산기 메뉴 출력 메서드
    public void printMenuPrompt(){
        System.out.println("\n[ 계산기 프로그램 ]");
        System.out.println("1. 계산하기");
        System.out.println("2. 출력하기(All)");
        System.out.println("3. 삭제하기");
        System.out.println("4. 종료하기");
        System.out.print("선택: ");
    }

    // ✅계산기 숫자 입력 프롬프트 출력 메서드
    public void printNumberPrompt(int order){
        System.out.print(order + "번째 숫자를 입력하세요.: ");
    }

    // ✅계산기 연산자 입력 프롬프트 출력 메서드
    public void printOperatorPrompt(){
        System.out.print("사칙연산 기호를 입력하세요! (+, -, *, /): ");
    }

    // ✅계산기 연속 연산 여부 프롬프트 출력 메서드
    public void printContinuePrompt(){
        System.out.print("연산을 계속 하시겠습니까? (Y, N): ");
    }

    // ✅계산기 연산 결과 출력하기 메서드
    public void printCalculatePrompt(int firstNumber, int secondNumber, String operator, int result){
        System.out.println("연산 결과: " + firstNumber + " " + operator + " " + secondNumber + " = " + result);
    }

    // FIXME: 미구현 메서드
    // ✅계산기 모든 결과 출력하기 메서드
    public void printCalculateAllPrompt(){

    }

    // ✅계산기 종료 메서드
    public void printExitPrompt() {
        System.out.println("프로그램을 종료합니다.");
        System.exit(0);
    }
}
