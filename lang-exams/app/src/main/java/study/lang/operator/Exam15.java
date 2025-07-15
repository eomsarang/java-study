// 비트 이동 연산자 - >> (나누기 2**n과 같다)

package study.lang.operator;

public class Exam15 {

  public static void main(String[] args) {
    int i = -209;
    System.out.println(i >> 1); // i / 2**1 = -105
    System.out.println(i >> 2); // i / 2**2 = -53
    System.out.println(i >> 3); // i / 2**3 = -27
    System.out.println(i >> 4); // i / 2**4 = -14

    // 결론:
    // - 어떤 값에 대해 2의 n승으로 나눌 때, 나누기를 실행하는 것 보다 비트 이동 연산자을 수행하는 것이 실행속도가 더 빠르다.
  }
}
