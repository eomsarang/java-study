package baekjoon.step08;

import java.util.Scanner;

public class Main2869 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long A = sc.nextLong();
    long B = sc.nextLong();
    long V = sc.nextLong();

    long days = (V - A) / (A - B);
    if ((V - A) % (A - B) != 0) {
      days++;
    }
    days++;

    System.out.println(days);
  }
}
