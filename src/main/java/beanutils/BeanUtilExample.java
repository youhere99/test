package beanutils;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;

import entity.Address;
import entity.Profile;
import entity.User;

/**
 * Title.<br>
 * Description. BeanUtils的一个很重要的用法是可以逐连读取各个类的属性值以及内嵌的属性值,
 * 这里我所理解的内嵌的属性值是指一个类中的属性是另一个类, 比如类User,它包括了Profile这个属性类,
 * Profile这个类的其中一个属性值为Address, 这个Address又是一个类, 如果想要取得Address类里面的某一个属性值时,
 * 在传统的方法中是不能达到的. 这里的所有类及其属性都设置了值 User user = new
 * User();user.getProfile().getAddress(), 这里只能取得Address这个类,并不能导航到下面的属性值,
 * 而BeanUtils可以做到
 * <p>
 * Copyright: Copyright (c) 2014-10-30 上午10:36:44
 * <p>
 * Company: 北京金瑞帆科技有限公司
 * <p>
 * 
 * @author zhaomx
 * @version 1.0
 */
public class BeanUtilExample {

	/**
	 * @param args
	 */
	public static User prepareDate() {
		Profile profile = new Profile();

		profile.setEmail("dys0411q1@126.com");
		profile.setBirthDate(new Date());

		Map<String, String> phone = new HashMap<String, String>();
		phone.put("home", "6861543");
		phone.put("office", "123456");
		phone.put("mobile", "15920054876");
		profile.setPhone(phone);

		Address address1 = new Address("中国", "北京", "天安门一路", "1001");
		Address address2 = new Address("中国", "深圳", "深南大道", "1002");
		Address[] address = { address1, address2 };
		profile.setAddress(address);

		User user = new User();
		user.setUserId(new Long(123456789));
		user.setUsername("deng");
		user.setPassword("123456");
		user.setProfile(profile);

		return user;
	}

	public static void main(String[] args) {
		User user = BeanUtilExample.prepareDate();
		try {
			System.out.println(BeanUtils.getProperty(user, "userId")); // 输出user类的userId的值
			System.out.println(PropertyUtils.getProperty(user, "userId"));
			System.out.println(BeanUtils.getProperty(user, "username"));
			System.out.println(BeanUtils.getProperty(user, "password"));
			System.out.println(BeanUtils.getProperty(user, "profile"));
			System.out.println(BeanUtils.getProperty(user, "profile.email"));
			System.out.println(BeanUtils.getProperty(user, "profile.birthDate"));
			// phone的输出格式:{mobile=15920054876, office=123456, home=6861543}
			System.out.println(BeanUtils.getProperty(user, "profile.phone"));
			System.out.println(BeanUtils.getProperty(user, "profile.phone(mobile)"));
			System.out.println(BeanUtils.getProperty(user, "profile.phone(office)"));
			System.out.println(BeanUtils.getProperty(user, "profile.phone(home)"));
			System.out.println(BeanUtils.getProperty(user, "profile.address[0].country"));
			System.out.println(BeanUtils.getProperty(user, "profile.address[0].city"));
			System.out.println(BeanUtils.getProperty(user, "profile.address[0].postcode"));

			User user2 = new User();
			BeanUtils.copyProperties(user2, user);
			System.out.println(BeanUtils.getProperty(user2, "userId")); // 输出user类的userId的值
			System.out.println(PropertyUtils.getProperty(user2, "userId"));
			System.out.println(BeanUtils.getProperty(user2, "username"));
			System.out.println(BeanUtils.getProperty(user2, "password"));
			System.out.println(BeanUtils.getProperty(user2, "profile"));
			System.out.println(BeanUtils.getProperty(user2, "profile.email"));
			System.out.println(BeanUtils.getProperty(user2, "profile.birthDate"));
			// phone的输出格式:{mobile=15920054876, office=123456, home=6861543}
			System.out.println(BeanUtils.getProperty(user2, "profile.phone"));
			System.out.println(BeanUtils.getProperty(user2, "profile.phone(mobile)"));
			System.out.println(BeanUtils.getProperty(user2, "profile.phone(office)"));
			System.out.println(BeanUtils.getProperty(user2, "profile.phone(home)"));
			System.out.println(BeanUtils.getProperty(user2, "profile.address[0].country"));
			System.out.println(BeanUtils.getProperty(user2, "profile.address[0].city"));
			System.out.println(BeanUtils.getProperty(user2, "profile.address[0].postcode"));
		}
		catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	}

}
