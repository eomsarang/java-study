package operator;

public class Test19 {
  public static void main(String[] args) {
    // 암시적 형변환 III
    // => 다른 타입으로 자동 형변환

    // 연산자 우선 순위 + 형변환
    byte b = 1;
    short s = 2;
    char c = 3;
    int i = 4;
    long l = 5;
    float f = 2.0f;
    double d = 3.1;

    // byte, short, char ==> int ==> long ==> float ==> double
    double r = b * s + c / i + l / f + d;
    // (int) b * (int) s + (int) c / i + (float) l / f + d
    // (int) 1 * (int) 2 + (int) 3 / 4 + (float) 5 / 2.0f + 3.1
    // (int) 2 + (int) 0 + 2.5f + 3.1
    // (int) 2 + 2.5f + 3.1
    // (float) 2 + 2.5f + 3.1
    // 4.5f + 3.1
    // (double) 4.5f + 3.1
    // 7.6
    System.out.println(r);
    // => 결론: 연산자 우선 순위에 따라 순서대로 암시적 형변환을 수행한다.

    double r2 = 3.1 + 5 / 2 - 2.7f * 3;
    // r2 = 3.1f + 2 - 2.7f * 3.0f
    // r2 = 3.1 + 2 - 8.1f
    // r2 = 3.1 + 2.0 - 8.1f
    // r2 = 5.1 - 8.1
    // r2 = -3.0
    System.out.println(r2);
    System.out.println(((int) r2 * 10000) / 10000f);

  }
}
