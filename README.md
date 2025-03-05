# 정수형 계산기 프로그램 🧮

##  개요
- 개발기간: 2025.02.26(목) ~ 2025.03.05(목)
- 자바버전: OpenJDK 17
- Java를 사용하여 구현된 콘솔 기반 계산기 프로그램
- 기본적인 사칙연산을 수행하고, 연산 결과를 저장/출력 및 삭제할 수 있는 기능을 제공

---

## 기능 목록

- **계산하기**: 덧셈, 뺄셈, 곱셈, 나눗셈 연산 가능
- **중복연산 지원 (level2 이상)**: 이전 연산 결과를 누적하여 추가 연산 가능
- **연산 결과 저장 (level2 이상)**: 계산된 결과를 저장 및 조회 가능
- **연산 결과 삭제 (level2 이상)**: 개별 또는 전체 연산 결과 삭제 가능
- **종료하기**: 프로그램 종료

---

## 레벨에 따른 기능 추가
### Level 1
- 두개의 숫자를 입력받아 덧셈, 뺄셈, 곱셈, 나눗셈을 수행하고 결과를 출력합니다.
- `"exit"`을 입력하면 프로그램을 종료합니다.

### Level 2
- 사칙연산을 수행 후, 결과값 반환 메서드를 구현했습니다.
- 연산 결과를 저장하는 `컬렉션 타입(Queue)`를 가진 `Calculator` 클래스를 구현했습니다.
- `캡슐화`: Calculator 클래스의 연산 결과를 저장하고 있는 컬렉션 필드에 직접 접근하지 못하도록 하였습니다.
- `Calculator` 클래스에 저장된 연산 결과들 중 가장 먼저 저장된 데이터를 삭제하는 기능을 가진 메서드를 구현했습니다.
- 프로그램 종료 기능을 제공합니다.

### Level 3
- `Enum` 타입을 활용하여 연산자 타입에 대한 정보를 관리하고 활용했습니다.
- 제네릭을 활용하여 실수를 받아도 연산이 가능하도록 구현했습니다. ***(단, 계산은 정수형으로 처리)***

---

## 프로그램 실행 화면
```plaintext
[ 정수형 계산기 프로그램 ]
1. 계산하기
2. 출력하기(All)
3. 삭제하기
4. 종료하기
선택: 
```

---

## 프로그램 구조
```plaintext
src
[ 🚀 LEVEL 1 ]
├── level1
│   └── calculator
│       └── Main.java // ✅ level1.Main()

[ 🚀🚀 LEVEL 2 ]
├── level2 
│   ├── calculator
│   │   └── Calculator.java
│   ├── io
│   │   ├── input
│   │   │   └── InputReader.java
│   │   ├── output
│   │   │   └── OutputPrinter.java
│   ├── operations
│   │   ├── Addition.java
│   │   ├── Division.java
│   │   ├── Multiplication.java
│   │   ├── Operation.java
│   │   ├── Subtraction.java
│   └── Main.java // // ✅ level2.Main()

[ 🚀🚀🚀 LEVEL 3 ]
├── level3
│   ├── calculator
│   │   └── Calculator.java
│   ├── io
│   │   ├── input
│   │   │   └── InputReader.java
│   │   ├── output
│   │   │   └── OutputPrinter.java
│   ├── operations
│   │   ├── Operation.java
│   │   ├── Operator.java
│   └── Main.java // // ✅ level3.Main()
└── README.md
```