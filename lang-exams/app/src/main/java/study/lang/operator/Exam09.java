// 관계 연산자 II
package study.lang.operator;

public class Exam09 {

  public static void main(String[] args) {
    System.out.println(2 * 0.3 == 0.6); // true

    // 부동소수점의 경우 2진수 변환 과정에서 극한의 소수점이 추가되는 경우가 있어 비교 연산이 정확할 수 없다.
    System.out.println(7 * 0.1 == 0.7); // false

    System.out.println(2 * 0.3);
    System.out.println(7 * 0.1);

    // 그래서 부동소수점 값을 비교할 때는 특히 주의해야 한다.
    // 가능한 극한의 값을 제외한 후 비교하라!
    System.out.println(Math.abs(7 * 0.1 - 0.7) < 0.00001);
  }
}
