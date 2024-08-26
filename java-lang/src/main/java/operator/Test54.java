package operator;

import java.beans.JavaBean;

public class Test54 {
  public static void main(String[] args) {
    // 비트 연산자 활용 III
    // 홍길동이 다룰 수 있는 언어의 종류를 한 변수에 저장하시오!
    // 언어 종류: Python, C, Java, C++, JavaScript, C#, HTML, Go, PHP
    // 홍길동이 다룰 수 있는 언어: Python, Java, JavaScript, HTML
    // 변수의 값을 분석하여 다룰 수 있는 언어가 무엇인지 출력하시오!

    final int PYTHON = 1, C = 2, JAVA = 4, CPP = 8, JAVASCRIPT = 16, CSHARP = 32, HTML = 64,
        GO = 128, PHP = 256;

    int languages = PYTHON | JAVA | JAVASCRIPT | HTML; // 00000000 01010101

    if ((languages & PYTHON) == PYTHON)
      System.out.println("Python");
    if ((languages & C) == C)
      System.out.println("C");
    if ((languages & JAVA) == JAVA)
      System.out.println("Java");
    if ((languages & CPP) == CPP)
      System.out.println("Cpp");
    if ((languages & JAVASCRIPT) == JAVASCRIPT)
      System.out.println("JavaScript");
    if ((languages & CSHARP) == CSHARP)
      System.out.println("C#");
    if ((languages & HTML) == HTML)
      System.out.println("HTML");
    if ((languages & GO) == GO)
      System.out.println("Go");
    if ((languages & PHP) == PHP)
      System.out.println("PHP");


  }
}
