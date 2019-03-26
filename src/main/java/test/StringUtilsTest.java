package test;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class StringUtilsTest {
	/*
	 * StringUtils.containsOnly(null, *) = false StringUtils.containsOnly(*, null) =
	 * false StringUtils.containsOnly("", *) = true StringUtils.containsOnly("ab",
	 * "") = false StringUtils.containsOnly("abab", "abc") = true
	 * StringUtils.containsOnly("ab1", "abc") = false
	 * StringUtils.containsOnly("abz", "abc") = false </pre>
	 *
	 * @param cs the CharSequence to check, may be null
	 * 
	 * @param validChars a String of valid chars, may be null
	 * 
	 * @return true if it only contains valid chars and is non-null
	 * 
	 * @since 2.0
	 * 
	 * @since 3.0 Changed signature from containsOnly(String, String) to
	 * containsOnly(CharSequence, String)
	 */
	@Test
	public void contains() {
		System.err.println(StringUtils.containsOnly("abab", "abc"));
		System.err.println(StringUtils.containsOnly("ab1", "abc"));
		System.err.println(StringUtils.containsOnly("abc1", "ab"));
		System.err.println(StringUtils.containsOnly("ab", "abc"));
		System.err.println(StringUtils.containsOnly("receivesys", "receivesysRelease"));
		System.err.println(StringUtils.containsOnly("receivesysRelease", "receivesys"));
		System.err.println("------------------");
		System.err.println(StringUtils.contains("receivesys", "receivesysRelease"));
		System.err.println(StringUtils.contains("receivesysRelease", "receivesys"));
		System.err.println("------------------");
		System.err.println(StringUtils.containsAny("zzabyycdxx", "e"));
		System.err.println(StringUtils.containsAny("zzabyycdxx", "ye"));
	}
}
