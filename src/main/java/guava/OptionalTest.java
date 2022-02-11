package guava;

import java.util.Optional;
import java.util.Set;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;


/**
 * Title.<br>
 * Description.
 * <p>
 * Copyright: Copyright (c) 2017年5月17日 下午3:05:42
 * <p>
 * Company: 翡翠教育
 * <p>
 * 
 * @author zhaomingxing
 * @version 1.0
 */
@Slf4j
public class OptionalTest {

	@Test
	public void givenEmptyValue_whenCompare_thenOk() {
		User user = null;
		log.debug("Using orElse");
		User result = Optional.ofNullable(user).orElse(createNewUser());
		log.debug("Using orElseGet");
		User result2 = Optional.ofNullable(user).orElseGet(() -> createNewUser());
	}

	@Test
	public void givenPresentValue_whenCompare_thenOk() {
		User user = new User("john@gmail.com", "1234");
		log.info("Using orElse");
		User result = Optional.ofNullable(user).orElse(createNewUser());
		log.info("Using orElseGet");
		User result2 = Optional.ofNullable(user).orElseGet(() -> createNewUser());
	}

	private User createNewUser() {
		log.debug("Creating New User");
		return new User("extra@gmail.com", "1234");
	}
}
