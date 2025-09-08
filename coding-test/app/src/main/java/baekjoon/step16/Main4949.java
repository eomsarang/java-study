package baekjoon.step16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main4949 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;

    while (true) {
      line = br.readLine();
      if (line.equals(".")) {
        break;
      }

      if (isBalanced(line)) {
        System.out.println("yes");
      } else {
        System.out.println("no");
      }
    }
  }

  private static boolean isBalanced(String line) {
    Stack<Character> stack = new Stack<>();

    for (char ch : line.toCharArray()) {
      if (ch == '(' || ch == '[') {
        stack.push(ch);
      } else if (ch == ')') {
        if (stack.isEmpty() || stack.pop() != '(') {
          return false;
        }
      } else if (ch == ']') {
        if (stack.isEmpty() || stack.pop() != '[') {
          return false;
        }
      }
    }

    return stack.isEmpty();
  }
}
