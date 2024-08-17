package literal;

public class Test12 {
  public static void main(String[] args) {
    // 문자열 리터럴(literal) - 이스케이프 문자(escape character)
    System.out.println("Hello\nworld!"); // line feed(LF)
    System.out.println("Hello\rabc"); // carrage return(CR)
    System.out.println("Hello\t"); // horizontal tab
    System.out.println("Hello\bworld!"); // backspace
    System.out.println("Hello\fworld!"); // forn feed
    System.out.println("Hello\\world!"); // back slash
    System.out.println("Hello\"world!"); // double quote
    System.out.println("Hello'world!"); // single quote
  }
}
