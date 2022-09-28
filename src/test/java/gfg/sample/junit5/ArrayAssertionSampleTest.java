package gfg.sample.junit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This class demonstrates how we can write assertions for arrays
 * by using AssertJ.
 *
 * 
 */
@DisplayName("Writing assertions for arrays")
class ArrayAssertionSampleTest {

    @Nested
    @DisplayName("Checking whether when two arrays are having equal values")
    class WhenArrayValuesAreEqual {

        @Nested
        @DisplayName("When arrays contain integers")
        class WhenArraysContainIntegers {

            final int[] ACTUAL = new int[]{25, 50, 75,100};
            final int[] EXPECTED = new int[]{25, 50, 75,100};

            @Test
            @DisplayName("Test to check when they contain the same integers")
            void checkForSameIntegers() {
                assertThat(ACTUAL).isEqualTo(EXPECTED);
            }

            @Test
            @DisplayName("Test to check when they contain the same integers (with custom error message)")
            void checkForSameIntegersWithCustomErrorMessage() {
                assertThat(ACTUAL)
                        .overridingErrorMessage(
                                "Expected array: %s but got array: %s",
                                Arrays.toString(EXPECTED),
                                Arrays.toString(ACTUAL)
                        )
                        .isEqualTo(EXPECTED);
            }
        }

        @Nested
        @DisplayName("When arrays contain strings as values")
        class WhenArraysContainStringsAsValues {

            final String[] ACTUAL = new String[] {"Monica", "Geller"};
            final String[] EXPECTED = new String[] {"Monica", "Geller"};

            @Test
            @DisplayName("Test to check whether strings match")
            void testToCheckForSameStrings() {
                assertThat(ACTUAL).isEqualTo(EXPECTED);
            }

            @Test
            @DisplayName("Test to check whether strings match (with custom error message)")
            void testToCheckForSameStringsWithCustomErrorMessage() {
                assertThat(ACTUAL)
                        .overridingErrorMessage(
                                "Expected array: %s but got array: %s",
                                Arrays.toString(EXPECTED),
                                Arrays.toString(ACTUAL)
                        )
                        .isEqualTo(EXPECTED);
            }
        }
    }

    @Nested
    @DisplayName("When two array values are not equal")
    class WhenArrayValuesAreNotEqual {

        @Nested
        @DisplayName("When arrays contain integers")
        class WhenArraysContainIntegerValues {

            final int[] ACTUAL = new int[]{200, 6000, 70000,10};
            final int[] EXPECTED = new int[]{20, 600, 7000,1};

            @Test
            @DisplayName("When they do not contain the same integers")
            void whenTheyDoNotContainSameIntegers() {
                assertThat(ACTUAL).isNotEqualTo(EXPECTED);
            }

            @Test
            @DisplayName("When they do not contain the same integers (with custom error message)")
            void whenTheyDoNotContainSameIntegersWithCustomErrorMessage() {
                assertThat(ACTUAL)
                        .overridingErrorMessage(
                                "Expected arrays to not be equal but both are: %s",
                                Arrays.toString(EXPECTED)
                        )
                        .isNotEqualTo(EXPECTED);
            }
        }

        @Nested
        @DisplayName("When arrays contain strings as values")
        class WhenArraysContainStringValues {

            final String[] ACTUAL = new String[] {"Monica", "Geller"};
            final String[] EXPECTED = new String[] {"Monica", "Geller"};

            @Test
            @DisplayName("Should not contain the same string values")
            void notHavingSameStrings() {
                assertThat(ACTUAL).isNotEqualTo(EXPECTED);
            }

            @Test
            @DisplayName("Should not contain the same string values (with custom error message)")
            void notHavingSameStringsWithCustomErrorMessage() {
                assertThat(ACTUAL)
                        .overridingErrorMessage(
                                "Expected arrays to not be equal but both are: %s",
                                Arrays.toString(EXPECTED)
                        )
                        .isNotEqualTo(EXPECTED);
            }
        }
    }
}
