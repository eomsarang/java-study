package condition;

public class Test33 {
  public static void main(String[] args) {

    // case 상수, 리터럴:
    int role = 1;

    final int value = 2;

    int value2 = 100;

    switch (role) {
      case 1: // 리터럴
      case value: // 상수
      case 1 + 3: // 리터럴과 리터럴의 연산 결과는 리터럴이다.
      case value + 3: // 리터럴과 상수의 연산 결과는 상수이다.
        // case value2: // 변수는 사용할 수 없다. 컴파일 오류!
        // case value2 + 100: //변수와 상수의 연산 결과는 변수이다.

    }

  }
}

