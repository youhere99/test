package thread;

/**
 * https://www.cnblogs.com/skywang12345/p/3479202.html
 */
// LockTest4.java的源码


public class LockTest4 {

    Something x = new Something();
    Something y = new Something();

    // 比较(04) x.isSyncA()与Something.cSyncA()
    private void test4() {
        // 新建t41, t41会调用 x.isSyncA()
        Thread t41 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        x.isSyncA();
                    }
                }, "t41");

        // 新建t42, t42会调用 x.isSyncB()
        Thread t42 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        Something.cSyncA();
                    }
                }, "t42");


        t41.start();  // 启动t41
        t42.start();  // 启动t42
    }

    public static void main(String[] args) {
        LockTest4 demo = new LockTest4();

        demo.test4();
    }
}