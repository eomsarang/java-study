// 부동소수점 리터럴 범위
package study.lang.literal;

public class Exam07 {
  public static void main(String[] args){
    System.out.println(Float.MIN_VALUE);
    System.out.println(Float.MAX_VALUE);

    System.out.println(Double.MIN_VALUE);
    System.out.println(Double.MAX_VALUE);

    // 부동소수점 최소/최대 리터럴 값
    // - 4바이트 메모리, 7자리가지 거의 100% 유효
    System.out.println(0.9876543f);
    System.out.println(987.6543f);
    System.out.println(987654.3f);

    // - 4바이트 메모리, 7자리 초과할 경우 대부분 값이 잘리거나 변형된다.
    System.out.println(0.98765434f);
    System.out.println(987.65434f);
    System.out.println(987654.34f);

    // - 8바이트 메모리, 16자리가지 거의 100% 유효
    System.out.println(0.9876543212345678);
    System.out.println(987654.3212345678);
    System.out.println(987654321234567.8);

    // - 8바이트 메모리, 16자리 초과할 경우 대부분 값이 잘리거나 변형된다.
    System.out.println(0.98765432123456789);
    System.out.println(987654.32123456789);
    System.out.println(9876543212345678.9);

    // - 부동소수점은 2진수 변환 과정에서 완전하게 2진수로 표현할 수 없다.
    //   그래서 비교 연산자를 사용할 때 주의해야 한다.
    System.out.println(7 * 0.1);
    System.out.println(7 * 0.1 == 0.7);
    System.out.println(8 * 0.8);
    System.out.println(8 * 0.8 == 6.4);
  }
}
