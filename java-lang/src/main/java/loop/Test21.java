package loop;

public class Test21 {
  public static void main(String[] args) {
    int i = 1, sum = 0;

    // do { 반복 실행할 문장 } while (조건);
    do {
      sum += i++;
    } while (i <= 100);

    System.out.println(sum);
  }
}
