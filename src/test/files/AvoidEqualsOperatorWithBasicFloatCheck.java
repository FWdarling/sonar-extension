class MyClass {
    float xf = 0.1F;
    float yf = 0.1F;

    MyClass(MyClass mc) { }

    void foo1() {
        boolean res = xf == yf; // Noncompliant

        float diff = 1e-6f;
        if (Math.abs(xf - yf) < diff) {
            System.out.println("true");
        }
        res = xf == 0.1F; // Noncompliant

        if ((xf - yf) == 0.0F) { // Noncompliant
            return;
        }
    }
}