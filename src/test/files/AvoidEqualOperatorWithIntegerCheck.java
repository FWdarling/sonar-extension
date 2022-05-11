class MyClass {

  void foo1(){
    Integer a = 1;
    Integer b = 2;
    a.equals(b);
    boolean res = a == b; // Noncompliant
  }
}
