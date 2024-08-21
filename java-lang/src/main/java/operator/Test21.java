package operator;

public class Test21 {
  public static void main(String[] args) {
    // 증감 전위 연산자
    int i = 100, j = 100;

    ++i; // i = i + 1
    --j; // j = j - 1
    System.out.println(i);
    System.out.println(j);

    // 증감 후위 연산자
    i = 100; // i = i + 1
    j = 100; // j = j - 1
    i++;
    j--;
    System.out.println(i);
    System.out.println(j);
  }
}
