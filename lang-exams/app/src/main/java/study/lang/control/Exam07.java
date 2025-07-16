// 조건문: switch (값)
package study.lang.control;

public class Exam07 {

  public static void main(String[] args) {

    byte b = 100;
    short s = 100;
    int i = 100;
    long l = 100;
    float f = 100.0f;
    double d = 100.0;
    boolean bool = true;
    char c = 'A';
    String str = "Hello";

    switch (b) {} // 4바이트 이하의 정수 타입
    switch (s) {} // 4바이트 이하의 정수 타입
    switch (c) {} // 4바이트 이하의 정수 타입
    switch (i) {} // 4바이트 이하의 정수 타입
    switch (str) {} // 문자열 타입

//    switch (l) {} // 컴파일 오류!
//    switch (f) {} // 컴파일 오류!
//    switch (d) {} // 컴파일 오류!
//    switch (bool) {} // 컴파일 오류!

    // enum은 상수를 만드는 특별한 문법이다.
    enum Role {
      USER, MANAGER, GUEST
    }

    Role role = Role.MANAGER;
    switch (role) {} // enum 상수가 올 수 있다.
  }
}
