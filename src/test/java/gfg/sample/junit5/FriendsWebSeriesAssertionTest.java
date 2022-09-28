package gfg.sample.junit5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This class demonstrates how we can write assertions for maps by using
 * AssertJ.
 *
 * 
 */
@DisplayName("Writing assertions for maps - Taking few characters and their professions")
class FriendsWebSeriesAssertionTest {

	private static final String INCORRECT_USERNAMEKEY = "monica";
	private static final String USERNAME1KEY = "rachel";
	private static final String USERNAME1VALUE = "Fashiondesigner";
	private static final String USERNAME2KEY = "ross";
	private static final String USERNAME2VALUE = "Paleontologist";

	private Map<String, String> userNameMap;

	@BeforeEach
	void creationAndInitializationOfFriendsWebSeriesUsers() {
		userNameMap = new HashMap<>();
		userNameMap.put(USERNAME1KEY, USERNAME1VALUE);
		userNameMap.put(USERNAME2KEY, USERNAME2VALUE);
	}

	@Nested
	@DisplayName("checking for the character map contains the given key and value")
	class VerifyThatFriendsWebseriesContainsGivenUserNameKeyAndValue {

		@Test
		@DisplayName("Should contain the correct key and value")
		void shouldContainCorrectKey() {
			assertThat(userNameMap).containsKey(USERNAME1KEY);
			assertThat(userNameMap).containsKey(USERNAME2KEY);
			assertThat(userNameMap).containsValue(USERNAME1VALUE);
			assertThat(userNameMap).containsValue(USERNAME2VALUE);
		}

		@Test
		@DisplayName("Should contain the correct key and value (with custom error message)")
		void shouldContainCorrectKeyAndValueWithCustomErrorMessage() {
			assertThat(userNameMap).overridingErrorMessage("The map doesn't contain the key: %s", USERNAME1KEY)
					.containsKey(USERNAME1KEY);
			assertThat(userNameMap).overridingErrorMessage("The map doesn't contain the value: %s", USERNAME2KEY)
					.containsValue(USERNAME2VALUE);
		}
	}

	@Nested
	@DisplayName("Verification of the usermap does not contain the given usernamekey")
	class VerificationOfTheMapDoesNotContainGivenUserNameKey {

		@Test
		@DisplayName("Should not contain the incorrect userNameKey")
		void checkTheNonExistenceOfIncorrectUserNameKey() {
			assertThat(userNameMap).doesNotContainKey(INCORRECT_USERNAMEKEY);
		}

		@Test
		@DisplayName("Should not contain the incorrect key (with custom error message)")
		void checkTheNonExistenceOfIncorrectUserNameKeyWithCustomErrorMessage() {
			assertThat(userNameMap).overridingErrorMessage("The map contains the key: %s", INCORRECT_USERNAMEKEY)
					.doesNotContainKey(INCORRECT_USERNAMEKEY);
		}
	}

	@Nested
	@DisplayName("Checking for correct username key and values")
	class ConcurrenceOfCorrectUserNameWithValues {

		@Test
		@DisplayName("Should contain the correct usernames and uservalues")
		void checkingForCorrectUserNameKeyAndValue() {
			assertThat(userNameMap).containsEntry(USERNAME1KEY, USERNAME1VALUE);
			assertThat(userNameMap).containsEntry(USERNAME2KEY, USERNAME2VALUE);
		}

		@Test
		@DisplayName("Checking for correct username key and values (with custom error message)")
		void checkingForCorrectUserNameKeyAndValueWithCustomErrorMessage() {
			assertThat(userNameMap).overridingErrorMessage("The map didn't contain the value: %s for the key: %s",
					USERNAME1VALUE, USERNAME1KEY).containsEntry(USERNAME1KEY, USERNAME1VALUE);
		}
	}

	@Nested
	@DisplayName("Checking For matched or mismatched entries")
	class CheckForMismatchedEntries {
		@Test
		@DisplayName("Checking for the existence of the given entry")
		void checkForExistenceOfGivenEntry() {
			assertThat(userNameMap).doesNotContainEntry(INCORRECT_USERNAMEKEY, USERNAME1VALUE);
			assertThat(userNameMap).doesNotContainEntry(USERNAME2KEY, USERNAME1VALUE);
		}

		@Test
		@DisplayName("Checking for the existence of the given entry (with custom error message)")
		void checkForExistenceOfGivenEntryWithCustomErrorMessage() {
			assertThat(userNameMap)
					.overridingErrorMessage(
							"Expected the map to not contain the value: %s for the key: %s but it contained it",
							USERNAME1VALUE, INCORRECT_USERNAMEKEY)
					.doesNotContainEntry(INCORRECT_USERNAMEKEY, USERNAME1VALUE);
		}
	}

	@Nested
	@DisplayName("Check for UserNameKey and UserNameValue")
	class CheckForUserNameValueFromMap {

		@Nested
		@DisplayName("When the usernamevalue is found")
		class WhenUserNameValueIsFound {

			@Test
			@DisplayName("Check for the found value")
			void checkForFoundUserNameValue() {
				final String returned = userNameMap.get(USERNAME1KEY);
				assertThat(returned).isEqualTo(USERNAME1VALUE);
				assertThat(userNameMap.get(USERNAME2KEY)).isEqualTo(USERNAME2VALUE);
			}

			@Test
			@DisplayName("Check for the found value (with custom error message)")
			void checkForFoundUserNameValueWithCustomErrorMessage() {
				final String returned = userNameMap.get(USERNAME1KEY);
				assertThat(returned).overridingErrorMessage(
						"Expected the map to return: %s by using the key: %s but it returned: %s", USERNAME1VALUE,
						USERNAME1KEY, returned).isEqualTo(USERNAME1VALUE);
			}
		}

		@Nested
		@DisplayName("When the usernamevalue is not found")
		class WhenUserNameValueIsNotFound {

			@Test
			@DisplayName("Check the returned null value")
			void checkForReturnNull() {
				final String returned = userNameMap.get(INCORRECT_USERNAMEKEY);
				assertThat(returned).isNull();
			}

			@Test
			@DisplayName("Check the returned null value (with custom error message)")
			void checkForReturnNullWithCustomErrorMessage() {
				final String returned = userNameMap.get(INCORRECT_USERNAMEKEY);
				assertThat(returned)
						.overridingErrorMessage("Expected the map to return null for the key: %s but it returned: %s",
								USERNAME1KEY, returned)
						.isNull();
				assertThat(returned)
						.overridingErrorMessage("Expected the map to return null for the key: %s but it returned: %s",
								USERNAME2KEY, returned)
						.isNull();
			}
		}
	}
}
