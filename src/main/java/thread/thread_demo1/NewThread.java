package thread.thread_demo1;


/**
 * Title.<br> 
 * Description.
 * <p>
 * Copyright: Copyright (c) 2016年10月12日 下午6:08:34
 * <p>
 * Company: 北京乐学通在线教育
 * <p>
 * @author zhaomingxing
 * @version 1.0
 */
//创建一个新的线程
class NewThread implements Runnable {
	Thread t;
	NewThread() {
	   // 创建第二个新线程
	   t = new Thread(this, "Demo Thread");
	   System.out.println("Child thread: " + t);
	   t.start(); // 开始线程
	}

// 第二个线程入口
public void run() {
   try {
	      for(int i = 5; i > 0; i--) {
	         System.out.println("Child Thread: " + i);
	         // 暂停线程
	         Thread.sleep(50);
	      }
	  } catch (InterruptedException e) {
	      System.out.println("Child interrupted.");
	  }
   System.out.println("Exiting child thread.");
	}
}