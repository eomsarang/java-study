package operator;

public class Test22 {
  public static void main(String[] args) {

    int a = 100, b = 100;
    int r1, r2;

    // 전위 연산자의 동작
    r1 = ++a;
    // 컴파일러는 위의 문장을 다음과 같이 변환한다.
    // a = a + 1;
    // r1 = a;

    // 후위 연산자의 동작
    r2 = b++;
    // 컴파일러는 위의 문장을 다음과 같이 변환한다.
    // int temp = b;
    // b = b + 1;
    // r2 = temp;

    System.out.println(r1);
    System.out.println(r2);
  }
}
