// 암시적 형변환: 타입이 다른 값을 연산할 때(정수 또는 부동소수점 연산 시)

package study.lang.operator;

public class Exam19 {

  public static void main(String[] args) {
    // byte, short 연산 ===> int로 암시적 자동 형변환 수행
    byte b1 = 20;
    byte b2 = 30;
//    byte b = b1 + b2; // 컴파일 오류! 연산하기 전에 b1, b2의 값을 int로 형변환 한 후에 계산을 수행한다.
//    short s = b1 + b2; // 컴파일 오류! 연산하기 전에 b1, b2의 값을 int로 형변환 한 후에 계산을 수행한다.

    short s1 = 20;
    short s2 = 30;
//    short s = s1 + s2; // 컴파일 오류! 연산하기 전에 s1, s2의 값을 int로 형변환 한 후에 계산을 수행한다.

    int i = b1 + s1; // OK! 연산하기 전에 b1, s1의 값을 int로 형변환 한 후에 계산을 수행한다.

    // int ===> long ===> float ===> double
    // => 연산 우선 순위에 따라 차례대로 암시적 형변환을 수행한다.
    // => 피연산자의 타입이 서로 다를 때 위 규칙에 따라 암시적 형변환을 수행하여 타입을 일치시킨 후 계산을 수행한다.
    double result = 3.2 + 5L / 2 - 12.24f;
    // = 3.2(double) + 5(long) / 2(int) - 12.24(float)
    // = 3.2(double) + 5(long) / 2(long) - 12.24(float)
    // = 3.2(double) + 2(long) - 12.24(float)
    // = 3.2(double) + 2.0(double) - 12.24(float)
    // = 5.2(double) - 12.24(float)
    // = 5.2(double) - 12.24(double)
    // = -7.04(double)
    System.out.println(result);

    System.out.println(5 / 2);
    System.out.println(5.0 / 2.0);
    System.out.println(5 / 2.0); // 5는 double로 암시적 형변환 된다.
    System.out.println(5.0 / 2); // 2는 double로 암시적 형변환 된다.
    System.out.println((double) 5 / 2); // 5는 double로 명시적 형변환, 2는 double 암시적 형변환 된다.
    System.out.println(5 / (double) 2); // 5는 double로 암시적 형변환, 2는 double 명시적 형변환 된다.
  }
}
