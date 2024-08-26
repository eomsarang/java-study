package operator;

public class Test23 {
  public static void main(String[] args) {

    int a = 100;

    // r-vlaue가 실행된 후 assignment operator가 실행된다.
    a = a++;
    // 컴파일러는 다음 문장으로 변환
    // 1) int temp = a;
    // 2) a = a + 1;
    // 3) a = temp;

    System.out.println(a);

  }
}
