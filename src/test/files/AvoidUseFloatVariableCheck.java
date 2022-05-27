class MyClass {
    float f1; // Noncompliant
    Float f2; // Noncompliant
    double d1;
    Double d2;
    void foo1(){
        float f3; // Noncompliant
        Float f4; // Noncompliant
        double d3;
        Double d4;
    }
}