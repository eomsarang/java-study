package condition;

public class Test23 {
  public static void main(String[] args) {
    int age = 20;

    // if ~ else ~ 는 한 문장으로 취급한다.
    if (age < 19)
      if (age >= 14)
        System.out.println("청소년입니다.");
      else
        System.out.println("어린이입니다.");
    else
      System.out.println("성인입니다.");

  }
}


