package baekjoon.step37;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main15311 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    List<Integer> bags = new ArrayList<>();

    int sum = 0;
    int value = 1;

    while (sum < N) {
      bags.add(value);
      sum += value;
      value *= 2;
    }

    System.out.println(bags.size());

    StringBuilder sb = new StringBuilder();
    for (int x : bags) {
      sb.append(x).append(" ");
    }
    System.out.println(sb.toString().trim());
  }
}
