package rest;
interface InterfaceC extends InterfaceA {
    @Override
    default void foo() {
        InterfaceA.super.foo();
    }
}