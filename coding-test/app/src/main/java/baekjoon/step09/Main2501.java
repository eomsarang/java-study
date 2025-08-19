package baekjoon.step09;
import java.util.*;

public class Main2501 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int K = sc.nextInt();

    int count = 0;
    int answer = 0;

    for (int i = 1; i <= N; i++) {
      if (N % i == 0) {
        count++;
        if (count == K) {
          answer = i;
          break;
        }
      }
    }

    if (count < K) {
      System.out.println(0);
    } else {
      System.out.println(answer);
    }
  }
}
