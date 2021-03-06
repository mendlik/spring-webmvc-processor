package net.exacode.spring.web.processor.example.request;

import static org.assertj.core.api.Assertions.assertThat;
import net.exacode.spring.web.processor.example.BaseSpringTest;
import net.exacode.spring.web.processor.shared.routing.MvcRouting;

import org.junit.Test;

public class RequestOptionalParameterUserControllerTest extends BaseSpringTest {
	public static final int[] USER_IDS = { 1, 2, 3 };

	@Test
	public void shouldGenerateGetUserById() {
		assertThat(RequestOptionalParameterUserController_.getUserById().mvc())
				.isEqualTo(new MvcRouting("/users"));
		assertThat(
				RequestOptionalParameterUserController_.getUserById()
						.id(USER_IDS[0]).mvc()).isEqualTo(
				new MvcRouting("/users?id=" + USER_IDS[0]));
	}

	@Test
	public void shouldGenerateGetUserByIds() {
		assertThat(RequestOptionalParameterUserController_.getUserByIds().mvc())
				.isEqualTo(new MvcRouting("/users"));
		assertThat(
				RequestOptionalParameterUserController_.getUserByIds()
						.ids(USER_IDS).mvc()).isEqualTo(
				new MvcRouting("/users?id=" + USER_IDS[0] + "&id="
						+ USER_IDS[1] + "&id=" + USER_IDS[2]));
	}

	@Test
	public void shouldGenerateGetUsersWithQuery() {
		String query = "abc";

		assertThat(
				RequestOptionalParameterUserController_.getUsersWithQuery()
						.mvc()).isEqualTo(new MvcRouting("/users"));
		assertThat(
				RequestOptionalParameterUserController_.getUsersWithQuery()
						.query(query).mvc()).isEqualTo(
				new MvcRouting("/users?query=" + query));
	}

	@Test
	public void shouldGenerateGetUsersWithQueryNoValue() {
		String query = "abc";

		assertThat(
				RequestOptionalParameterUserController_
						.getUsersWithQueryNoValue().mvc()).isEqualTo(
				new MvcRouting("/users"));
		assertThat(
				RequestOptionalParameterUserController_
						.getUsersWithQueryNoValue().query(query).mvc())
				.isEqualTo(new MvcRouting("/users?query=" + query));
	}

	@Test
	public void shouldGenerateGetUsersWithProperties() {
		String prop1 = "abc";
		String prop2 = "def";

		assertThat(
				RequestOptionalParameterUserController_
						.getUsersWithSomeProperties().mvc()).isEqualTo(
				new MvcRouting("/users"));
		assertThat(
				RequestOptionalParameterUserController_
						.getUsersWithSomeProperties().prop1(prop1).mvc())
				.isEqualTo(new MvcRouting("/users?prop1=" + prop1));
		assertThat(
				RequestOptionalParameterUserController_
						.getUsersWithSomeProperties().prop2(prop2).mvc())
				.isEqualTo(new MvcRouting("/users?prop2=" + prop2));
		assertThat(
				RequestOptionalParameterUserController_
						.getUsersWithSomeProperties().prop1(prop1).prop2(prop2)
						.mvc()).isEqualTo(
				new MvcRouting("/users?prop1=" + prop1 + "&prop2=" + prop2));
	}

	@Test
	public void shouldGenerateGetUsersWithSomeRequiredProperties() {
		String prop1 = "abc";
		String prop2 = "def";

		assertThat(
				RequestOptionalParameterUserController_
						.getUsersWithSomeRequiredProperties(prop1).mvc())
				.isEqualTo(new MvcRouting("/users?prop1=" + prop1));
		assertThat(
				RequestOptionalParameterUserController_
						.getUsersWithSomeRequiredProperties(prop1).prop2(prop2)
						.mvc()).isEqualTo(
				new MvcRouting("/users?prop1=" + prop1 + "&prop2=" + prop2));
	}
}
