// 조건 연산자

package study.lang.operator;

public class Exam17 {

  public static void main(String[] args) {
    int age = 20;
    String msg = (age >= 18) ? "유권자입니다." : "비유권자입니다.";
    System.out.println(msg);

    int value = 201;
    String result = (value % 2 == 0) ? "짝수" : "홀수";

    String gender = "남자";
    int b = gender.equals("남자") ? 0 : 1;

    System.out.println(value % 2 == 0 ? "짝수" : "홀수");
  }
}
