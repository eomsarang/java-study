package variable;

public class Test22 {
  public static void main(String[] args) {
    // 부동소수점의 유효 자릿수를 넘어 갈 때,
    // 컴파일 오류가 발생하지는 않는다.
    // => 다만 유효 자릿수를 넘어가는 값이 반올림되거나 잘린다.

    float f1 = 9.8765435f; // 유효 자릿수: 7자리 --> 8자리
    System.out.println(f1);

    f1 = 9876.5435f;
    System.out.println(f1);

    f1 = 987654.35f;
    System.out.println(f1);

    double d1 = 9.8765432109876545; // 유효 자릿수: 16자리 --> 17자리
    System.out.println(d1);

    d1 = 98765432.109876545;
    System.out.println(d1);

    d1 = 987654321098765.45;
    System.out.println(d1);
  }
}
