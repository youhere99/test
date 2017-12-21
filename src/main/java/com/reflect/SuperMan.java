package com.reflect;



public class SuperMan extends Persons implements ActionInterface {
    /**   */
    private static final long serialVersionUID = 1L;
	private boolean blueBriefs;
 
    public void fly() {
        System.out.println("超人会飞耶～～");
    }
 
    public boolean isBlueBriefs() {
        return blueBriefs;
    }
 
    public void setBlueBriefs(boolean blueBriefs) {
        this.blueBriefs = blueBriefs;
    }
 
    public void walk(int m) {
        System.out.println("超人会走耶～～走了" + m + "米就走不动了！");
    }
}