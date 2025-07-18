// 메서드: 재귀 호출
package study.lang.method;

public class Exam13 {

  public static void main(String[] args) {
    // 1 + 2 + 3 + ... + n = ?

    // 1) 반복문을 이용한 방법:
    // = 실행 속도 빠르다.
    long result = 0;
    for (long i = 1; i <= 22658; i++) {
      result += i;
    }
    System.out.printf("%d\n", result);

    // 2) 수학식을 이용한 방법:
    // - 구현이 쉽다.
    // - 메서드를 여러번 호출해야 하기 때문에 실행 속도가 느리고, 메모리를 많이 사용.
    // - 종료 조건을 지정하지 않으면 무한으로 호출된다.
    //   무한으로 호출될 때 스택 메모리가 꽉차는 예외가 발생한다.
    //   이것이 스택 오버플로우 예외이다.
    // 1 + 2 + 3 + ... + n
    // f(n) = n + f(n - 1), n >= 1, f(1) = 1이다.
    // f(5) = 5 + f(4)
    // f(5) = 5 + 4 + f(3)
    // f(5) = 5 + 4 + 3 + f(2)
    // f(5) = 5 + 4 + 3 + + 2 + f(1)
    // f(5) = 5 + 4 + 3 + + 2 + 1
    result = f(22658);
    System.out.printf("%d\n", result);

  }

  static long f(long n) {
    if (n == 1) {
      return 1;
    }
    return n + f(n - 1);
  }

}
