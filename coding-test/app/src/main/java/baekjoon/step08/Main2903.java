package baekjoon.step08;
import java.util.Scanner;

public class Main2903 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();

    int len = (int)Math.pow(2, N) + 1;
    int result = len * len;

    System.out.println(result);
  }
}
