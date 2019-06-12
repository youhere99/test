package test;

import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.Map;

import org.junit.Test;
import org.springframework.util.AntPathMatcher;

/**
 * 
 * description:Ant路径匹配规则AntPathMatcher的注意事项
 * 
 * 
 * 
 * @author zhaomingxing 2019年6月5日
 *
 */
public class AntPathMatcherTest {

	/**
	 * https://www.twblogs.net/a/5c9dedc6bd9eee73ef4b5025
	 * 
	 * 2019年6月5日 zhaomingxing
	 */
	@Test
	public void testA() {

		AntPathMatcher antPathMatcher = new AntPathMatcher();
		System.out.println(antPathMatcher.isPattern("/user/001")); // 返回 false

		System.out.println(antPathMatcher.match("/user/001", "/user/001"));// 返回 true

		System.out.println("antPathMatcher.matchStart(\"/user/002\", \"/user/001\")"
				+ antPathMatcher.matchStart("/user/002", "/user/001"));

		System.out.println(antPathMatcher.isPattern("/user/*")); // 返回 true

		System.out.println(antPathMatcher.match("/user/*", "/user/001"));// 返回 true

		System.out.println(antPathMatcher.matchStart("/user/*", "/user/001")); // 返回 true
		System.out.println(antPathMatcher.matchStart("/user/*", "/user001")); // 返回 false
		System.out.println(antPathMatcher.matchStart("/user/*", "/user")); // 返回 true

		System.out.println(
				"antPathMatcher.matchStart(\"/user\", \"/user\")" + antPathMatcher.matchStart("/user", "/user"));

		System.out.println("antPathMatcher.matchStart(\"/user\", \"/user/abc\")"
				+ antPathMatcher.matchStart("/user", "/user/abc")); //

		System.out
				.println("antPathMatcher.match(\"/user\", \"/user/abc\")" + antPathMatcher.match("/user", "/user/abc")); //

		System.out.println(
				"antPathMatcher.match(\"/user/*\", \"/user/abc\")" + antPathMatcher.match("/user/*", "/user/abc")); //

		System.out.println("antPathMatcher.extractPathWithinPattern(\"uc/profile*\", \"uc/profile.html\")"
				+ antPathMatcher.extractPathWithinPattern("uc/profile*", "uc/profile.html")); // profile.html

		System.out.println("antPathMatcher.combine(\"uc/*.html\", \"uc/profile.html\")"
				+ antPathMatcher.combine("uc/*.html", "uc/profile.html")); // uc/profile.html

		System.out.println(
				"antPathMatcher.match(\"/x/x/**/bla\", \"/x/x/x/\")" + antPathMatcher.match("/x/x/**/bla", "/x/x/x/"));

		System.out.println("antPathMatcher.matchStart(\"/x/x/**/bla\", \"/x/x/x/\")"
				+ antPathMatcher.matchStart("/x/x/**/bla", "/x/x/x/"));

		System.out.println(antPathMatcher.extractPathWithinPattern("/docs/commit.html", "/docs/commit.html"));
		System.out.println(antPathMatcher.extractPathWithinPattern("/docs/*", "/docs/cvs/commit"));
		System.out.println(antPathMatcher.extractPathWithinPattern("/d?cs/*", "/docs/cvs/commit"));

		Map<String, String> result = antPathMatcher.extractUriTemplateVariables("/hotels/{hotel}", "/hotels/1");
		System.out.println(result);

		result = antPathMatcher.extractUriTemplateVariables("/{page}.*", "/42.html");
		System.out.println(result);
		assertEquals(Collections.singletonMap("page", "42"), result);

		result = antPathMatcher.extractUriTemplateVariables(
				"{symbolicName:[\\p{L}\\.]+}-sources-{version:[\\p{N}\\.]+}.jar", "com.example-sources-1.0.0.jar");

		System.out.println(result);

		System.out.println(antPathMatcher.combine("/hotels", null));
		System.out.println(antPathMatcher.combine("/hotels/*", "/booking"));
		System.out.println(antPathMatcher.combine("/hotels/**", "booking"));
		System.out.println(antPathMatcher.combine("/hotels/**", "/booking"));
		System.out.println(antPathMatcher.combine("/hotels", "/booking"));
		System.out.println(antPathMatcher.combine("/hotels/*", "{hotel}"));
		System.out.println(antPathMatcher.combine("/hotels/**", "{hotel}"));
		System.out.println(antPathMatcher.combine("/hotels/*/booking", "{booking}"));

	}
}
