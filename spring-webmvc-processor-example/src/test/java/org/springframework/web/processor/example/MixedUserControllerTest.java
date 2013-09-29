package org.springframework.web.processor.example;

import org.fest.assertions.api.Assertions;
import org.junit.Test;
import org.springframework.web.processor.routing.MvcRouting;

public class MixedUserControllerTest {

	public static final int[] USER_IDS = { 1, 2, 3 };

	@Test
	public void shouldGenerateGetUserAccounts() {
		String resource = "image";
		String query = "some-query";

		Assertions.assertThat(
				MixedUserController_.getUsers(resource, query, USER_IDS).mvc())
				.isEqualTo(
						new MvcRouting("/users/" + resource + ";q="
								+ USER_IDS[0] + "," + USER_IDS[1] + ","
								+ USER_IDS[2] + "?query=" + query));
	}
}
