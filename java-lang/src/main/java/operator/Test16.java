package operator;

public class Test16 {
  public static void main(String[] args) {
    // 명시적 형변환 III

    // float, double ===> byte, short, char, int, long
    byte b1 = (byte) 3.14;
    short s1 = (short) 3.14;
    char c1 = (char) 3.14;
    int i1 = (int) 3.14;
    long l1 = (long) 3.14;

    // byte, short, char, int, long, float, double ===> boolean 허용 안함
    // boolean bool1 = (boolean) 3.14; // 컴파일 오류
    // boolean bool2 = (boolean) 1; // 컴파일 오류

  }
}
