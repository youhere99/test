package rest;

class ClassA implements InterfaceB, InterfaceC {
    @Override
    public void foo() {
        InterfaceB.super.foo();
        InterfaceC.super.foo();
    }
   
}
