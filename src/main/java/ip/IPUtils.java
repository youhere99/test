package ip;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class IPUtils {

	public static void main(String[] args) {
		System.out.println("get local ip for windows: ");
		printList(getAllLocalHostIPForWin());

		System.out.println();
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println();

		System.out.println("get local ip for linux: ");
		printList(getAllLocalHostIPForLinux());
	}

	/** 
	 * @return 
	 */
	private static String getLocalHostName() {
		String hostName;
		try {
			InetAddress addr = InetAddress.getLocalHost();
			hostName = addr.getHostName();
		}
		catch (Exception ex) {
			hostName = "";
		}
		return hostName;
	}

	/** 
	 * @return 
	 */
	public static List<String> getAllLocalHostIPForWin() {
		List<String> ret = new ArrayList<String>();
		try {
			String hostName = getLocalHostName();
			if (hostName.length() > 0) {
				InetAddress[] addrs = InetAddress.getAllByName(hostName);
				if (addrs.length > 0) {
					for (int i = 0; i < addrs.length; i++) {
						ret.add(addrs[i].getHostName() + "  ->  " + addrs[i].getHostAddress());
					}
				}
			}

		}
		catch (Exception ex) {
			ret = null;
		}
		return ret;
	}

	// 上面这个方法在linux平台上将只能获取 127.0.0.1  
	// 为了获取到linux上的IP地址，请使用下面的方法。  
	// 但下面的这个方法也可用于windows平台，但获取的信息比真实的网卡信息要多。请自行分辨。  

	/** 
	 * @return 
	 */
	public static List<String> getAllLocalHostIPForLinux() {
		List<String> ret = new ArrayList<String>();
		try {
			Enumeration<?> e1 = NetworkInterface.getNetworkInterfaces();
			NetworkInterface ni = null;
			while (e1.hasMoreElements()) {
				ni = (NetworkInterface) e1.nextElement();
				Enumeration<?> e2 = ni.getInetAddresses();
				InetAddress ia = null;
				while (e2.hasMoreElements()) {
					ia = (InetAddress) e2.nextElement();
					ret.add(ia.getHostName() + "  ->  " + ia.getHostAddress());
				}

			}

		}
		catch (SocketException e) {
			e.printStackTrace();
		}

		return ret;
	}

	/** 
	 *  
	 * @param list 
	 */
	public static void printList(List<String> list) {
		for (String ele : list) {
			System.out.println(ele);
		}
	}
}
