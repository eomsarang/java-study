// 메서드: main() 메서드의 아규먼트
package study.lang.method;

public class Exam18 {

  // 프로그램 아규먼트
  // $ java.study.lang.method.Exam18 aaa bbb ccc ddd
  // args[0]: "aaa"
  // args[1]: "bbb"
  // args[2]: "ccc"
  // args[3]: "ddd"
  public static void main(String[] args) {
    for (String arg : args) {
      System.out.printf("=> %s\n", arg);
    }
  }
}
