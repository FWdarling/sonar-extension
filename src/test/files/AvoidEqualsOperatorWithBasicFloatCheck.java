class MyClass {
    float xf = 0.1F;
    float yf = 0.1F;

    MyClass(MyClass mc) { }

    void foo1() {
        float diff = 1e-6f;
        if (Math.abs(xf - yf) < diff) {
            System.out.println("true");
        }

        boolean res = xf == yf; // Noncompliant
        res = xf == 0.1F; // Noncompliant
        res = 0.1F == 0.1F; // Noncompliant

        res = ((xf - yf) == 0.0F); // Noncompliant
        res = (foo2() == (xf - yf)); // Noncompliant

    }

    float foo2() {
        return 0.0F;
    }
}