package condition;

public class Test24 {
  public static void main(String[] args) {
    int age = 12;

    // else는 가장 가까운 if에 소속된다.
    if (age < 19)
      if (age >= 14)
        System.out.println("청소년입니다.");
    else
      System.out.println("성인입니다.");

  }
}


