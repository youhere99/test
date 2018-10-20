package rest;
interface InterfaceA {
    default void foo() {
        System.out.println("InterfaceA foo");
    }
}