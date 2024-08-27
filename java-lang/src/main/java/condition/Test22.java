package condition;

public class Test22 {
  public static void main(String[] args) {
    int age = 18;

    // if 문과 else 문 사이에는 다른 문장이 올 수 없다.
    if (age >= 19)
      System.out.println("성인입니다.");
    age = 20;
    else
      System.out.println("미성년입니다.");

  }
}


