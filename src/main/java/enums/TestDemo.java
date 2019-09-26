package enums;

import org.junit.Test;

/**
 * Title.<br>
 * Description.
 * <p>
 * Copyright: Copyright (c) 2016年11月21日 下午3:10:05
 * <p>
 * Company: 翡翠教育
 * <p>
 * 
 * @author zhaomingxing
 * @version 1.0
 */
public class TestDemo {

    @Test
    public void testDemo_3() {
        for (SharpShooter_3 enumSS : SharpShooter_3.values()) {
            System.out
                .println(enumSS + "----" + enumSS.name() + "----" + enumSS.ordinal() + "----- " + enumSS.getDesc());
        }
    }

    @Test
    public void testDemo_4() {
        for (SharpShooter_4 enumSS : SharpShooter_4.values()) {
            System.out
                .println(enumSS + "----" + enumSS.name() + "----" + enumSS.ordinal() + "----- " + enumSS.getDesc());
        }
    }

    @Test
    public void testDemo_5() {
        for (SharpShooter_5 enumSS : SharpShooter_5.values()) {
            System.out
                .println(enumSS + "----" + enumSS.name() + "----" + enumSS.ordinal() + "----- " + enumSS.getDesc());
        }
    }

    @Test
    public void testDemo_6() {
        for (SharpShooter_6 enumSS : SharpShooter_6.values()) {
            System.out
                .println(enumSS + "----" + enumSS.name() + "----" + enumSS.ordinal() + "----- " + enumSS.getDesc());
        }
    }

    @Test
    public void testDemo_7() {
        for (SharpShooter_7 enumSS : SharpShooter_7.values()) {
            System.out
                .println(enumSS + "----" + enumSS.name() + "----" + enumSS.ordinal() + "----- " + enumSS.getDesc());
        }
    }

    /**
     * 测试
     */
    @Test
    public void testDemo_8() {
        // String taskType = "RED";
        String taskType = "error";
        Color valueOf = Color.BLANK;
        try {
            valueOf = Color.valueOf(taskType);
        } catch (Exception e) {
            System.err.println("--------------传入的枚举常量值不合法-----------");
        }
        switch (valueOf) {
            case RED:
                System.err.println(Color.RED.getName() + "---" + Color.RED.name() + "---" + Color.RED.toString());
                break;

            default:
                System.err.println(Color.GREEN.getName() + "---" + Color.GREEN.name() + "---" + Color.GREEN.toString());
                break;
        }
    }
}
