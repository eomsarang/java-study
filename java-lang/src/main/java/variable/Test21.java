package variable;

public class Test21 {
  public static void main(String[] args) {
    // 부동소수점 변수와 값의 범위
    float f1 = 9.876543f; // 유효 자릿수: 7자리
    System.out.println(f1);

    f1 = 9876.543f;
    System.out.println(f1);

    f1 = 987654.3f;
    System.out.println(f1);

    double d1 = 9.876543210987654; // 유효 자릿수: 16자리
    System.out.println(d1);

    d1 = 98765432.10987654;
    System.out.println(d1);

    d1 = 987654321098765.4;
    System.out.println(d1);
  }
}
