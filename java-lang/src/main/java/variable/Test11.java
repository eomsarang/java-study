package variable;

public class Test11 {
  public static void main(String[] args) {
    // 정수 변수와 값의 범위
    byte b1 = Byte.MAX_VALUE; // -128;
    byte b2 = Byte.MIN_VALUE; // 127;
    System.out.printf("byte: %d ~ %d\n", b1, b2);

    short s1 = Short.MIN_VALUE; // -32768;
    short s2 = Short.MAX_VALUE; // 32767;
    System.out.printf("short: %d ~ %d\n", s1, s2);

    char c1 = Character.MIN_VALUE; // 0;
    char c2 = Character.MAX_VALUE; // 65535;
    System.out.printf("char: %d ~ %d\n", (int) c1, (int) c2);

    int i1 = Integer.MIN_VALUE;
    int i2 = Integer.MAX_VALUE;
    System.out.printf("int: %d ~ %d\n", i1, i2);

    long l1 = Long.MIN_VALUE;
    long l2 = Long.MAX_VALUE;
    System.out.printf("long: %d ~ %d\n", l1, l2);

  }
}
