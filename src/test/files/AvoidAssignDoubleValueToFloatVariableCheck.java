class MyClass {
    void foo1(){
        double d1 = 1.0;
        float f1, f2, f3, f4, f5;
        f1 = 1.0;  // Noncompliant
        f2 = 1.0F;
        f3 = d1;  // Noncompliant
        f4 = f1;
        f5 = f2;
    }
}