package beanutils;

import org.apache.commons.beanutils.Converter;

class CustomStringConverter implements Converter {
	/**
	 * 
	 * 
	 * @see org.apache.commons.beanutils.Converter#convert(java.lang.Class,
	 *      java.lang.Object)
	 * @param type
	 * @param value
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T> T convert(Class<T> type, Object value) {

		if (String.class.isInstance(value)) {
			return (T) ("custom" + value);
		} else if (Integer.class.isInstance(value)) {
			return (T) ((Integer) value);
		} else {
			return (T) (value);
		}
	}
}
