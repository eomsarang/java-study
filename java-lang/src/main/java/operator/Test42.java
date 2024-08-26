package operator;

public class Test42 {
  public static void main(String[] args) {
    boolean a, b, c;

    a = true;
    b = false;
    c = a && (b = true);
    System.out.printf("%b, %b, %b\n", a, b, c); // true, true, true

    a = false;
    b = false;
    c = a && (b = true);
    // && 연산은 왼쪽 피연산자의 값으로 결과가 결정된다면 오른쪽 피연산자는 수행하지 않는다.
    System.out.printf("%b, %b, %b\n", a, b, c); // false , flase, false

    a = true;
    b = false;
    c = a & (b = true);
    System.out.printf("%b, %b, %b\n", a, b, c); // true, true, true

    a = false;
    b = false;
    c = a & (b = true);
    // && 연산은 왼쪽 피연산자의 값으로 결과가 결정되더라도 오른쪽 피연산자는를 반드시 수행한다.
    System.out.printf("%b, %b, %b\n", a, b, c); // false , true, false
  }
}
