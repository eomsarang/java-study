package condition;

public class Test26 {
  public static void main(String[] args) {
    int age = 70;

    if (age < 14) 
      System.out.println("어린이입니다.");
    else 
      if (age >= 14 && age < 20) 
        System.out.println("청소년입니다.");
      else 
        if (age >= 20 && age < 65)
          System.out.println("성인입니다.");
        else
          System.out.println("노인입니다.");
    
    
  }
}


