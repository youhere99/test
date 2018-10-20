package rest;
interface InterfaceB extends InterfaceA {
    @Override
    default void foo() {
        System.out.println("InterfaceB foo");
    }
}