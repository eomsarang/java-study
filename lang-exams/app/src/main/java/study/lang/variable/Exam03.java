// l-value와 r-value
package study.lang.variable;

public class Exam03 {
  public static void main(String[] args){
    int i;

    // assignment 연산자(=)를 기준으로,
    // > l-value(left에 놓는 것)는 변수여야 한다.
    // > r-value(right에 놓는 것)는 변수이거나 리터럴, 메서드일 수 있다.
    i = 100;

    // 100 = 200; // l-value가 리터럴, 메서드이면 안된다.

    // r-value를 모두 수행한 후 할당 연산(=)이 마지막으로 수행된다.
    int j = i + 100 * 2;

  }
}
