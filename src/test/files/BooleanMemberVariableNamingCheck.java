class MyClass1 { // Noncompliant
    boolean var1;
}

class MyClass2{// Noncompliant
    Boolean var2;
}

class MyClass3{
    boolean bVar1;
    Boolean bVar2;
    boolean isVar1;
    Boolean isVar2;

    void foo1(){
        boolean var3;
        Boolean var4;
        boolean bVar3;
        Boolean bVar4;
        boolean isVar3;
        Boolean isVar4;
    }
}