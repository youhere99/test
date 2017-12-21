package thread.thread_demo1;


/**
 * Title.<br> 
 * Description.
 * <p>
 * Copyright: Copyright (c) 2016年10月12日 下午6:37:32
 * <p>
 * Company: 北京乐学通在线教育
 * <p>
 * @author zhaomingxing
 * @version 1.0
 */
public class ExtendThread {
	   public static void main(String args[]) {
	      new NewThreadA(); // 创建一个新线程
	      try {
	         for(int i = 5; i > 0; i--) {
	            System.out.println("Main Thread: " + i);
	            Thread.sleep(100);
	         }
	      } catch (InterruptedException e) {
	         System.out.println("Main thread interrupted.");
	      }
	      System.out.println("Main thread exiting.");
	   }
}