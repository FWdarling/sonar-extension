class MyClass {

  Float xf = Float.valueOf(0.1F);
  Float yf = Float.valueOf(0.1F);
  Double xd = 0.2;
  Double yd = 0.2;

  MyClass(MyClass mc) { }

  void foo1() {
    xf.equals(yf); // Noncompliant
    xd.equals(yd); // Noncompliant
    Integer a = 1;
    Integer b = 2;
    a.equals(b);
    Double.valueOf(0.2).equals(xd); // Noncompliant
    Float.valueOf(0.1F).equals(xf); // Noncompliant
  }
}
