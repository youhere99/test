package guava;

import java.util.Iterator;

import com.google.common.collect.AbstractIterator;

/**
 * Title.<br>
 * Description.
 * <p>
 * Copyright: Copyright (c) 2017年5月18日 上午10:47:25
 * <p>
 * Company: 翡翠教育
 * <p>
 * 
 * @author zhaomingxing
 * @version 1.0
 */
public class SkipNullsIterator extends AbstractIterator<String> {

	private Iterator<String> iterator = null;

	public SkipNullsIterator(Iterator<String> iterator) {
		super();
		this.iterator = iterator;
	}

	@Override
	protected String computeNext() {
		while (iterator.hasNext()) {
			String t = iterator.next();
		}
		return endOfData();
	}

}
