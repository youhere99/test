package thread.thread_demo1;


/**
 * Title.<br> 
 * Description.
 * <p>
 * Copyright: Copyright (c) 2016年10月12日 下午6:33:26
 * <p>
 * Company: 北京乐学通在线教育
 * <p>
 * @author zhaomingxing
 * @version 1.0
 */
//通过继承 Thread 创建线程
class NewThreadA extends Thread {
	NewThreadA() {
	   // 创建第二个新线程
	   super("Demo Thread");
	   System.out.println("Child thread: " + this);
	   start(); // 开始线程
	}

// 第二个线程入口
public void run() {
   try {
      for(int i = 5; i > 0; i--) {
         System.out.println("Child Thread: " + i);
                         // 让线程休眠一会
         Thread.sleep(50);
      }
   } catch (InterruptedException e) {
      System.out.println("Child interrupted.");
   }
   System.out.println("Exiting child thread.");
}
}