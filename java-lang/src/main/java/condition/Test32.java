package condition;

public class Test32 {
  public static void main(String[] args) {

    // byte, short, char, int, String, Enum {}
    byte b = 100;
    short s = 100;
    char c = 100;
    int i = 100;
    String str = "Hello";
    enum Lang {
      JAVA, C, CPP, PYTHON
    }

    switch (b) {
    }
    switch (s) {
    }
    switch (c) {
    }
    switch (i) {
    }
    switch (str) {
    }
    switch (Lang.JAVA) {
    }

    long l = 100;
    float f = 100f;
    double d = 100;
    boolean bool = true;

    // switch (l) {} // 컴파일 오류!
    // switch (f) {} // 컴파일 오류!
    // switch (d) {} // 컴파일 오류!
    // switch (bool) {} // 컴파일 오류!

  }
}

