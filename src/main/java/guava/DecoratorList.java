package guava;

import java.util.List;

import com.google.common.collect.ForwardingList;

/**
 * Title.<br>
 * Description.
 * <P>
 * Forwarding装饰器模式的应用场景： 1、需要扩展一个类的功能。
 * 2、动态的为一个对象增加功能，而且还能动态撤销。（继承不能做到这一点，继承的功能是静态的，不能动态增删。） 缺点：产生过多相似的对象，不易排错！
 * <p>
 * Copyright: Copyright (c) 2017年5月18日 上午10:19:24
 * <p>
 * Company: 翡翠教育
 * <p>
 * 
 * @author zhaomingxing
 * @version 1.0
 */
public class DecoratorList<E> extends ForwardingList<E> {

	private List<E> delegate;

	public DecoratorList(List<E> delegate) {
		super();
		this.delegate = delegate;
	}

	@Override
	protected List<E> delegate() {
		return delegate;
	}
}
