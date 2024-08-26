package operator;

public class Test24 {
  public static void main(String[] args) {
    int a, r;

    // 전위 연산자와 연산자 우선순위
    a = 3;
    r = ++a + ++a * ++a;
    // 전위 연산자가 운선순위가 높다.
    // 1) r = 4 + 5 * 6;
    // 2) r = 4 + 30;
    // 3) r = 34;
    System.out.println(r);

    // 후위 연산자와 연산자 우선순위
    a = 3;
    r = a++ + a++ * a++;
    // 후위 연산자가 우선순위가 높다.
    // 1) r = 3 + 4 * 5;
    // 2) r = 3 + 20;
    // r = 23;
    System.out.println(r);

    // 전위 연산자, 후위 연산자는 우선순위 없이 나오는 순서대로 바로 실행한다.
    a = 3;
    r = a++ + (a++ * a++);
    // 괄호 보다 후위 연산자가 연산 우선순위가 높다.
    System.out.println(r);

    a = 3;
    r = a++ + ++a * ++a;
    // r = 3 + 5 * 6;
    // r = 3 + 30;
    // r = 33;
    System.out.println(r);

    a = 3;
    r = ++a + a++ * a++;
    // r = 4 + 4 * 5;
    // r = 4 + 20;
    // r = 24;
  }
}
