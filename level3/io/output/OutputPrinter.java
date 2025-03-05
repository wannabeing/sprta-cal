package level3.io.output;

import java.util.Queue;

public class OutputPrinter {
    // ✅계산기 메뉴 출력 메서드
    public void printMenuPrompt(){
        System.out.println("\n[ 정수 계산기 프로그램 ]");
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

    // ✅계산기 연산 결과 출력 메서드
    public void printCalculatePrompt(int firstNumber, int secondNumber, String operator, int result){
        System.out.println("\n📌 연산 결과");
        System.out.println(firstNumber + " " + operator + " " + secondNumber + " = " + result + "\n");
    }

    // ✅계산기 모든 결과 출력 메서드
    public void printResultsPrompt(Queue<Integer> results){
        if (results.isEmpty()){
            System.out.println("\n❌ 저장된 연산 결과가 없습니다.");
        } else {
            System.out.println("\n📌 저장된 연산 결과");

            int index = 1;
            for (Integer result : results) {
                System.out.println(index++ + ") " + result);
            }
        }
    }

    // ✅계산기 삭제 메뉴 출력 메서드
    public void printDeleteMenuPrompt(){
        System.out.println("\n📌[ 삭제 메뉴 ]");
        System.out.println("1) 최근 연산 결과 삭제 (1개)");
        System.out.println("2) 모든 연산 결과 삭제 (전체)");
    }

    // ✅계산기 삭제 결과 출력 메서드
    public void printDeletePrompt(boolean isSuccess, Queue<Integer> results){
        if (isSuccess){
            System.out.println("\n✅ 정상적으로 삭제되었습니다.");
            printResultsPrompt(results);
        } else{
            System.out.println("\n❌ 저장된 연산 결과가 없습니다.");
        }
    }

    // ✅계산기 종료메시지 출력 메서드
    public void printExitPrompt() {
        System.out.println("\n🚀 프로그램을 종료합니다.");
    }
}
