package baekjoon.step38;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main3015 {

  static class Person {

    int height;
    int count;

    Person(int height, int count) {
      this.height = height;
      this.count = count;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    Deque<Person> stack = new ArrayDeque<>();
    long answer = 0;

    for (int i = 0; i < N; i++) {
      int h = Integer.parseInt(br.readLine());
      int same = 1;

      while (!stack.isEmpty() && stack.peekLast().height < h) {
        answer += stack.pollLast().count;
      }

      if (!stack.isEmpty() && stack.peekLast().height == h) {
        Person p = stack.pollLast();
        answer += p.count;
        same += p.count;

        if (!stack.isEmpty()) {
          answer += 1;
        }
      } else if (!stack.isEmpty()) {
        answer += 1;
      }

      stack.addLast(new Person(h, same));
    }

    System.out.println(answer);
  }
}
