package loop;

public class Test11 {
  public static void main(String[] args) {
    int i = 1, sum = 0;

    // while (조건) { 반복 실행할 문장 }
    while (i <= 100) {
      sum += i++;
    }

    System.out.println(sum);
  }
}
